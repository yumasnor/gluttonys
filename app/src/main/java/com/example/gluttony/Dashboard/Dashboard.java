package com.example.gluttony.Dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gluttony.MainActivity;
import com.example.gluttony.R;
import com.example.gluttony.User_Activities.About_Us;
import com.example.gluttony.User_Activities.Restaurant_list;
import com.example.gluttony.User_Activities.User_Update;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
TextView et_rest, et_update, et_aboutus, et_log_out;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        et_rest = findViewById(R.id.et_view_restaurant);
        et_rest.setOnClickListener(this);

        et_update= findViewById(R.id.et_update_profile);
        et_update.setOnClickListener(this);

        et_aboutus= findViewById(R.id.et_about_us);
        et_aboutus.setOnClickListener(this);

        et_log_out=findViewById(R.id.et_logout);
        et_log_out.setOnClickListener(this);

        SharedPreferences preferences=getSharedPreferences("storetoken",0);
        String token=preferences.getString("token",null);
        String user=preferences.getString("username",null);
        Toast.makeText(this, user, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.et_view_restaurant:
                startActivity(new  Intent(this, Restaurant_list.class));
            break;

            case R.id.et_update_profile:
                startActivity(new Intent(this, User_Update.class));
            break;

            case R.id.et_about_us:
                startActivity(new Intent(this, About_Us.class));
            break;

            case R.id.et_logout:
                Intent intent = new Intent (Dashboard.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Log Out Successful", Toast.LENGTH_SHORT).show();
                finish();

        }

    }


}


