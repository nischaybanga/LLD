package com.lld.lowleveldesign.elevatorSystem;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
//
//public class ScanServingAlgorithm implements SchedulingStrategy{
//    @Override
//    public Floor getNextStop(Elevator elevator) {
//        PriorityQueue <ElevatorRequest> upQueue = new PriorityQueue<>(); //min PQ
//        PriorityQueue <ElevatorRequest> downQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.destinationFloor.floorNumber, a.destinationFloor.floorNumber)); //max PQ
//        Deque<ElevatorRequest> requestsCopy=new ArrayDeque<>(elevator.requestQueue);
//        while (!requestsCopy.isEmpty()){
//            ElevatorRequest request=requestsCopy.poll();
//            if(request.destinationFloor.floorNumber>elevator.currentFloor.floorNumber){
//                upQueue.add(request);
//            }else {
//                downQueue.add(request);
//            }
//        }
//        if (Direction.IDLE.equals(elevator.direction)){
//            ElevatorRequest firstUpRequest=upQueue.poll();
//            if ()
//        }else if (Direction.UP.equals(elevator.direction)){
//
//        }else {
//
//        }
//    }
//}
