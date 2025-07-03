package com.lld.lowleveldesign.carRentalSystem;

public class SUV extends Vehicle{
    public SUV(String name, String fuelType, String numberPlate, String colour,int ratePerHour){
        super(name, fuelType, numberPlate, colour,VehicleType.SUV,ratePerHour);
    }
}
