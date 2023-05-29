package com.mycompany.sotware_project;
import java.util.Date;
import java.util.Scanner;


public class Admin extends User{
    
    private final int admin_id;
    private String adminName;
    private String email;
    private String password;
    private Date birthdate;
    
    public Admin(int user_id, String user_type,int admin_id, String adminName, String email, String password, Date birthdate){
        super(user_id, user_type);
        this.admin_id = admin_id;
        this.adminName = adminName;
        this.email = email;
        this.password = password;
    }
    
    public void initiate_authentication(){
        System.out.println("To Log In as Admin, please insert code:"); //code must be 123
        Scanner code = new Scanner(System.in);
        int co = code.nextInt();
        if(co==123){
            System.out.println("Choose options:\n1. Delete user \n2. Approve provider \n3. Inspect Car \n4. Leave");
            Scanner opt = new Scanner(System.in);
            int op = opt.nextInt();
            if(op==1){
                Delete_user();
            }
            else if(op==2){
                approve_provider();
            }
            else if(op==3){
                inspect_car();
            }
            else{
                System.exit(0);
            }
        }
        else{
            System.out.println("Password incorrect try again");
            initiate_authentication();
        }
    }
    
    public void Delete_user(){
        
        User u1 = new User(1,"customer");
        User u2 = new User(2,"provider");
        u1.setUser(u1);
        u2.setUser(u2);
        
        System.out.println("Choose a user option to delete");
        Scanner del = new Scanner(System.in);
        System.out.println("Please type the user id you want to delete");
        String id_del = del.nextLine();
        int id_int_del = Integer.parseInt(id_del);
        for(int i=0; i<u1.users.size(); i++){
            if(u1.users.get(i).user_id==id_int_del){
                u1.users.remove(i);
                System.out.println("USER DELETED SUCCESSFULLY");
            }
        }
        for(int i=0; i<u1.users.size(); i++){
            System.out.println("User id: " +u1.users.get(i).user_id);
            System.out.println("User type: " + u1.users.get(i).user_type);
        }
        initiate_authentication();      
    }
    
    public void approve_provider(){
        //public car(int car_id,float price,String carType,float drive_range,String pinakida, int insurance,double rating,double dailyCost, double hourlyCost ,int provider_id,int arithmos_kykloforias)
        car newcar = new car(0,0,".",0,".",0,0.0,0,0,0,1,0);
        //int user_id, String user_type, String username, String password, String pr_email, int phoneNum, Date birthdate,Car car, int approveValue
        Provider provider = new Provider(4,"provider","Depi","ef234","depi@outlook.gr",37897,birthdate,newcar,1);
        System.out.println(provider.username);
        System.out.println(provider.password);
        System.out.println(provider.pr_email);
        System.out.println(provider.phoneNum);
        System.out.println(provider.birthdate);
        System.out.println(provider.car1);
        System.out.println(provider.approveValue);
        
        System.out.println("Do you approve this provider? Type 1 if Yes or 2 if No");
        Scanner answer = new Scanner(System.in);
        String ans = answer.nextLine();
        int ianswer = Integer.parseInt(ans);
        
        if(ianswer==1){
            provider.approveValue=1;
            System.out.println("Provider approved!");
            System.out.println("New approve value of provider:" +provider.approveValue);
        }
        else if(ianswer==2){
            provider.approveValue=0;
            System.out.println("You did not approve this provider");
            System.out.println("New apprive value of provider:\t" +provider.approveValue);
        }
        initiate_authentication();
    }
    
    public void inspect_car(){
        //int car_id,float price,String carType,float drive_range,String pinakida, int insurance,double rating,double dailyCost, double hourlyCost ,int provider_id,int arithmos_kykloforias
        car newcar = new car(0,0,".",0,".",0,0,0,0,0,0,0);
        car newcar1 = new car(23,23000,"BMW E36 2021",110,"XXK2349",34,4,60,23,4,990,0);
        car newcar2 = new car(24,16000,"Audi A3",250,"AXK2890",21,4.6,77,18,1,945,0);
        car newcar3 = new car(25,89000,"Tesla Model X Long Range",350,"EEX3455",8,3.2,50,12,2,578,0);
        
        try{
            newcar.set_carList(newcar1);
            newcar.set_carList(newcar2);
            newcar.set_carList(newcar3);
        }
        catch(D2DException e){
            
        }
        
        for(int i=0; i<newcar.carList.size(); i++){
            if(newcar.carList.get(i).inspected==0){
                for(int j=0; j<newcar.carList.size(); j++){
                    System.out.println(newcar.carList.get(j));
                }
            }
        }
        System.out.println("Choose a car to inspect by ID");
        
        Scanner carid = new Scanner(System.in);
        int carId = carid.nextInt();
        
        Scanner keybord = new Scanner(System.in);
        System.out.println("Choose action for selected car:");
        System.out.println("1. Inspect Car");
        System.out.println("2. Delete Car");
        System.out.println("3. Set Availability");
        System.out.println("4. Leave");
        
        Scanner choice= new Scanner(System.in);   
        int ichoice = choice.nextInt();
        
        if (ichoice == 1){
            Scanner newapproved = new Scanner(System.in);

            System.out.println("Set car status:");
            System.out.println("1. Approve car");
            System.out.println("2. Decline car");

            String approved = newapproved.nextLine();
            int iapproved = Integer.parseInt(approved);
            
            if (iapproved == 1) {
                newcar2.inspected = 1;        
                System.out.println("Car successfuly approved");
            }
           else if (iapproved == 0) {
                newcar2.inspected = 0;
                Scanner comm = new Scanner(System.in);
                System.out.println("Input reason for declining car:");
                String comment = comm.nextLine();
        }
        
    }
        else if(ichoice == 2){
            System.out.println("Are you sure you want to delete this car?");
            newcar2.carList.remove(newcar2);
        }
        
        else if (ichoice == 3) {
            
        }
        else{
        System.exit(0);
       }
      initiate_authentication();
    
}
}
