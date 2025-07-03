package com.lld.lowleveldesign.carRentalSystem;

import com.lld.lowleveldesign.elevatorSystem.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalDemo {
    public static void main(String[] args) {
        List<RentalStore> rentalStores = new ArrayList<>();
        List<Vehicle>vehicles1 = new ArrayList<>();
        vehicles1.add(new HatchBack("i20","petrol","DL9CAZ8108","White",30));
        vehicles1.add(new SUV("punch","petrol","DL10CX9021","Grey",30));
        vehicles1.add(new Sedan("activa","petrol","DL9SBU0254","Grey",10));
        rentalStores.add(new RentalStore(new Location(0,0,"ABC","DWARKA"),new InventoryManager(vehicles1)));

        List<Vehicle>vehicles2 = new ArrayList<>();
        vehicles2.add(new HatchBack("celerio","petrol","DL9CAZ8008","White",30));
        vehicles2.add(new SUV("kia","petrol","DL10CX1021","Grey",20));
        vehicles2.add(new Sedan("alto","petrol","DL9SBU3254","Grey",10));
        rentalStores.add(new RentalStore(new Location(0,0,"ABC","GK"),new InventoryManager(vehicles2)));

        RentalSystem rentalSystem=new RentalSystem(rentalStores);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Request car");
            System.out.println("2. get car statuses ");
            System.out.println("3. unbook a car");
            int choice = scanner.nextInt(); // Read user's menu choice
            switch (choice) {
                case 1:
                    System.out.printf("Please enter your userName\n");
                    String userName=scanner.next();
                    System.out.printf("Please enter your locality\n");
                    String locality=scanner.next();
                    System.out.printf("Please enter your vehicle type\n");
                    String vehicleType=scanner.next();
                    System.out.printf("Please enter number of days\n");
                    int days=scanner.nextInt();
                    System.out.printf("Please enter booking type\n");
                    String bookingType=scanner.next();
                    rentalSystem.bookCar(userName, locality, vehicleType, days, bookingType);
                    break;
                case 2:
                    rentalSystem.getStoresStatus();
                    break;
                case 3:
                    System.out.printf("Please enter your userName\n");
                    String userName2=scanner.next();
                    rentalSystem.unbookCar(userName2);
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
