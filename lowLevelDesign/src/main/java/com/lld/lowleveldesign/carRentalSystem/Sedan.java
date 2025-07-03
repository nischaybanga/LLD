package com.lld.lowleveldesign.carRentalSystem;

public class Sedan extends Vehicle{
    public Sedan(String name, String fuelType, String numberPlate, String colour,int ratePerHour){
        super(name, fuelType, numberPlate, colour,VehicleType.SEDAN,ratePerHour);
    }
}
