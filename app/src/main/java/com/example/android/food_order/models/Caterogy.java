package com.example.android.food_order.models;

import com.google.gson.annotations.SerializedName;

public class Caterogy {
    @SerializedName("cateriry_id")
    String caterory_id;
    @SerializedName("caterory_name")
    String category_name;

    public Caterogy(String caterory_id, String category_name) {
        this.caterory_id = caterory_id;
        this.category_name = category_name;
    }

    public String getCaterory_id() {
        return caterory_id;
    }

    public void setCaterory_id(String caterory_id) {
        this.caterory_id = caterory_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
