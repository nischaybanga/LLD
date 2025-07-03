package com.lld.lowleveldesign.parkingLot;

public class DayWiseFareStrategy implements FareStrategy{
    @Override
    public int calculateFare(Vehicle vehicle,int duration){
        int numberOfDays=1;
        if (duration>=24){
            numberOfDays=duration/24;
        }
        if (VehicleType.CAR.equals(vehicle.getVehicleType())){
            return numberOfDays*100;
        }else if(VehicleType.BIKE.equals(vehicle.getVehicleType())){
            return numberOfDays*50;
        }else{
            return numberOfDays*25;
        }
    }
}
