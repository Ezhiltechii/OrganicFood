package com.sbtechnologies.organicfood.Activity;

public class ProductSize {

    String product_size;
    String product_price;
    String product_discount;
    String product_discount_price;

    public ProductSize(String product_size, String product_price, String product_discount, String product_discount_price) {
        this.product_size = product_size;
        this.product_price = product_price;
        this.product_discount = product_discount;
        this.product_discount_price = product_discount_price;
    }

    public String getProduct_size() {
        return product_size;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(String product_discount) {
        this.product_discount = product_discount;
    }

    public String getProduct_discount_price() {
        return product_discount_price;
    }

    public void setProduct_discount_price(String product_discount_price) {
        this.product_discount_price = product_discount_price;
    }
}
