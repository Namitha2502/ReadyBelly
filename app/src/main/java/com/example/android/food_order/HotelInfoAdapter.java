package com.example.android.food_order;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.food_order.models.HotelInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HotelInfoAdapter extends RecyclerView.Adapter<HotelInfoAdapter.MyViewHolder> {
    List<HotelInfo> hotellist;
    private LayoutInflater mlayoutInflater;
    public Context context;

    public HotelInfoAdapter(Activity context, List<HotelInfo> hotellist) {
        mlayoutInflater=LayoutInflater.from(context);
        this.hotellist=hotellist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.info_of_hotel_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        HotelInfo currentInfo_of_hotel = hotellist.get(position);
        holder.tvOffer.setText(currentInfo_of_hotel.getOffer());
        holder.tvSpecials.setText(currentInfo_of_hotel.getSpecials());
        holder.tvOpenOrClosed.setText(currentInfo_of_hotel.getOpenOrClosed());
        Log.d("URL" , currentInfo_of_hotel.getHotelImageId());
        Picasso.with(context)
                .load(currentInfo_of_hotel.getHotelImageId())
                .into(holder.ivHotelImage);
     /*  try
       {
         holder.ivHotelImage.setImageResource(Integer.parseInt(currentInfo_of_hotel.getHotelImageId()));}
         catch (NumberFormatException nfe)
         {

         }*/
        holder.ivHotelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,HotelInfoActivity.class);
              //  intent.putExtra("HOTEL_NAME" , hotellist.get(position).getHotel_name());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return hotellist.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvOffer;
            TextView tvSpecials;
            TextView tvOpenOrClosed;
            ImageView ivHotelImage;


            public MyViewHolder(View itemView) {
                super(itemView);
                tvOffer = itemView.findViewById(R.id.offer);
                tvSpecials = itemView.findViewById(R.id.specials);
                tvOpenOrClosed= itemView.findViewById(R.id.open_closed);
                ivHotelImage = itemView.findViewById(R.id.hotel_image_id);
            }
        }

}
