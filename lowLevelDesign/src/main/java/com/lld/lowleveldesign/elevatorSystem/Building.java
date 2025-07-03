package com.lld.lowleveldesign.elevatorSystem;

public class Building {
    public ElevatorController elevatorController;
    public String name;
    public int floors;
    public Building(ElevatorController elevatorController, String name, int floors) {
        this.elevatorController = elevatorController;
        this.name = name;
        this.floors = floors;
    }
}
