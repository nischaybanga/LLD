package com.lld.lowleveldesign.elevatorSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevatorSimulator {
    public static void main(String[] args) {
        List<Elevator>elevators=new ArrayList<>();
        elevators.add(new Elevator(new Floor(0),Direction.IDLE));
        elevators.add(new Elevator(new Floor(0),Direction.IDLE));
        elevators.add(new Elevator(new Floor(0),Direction.IDLE));

        Building building= new Building(new ElevatorController(elevators),"Nischay's Building",20);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        // Display simulation details and options
        System.out.println("Elevator System Simulation");
        System.out.println("Building: " + building.name);
        System.out.println("Floors: " + building.floors);
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Request elevator (external)");
            System.out.println("2. Request floor (internal)");
            System.out.println("3. Simulate next step");
            System.out.println("4. Show elevators status");
            System.out.println("5. Exit simulation");
            int choice = scanner.nextInt(); // Read user's menu choice
            switch (choice) {
                case 1:
                    System.out.print("Enter elevator ID: ");
                    int externalElevatorId = scanner.nextInt();
                    System.out.print("Enter floor number: ");
                    int floorNum = scanner.nextInt();
                    System.out.print("Direction (1 for UP, 2 for DOWN): ");
                    int dirChoice = scanner.nextInt();
                    Direction dir = dirChoice == 1 ? Direction.UP : Direction.DOWN;
                    building.elevatorController.requestElevator(externalElevatorId, floorNum, dir);
                    break;
                case 2:
                    System.out.print("Enter elevator ID: ");
                    int elevatorId = scanner.nextInt();
                    System.out.print("Enter destination floor: ");
                    int destFloor = scanner.nextInt();
                    building.elevatorController.requestFloor(elevatorId, destFloor);
                    break;
                case 3:
                    // Simulate the next step in the system
                    System.out.println("Simulating next step...");
                    building.elevatorController.step();
                    break;
                case 4:
                    building.elevatorController.showElevatorsStatus();
                    break;
                case 5:
                    // Exit the simulation
                    running = false;
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
        System.out.println("Simulation ended");

    }
}
