package com.example.gluttony.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gluttony.Models.Restaurants;
import com.example.gluttony.R;
import com.example.gluttony.Retro_API.API;
import com.example.gluttony.User_Activities.Restaurant_info;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Restaurant_List_Adapter extends RecyclerView.Adapter<Restaurant_List_Adapter.Holder> {
    private Context context;
    private List<Restaurants> restaurantsList;
    public static  String Lat;
    public static  String Log;


    public Restaurant_List_Adapter(Context context, List<Restaurants> restaurantsList) {
        this.context = context;
        this.restaurantsList = restaurantsList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_restaurant, viewGroup, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        final Restaurants restaurants = restaurantsList.get(i);
        holder.tv_number.setText(restaurants.getRestaurantcontact());
        holder.tv_restaurant_name.setText(restaurants.getRestaurantname());

//        Uri uri = Uri.parse(API.BASE_URL + restaurants.getRestaurantlogo());
//        holder.img_logo.setImageURI(uri);

        String path=API.BASE_URL+"logo/"+restaurants.getRestaurantlogo();
        Picasso.get().load(path).into(holder.img_logo);
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= API.BASE_URL+"logo/"+restaurants.getRestaurantlogo();

               Intent intent = new Intent(context, Restaurant_info.class);
               intent.putExtra("Restaurantname",restaurants.getRestaurantname());
               intent.putExtra("Restaurantcontact",restaurants.getRestaurantcontact());
               intent.putExtra("Restauranttype",restaurants.getRestauranttype());
               intent.putExtra("Restaurantlogo", restaurants.getRestaurantlogo());
               intent.putExtra("Restaurantdesc", restaurants.getRestaurantdesc());
               intent.putExtra("Latitude", restaurants.getLatitude());
               intent.putExtra("Longitude", restaurants.getLongitude());
               intent.putExtra("id",restaurants.getId());
               Log=restaurants.getLongitude();
               Lat=restaurants.getLatitude();
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img_logo;
        private TextView tv_restaurant_name, tv_number;
        private CardView card_view;

        public Holder(@NonNull View itemView) {
            super(itemView);
            card_view = itemView.findViewById(R.id.card_view);
            img_logo = itemView.findViewById(R.id.img_logo);
            tv_restaurant_name = itemView.findViewById(R.id.tv_restaurant_name);
            tv_number = itemView.findViewById(R.id.tv_number);
        }

    }
}

