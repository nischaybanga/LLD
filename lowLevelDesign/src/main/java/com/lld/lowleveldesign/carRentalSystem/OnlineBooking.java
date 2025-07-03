package com.lld.lowleveldesign.carRentalSystem;

import java.util.Date;

public class OnlineBooking implements BookingStrategy{
    @Override
    public Reservation bookVehicle(Vehicle vehicle, User user, Date endTime){
        return new Reservation(vehicle,user,endTime,new Discount(20,100),this,new OnlinePayment());
    }
}
