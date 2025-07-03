package com.lld.lowleveldesign.carRentalSystem;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    public Map<Integer,Reservation> reservationMap;
    public List<Vehicle>vehicles;
    public InventoryManager(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        reservationMap = new HashMap<>();
    }

    public Vehicle getAvailableVehicle(VehicleType vehicleType){
        Vehicle vehicleSelected=null;
        for(Vehicle vehicle : this.vehicles){
            if (vehicle.isBooked==true||vehicle.vehicleType!=vehicleType){
                continue;
            }
            vehicleSelected=vehicle;
            break;
        }
        if (vehicleSelected==null){
            System.out.printf("No inventory available for %s",vehicleType.name());
        }
        return vehicleSelected;
    }

    public boolean bookVehicle(Vehicle vehicle,User user, Date endTime,String bookingType,int rentalStoreId){
        for (Vehicle vehicle1 : this.vehicles) {
            if (vehicle1.id==vehicle.id){
                if (vehicle1.isBooked){
                    System.out.printf("Already booked sorry");
                    return false;
                }else{
                    vehicle1.isBooked=true;
                    Reservation reservation=null;
                    if (bookingType.equalsIgnoreCase("Online")){
                        reservation=new OnlineBooking().bookVehicle(vehicle,user,endTime);
                    }else{
                        reservation=new WalkInBooking().bookVehicle(vehicle,user,endTime);
                    }
                    this.reservationMap.put(vehicle.id,reservation);
                    user.vehicle=vehicle;
                    user.rentalStoreId=rentalStoreId;
                    return true;
                }

            }
        }
        return false;
    }

    public boolean unbookVehicle(User user){
        Vehicle vehicleSelected=user.vehicle;
        Reservation reservation=reservationMap.get(vehicleSelected.id);
        if (reservation==null){
            return false;
        }
        boolean paymentRecieved=reservation.paymentStrategy.acceptPayment(reservation);
        if (!paymentRecieved){
            System.out.printf("Could not take payment");
            return false;
        }
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.id==vehicleSelected.id){
                vehicle.isBooked=false;
            }
        }
        reservation.isComplete=true;
        reservationMap.remove(vehicleSelected.id);
        user.vehicle=null;
        user.rentalStoreId=null;
        return true;
    }
    public void getReservationStatus(){
        for (Vehicle vehicle : this.vehicles) {
            System.out.printf("%d car id with name %s with reservation status is %s \n",vehicle.id,vehicle.name,vehicle.isBooked);
        }
        System.out.print("Reservations are: \n");
        for (Integer carId:reservationMap.keySet()){
            Reservation reservation=reservationMap.get(carId);
            System.out.printf("%d car id is taken by user %s and isComplete is %s \n",reservation.vehicle.id,reservation.user.userName,reservation.isComplete);
        }
    }
}
