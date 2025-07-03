package com.lld.lowleveldesign.carRentalSystem;

public abstract class Vehicle {
    public int id;
    public String name;
    public String fuelType;
    public String numberPlate;
    public String colour;
    public boolean isBooked;
    public int ratePerHour;
    public VehicleType vehicleType;
    public static int counter=0;
    public Vehicle(String name, String fuelType, String numberPlate, String colour,VehicleType vehicleType,int ratePerHour) {
        this.id = ++counter;
        this.name = name;
        this.fuelType = fuelType;
        this.numberPlate = numberPlate;
        this.colour = colour;
        this.vehicleType = vehicleType;
        this.isBooked = false;
        this.ratePerHour = ratePerHour;
    }

}
