package com.example.gluttony.API;

import com.example.gluttony.Models.Restaurants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Restaurant_API {

    @GET ("restaurants/showrestaurent")
    Call<List<Restaurants>> getRestaurant(@Header("Authorization")String token);


}
