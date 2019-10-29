/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugtrackingsystem;

import java.util.Scanner;

/**
 *
 * @author Sathwik
 */
public class Menu {
    
    public int displayMenu(){
        System.out.println("1.Projects");
        System.out.println("2.Create Ticket");
        System.out.println("3.Tickets");
        System.out.println("4.Create Project");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String s = sc.nextLine();
        return i;
        
    }
}
