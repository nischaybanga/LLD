package com.lld.lowleveldesign.carRentalSystem;

public interface PaymentStrategy {
    public boolean acceptPayment(Reservation reservation);
}
