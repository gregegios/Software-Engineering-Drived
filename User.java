package com.mycompany.sotware_project;
import java.util.ArrayList;

public class User {
    public static int user_id;
    public static String user_type;
    public ArrayList<User> users;
    
    public User (int user_id, String user_type){
        this.user_id = user_id;
        this.user_type = user_type;
        this.users = new ArrayList<User>();
    }
    
    //setter to add user
    public void setUser(User user){
        this.users.add(user);
    }
    
    public void printUser(User user){
        System.out.print("User ID:" +User.user_id+ "\n");
        System.out.print("User type:" +User.user_type+"\n");
    }
}
