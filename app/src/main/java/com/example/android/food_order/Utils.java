package com.example.android.food_order;

import com.example.android.food_order.models.HotelItem;

import java.util.ArrayList;

public class Utils {
    public static ArrayList<HotelItem> getHotelInfoItems() {
        ArrayList<HotelItem> hotelitems = new ArrayList<>();
        hotelitems.add(new HotelItem( "hn","huh","ngh","R.drawable.pizza", "Pizza","200", "78"));
        hotelitems.add(new HotelItem( "hn","huh","ngh","R.drawable.chickenlollipop", "Chicken Lollipop","400", "78"));
        hotelitems.add(new HotelItem( "hn","huh","ngh","R.drawable.chickenroll", "Chicken Roll","454", "78"));
        hotelitems.add(new HotelItem( "hn","huh","ngh","R.drawable.chillichicken", "Chilli chicken","244", "78"));
        hotelitems.add(new HotelItem( "hn","huh","ngh","R.drawable.chickenwings", "Chicken wings","443", "78"));
       /* hotelitems.add(new HotelItem(R.drawable.chickenlollipop, 120, "Chicken Lollipop"));
        hotelitems.add(new HotelItem(R.drawable.chickenroll, 120, "Chicken Roll"));
        hotelitems.add(new HotelItem(R.drawable.chillichicken, 120, "Chilli Chicken"));
        hotelitems.add(new HotelItem(R.drawable.chickenwings, 120, "Chicken Wings"));*/
        return hotelitems;
    }
}
