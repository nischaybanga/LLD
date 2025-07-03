package com.lld.lowleveldesign.elevatorSystem;

public class ExternalRequest extends ElevatorRequest{
    public ExternalRequest(int elevatorId, Direction requestDirection,Floor destinationFloor,ElevatorController elevatorController) {
        super(elevatorId, requestDirection, destinationFloor,elevatorController);
    }
    @Override
    public void execute(){
        elevatorController.requestElevator(elevatorId,destinationFloor.floorNumber,requestDirection);
    }
}
