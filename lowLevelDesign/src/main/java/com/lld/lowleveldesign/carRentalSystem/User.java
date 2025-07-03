package com.lld.lowleveldesign.carRentalSystem;

public class User {
    public Vehicle vehicle;
    public Integer rentalStoreId;
    public String userName;
    public int userId;
    public static int counter=0;
    public User(String userName,Vehicle vehicle) {
        this.userName = userName;
        this.vehicle = vehicle;
        this.userId=++counter;
    }
}
