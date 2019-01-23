package com.example.android.food_order;

import android.widget.LinearLayout;

import com.example.android.food_order.models.AddsInfo;
import com.example.android.food_order.models.Caterogy;
import com.example.android.food_order.models.HotelInfo;
import com.example.android.food_order.models.HotelItem;

import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("createuser")
    Call<ResponseBody> createUser(
            @Field("name") String name,
            @Field("mobileNumber") String mobileNumber,
            @Field("email") String email,
            @Field("password") String password
    );
    @GET("getHotels.php")
    Call<List<HotelInfo>> getHotelInfo();
    @GET("/getHotelItems.php")
    Call<List<HotelItem>> getHotelItems();
    @GET("getAdds.php")
    Call<List<AddsInfo>> getAddsInfo();
    @GET("getItems(category_id).php")
    Call<List<HotelItem>> getItemsInfo();
    @GET("getCategories.php")
    Call<List<Caterogy>> getCategories();



}
