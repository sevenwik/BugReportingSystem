/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugtrackingsystem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
/**
 *
 * @author Laptop
 */
enum LoginStatus{
    Success,
    Fail
}
enum Choice{
    ADMIN(1),USER(2);
    int i;
    Choice(int i)
    {
        this.i = i;
    }
    public int getValue()
    {
        return i;
    }
}
public class LogIn {
    
    User user;
    
//    @Override
//    public void run(){
//            login();
//        
//    }
    
    public User login(){
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-------------Welcome to BTS Login-----------------------");
        System.out.println("1.Admin");
        System.out.println("2.User");
        System.out.println("Enter Your choice:");
        
        Scanner scaninput = new Scanner(System.in);
        int choice = scaninput.nextInt();
        
        if(choice == Choice.ADMIN.getValue()){
            final String adminid = "btsadmin";
            final String password = "1234";
            
            Scanner userinput = new Scanner(System.in);
            System.out.println("Welcome Admin");
            System.out.println("Enter ID:");
            String name = userinput.nextLine();
            System.out.println("Enter Password");
            String pass = userinput.nextLine();
            
            if(name.equals(adminid) && pass.equals(password)){
                System.out.println("Login Success");
                Admin admin = new Admin();
                admin.displaymenu();
                user = new User(name,pass);
            }else if(!name.equals(adminid) && pass.equals(password)){
                System.out.println("Wrong ID");
            }else if(name.equals(adminid) && !pass.equals(password)){
                System.out.println("Wrong Password");
            }else
                System.out.println("YOU ARE NOT AN ADMIN");
        }else if(choice == Choice.USER.getValue()){
            
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Username:");
            String uname = input.nextLine();
            System.out.println("Enter Password:");
            String password = input.nextLine();
            
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("Users.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ObjectInputStream oin = null;
            try {
                oin = new ObjectInputStream(fis);
            } catch (IOException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ArrayList<User> userlist = new ArrayList<>();
            try { 
                userlist = (ArrayList) oin.readObject();
            } catch (IOException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
            LoginStatus status = LoginStatus.Success;
            for(int i=0;i<userlist.size();i++){
                if(userlist.get(i).getUserName().equals(uname) && userlist.get(i).getPassword().equals(password)){
                    System.out.println("Login Success");
                    status = LoginStatus.Success;
                    user =new User(uname,password);
                    break;
                }else if(!userlist.get(i).getUserName().equals(uname) && userlist.get(i).getPassword().equals(password)){
                    System.out.println("Username doesn't exist");
                }else if(userlist.get(i).getUserName().equals(uname) && !userlist.get(i).getPassword().equals(password)){
                    System.out.println("Password Incorrect");
                }else
                    status = LoginStatus.Fail;
                }
            if(status == LoginStatus.Fail){
                System.out.println("Invalid User");
                return null;
            }
            
            
        }
        return user;
    }
    
}
