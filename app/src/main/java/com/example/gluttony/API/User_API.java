package com.example.gluttony.API;

import android.provider.ContactsContract;

import com.example.gluttony.Models.Token_Generate;
import com.example.gluttony.Models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface User_API {
@FormUrlEncoded
    @POST("users/Login")
    Call<Token_Generate> login(@Field("Username") String username, @Field("Password") String pass);

    @POST("users/registeruser")
    Call<String> register(@Body Users users);

    @GET("users/getUserById/{id}")
    Call<Users> loadprofile(@Path("id")String id);

    @FormUrlEncoded
    @PUT("users/UserUpdateAndroid")
    Call<String> updateProfile(
            @Field("_id") String uid,
            @Field("Fname") String Fname,
            @Field("Lname") String Lname,
            @Field("Email") String Email,
            @Field("Username") String Username,
            @Field("Password") String Password,
            @Field("Address") String Address,
            @Field("Age") String Age );



}
