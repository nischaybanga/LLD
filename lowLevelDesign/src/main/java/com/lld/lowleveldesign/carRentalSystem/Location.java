package com.lld.lowleveldesign.carRentalSystem;

public class Location {
    public long lon;
    public long lat;
    public String address;
    public String locality;
    public Location(long lon, long lat, String address, String locality) {
        this.lon = lon;
        this.lat = lat;
        this.address = address;
        this.locality = locality;
    }
}
