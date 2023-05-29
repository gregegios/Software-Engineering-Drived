package com.mycompany.sotware_project;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Provider extends User{
    
    public String username;
    public String password;
    public String pr_email;
    public int phoneNum;
    public Date birthdate;
    public car car1;
    public int approveValue;
    public ArrayList<Provider> prList;
    
    
    public Provider(int user_id, String user_type, String username, String password, String pr_email, int phoneNum, Date birthdate,car car1, int approveValue){
        super(user_id,user_type);
        this.username = username;
        this.password = password;
        this.pr_email = pr_email;
        this.phoneNum = phoneNum;
        this.birthdate = birthdate;
        this.car1 = car1;
        this.approveValue = approveValue;
        this.prList = new ArrayList<Provider>();
    }
    
    public void provider_interface(Provider provider){       
        System.out.println("Press 1 for Sign Up or 2 for Log In");
        Scanner s = new Scanner(System.in);
        int sl = s.nextInt();
        if(sl==1){
            provider_SignUp();
            provider_login(provider);
        }
        else{
            provider_login(provider);
        }        
    }
    
    public void provider_login(Provider provider){
        //int car_id,float price,String carType,float drive_range,String pinakida, int insurance,double rating,double dailyCost, double hourlyCost ,int provider_id,int arithmos_kykloforias
        car car2 = new car(0,26,"VW",45,"AAX2341",26,4.7,25.0,5.5,4,234,0);
        Customer ncustomer = new Customer(1,"customer","Efti","efti@outlook.com","123",692234309,birthdate,"card");
        //int customerId, int ownerId, String licensePlate, String route, String location, int paymentId
        ProviderHistory h1 = new ProviderHistory(4,2,"sd5768","Athens-Patras","Patras",890);
        //int user_id, String user_type, String username, String password, String pr_email, int phoneNum, Date birthdate,car car1, int approveValue
        Provider provider1 = new Provider(23,"provider","greg","1234","greg@idontknow.com",462892,birthdate,car2,1);
        Provider provider2 = new Provider(23,"provider","depi","1234","depi@idontknow.com",4624392,birthdate,car2,1);
        Provider provider3 = new Provider(23,"provider","efipas","1234","efipas@idontknow.com",463282,birthdate,car2,1);
        
        this.prList.add(provider1);
        this.prList.add(provider2);
        this.prList.add(provider3);
        
        System.out.println("Log in as Owner insert id:");
        Scanner code = new Scanner(System.in);
        int co= code.nextInt();
        
        for(int i=0;i<provider.prList.size();i++){
            if(provider.prList.get(i).user_id==co){
              System.out.println("\nChoose options: \n1. Car Registration\n2. Edit Car\n3. Browze Histroty\n4. Leave");
              Scanner opt = new Scanner(System.in);
              int op= opt.nextInt();
              if(op==1){ 
                  car_registration(provider);
               }
              else if(op==2){
                  car2.editinfo();
              }
              else if(op==3){
                  h1.showprRentals();
              }
              else{
                  System.exit(0);
              }
            }
            else{
                System.out.println("ID Incorrect try again");
                provider_login(provider);
            }
        }
        
        
    }
    
    public void provider_SignUp(){
        Random rand = new Random();
        int upperbound = 100;
        int id=rand.nextInt(upperbound);
        Date birthdate = new Date();
        //int car_id,float price,String carType,float drive_range,String pinakida, int insurance,double rating,double dailyCost, double hourlyCost ,int provider_id,int arithmos_kykloforias, int inspected
        car newcar = new car(0,24,"Mercedes-Benz EQS", 500, "ZXI9088", 78, 4.8, 25, 6.70, 2,89000,0);
        
        Scanner newPname = new Scanner(System.in);
        System.out.println("Please add your name:\n");
        String nPname = newPname.nextLine();
        
        Scanner newPemail = new Scanner(System.in);
        System.out.println("Please add your email:\n");
        String nEmail = newPemail.nextLine();
        
        Scanner newPphone = new Scanner(System.in);
        System.out.println("Please add your phone number:\n");
        int nPhone = newPphone.nextInt();
        
        Scanner newPass = new Scanner(System.in);
        System.out.println("Please add your password:\n");
        String nPass = newPass.nextLine();
        
        Scanner newPay = new Scanner(System.in);
        System.out.println("Please add your payment method:\n");
        String nPay = newPay.nextLine();
        
        Provider newprovider = new Provider(id,"provider",nPname,nPass,nEmail,nPhone,birthdate,newcar,1);
        this.prList.add(newprovider);
        System.out.println("You are signed up! \n");
    }
    
    public void car_registration(Provider provider){
        if(provider.approveValue==1){
            System.out.println("CAR REGISTRATION");
            
            Random rand = new Random();
            int upperbound=400;
            int id = rand.nextInt(upperbound);
            
            Scanner model = new Scanner(System.in);
            System.out.println("Please add your car's model\n");
            String m = model.nextLine();
            
            Scanner drive_range = new Scanner(System.in);
            System.out.println("Please add your car's driving range\n");
            Float dr = drive_range.nextFloat();
            
            Scanner pinakida = new Scanner(System.in);
            System.out.println("Please add your car's sign\n");
            String p = pinakida.nextLine();
            
            Scanner ins = new Scanner(System.in);
            System.out.println("Please add your car's insurance\n");
            int i = ins.nextInt();
            
            Scanner ar_kykloforias = new Scanner(System.in);
            System.out.println("Please add your car's license\n");
            int a = ar_kykloforias.nextInt();
            
            //int car_id,float price,String carType,float drive_range,String pinakida, int insurance,double rating,double dailyCost, double hourlyCost ,int provider_id,int arithmos_kykloforias, int inspected
            car newcar = new car(id,0,m,dr,p,i,0,0,0,0,a,0);
            try{
                newcar.set_carList(newcar);
            }
            catch(D2DException ex){
                
            }
            System.out.println("CAR REGISTRATION COMPLETE!");
        }
        else{
            System.out.println("CANNOT REGISTER A CAR");
            System.exit(0);
        }
        
    }
    
}
	
