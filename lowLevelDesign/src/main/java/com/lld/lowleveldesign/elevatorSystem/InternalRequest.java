package com.lld.lowleveldesign.elevatorSystem;

public class InternalRequest extends ElevatorRequest {
    public InternalRequest(int elevatorId, Floor destinationFloor, ElevatorController elevatorController) {
        super(elevatorId, null, destinationFloor,elevatorController);
    }
    @Override
    public void execute(){
        elevatorController.requestFloor(destinationFloor.floorNumber,elevatorId);
    }
}
