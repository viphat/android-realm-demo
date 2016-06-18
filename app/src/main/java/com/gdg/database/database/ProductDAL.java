package com.gdg.database.database;

import com.gdg.database.config.RealmApplication;
import com.gdg.database.model.Product;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by viphat on 18/06/2016.
 */
public class ProductDAL {

    public static Product insertProduct(Product product){
        Realm realm = Realm.getDefaultInstance(); //Default Instance da khoi tao o RealmApplication.java
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(product);
        realm.commitTransaction();
        return product;
    }

    public static List<Product> getAllList() {
        int sortType = PrefStore.getSortType(RealmApplication.getContext());
        String fieldName;
        if (sortType == 0) {
            fieldName = "productName";
        } else {
            fieldName = "quantity";
        }

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Product> query = realm.where(Product.class);
        RealmResults<Product> products = query.findAll();
        products.sort(fieldName, true); // true is asc, false is desc
        return products.subList(0, products.size());
    }

}
