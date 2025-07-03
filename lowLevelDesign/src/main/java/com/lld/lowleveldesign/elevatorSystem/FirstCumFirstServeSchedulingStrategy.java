package com.lld.lowleveldesign.elevatorSystem;

public class FirstCumFirstServeSchedulingStrategy implements SchedulingStrategy {
    @Override
    public Floor getNextStop(Elevator elevator) {
        Floor currentFloor= elevator.currentFloor;
        ElevatorRequest request=elevator.requestQueue.peek();
        if (request==null){
            return null;
        }
        Floor requestedFloor=request.destinationFloor;
        if (currentFloor.floorNumber==requestedFloor.floorNumber){
            elevator.direction=Direction.IDLE;
        }else if(currentFloor.floorNumber>requestedFloor.floorNumber){
            elevator.direction=Direction.DOWN;
        }else{
            elevator.direction=Direction.UP;
        }
        return requestedFloor;
    }
}
