package com.lld.lowleveldesign.parkingLot;

public interface PaymentStrategy {
    public boolean processPayment(double amount);
}
