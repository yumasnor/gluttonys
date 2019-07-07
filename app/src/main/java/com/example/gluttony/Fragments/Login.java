package com.example.gluttony.Fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gluttony.API.User_API;
import com.example.gluttony.Dashboard.Dashboard;
import com.example.gluttony.MainActivity;
import com.example.gluttony.Models.Token_Generate;
import com.example.gluttony.R;
import com.example.gluttony.Retro_API.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends Fragment implements View.OnClickListener {
EditText etuname,etpass;
Button btn_login;


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        etuname=view.findViewById(R.id.etUsername);
        etpass=view.findViewById(R.id.etPassword);
        btn_login=view.findViewById(R.id.btnLogin);

        btn_login.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                Logincheck();
                break;

        }


    }

    private void Logincheck() {
        User_API user_api= API.createinstance().create(User_API.class);
        String username=etuname.getText().toString();
        String password=etpass.getText().toString();
        Call<Token_Generate> logincall= user_api.login(username,password);
        logincall.enqueue(new Callback<Token_Generate>() {
            @Override
            public void onResponse(Call<Token_Generate> call, Response<Token_Generate> response) {
                Token_Generate token_generate=response.body();
                SharedPreferences preferences=getActivity().getSharedPreferences("storetoken",0);
                SharedPreferences.Editor edit=preferences.edit();
                edit.putString("token",token_generate.getToken());
                edit.putString("userid",token_generate.get_id());
                edit.putString("username",token_generate.getUser());
                edit.commit();
                Intent intent= new Intent(getActivity(), Dashboard.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Token_Generate> call, Throwable t) {
                Toast.makeText(getContext(), "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }
}
