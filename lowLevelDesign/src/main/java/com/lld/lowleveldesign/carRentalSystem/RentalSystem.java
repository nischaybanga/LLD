package com.lld.lowleveldesign.carRentalSystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RentalSystem {
    List<RentalStore>rentalStores;
    List<User>users;
    public RentalSystem(List<RentalStore> rentalStores) {
        this.rentalStores = rentalStores;
        this.users = new ArrayList<>();
    }
    public Vehicle bookCar(String userName,String locality,String vehicleTypeStr,int numberOfDays,String bookingType){
        VehicleType vehicleType=VehicleType.parse(vehicleTypeStr);
        if (vehicleType==null){
            System.out.printf("Sorry this type of vehicle not available\n");
            return null;
        }
        User userSelect=null;
        for (User user : users){
            if (user.userName.equalsIgnoreCase(userName)&&user.vehicle!=null){
                System.out.printf("Already have a booking");
                return null;
            }else if(user.userName.equalsIgnoreCase(userName)){
                userSelect=user;
            }
        }
        if(userSelect==null){
            userSelect=new User(userName,null);
            users.add(userSelect);
        }
        RentalStore selectedRentalStore=null;
        for (RentalStore store:rentalStores){
            if(store.location.locality.equalsIgnoreCase(locality)){
                selectedRentalStore=store;
            }
        }
        if (selectedRentalStore==null){
            System.out.printf("No store found!");
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, numberOfDays);
        Date futureDate = calendar.getTime();
        Vehicle vehicleBooked=selectedRentalStore.bookVehicle(vehicleType,userSelect,futureDate,bookingType);
        return vehicleBooked;
    }

    public boolean unbookCar(String userName){
        User userSelect=null;
        for (User user : users){
            if (user.userName.equalsIgnoreCase(userName)&&user.vehicle!=null){
                userSelect=user;
            }
        }
        if(userSelect==null){
            System.out.printf("No Booking found!");
            return false;
        }
        RentalStore rentalStore=null;
        int rentalStoreId=userSelect.rentalStoreId;
        for (RentalStore store:rentalStores){
            if (rentalStoreId==store.id){
                rentalStore=store;
                break;
            }
        }
        if (rentalStore==null){
            System.out.printf("No store found!");
            return false;
        }
        return rentalStore.inventoryManager.unbookVehicle(userSelect);
    }
    public void getStoresStatus(){
        for (RentalStore store:rentalStores){
            System.out.printf("%s store car statuses are as followed \n",store.location.locality);
            store.inventoryManager.getReservationStatus();
        }
    }
}
