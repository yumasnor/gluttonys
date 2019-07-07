package com.example.gluttony.API;

import com.example.gluttony.Models.Token_Generate;
import com.example.gluttony.Models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface User_API {
@FormUrlEncoded
    @POST("users/Login")
    Call<Token_Generate> login(@Field("Username") String username, @Field("Password") String pass);

    @POST("users/registeruser")
    Call<String> register(@Body Users users);

}
