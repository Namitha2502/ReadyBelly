package com.example.android.food_order.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HotelItem implements Serializable{
    @SerializedName("hotel_id")
    String hotel_id;
    @SerializedName("item_id")
    String item_id;
    @SerializedName("item_image_id")
    String  item_image_id;
    @SerializedName("item_type_image_id")
    String item_type_image_id;

    @SerializedName("item_category")
    String item_category;

    @SerializedName("item_name")
    String item_name;
    @SerializedName("item_price")
    double item_price;

    @SerializedName("discount")
    double discount;

    public HotelItem(String hotel_id, String item_id, String item_image_id, String item_type_image_id, String item_category, String item_name, double item_price, double discount) {
        this.hotel_id = hotel_id;
        this.item_id = item_id;
        this.item_image_id = item_image_id;
        this.item_type_image_id = item_type_image_id;
        this.item_category = item_category;
        this.item_name = item_name;
        this.item_price = item_price;
        this.discount = discount;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_image_id() {
        return item_image_id;
    }

    public void setItem_image_id(String item_image_id) {
        this.item_image_id = item_image_id;
    }

    public String getItem_type_image_id() {
        return item_type_image_id;
    }

    public void setItem_type_image_id(String item_type_image_id) {
        this.item_type_image_id = item_type_image_id;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
