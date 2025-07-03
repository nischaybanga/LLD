package com.lld.lowleveldesign.parkingLot;

public enum VehicleType {
    CAR,BIKE;
    public static VehicleType parse(String type){
        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.name().equalsIgnoreCase(type)) {
                return vehicleType;
            }
        }
        return null;
    }
}
