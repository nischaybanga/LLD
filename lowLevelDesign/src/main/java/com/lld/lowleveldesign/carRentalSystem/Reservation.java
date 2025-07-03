package com.lld.lowleveldesign.carRentalSystem;

import java.util.Date;

public class Reservation {
    public int id;
    public Vehicle vehicle;
    public User user;
    public static int counter=0;
    public Date startTime;
    public Date endTime;
    public Discount discount;
    public BookingStrategy bookingStrategy;
    public PaymentStrategy paymentStrategy;
    public boolean isComplete;
    public Reservation (Vehicle vehicle,User user,Date endTime,Discount discount,BookingStrategy bookingStrategy,PaymentStrategy paymentStrategy){
        id = ++counter;
        this.vehicle = vehicle;
        this.user = user;
        this.endTime = endTime;
        this.discount = discount;
        this.bookingStrategy = bookingStrategy;
        this.paymentStrategy = paymentStrategy;
        startTime = new Date();
        isComplete=false;
    }
}
