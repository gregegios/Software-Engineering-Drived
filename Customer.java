package com.mycompany.sotware_project;
import java.util.*;


public class Customer extends User{
    
    //private int customer_id;
    private String customerName;
    private String email;
    public String password;
    public int phoneNumber;
    private Date birthDate;
    public String payment_method;
    public ArrayList<Customer> customerList;
    public ArrayList<Float> priceList;
    public ArrayList<String> locationList;
    //public ArrayList<Calendar_Customer> datesList;
    
    public Customer(int user_id,String user_type,String customerName, String email, String password, int phoneNumber, Date birthDate, String payment_method){
        super(user_id, user_type);
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.payment_method = payment_method;
        this.customerList = new ArrayList<Customer>();
        this.locationList = new ArrayList<String>();
        this.priceList = new ArrayList<Float>();
        //this.datesList=new ArrayList<Calendar_custumer>();
    }
    
    public void customer_interface(Customer cust){
        car newcar=new car(0,0,".",0,".",0,0,0,0,0,0,0);
        System.out.println("Press 1 for Sign Up and 2 for Log In");
        Scanner silo = new Scanner(System.in);
        int sl = silo.nextInt();
        if(sl==1){
            customer_Sign_Up();
            System.out.println("Choose options: \n1. Rent a car \n2. Comment and rate driving experience");
            Scanner opt = new Scanner(System.in);
            int op = opt.nextInt();
            if(op==1){
                cust.rent_a_car(newcar);
            }
            else if(op==2){
                commentRating(cust);
            }
            else{
                customer_login(cust);
            }
        }
    }
    
    public void customer_login(Customer cust){
        //int car_id,float price,String carType,float drive_range,String pinakida, int insurance,double rating,double dailyCost, double hourlyCost ,int provider_id,int arithmos_kykloforias, int inspected
        car newcar=new car(0,0,".",0,".",0,0,0,0,0,0,0);
        
        //USER_ID, USER_TYPE, CYSTOMER_NAME, EMAIL, PASSWORD, PHONE_NUMBER, BIRTHDATE, PAYMENT_METHOD
        customerList.add(new Customer(1,"customer","name","email","pass",687,birthDate,"card"));
         customerList.add(new Customer(2,"customer","pascal" ,"pass1","pascal@gmail.com",6988888,birthDate,"card"));
         customerList.add( new Customer(3,"customer","greg" ,"pass2","greg@gmail.com",6977777,birthDate,"crypto")); 
         
         System.out.println("Log in as Customer insert id:");
         Scanner code = new Scanner(System.in);
         int co = code.nextInt();
         
         for(int i=0; i<this.customerList.size(); i++){
             System.out.println(this.customerList.get(i).user_id);
             
             if(this.customerList.get(i).user_id==co){
                 System.out.println("Choose options: \n1. Rent a car \n2. Comment and rate a driving experience \n3. Exit");
                 Scanner opt = new Scanner(System.in);
                 int op = opt.nextInt();
                 if(op==1){
                     cust.rent_a_car(newcar);
                 }
                 else if(op==2){
                     commentRating(cust);
                 }
                 else{
                     System.exit(0);
                 }
             } else{
                 System.out.println("ID incorrect try again");
                 customer_login(cust);
             }   
         }         
    }
    
    public void customer_Sign_Up(){
        
        Random rand = new Random();
        int upperbound = 100;
        int id = rand.nextInt(upperbound);
        Date birthdate = new Date();
        
        Scanner newCEmail = new Scanner(System.in);
        System.out.println("Please add your email\n");
        String nCemail = newCEmail.nextLine();
        
        Scanner newCName = new Scanner(System.in);
        System.out.println("Please add your name\n");
        String nCname = newCName.nextLine();
        
        Scanner newCsurname = new Scanner(System.in);
        System.out.println("Please add your surname\n");
        String nSname = newCsurname.nextLine();
        
        
        Scanner newCphone = new Scanner(System.in);
        System.out.println("Please add your phonenumber\n");
        int nCphone= newCphone.nextInt();
         
        Scanner newCpass = new Scanner(System.in);
        System.out.println("Please add your password\n");
        String nCpass= newCpass.nextLine(); 
        
        Scanner newCpay = new Scanner(System.in);
        System.out.println("Please add your payment method\n");
        String nCpay= newCpay.nextLine();
        
        //int user_id,String user_type,String customerName, String email, String password, int phoneNumber, Date birthDate, String payment_method
        Customer newcustomer= new Customer(id,"customer",nCname, nCemail, nCpass, nCphone, birthdate, nCpay);
        this.customerList.add(newcustomer);
        System.out.println("You are signed up !\n");
        
    }
    
