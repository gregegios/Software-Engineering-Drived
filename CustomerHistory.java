package com.mycompany.sotware_project;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class History {
    private LocalDateTime startTime;
    private int customerId;
    private int ownerId;
    private String licensePlate;
    private String route;
    private String location;
    private int paymentId;

    public History(int customerId, int ownerId, String licensePlate, String route, String location, int paymentId) {
        //this.startTime = startTime;
        this.customerId = customerId;
        this.ownerId = ownerId;
        this.licensePlate = licensePlate;
        this.route = route;
        this.location = location;
        this.paymentId = paymentId;
    } 
    
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getRoute() {
        return route;
    }

    public String getLocation() {
        return location;
    }

    public int getPaymentId() {
        return paymentId;
    }

}
