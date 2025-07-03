package com.lld.lowleveldesign.parkingLot;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean processPayment(double amount){
        System.out.println("Processing cash payment of amount " + amount);
        return true;
    }
}
