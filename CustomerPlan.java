package com.mycompany.sotware_project;
import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
import java.util.*;


public class CustomerPlan {
   public Customer customer;
   private ArrayList<Calendar> datesList;
   private ArrayList<String> days;
   public ArrayList<String> availability;
   public Calendar calendar_c;
   private int customerID;
   
   public CustomerPlan(Customer customer,Calendar calendar_c){
       this.customer = customer;
       this.calendar_c=calendar_c;
       this.datesList=datesList;
   }
   
   public void updateDate(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the day you want to rent a car:");
       String day = sc.nextLine();
       days.add(day);
       
       System.out.println("Enter the availability:");
       String avail = sc.nextLine();
       availability.add(avail);
   }
   
}
