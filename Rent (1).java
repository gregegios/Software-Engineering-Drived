package com.mycompany.sotware_project;
import java.util.Scanner;

public class Rent {
    private int rentalID;
    private int customerID;
    private int ownerID;
    private int providerID;
    private String licensePlate;

    public Rent() {
        rentalID = 0;
        customerID = 0;
        providerID = 0;
        licensePlate = "";
    }
    public void rentCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rental ID:");
        rentalID = scanner.nextInt();

        System.out.println("Enter customer ID:");
        customerID = scanner.nextInt();

        System.out.println("Enter providers ID:");
        providerID = scanner.nextInt();

        System.out.println("Enter license plate:");
        licensePlate = scanner.nextLine();
    }
}
