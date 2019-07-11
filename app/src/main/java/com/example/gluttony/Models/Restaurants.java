package com.example.gluttony.Models;

public class Restaurants {
    private String Restaurantlogo;
    private String Restaurantname;
    private String Restauranttype;
    private String Restaurantdesc;
    private String Restaurantcontact;
    private String Longitude;
    private String Latitude;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantlogo() {
        return Restaurantlogo;
    }

    public void setRestaurantlogo(String restaurantlogo) {
        Restaurantlogo = restaurantlogo;
    }

    public String getRestaurantname() {
        return Restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        Restaurantname = restaurantname;
    }

    public String getRestauranttype() {
        return Restauranttype;
    }

    public void setRestauranttype(String restauranttype) {
        Restauranttype = restauranttype;
    }

    public String getRestaurantdesc() {
        return Restaurantdesc;
    }

    public void setRestaurantdesc(String restaurantdesc) {
        Restaurantdesc = restaurantdesc;
    }

    public String getRestaurantcontact() {
        return Restaurantcontact;
    }

    public void setRestaurantcontact(String restaurantcontact) {
        Restaurantcontact = restaurantcontact;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public Restaurants(String restaurantlogo, String restaurantname, String restauranttype, String restaurantdesc, String restaurantcontact, String longitude, String latitude) {
        Restaurantlogo = restaurantlogo;
        Restaurantname = restaurantname;
        Restauranttype = restauranttype;
        Restaurantdesc = restaurantdesc;
        Restaurantcontact = restaurantcontact;
        Longitude = longitude;
        Latitude = latitude;
    }
}
