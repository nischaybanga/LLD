package com.lld.lowleveldesign.carRentalSystem;

public enum VehicleType {
    SEDAN,SUV,HATCH_BACK;
    public static VehicleType parse(String type){
        if (type.equalsIgnoreCase("Sedan")){
            return SEDAN;
        }else if (type.equalsIgnoreCase("Suv")){
            return SUV;
        }else if (type.equalsIgnoreCase("HatchBack")){
            return HATCH_BACK;
        }
        return null;
    }
}
