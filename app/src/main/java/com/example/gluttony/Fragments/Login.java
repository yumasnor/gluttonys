package com.example.gluttony.Fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

                Logincheck();
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
}
