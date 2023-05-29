package com.mycompany.sotware_project;
import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class Ratings {
    private int score;
    private String comment;
    private String customerId;
    private String licensePlate;
    private String providerID;
    private String rentalID;
    public ArrayList<Ratings> rateList;
    //Ratings r = new Ratings();
    
     public Ratings() {
        score = 0;
        comment = "";
        customerId = "";
        licensePlate = "";
        providerID = "";
        rentalID = "";
    }
     
    public void rateDrivingExperience() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rate your driving experience from 1 to 5:");
        score = scanner.nextInt();
        if (score < 1 || score > 5) {
            System.out.println("Invalid rating! Please enter a value between 1 and 5.");
            score = 0;
        }
    }
    
    public void leaveComment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Leave a comment (up to 500 characters):");
        comment = scanner.nextLine();
    }
    
    public void noComment() {
        rateList.add(null);
    }


    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setproviderID(String providerID) {
        this.providerID = providerID;
    }

    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }


}
