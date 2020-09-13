package com.sbtechnologies.organicfood.Activity;

import android.media.Image;

import java.util.List;

public class ProductList {

    String product_category;
    String product_sub_category;
    String product_name;
    Integer product_image;
    List <com.sbtechnologies.organicfood.Activity.ProductSize> productSizes;

    public ProductList(String product_category, String product_sub_category, String product_name, Integer product_image, List<com.sbtechnologies.organicfood.Activity.ProductSize> productSizes) {
        this.product_category = product_category;
        this.product_sub_category = product_sub_category;
        this.product_name = product_name;
        this.product_image = product_image;
        this.productSizes = productSizes;
    }

    public Integer getProduct_image() {
        return product_image;
    }

    public void setProduct_image(Integer product_image) {
        this.product_image = product_image;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getProduct_sub_category() {
        return product_sub_category;
    }

    public void setProduct_sub_category(String product_sub_category) {
        this.product_sub_category = product_sub_category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public List<com.sbtechnologies.organicfood.Activity.ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<com.sbtechnologies.organicfood.Activity.ProductSize> productSizes) {
        this.productSizes = productSizes;
    }
}
