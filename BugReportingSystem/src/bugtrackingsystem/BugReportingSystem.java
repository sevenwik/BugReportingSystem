/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugtrackingsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Sathwik
 */
enum Options{
    OPTION1(1),OPTION2(2),OPTION3(3),OPTION4(4);
    int i;
    Options(int i)
    {
        this.i = i;
    }
    public int getValue(){
        return i;
    }
}
class BugReportingApp
{
    User currentUser;
    public void displayUI() throws FileNotFoundException, IOException, ClassNotFoundException
    {
                   
            LogIn l = new LogIn();
            currentUser = l.login();
            //currentUser.createProject();
            if(currentUser.getUserName().equals("btsadmin"))
            {
                System.out.println("Admin Logged out");
            }
            else if(currentUser != null)
            {
                System.out.println("Login Done");
                DashBoard d = new DashBoard();
                Menu menu = new Menu();
                while(true)
                {
                    int choice = menu.displayMenu();
                    if(choice == Options.OPTION1.getValue())
                    {
                        d.displayProjects(currentUser);
                    }
                    else if(choice == Options.OPTION2.getValue())
                    {
                        System.out.println("Create Ticket: ");
                        currentUser.createTicket();
                    }
                    else if(choice == Options.OPTION3.getValue())
                    {
                        System.out.println("displays Tickets: ");
                        d.displayTicket(currentUser);
                    }
                    else if(choice == Options.OPTION4.getValue())
                    {
                        
                        currentUser.createProject();
                    }
                }
            }
            else
               System.out.println("Login Failed");
    }
}

public class BugReportingSystem {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here
        System.out.println("--------------------------------------------");
        System.out.println("|                                           |");
        System.out.println("|     Welcome to Bug Reporting System        |");
        System.out.println("|                                           |");
        System.out.println("---------------------------------------------");
        System.out.println("Press Enter to continue----------------------");
        Scanner scan = new Scanner(System.in);
        if(scan.nextLine().isEmpty()){
            
        
        BugReportingApp a = new BugReportingApp();
        a.displayUI();
        }
    }
    
}
