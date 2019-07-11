package com.example.gluttony.Models;

public class Users {
 private String Fname;
    private String Lname;
    private String Email;
    private String Username;
    private String Password;
    private String Address;
    private String Age;
    private String Usertype;

    public Users(String fname, String lname, String email, String username, String password, String address, String age, String usertype) {
        Fname = fname;
        Lname = lname;
        Email = email;
        Username = username;
        Password = password;
        Address = address;
        Age = age;
        Usertype = usertype;

    }


    public String getUsertype() {
        return Usertype;
    }

    public void setUsertype(String usertype) {
        Usertype = usertype;
    }


    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }


    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }


}
