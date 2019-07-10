package com.example.gluttony.BLL;

import android.os.StrictMode;

import com.example.gluttony.API.User_API;
import com.example.gluttony.Models.Token_Generate;
import com.example.gluttony.Retro_API.API;

import java.io.IOException;

import retrofit2.Response;

public class LoginBLL {
    private String username;
    private String password;
    private Token_Generate token_generate;
    boolean isSuccess = false;

    public LoginBLL(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public boolean checkUser() {
        try {
            StrictMode();
            Response<Token_Generate> response = API.createinstance().create(User_API.class).login(username, password).execute();
            if (response.isSuccessful()) {
                this.token_generate = response.body();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }


    private void StrictMode(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public Token_Generate getToken_generate() {
        return token_generate;
    }

    public void setToken_generate(Token_Generate token_generate) {
        this.token_generate = token_generate;
    }
}
