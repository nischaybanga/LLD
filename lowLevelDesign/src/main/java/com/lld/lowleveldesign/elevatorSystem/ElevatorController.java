package com.lld.lowleveldesign.elevatorSystem;

import java.util.List;

public class ElevatorController {
    public List<Elevator> elevators;
    public SchedulingStrategy schedulingStrategy;

    public ElevatorController(List<Elevator> elevators) {
        this.elevators = elevators;
        this.schedulingStrategy=new FirstCumFirstServeSchedulingStrategy();
    }

    public void requestElevator(int elevatorId,int floorNumber, Direction direction) {
        Elevator elevator = getElevator(elevatorId);
        if (elevator == null) {
            System.out.println("No elevator available for floor " + floorNumber);
            return;
        }
        ElevatorRequest request=new ExternalRequest(elevatorId,direction,new Floor(floorNumber),this);
        elevator.addRequestToElevatorQueue(request);
    }
    public void requestFloor(int floorNumber,int elevatorId) {
        Elevator elevator = getElevator(elevatorId);
        if (elevator == null) {
            System.out.println("No elevator available for floor " + floorNumber);
            return;
        }
        ElevatorRequest request=new InternalRequest(elevatorId,new Floor(floorNumber),this);
        elevator.addRequestToElevatorQueue(request);
    }

    public Elevator getElevator(int elevatorId) {
        for (Elevator elevator : elevators) {
            if (elevator.id == elevatorId) {
                return elevator;
            }
        }
        return null;
    }

    public void step(){
        for (Elevator elevator : this.elevators) {
            if (elevator.requestQueue==null||elevator.requestQueue.isEmpty()) {
                continue;
            }
            Floor nextFloor=schedulingStrategy.getNextStop(elevator);
            if (nextFloor==null) {
                continue;
            }
            elevator.moveToNextFloor(nextFloor.floorNumber);
        }
    }
    public void showElevatorsStatus(){
        for (Elevator elevator : this.elevators) {
            System.out.printf("Elevator %d is at floor %d and has direction %s\n" ,elevator.id,elevator.currentFloor.floorNumber,elevator.direction.name());
            if (elevator.requestQueue==null||elevator.requestQueue.isEmpty()) {
                System.out.printf("No requests for elevator %d\n" ,elevator.id);
            }

        }
    }

}