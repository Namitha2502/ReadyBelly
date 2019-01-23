package com.example.android.food_order;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.43.19/";
    private static ApiClient mInstance;
    public  static Retrofit mretrofit;

    private ApiClient() {
         mretrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized ApiClient getInstance() {
        if (mInstance == null) {
            mInstance = new ApiClient();
        }
        return mInstance;
    }
    public static ApiInterface getApi()
    {

        return  mretrofit.create(ApiInterface.class);
    }

}
