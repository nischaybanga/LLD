package com.lld.lowleveldesign.carRentalSystem;

import java.util.Date;

public class CashPayment implements PaymentStrategy{
    @Override
    public boolean acceptPayment(Reservation reservation){
        Date endTime=reservation.endTime;
        Date startTime=reservation.startTime;
        long diffInMillies = endTime.getTime() - startTime.getTime();
        int hoursDifference =(int) diffInMillies / (1000 * 60 * 60);
        int rate=reservation.vehicle.ratePerHour;
        int amount=rate*hoursDifference;
        System.out.printf("Payment of %d accepted by user %s for reservation id %d",amount,reservation.user.userName,reservation.id);
        return true;
    }
}
