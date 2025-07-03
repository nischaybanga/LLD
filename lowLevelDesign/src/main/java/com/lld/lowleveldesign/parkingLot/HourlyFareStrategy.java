package com.lld.lowleveldesign.parkingLot;

public class HourlyFareStrategy implements FareStrategy {
    @Override
    public int calculateFare(Vehicle vehicle,int duration){
        if (VehicleType.CAR.equals(vehicle.getVehicleType())){
            return duration*20;
        }else if(VehicleType.BIKE.equals(vehicle.getVehicleType())){
            return duration*10;
        }else{
            return duration*5;
        }
    }
}
