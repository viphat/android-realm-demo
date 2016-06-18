package com.gdg.database.model;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by hqthao on 6/5/16.
 */

public class Product extends RealmObject {

    @PrimaryKey
    @Index
    private String productName;
    @Index
    private String productCompany;
    private int quantity;

    public Product() {

    }

    public Product(String mProductName, String mProductCompany, int mQuantity) {
        this.productName = mProductName;
        this.productCompany = mProductCompany;
        this.quantity = mQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String mProductName) {
        this.productName = mProductName;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String mProductCompany) {
        this.productCompany = mProductCompany;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int mQuantity) {
        this.quantity = mQuantity;
    }
}
