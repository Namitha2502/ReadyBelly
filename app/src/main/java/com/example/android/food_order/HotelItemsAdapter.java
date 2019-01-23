package com.example.android.food_order;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.food_order.models.HotelItem;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HotelItemsAdapter extends RecyclerView.Adapter<HotelItemsAdapter.MyViewHolder1>{
    List<HotelItem> hotelItemsList;
    Context context;

    public HotelItemsAdapter( Context context,List<HotelItem> hotelItemsList) {
        this.hotelItemsList=hotelItemsList;
        this.context = context;

    }
    @NonNull
    @Override
    public HotelItemsAdapter.MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.info_of_hotel_items_card, parent, false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder1 holder, int position) {
        HotelItem currentInfoOfHotelItems = hotelItemsList.get(position);
      /*  try {
            holder.item_image_id.setImageResource(Integer.parseInt(currentInfoOfHotelItems.getItem_image_id()));
        }
        catch (NumberFormatException nfe)
        {

        }*/
        Log.d("URL" , currentInfoOfHotelItems.getItem_image_id());
        Picasso.with(context)
                .load(currentInfoOfHotelItems.getItem_image_id())
                .into(holder.item_image_id);
        holder.original_price.setText(String.valueOf(currentInfoOfHotelItems.getItem_price()));
        holder.item_name.setText(currentInfoOfHotelItems.getItem_name());
        holder.discount.setText(String.valueOf(currentInfoOfHotelItems.getDiscount()));
        holder.customer_price.setText(String.valueOf(currentInfoOfHotelItems.getItem_price()+currentInfoOfHotelItems.getDiscount()));


        holder.tvNoOfOrders.setText("0");



       holder.btnDecrement.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int noOfOrders = Integer.parseInt(holder.tvNoOfOrders.getText().toString());
               if(noOfOrders==0) {
                   Toast.makeText(context,"You cannot have less than 0 items",Toast.LENGTH_SHORT).show();
               }else {
                   noOfOrders--;
               }
               holder.tvNoOfOrders.setText(String.valueOf(noOfOrders));
           }
       });

        holder.btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int noOfOrders = Integer.parseInt(holder.tvNoOfOrders.getText().toString());
                if(noOfOrders==20) {
                    Toast.makeText(context,"You cannot have more than 20 items",Toast.LENGTH_SHORT).show();
                }else {
                    noOfOrders++;
                }
                holder.tvNoOfOrders.setText(String.valueOf(noOfOrders));
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelItemsList.size();
    }





    class MyViewHolder1 extends RecyclerView.ViewHolder {

        private ImageView item_image_id;
        private TextView original_price,customer_price,discount;
        private TextView item_name , tvNoOfOrders;
        private Button btnIncrement , btnDecrement;


        public MyViewHolder1(View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            original_price = (TextView)itemView.findViewById(R.id.original_price);
            customer_price=itemView.findViewById(R.id.customer_price);
            discount=itemView.findViewById(R.id.discount);
            item_image_id= itemView.findViewById(R.id.item_id);
            btnIncrement= itemView.findViewById(R.id.btnIncrement);
            btnDecrement= itemView.findViewById(R.id.btnDecrement);
            tvNoOfOrders = itemView.findViewById(R.id.no_of_orders);
        }
    }
}
