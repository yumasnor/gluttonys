package com.example.gluttony.BLL;

import com.example.gluttony.API.Restaurant_API;
import com.example.gluttony.Models.Restaurants;
import com.example.gluttony.Retro_API.API;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

public class RestaurantBLL {
    private String Restaurantlogo;
    private String Restaurantname;
    private String Restauranttype;
    private String Restaurantdesc;
    private String Restaurantcontact;
    private String Longitude;
    private String Latitide;
    private String token;

    public RestaurantBLL(String restaurantlogo, String restaurantname, String restauranttype, String restaurantdesc, String restaurantcontact, String longitude, String latitide) {
        Restaurantlogo = restaurantlogo;
        Restaurantname = restaurantname;
        Restauranttype = restauranttype;
        Restaurantdesc = restaurantdesc;
        Restaurantcontact = restaurantcontact;
        Longitude = longitude;
        Latitide = latitide;
    }

    public RestaurantBLL() {

    }


    public List<Restaurants> getRestaurant(){
        List<Restaurants> restaurantsList = null;
        try {
            Response<List<Restaurants>> response = API.createinstance().create(Restaurant_API.class).getRestaurant(token).execute();
            restaurantsList = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restaurantsList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
