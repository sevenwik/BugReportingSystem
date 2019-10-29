/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugtrackingsystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sathwik
 */
public class User implements Serializable{
    private String username;
    private String password;
    ArrayList<Project> currentProjects = new ArrayList<>();
    ArrayList<Ticket> tickets = new ArrayList<>();
    
    public User(){
        
    }
    public User(String username,String password)
    {
        this.username = username;
        this.password = password;
    }
  
    public void setUsername(String uname){
        this.username = uname;
    }
    
    public void setPassword(String pass){
        this.password = pass;
    }
    
    public String getUserName()
    {
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    public String toString(){
        return ("Username:"+this.getUserName());
    }
    public boolean createTicket() throws FileNotFoundException, IOException
    {
        Scanner ticketInfo = new Scanner(System.in); 
        int ticketId = (int) ((Math.random()*((999-111)+1))+111); 
        System.out.println("Project ID: ");
        String projectID = ticketInfo.nextLine();
        int projectId = parseInt(projectID);
        System.out.println("Type: ");
        String type = ticketInfo.nextLine();
        System.out.println("Component: ");
        String component = ticketInfo.nextLine();
        System.out.println("Description: ");
        String description = ticketInfo.nextLine();
        System.out.println("Priority(10,5,0): ");
        String priority = ticketInfo.nextLine();
        int priority1 = parseInt(priority);
        System.out.println("Assignee: ");
        String username = ticketInfo.nextLine();
        Ticket t = new Ticket(ticketId,projectId,type,component,description,priority1,username,this.username);
        
        ArrayList ticketList = new ArrayList<>();
        ticketList.add(t);
        /*FileOutputStream fileOut = new FileOutputStream("Tickets.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(ticketlist);*/
        try{
        
			FileInputStream is = new FileInputStream("Tickets.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
                                                
                        ticketList = (ArrayList)ois.readObject();
                        
            }
        catch(ClassNotFoundException e)
        {
            
        }
        ticketList.add(t);
        FileOutputStream fileOut = new FileOutputStream("Tickets.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        objectOut.writeObject(ticketList);
        
        fileOut.close();
        objectOut.close();
        
        return false;
    }
    public boolean createProject() throws FileNotFoundException, IOException
    {
        Scanner projectinfo = new Scanner(System.in);
        System.out.println("-------Create a Project");
        System.out.println("Enter ProjectName:");
        String name = projectinfo.nextLine();
        System.out.println("Enter Id:");
        String id = projectinfo.nextLine();
        int Id = parseInt(id);
        System.out.println("Enter Project Type");
        String type = projectinfo.nextLine();
        System.out.println("Enter Lead");
        String lead = projectinfo.nextLine();
        
        Project project = new Project(name,Id,type,lead,this.username);
        
        ArrayList projectList = new ArrayList<>();
        projectList.add(project);
       /*FileOutputStream fileOut = new FileOutputStream("Projects.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(projectList);*/
        try{
        
			FileInputStream is = new FileInputStream("Projects.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
                                                
                        projectList = (ArrayList)ois.readObject();
                        
            }
        catch(ClassNotFoundException e)
        {
            
        }
        projectList.add(project);
        FileOutputStream fileOut = new FileOutputStream("Projects.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        objectOut.writeObject(projectList);
        
        fileOut.close();
        objectOut.close();
        
        return false;
    }
}
