package com.lld.lowleveldesign.carRentalSystem;

public class VehicleFactory {
    public Vehicle getVehicle(String type,String numberPlate,String name,String fuelType,String colour,int ratePerHour){
        VehicleType vehicleType= VehicleType.parse(type);
        if (vehicleType == null){
            System.out.print("Invalid car type");
            return null;
        }
        if (VehicleType.SUV.equals(vehicleType)){
            return new SUV(name,fuelType,numberPlate,colour,ratePerHour);
        }
        if (VehicleType.SEDAN.equals(vehicleType)){
            return new Sedan(name,fuelType,numberPlate,colour,ratePerHour);
        }
        if (VehicleType.HATCH_BACK.equals(vehicleType)){
            return new HatchBack(name,fuelType,numberPlate,colour,ratePerHour);
        }
        return null;
    }
}
