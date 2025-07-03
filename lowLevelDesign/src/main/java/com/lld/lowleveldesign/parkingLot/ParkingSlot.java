package com.lld.lowleveldesign.parkingLot;

import lombok.Data;

@Data
public class ParkingSlot {
    private static int id;
    private VehicleType parkingSlotType;
    private boolean isOccupied;
    private Vehicle vehicle;
    public ParkingSlot (VehicleType parkingSlotType, boolean isOccupied, Vehicle vehicle) {
        id++;
        this.parkingSlotType = parkingSlotType;
        this.isOccupied = isOccupied;
        this.vehicle = vehicle;
    }
    public boolean getIsOccupied(){
        return isOccupied;
    }

    public boolean canParkVehicle(Vehicle vehicle){
        if (this.isOccupied){
            return false;
        }
        return this.parkingSlotType.equals(vehicle.getVehicleType());
    }

    public boolean parkVehicle(Vehicle vehicle){
        if (canParkVehicle(vehicle)){
            this.vehicle=vehicle;
            this.isOccupied=true;
            return true;
        }
        return false;
    }

    public boolean vacate(){
        if (!this.isOccupied){
            return false;
        }
        this.isOccupied=false;
        this.vehicle=null;
        return true;
    }
    public int getId(){
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getParkingSlotType() {
        return parkingSlotType;
    }
}
