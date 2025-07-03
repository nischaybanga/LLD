package com.lld.lowleveldesign.carRentalSystem;


import java.util.Date;

public class RentalStore {
    public int id;
    public static int counter=0;
    public Location location;
    public InventoryManager inventoryManager;
    public RentalStore(Location location, InventoryManager inventoryManager) {
        this.id=++counter;
        this.location = location;
        this.inventoryManager = inventoryManager;
    }

    public Vehicle bookVehicle(VehicleType vehicleType, User user, Date endTime, String bookingType) {
        Vehicle vehicle=inventoryManager.getAvailableVehicle(vehicleType);
        if(vehicle==null) {
            return null;
        }
        if (inventoryManager.bookVehicle(vehicle,user,endTime,bookingType,id)){
            return vehicle;
        }
        return null;
    }

}
