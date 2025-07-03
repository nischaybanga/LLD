package com.lld.lowleveldesign.elevatorSystem;

public abstract class ElevatorRequest implements ElevatorCommand {
    public int elevatorId;
    public Direction requestDirection;
    public Floor destinationFloor;
    public ElevatorController elevatorController;
    public ElevatorRequest(int elevatorId, Direction requestDirection,Floor destinationFloor,ElevatorController elevatorController) {
        this.elevatorId = elevatorId;
        this.requestDirection = requestDirection;
        this.destinationFloor = destinationFloor;
        this.elevatorController=elevatorController;
    }

}
