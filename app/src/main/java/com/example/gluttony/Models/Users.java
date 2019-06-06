package com.example.gluttony.Models;

public class Users {
 private String userFname,userLname,phn_number,email,username,password;

    public Users(String userFname, String userLname, String phn_number, String email, String username, String password) {
        this.userFname = userFname;
        this.userLname = userLname;
        this.phn_number = phn_number;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getPhn_number() {
        return phn_number;
    }

    public void setPhn_number(String phn_number) {
        this.phn_number = phn_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
