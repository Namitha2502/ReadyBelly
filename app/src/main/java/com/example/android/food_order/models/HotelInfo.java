package com.example.android.food_order.models;

import com.google.gson.annotations.SerializedName;

public class HotelInfo {
    @SerializedName("city_id")
    String city_id;
    @SerializedName("area_id")
    String area_id;
    @SerializedName("hotel_name")
    String hotel_name;
    @SerializedName("hotel_id")
    String hotel_id;

    @SerializedName("hotel_image_id")
    String hotelImageId;
    @SerializedName("offer")
    String offer;
    @SerializedName("open_closed")
    String openOrClosed;
    @SerializedName("specials")
    String specials;

    public HotelInfo(String city_id, String area_id, String hotel_name, String hotel_id, String hotelImageId, String offer, String openOrClosed, String specials) {
        this.city_id = city_id;
        this.area_id = area_id;
        this.hotel_name = hotel_name;
        this.hotel_id = hotel_id;
        this.hotelImageId = hotelImageId;
        this.offer = offer;
        this.openOrClosed = openOrClosed;
        this.specials = specials;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotelImageId() {
        return hotelImageId;
    }

    public void setHotelImageId(String hotelImageId) {
        this.hotelImageId = hotelImageId;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getOpenOrClosed() {
        return openOrClosed;
    }

    public void setOpenOrClosed(String openOrClosed) {
        this.openOrClosed = openOrClosed;
    }

    public String getSpecials() {
        return specials;
    }

    public void setSpecials(String specials) {
        this.specials = specials;
    }
}