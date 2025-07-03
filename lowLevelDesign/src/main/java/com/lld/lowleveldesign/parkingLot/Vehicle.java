package com.lld.lowleveldesign.parkingLot;

import lombok.Data;

import java.util.Date;

@Data
public class Vehicle {
    private static int id;
    private String licensePlate;
    private VehicleType vehicleType;
    private FareStrategy fareStrategy;
    private Date entryTime;
    public Vehicle(String licensePlate, VehicleType vehicleType, FareStrategy fareStrategy){
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.fareStrategy = fareStrategy;
        this.entryTime = new Date();
        id++;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
