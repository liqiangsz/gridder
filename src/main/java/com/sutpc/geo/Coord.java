package com.sutpc.geo;

public class Coord {
    public double lng;
    public double lat;

    public Coord(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    @Override
    public String toString(){
        return String.format("%.6f,%.6f", lng, lat);
    }
}
