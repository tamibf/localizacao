package com.example.tamires.localizacao.Data.webservice.webservices.contents;

public class LocationIV {
    private double latitude;
    private  double longitude;

    public LocationIV(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}