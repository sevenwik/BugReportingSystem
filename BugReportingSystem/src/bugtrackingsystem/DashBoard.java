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
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sathwik
 */
public class DashBoard {
    
    User u;
    ArrayList<Ticket> list1 = new ArrayList<>();
    ArrayList<Project> list2 = new ArrayList<>();
    public void displayTicket(User u) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        try{
        
			FileInputStream is = new FileInputStream("Tickets.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
                        
                        
                        list1 = (ArrayList)ois.readObject();
                        for(int i=0;i<list1.size();i++)
                        {
                            if(list1.get(i).assignee.equals(u.getUserName())||list1.get(i).created.equals(u.getUserName()))
                            {
                                    //System.out.println(list.get(i).ticketId);
                                    u.tickets.add(list1.get(i));
                                
                            }
                        }
                        Collections.sort(u.tickets,new SortByPriority());
                        
                        System.out.println(u.tickets);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error");
        }
    }
    public void displayProjects(User u) throws FileNotFoundException, IOException
    {
        try{
        
			FileInputStream is1 = new FileInputStream("Projects.txt");
			ObjectInputStream ois1 = new ObjectInputStream(is1);
                        
                        
                        list2 = (ArrayList)ois1.readObject();
                        for(int i=0;i<list2.size();i++)
                        {
                            if(list2.get(i).createdBy.equals(u.getUserName())||list2.get(i).lead.equals(u.getUserName()))
                            {
                                    //System.out.println(list.get(i).ticketId);
                                    u.currentProjects.add(list2.get(i));
                                
                            }
                        }
                        //Collections.sort(u.tickets,new SortByPriority());
                        
                        System.out.println(u.currentProjects);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error");
        }
    }
        
        
    
    }
