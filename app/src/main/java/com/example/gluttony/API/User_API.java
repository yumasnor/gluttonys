package com.example.gluttony.API;

import com.example.gluttony.Models.Token_Generate;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface User_API {

    @POST("users/login")
    Call<Token_Generate> login(@Field("Username") String username, @Field("Password") String pass);

}
