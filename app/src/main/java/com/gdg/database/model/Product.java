package com.gdg.database.model;

/**
 * Created by hqthao on 6/5/16.
 */

public class Product {

    private String productName;
    private String productCompany;
    private int quantity;

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
