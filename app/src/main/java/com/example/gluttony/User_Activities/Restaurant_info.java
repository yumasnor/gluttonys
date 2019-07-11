package com.example.gluttony.User_Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gluttony.API.Restaurant_API;
import com.example.gluttony.Adapters.CommentAdapter;
import com.example.gluttony.Adapters.Restaurant_List_Adapter;
import com.example.gluttony.Models.Reviews;
import com.example.gluttony.R;
import com.example.gluttony.Retro_API.API;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.squareup.picasso.Picasso;


import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Restaurant_info extends AppCompatActivity  {
    TextView textView_rest_name,textView_rest_contact,textView_rest_type,textView_rest_desc,textView_latitude,textView_longitude;
    ImageView iv_logo;
    SharedPreferences preferences;
    public MapView mapView;
    private RecyclerView recyclerView;
    private List<Reviews> commentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.eyJ1IjoiYmluYXkwMDEyMyIsImEiOiJjanh3dW5oMWMwNG4xM25tdXBhZ2oyczRuIn0.tVXWbvSvD7WoEBgICQZFtA");
        setContentView(R.layout.activity_restaurant_info);

        recyclerView = findViewById(R.id.comment_recycler);

        mapView = findViewById(R.id.map);
                mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
             float   longtitude= Float.parseFloat( Restaurant_List_Adapter.Log);
             float latitude= Float.parseFloat( Restaurant_List_Adapter.Lat);
//                latitude= Restaurant_List_Adapter.Lat;
                MarkerOptions options = new MarkerOptions();
                options.title("Restaurant Location");
                options.position(new LatLng(latitude,longtitude));
                mapboxMap.addMarker(options);
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                    }

                });
            }
        }) ;



        textView_rest_name = findViewById(R.id.tv_restaurant_name);
        textView_rest_contact=findViewById(R.id.tv_number);
        textView_rest_type=findViewById(R.id.tv_restaurant_type);
        textView_rest_desc=findViewById(R.id.tv_description);
        textView_latitude=findViewById(R.id.tv_latitude);
        textView_longitude=findViewById(R.id.tv_longitude);
        iv_logo=findViewById(R.id.img_logo);

       preferences = getApplicationContext().getSharedPreferences("Restaurant_info", Context.MODE_PRIVATE);

       Bundle bundle = getIntent().getExtras();
       if (bundle != null) {
           String image = API.BASE_URL+"logo/"+ bundle.getString("Restaurantlogo");
           Picasso.get().load(image).into(iv_logo);
           textView_rest_name.setText("Restaurant Name: " +bundle.getString("Restaurantname"));
           textView_rest_type.setText("Restaurant Type: " +bundle.getString("Restauranttype"));
           textView_rest_contact.setText("Restaurant Contact: " +bundle.getString("Restaurantcontact"));
           textView_rest_desc.setText("Restaurant Description: " +bundle.getString("Restaurantdesc"));
           textView_latitude.setText("Latitude: " +bundle.getString("Latitude"));
           textView_longitude.setText("Longitude: " +bundle.getString("Longitude"));
       }

       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       getComment();
    }

    private void getComment(){
        final Restaurant_API restaurant_api = API.createinstance().create(Restaurant_API.class);
        final String id = getIntent().getStringExtra("id");

        Toast.makeText(this, id, Toast.LENGTH_LONG).show();
         Call<List<Reviews>>listCall = restaurant_api.getReview(id);
         listCall.enqueue(new Callback<List<Reviews>>() {
             @Override
             public void onResponse(Call<List<Reviews>> call, Response<List<Reviews>> response) {
                 commentList = response.body();
                 recyclerView.setLayoutManager(new LinearLayoutManager(Restaurant_info.this));
                 recyclerView.setAdapter(new CommentAdapter(Restaurant_info.this, commentList));

             }

             @Override
             public void onFailure(Call<List<Reviews>> call, Throwable t) {
                 Toast.makeText(Restaurant_info.this,t.getMessage(),Toast.LENGTH_LONG).show();

             }
         });
        }


    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
