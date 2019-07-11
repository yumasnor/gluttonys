package com.example.gluttony.User_Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gluttony.API.User_API;
import com.example.gluttony.Dashboard.Dashboard;
import com.example.gluttony.Models.Users;
import com.example.gluttony.R;
import com.example.gluttony.Retro_API.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class User_Update extends AppCompatActivity implements View.OnClickListener {
    EditText et_fname, et_lname, et_email, et_username, et_password, et_address, et_age;
    Button btn_update;
    Boolean isLoggedIn = false;


    private static final String BASE_URL = "http://10.0.2.2:3100/";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    User_API user_api;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__update);

        LoadUserDetail();

        et_fname = findViewById(R.id.etFname);
        et_lname = findViewById(R.id.etLname);
        et_email = findViewById(R.id.etE_mail);
        et_username = findViewById(R.id.etUser_name);
        et_password = findViewById(R.id.etPass_word);
        et_address = findViewById(R.id.etAddress1);
        et_age = findViewById(R.id.etAge1);

        btn_update = findViewById(R.id.btnUpdate);
        btn_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnUpdate) {
            updateProfile();
        }


    }

    private void createInstance() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        user_api = retrofit.create(User_API.class);

    }


    private void LoadUserDetail() {
        createInstance();

        sharedPreferences = getSharedPreferences("storetoken", 0);

        String userID = sharedPreferences.getString("userid", null);
        Toast.makeText(this, "User ID: +" + userID, Toast.LENGTH_SHORT).show();
        Call<Users> usersCall = user_api.loadprofile(userID);

        usersCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Users users = response.body();
                et_fname.setText(users.getFname());
                et_lname.setText(users.getLname());
                et_email.setText(users.getEmail());
                et_username.setText(users.getUsername());
                et_password.setText(users.getPassword());
                et_address.setText(users.getAddress());
                et_age.setText(users.getAge());
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText(User_Update.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    public void updateProfile() {

        createInstance();
        String newFname, newLname, newEmail, newUsername, newPassword, newAddress, newAge;

        newFname = et_fname.getText().toString();
        newLname = et_lname.getText().toString();
        newEmail = et_email.getText().toString();
        newUsername = et_username.getText().toString();
        newPassword = et_password.getText().toString();
        newAddress = et_address.getText().toString();
        newAge = et_age.getText().toString();

        SharedPreferences sharedPreferences = (User_Update.this).getSharedPreferences("storetoken",0);
        String userID = sharedPreferences.getString("userid",null);

        Toast.makeText(this,"User id: +" +userID,Toast.LENGTH_LONG).show();

        Call<String> updateProfileData = user_api.updateProfile(userID, newFname, newLname, newEmail, newUsername, newPassword, newAddress, newAge);
        updateProfileData.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(User_Update.this, "Profile Updated", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(User_Update.this, Dashboard.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(User_Update.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}