    public void rent_a_car(car carl){
        
        System.out.println("Rent a Car");
        ArrayList<car> availableCars = carl.getCarList();
        //Display the available cars on the map 
        for(int i=0; i<availableCars.size(); i++){
            //car carl = availableCars.get(i);
            System.out.println("Car "+ (i+1) + ":" + carl.getCarType() + "-Provider: " + carl.getProviderId());
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a number to view details: ");
        int carNumber = scanner.nextInt();
        
        //Check if the car number is valid
        if(carNumber >= 1 && carNumber <= availableCars.size()){
            car selectedCar =availableCars.get(carNumber - 1);
            
            //Display car details 
            System.out.println("Car Type: " + selectedCar.getCarType());
            System.out.println("Provider: " + selectedCar.getProviderId());
            System.out.println("Rating: " + selectedCar.getRating());
            System.out.println("Daily Cost: $" + selectedCar.getDailyCost());
            System.out.println("Hourly Cost: $" + selectedCar.getHourlyCost());
            
            // Simulate renting process
            System.out.println("Press 'r' to rent this car or any other key to go back.");
            String choice = scanner.next();
            
            if (choice.equalsIgnoreCase("r")) {
                // Proceed with the rental process
                System.out.println("Enter rental duration in hours: ");
                int duration = scanner.nextInt();
                
                // Calculate rental cost
                double cost = (duration >= 24) ? selectedCar.getDailyCost() * (duration / 24) :
                                                 selectedCar.getHourlyCost() * duration;
                
                System.out.println("Total Cost: $" + cost);
                
                // Proceed to payment (implementation not included in this code snippet)
            }   
        }
        else{
            System.out.println("Invalid car number. Please try again.");
        }        
        scanner.close();
    }
    
    public void rate_driving(Customer cust){
       Scanner rcrentid = new Scanner(System.in);
       System.out.println("please add the rent id\n");
       String ratingrentid= rcrentid.nextLine();
       int ratingrentidint = Integer.parseInt(ratingrentid);
       
       Scanner newComment = new Scanner(System.in);
       System.out.println("Type your comment\n");
       String nComment= newComment.nextLine();
       
       Scanner newRating = new Scanner(System.in);
       System.out.println("Enter your rating 1-5\n");
       String nRating= newRating.nextLine();
       float fnRating=Float.parseFloat(nRating);
       
       Date birthdate=new Date();
       //int car_id,float price,String carType,float drive_range,String pinakida, int insurance,double rating,double dailyCost, double hourlyCost ,int provider_id,int arithmos_kykloforias, int inspected
       car newcar=new car(0,0,".",0,".",0,0,0,0,1,1,0);
       //int user_id,String user_type,String customerName, String email, String password, int phoneNumber, Date birthDate, String payment_method
       Customer newcustomer=new Customer(0,"customer","name","pass","email",687,birthdate,"card");
       Rent nrent=new Rent();
       
       Ratings newrating= new Ratings();
       
       newrating.rateList.add(newrating);
       Scanner leav = new Scanner(System.in);
                System.out.println("Press 1 if you would like to log out ,0 if you would like to go to the home page");
                int lea= leav.nextInt();
                if (lea==1){
                    System.exit(0);
                }
                else{
                    customer_login(cust);
                }
       
    }
    
    public void chooseDate(car carl){
        
        List<car> availableCars = carl.getCarList();
        // Display the available cars on the map
        for (int i = 0; i < availableCars.size(); i++) {
            car carn = availableCars.get(i);
            System.out.println("Car " + (i + 1) + ": " + carn.getCarType() + " - Provider: " + carn.getProviderId());
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a car number to make a reservation: ");
        int carNumber = scanner.nextInt();
        
        // Check if the car number is valid
        if (carNumber >= 1 && carNumber <= availableCars.size()) {
            car selectedCar = availableCars.get(carNumber - 1);
            
            // Check if the car is already reserved
            if (selectedCar.getReserved()== true) {
                System.out.println("This car is already reserved. Please choose another car.");
            } else {
                // Set the reservation status of the car
                selectedCar.setReserved(true);
                
                System.out.print("Enter reservation date (YYYY-MM-DD): ");
                String reservationDate = scanner.next();
                
                // TODO: Process the reservation date and perform any necessary validation or formatting
                
                System.out.println("Car reserved successfully for " + reservationDate);
            }
        } else {
            System.out.println("Invalid car number. Please try again.");
        }
        
        scanner.close();
        
    }
     public void payment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a payment method:");
        System.out.println("1. Card Payment");
        System.out.println("2. Skrill");
        System.out.println("3. Crypto");
        System.out.print("Enter your choice: ");
        
        int paymentMethod = scanner.nextInt();
        
        switch (paymentMethod) {
            case 1:
                System.out.println("Card Payment selected.");
                // Implement card payment logic here
                break;
            case 2:
                System.out.println("Skrill selected.");
                // Implement Skrill payment logic here
                break;
            case 3:
                System.out.println("Crypto selected.");
                // Implement crypto payment logic here
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        
        scanner.close();
    }
     
    public void commentRating(Customer cust){
       Scanner rcrentid = new Scanner(System.in);
       System.out.println("please add the rent id\n");
       String ratingrentid= rcrentid.nextLine();
       int ratingrentidint = Integer.parseInt(ratingrentid);
       
       Scanner newComment = new Scanner(System.in);
       System.out.println("Type your comment\n");
       String nComment= newComment.nextLine();
       
       Scanner newRating = new Scanner(System.in);
       System.out.println("Enter your rating 1-5\n");
       String nRating= newRating.nextLine();
       float fnRating=Float.parseFloat(nRating);
       
       Date birthdate=new Date();
       //int car_id,float price,String carType,float drive_range,String pinakida, int insurance,double rating,double dailyCost, double hourlyCost ,int provider_id,int arithmos_kykloforias, int inspected
       car newcar=new car(0,0,".",0,".",0,0,0,0,0,1,0);
       //int user_id,String user_type,String customerName, String email, String password, int phoneNumber, Date birthDate, String payment_method
       Customer newcustomer=new Customer(0,"costumer","name","pass","email",687,birthDate,"card");
       Rent nrent=new Rent();
       
       Ratings newrating= new Ratings();
       
       newrating.rateList.add(newrating);
       Scanner leav = new Scanner(System.in);
       
       System.out.println("Press 1 if you would like to log out ,0 if you would like to check out other drones");
                int lea= leav.nextInt();
                if (lea==1){
                    System.exit(0);
                }
                else{
                    customer_login(cust);
                }
    }
}
