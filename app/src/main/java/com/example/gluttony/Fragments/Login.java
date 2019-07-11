package com.example.gluttony.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gluttony.API.User_API;
import com.example.gluttony.BLL.LoginBLL;
import com.example.gluttony.Dashboard.Dashboard;
import com.example.gluttony.Models.Token_Generate;
import com.example.gluttony.R;
import com.example.gluttony.Retro_API.API;


public class Login extends Fragment implements View.OnClickListener {
    EditText etuname, etpass;
    Button btn_login;
    SensorManager sensorManager;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etuname = view.findViewById(R.id.etUsername);
        etpass = view.findViewById(R.id.etPassword);
        btn_login = view.findViewById(R.id.btnLogin);

        btn_login.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                if (validation()) {
                    Logincheck();
                }
                break;
                }


        }


    private void Logincheck() {
        User_API user_api = API.createinstance().create(User_API.class);
        String username = etuname.getText().toString();
        String password = etpass.getText().toString();

        LoginBLL bll = new LoginBLL(username, password);

        if (bll.checkUser()) {
            Token_Generate token_generate = bll.getToken_generate();
            SharedPreferences preferences = getActivity().getSharedPreferences("storetoken", 0);
            SharedPreferences.Editor edit = preferences.edit();
            edit.putString("token", token_generate.getToken());
            edit.putString("userid", token_generate.get_id());
            edit.putString("username", token_generate.getUser());
            edit.commit();
            Intent intent = new Intent(getActivity(), Dashboard.class);
            startActivity(intent);
        } else {
            Toast.makeText(getActivity(), "Login Failed...", Toast.LENGTH_SHORT).show();


        }


    }
    public boolean validation(){
        if (TextUtils.isEmpty(etuname.getText().toString())){
            etuname.setError("Enter Username");
            etuname.requestFocus();

            Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate (2000);
            return false;

        }
        else if(TextUtils.isEmpty(etpass.getText().toString())){
            etpass.setError("Enter Password");
            etpass.requestFocus();

            Vibrator vibrator =(Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(2000);
            return false;
        }
        return true;

    }

    public void proximity() {
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (sensor == null) {
            Toast.makeText(getActivity(), "No sensor detected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Sensor Kicking in...", Toast.LENGTH_SHORT).show();
        }
        SensorEventListener proximityListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
                if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                    if (event.values[0] == 0) {
                        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                        params.screenBrightness = 0;
                        getActivity().getWindow().setAttributes(params);
                    } else {
                        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                        params.screenBrightness = -1f;
                        getActivity().getWindow().setAttributes(params);
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(proximityListener, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

}
