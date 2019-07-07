package com.example.gluttony.Dashboard;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gluttony.R;

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

        }
    }
}
