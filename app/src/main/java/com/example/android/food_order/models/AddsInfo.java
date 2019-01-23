package com.example.android.food_order.models;

import com.google.gson.annotations.SerializedName;

public class AddsInfo {
    @SerializedName("add_id")
    String add_id;
    @SerializedName("hotel_id")
    String hotel_id;
    @SerializedName("hotel_name")
    String hotel_name;
    @SerializedName("hotel_image_id")
    String hotel_image_id;
    @SerializedName("specials")
    String specials;

    public AddsInfo(String add_id, String hotel_id, String hotel_name, String hotel_image_id, String specials) {
        this.add_id = add_id;
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_image_id = hotel_image_id;
        this.specials = specials;
    }

    public String getAdd_id() {
        return add_id;
    }

    public void setAdd_id(String add_id) {
        this.add_id = add_id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_image_id() {
        return hotel_image_id;
    }

    public void setHotel_iomage_id(String hotel_image_id) {
        this.hotel_image_id = hotel_image_id;
    }

    public String getSpecials() {
        return specials;
    }

    public void setSpecials(String specials) {
        this.specials = specials;
    }
}
