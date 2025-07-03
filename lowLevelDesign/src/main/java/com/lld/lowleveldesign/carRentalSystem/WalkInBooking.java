package com.lld.lowleveldesign.carRentalSystem;

import java.util.Date;

public class WalkInBooking implements BookingStrategy{
    @Override
    public Reservation bookVehicle(Vehicle vehicle, User user, Date endTime){
        return new Reservation(vehicle,user,endTime,null,this,new CashPayment());
    }
}
