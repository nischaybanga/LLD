package com.lld.lowleveldesign.carRentalSystem;

import java.util.Date;

public interface BookingStrategy {
    public Reservation bookVehicle(Vehicle vehicle, User user, Date endTime);
}
