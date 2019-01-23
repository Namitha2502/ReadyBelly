package com.example.android.food_order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.food_order.models.HotelInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SwipeRefreshLayout hotels_list_refresh;
    TextView responseText;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hotels_list_refresh = findViewById(R.id.hotels_list_refresh);
        hotels_list_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                hotels_list_refresh.setRefreshing(false);
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


     /*  ArrayList<HotelInfo> hotels=new ArrayList<HotelInfo>();
        hotels.add(new HotelInfo("id1","R.drawable.hotel1","Upto 15% Off","Closed","Indian/biryani/chinese"));
        hotels.add(new HotelInfo("id2","R.drawable.hotel2","Upto 15% Off","Closed","Indian/biryani"));
        hotels.add(new HotelInfo("id3","R.drawable.hotel3","Upto 15% Off","Closed","Indian/biryani"));
        hotels.add(new HotelInfo("id4","R.drawable.hotel4","Upto 15% Off","Closed","Indian/biryani/staters"));
        hotels.add(new HotelInfo("id5","R.drawable.hotel5","Upto 15% Off","Closed","Indian/biryani"));


        HotelInfoAdapter HotelInfo_adaptor= new HotelInfoAdapter(this,hotels);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(HotelInfo_adaptor);*/

        apiInterface = ApiClient.getApi();
        Call<List<HotelInfo>> call = apiInterface.getHotelInfo();
        call.enqueue(new Callback<List<HotelInfo>>() {
            @Override
            public void onResponse(Call<List<HotelInfo>> call, Response<List<HotelInfo>> response) {

                    generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<HotelInfo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });


    }
    private void generateDataList(List<HotelInfo> hotels){
        HotelInfoAdapter hotelInfoAdapter= new HotelInfoAdapter(this,hotels);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(hotelInfoAdapter);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.home) {

        } else if (id == R.id.profile) {
            Intent i=new Intent(this,ProfileActivity.class);
                    startActivity(i);

        } else if (id == R.id.orderlist) {
            Intent i=new Intent(this,OrderListActivity.class);
            startActivity(i);

        } else if (id == R.id.myCart) {
            Intent i=new Intent(this,MyCartActivity.class);
            startActivity(i);

        } else if (id == R.id.share) {

        } else if (id == R.id.contact) {
            Intent i=new Intent(this,ContactActivity.class);
            startActivity(i);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
