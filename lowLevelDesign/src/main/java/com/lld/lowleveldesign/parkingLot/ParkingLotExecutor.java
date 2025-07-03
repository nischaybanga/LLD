package com.lld.lowleveldesign.parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLotExecutor {
    public static void main(String[] args) {
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        ParkingSlot bike1=new ParkingSlot(VehicleType.BIKE,false,null);
        ParkingSlot bike2=new ParkingSlot(VehicleType.BIKE,false,null);
        ParkingSlot bike3=new ParkingSlot(VehicleType.BIKE,false,null);
        ParkingSlot car1=new ParkingSlot(VehicleType.CAR,false,null);
        ParkingSlot car2=new ParkingSlot(VehicleType.CAR,false,null);
        parkingSlots.add(bike1);
        parkingSlots.add(bike2);
        parkingSlots.add(bike3);
        parkingSlots.add(car1);
        parkingSlots.add(car2);
        ParkingLot parkingLot=new ParkingLot(parkingSlots);
        List<Vehicle>vehicles=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please enter your action type, 1 to park, 2 to vacate, 3 to exit,4 to print state of parking lot");
            int type=scanner.nextInt();
            if (type==1){
                System.out.println("Please enter the vehicle type you want to park");
                String vehicleType=scanner.next();
                VehicleType vehicleTypeEnum=VehicleType.parse(vehicleType);
                if (vehicleTypeEnum==null){
                    System.out.println("Please enter a valid vehicle type, please start again");
                    continue;
                }
                System.out.println("Please enter the fair type you want to choose, 1 for hourly and 2 for day basis");
                int fairType=scanner.nextInt();
                if (fairType!=1&&fairType!=2){
                    System.out.println("Please enter a valid fair type, please start again");
                    continue;
                }
                FareStrategy fareStrategy=null;
                if (fairType==1){
                    fareStrategy=new HourlyFareStrategy();
                }else{
                    fareStrategy=new DayWiseFareStrategy();
                }
                System.out.println("Please enter the license plate number");
                String licensePlate=scanner.next();
                Vehicle vehicle=new Vehicle(licensePlate,vehicleTypeEnum,fareStrategy);

                boolean parkedSuccessfully=parkingLot.park(vehicle);
                if (parkedSuccessfully){
                    vehicles.add(vehicle);
                }else{
                    System.out.println("Parking failed failed");
                }
            }else if (type==2){
                System.out.println("Please enter the license plate number of the vehicle you want to vacate");
                String licensePlate=scanner.next();
                boolean vacatedSuccessfully=parkingLot.vacate(licensePlate);
                if (vacatedSuccessfully){
                    System.out.printf("Vacated successfully");
                }else{
                    System.out.printf("Not Vacated");
                }
            }else if (type==3){
                break;
            }else if (type==4){
                List<ParkingSlot>parkingSlotsCurrently=parkingLot.getParkingSlots();
                for (ParkingSlot parkingSlot:parkingSlotsCurrently){
                    System.out.printf("parking lot id-> %s",parkingSlot.getId());
                    if (parkingSlot.getIsOccupied()&&parkingSlot.getVehicle()!=null){
                        System.out.printf(" vehicle parked-> %s\n",parkingSlot.getVehicle().getLicensePlate());
                    }else{
                        System.out.printf(" and it's empty\n");
                    }
                }
            }else{
                System.out.println("Invalid input, please enter your action type, 1 to park, 2 to vacate");
                scanner.nextLine();
            }
        }
    }
}
