package com.lld.lowleveldesign.parkingLot;

public interface FareStrategy {
    public int calculateFare(Vehicle vehicle,int duration);
}
