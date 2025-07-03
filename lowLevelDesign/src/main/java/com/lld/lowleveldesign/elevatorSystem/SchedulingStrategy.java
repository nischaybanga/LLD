package com.lld.lowleveldesign.elevatorSystem;

public interface SchedulingStrategy {
    public Floor getNextStop(Elevator elevator);
}
