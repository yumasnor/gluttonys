package com.example.gluttony.User_Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gluttony.API.Restaurant_API;
import com.example.gluttony.Adapters.Restaurant_List_Adapter;
import com.example.gluttony.BLL.RestaurantBLL;
import com.example.gluttony.Models.Restaurants;
import com.example.gluttony.R;
import com.example.gluttony.Retro_API.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Restaurant_list extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        recyclerView= findViewById(R.id.restaurant_recycler_view);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        getRestaurants();
    }

    private void getRestaurants() {
        RestaurantBLL bll = new RestaurantBLL();
        bll.setToken(getSharedPreferences("storetoken", 0).getString("token", ""));
        Restaurant_List_Adapter adapter = new Restaurant_List_Adapter(Restaurant_list.this, bll.getRestaurant());
        recyclerView.setAdapter(adapter);
    }
}
