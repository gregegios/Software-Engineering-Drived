package com.mycompany.sotware_project;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProviderHistory extends History {
    List<String> rentals = new ArrayList<>();
    public ProviderHistory(int customerId, int providerId, String licensePlate, String route, String location, int paymentId) {
        super(customerId, providerId, licensePlate, route, location, paymentId);
    }
    public List<String> showprRentals(){
        //List<String> rentals = new ArrayList<>();
        rentals.add(getStartTime().toString() + "-" +getLicensePlate());
        return rentals;
    }
}
