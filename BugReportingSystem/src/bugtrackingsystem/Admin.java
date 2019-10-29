/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugtrackingsystem;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
/**
 *
 * @author Laptop
 */
enum AdminMenu{
    ADDUSER(1),REMOVEUSER(2),USER(3);
    int value;
    AdminMenu(int i)
    {
        this.value = i;
    }
    public int getValue()
    {
        return value;
    }
}
public class Admin {
    
    public Admin(){
        
    }
    
    
    public void displaymenu(){
        System.out.println("1.Add User");
        System.out.println("2.Remove User");
        System.out.println("3.Users");
        
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
  
        if(choice == AdminMenu.ADDUSER.getValue())
        {
                Scanner scandetails = new Scanner(System.in);
                System.out.println("Enter Username:");
                String uname = scandetails.nextLine();
                System.out.println("Enter Password:");
                String password = scandetails.nextLine();
                this.addUser(uname,password);
                displaymenu();
        }
        else if(choice == AdminMenu.REMOVEUSER.getValue()){
                Scanner scaninput = new Scanner(System.in);
                System.out.println("Enter Username:");
                String name =scaninput.nextLine();
                deleteUser(name);
                displayUser();
                displaymenu();
        }
        else if(choice == AdminMenu.USER.getValue()){
                displayUser();
                displaymenu();
        }
        else{
                System.out.println("*************Wrong Choice*******************************");
                displaymenu();
        }
        
        
    }
    public boolean addUser(String uname,String password){
        User newuser = new User(uname,password);
        ArrayList<User> userlist = new ArrayList<>();
        /*   userlist.add(newuser);
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("Users.txt");
            try (ObjectOutputStream o = new ObjectOutputStream(f))
             {
                o.writeObject(userlist);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
        FileInputStream fi = null;
                try {
                    fi = new FileInputStream("Users.txt");
                    try (ObjectInputStream oi = new ObjectInputStream(fi)) {
                        if(fi.available()!=0){
                            
                            
                            try{
                                userlist = (ArrayList) oi.readObject() ;
                            }catch(EOFException ex){
                            }
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fi.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        
        
        userlist.add(newuser);
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("Users.txt");
            try (ObjectOutputStream o = new ObjectOutputStream(f))
             {
                o.writeObject(userlist);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return true;
    }
    
    public void deleteUser(String uname){
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("Users.txt");
            try (ObjectInputStream oi = new ObjectInputStream(fi)) {
                if(fi.available()!=0){
                    
                    ArrayList<User> userlist = new ArrayList<>();
                        try{
                        userlist = (ArrayList) oi.readObject() ;
                        for(int i=0;i<userlist.size();i++){
                            if(userlist.get(i).getUserName().equals(uname)){
                                userlist.remove(i);
                            }
                        }
                        FileOutputStream f = null;
                    
                        f = new FileOutputStream("Users.txt");
                        try (ObjectOutputStream o = new ObjectOutputStream(f))
                        {
                                o.writeObject(userlist);
                        }
                    } 
                        catch(EOFException ex){
                        }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fi.close();
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void displayUser(){
        
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("Users.txt");
            try (ObjectInputStream oi = new ObjectInputStream(fi)) {
                if(fi.available()!=0){
                    
                    ArrayList<User> userlist = new ArrayList<>();
                        try{
                        userlist = (ArrayList) oi.readObject() ;
                        System.out.println(userlist);
                        }catch(EOFException ex){
                        }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fi.close();
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
   

}

