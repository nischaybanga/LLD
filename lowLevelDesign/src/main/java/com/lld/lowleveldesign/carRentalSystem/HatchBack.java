package com.lld.lowleveldesign.carRentalSystem;

public class HatchBack extends Vehicle{
    public HatchBack(String name, String fuelType, String numberPlate, String colour,int ratePerHour){
        super(name, fuelType, numberPlate, colour,VehicleType.HATCH_BACK,ratePerHour);
    }
}
