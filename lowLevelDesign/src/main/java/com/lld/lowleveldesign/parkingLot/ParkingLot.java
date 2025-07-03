package com.lld.lowleveldesign.parkingLot;

import java.util.List;

public class ParkingLot {
    List<ParkingSlot> parkingSlots;
    public ParkingLot(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }
    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
    public ParkingSlot getAvailableSlot(Vehicle vehicle){
        for(ParkingSlot parkingSlot : this.parkingSlots){
            if (!parkingSlot.getIsOccupied()&&parkingSlot.getParkingSlotType().equals(vehicle.getVehicleType())){
                return parkingSlot;
            }
        }
        return null;
    }

    public boolean park(Vehicle vehicle){
        ParkingSlot slot=getAvailableSlot(vehicle);
        if (slot==null){
            System.out.println("Sorry no parking slots available");
            return false;
        }
        return slot.parkVehicle(vehicle);
    }

    public boolean vacate(String licensePlate){
        ParkingSlot slotToVacate=null;
        for(ParkingSlot slot:this.parkingSlots){
            if (slot.getVehicle()!=null&&licensePlate.equalsIgnoreCase(slot.getVehicle().getLicensePlate())){
                slotToVacate=slot;
                break;
            }
        }
        if (slotToVacate==null){
            System.out.println("Sorry no such car is parked");
            return false;
        }
        return slotToVacate.vacate();
    }
}
