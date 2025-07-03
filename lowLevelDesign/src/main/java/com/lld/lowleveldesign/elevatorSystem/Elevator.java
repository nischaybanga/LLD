package com.lld.lowleveldesign.elevatorSystem;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    public int id;
    public Floor currentFloor;
    public Direction direction;
    public Queue<ElevatorRequest> requestQueue;
    public static int idCounter=0;

    public Elevator(Floor currentFloor, Direction direction) {
        idCounter++;
        this.id = idCounter;
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.requestQueue = new LinkedList<>();
    }
    public void addRequestToElevatorQueue(ElevatorRequest elevatorRequest){
        if (!requestQueue.contains(elevatorRequest)) {
            requestQueue.add(elevatorRequest);
        }
    }
    public void moveToNextFloor(int nextStop){
        if (nextStop==currentFloor.floorNumber){
            requestQueue.removeIf(request -> request.destinationFloor.floorNumber==nextStop);
            return;
        }
        if (nextStop>currentFloor.floorNumber){
            direction=Direction.UP;
        }else{
            direction=Direction.DOWN;
        }
        while(nextStop!=currentFloor.floorNumber){
            if(Direction.UP.equals(direction)){
                this.currentFloor.floorNumber++;
            }else{
                this.currentFloor.floorNumber--;
            }
            System.out.printf("Elevator with id %d has reached floor %d\n", id, currentFloor.floorNumber);
        }
        if (currentFloor.floorNumber==nextStop){
            requestQueue.removeIf(request -> request.destinationFloor.floorNumber==nextStop);
        }
        if (requestQueue.isEmpty()){
            this.direction=Direction.IDLE;
        }
    }
}
