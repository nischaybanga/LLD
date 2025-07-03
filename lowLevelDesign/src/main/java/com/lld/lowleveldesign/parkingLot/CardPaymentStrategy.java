package com.lld.lowleveldesign.parkingLot;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean processPayment(double amount){
        System.out.println("Processing card payment of amount " + amount);
        return true;
    }
}
