/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugtrackingsystem;

import java.io.Serializable;

/**
 *
 * @author Sathwik
 */

public class Ticket implements Serializable{
    int ticketId;
    int projectId;
    String type;
    String component;
    String description;
    int priority;
    String assignee;
    String created;
    private static final long serialVersionUID = 1L;
    
    public Ticket(int ticketId,int projectId,String type,String component,String description,int priority,String assignee,String created)
    {
        this.ticketId = ticketId;
        this.projectId = projectId;
        this.type = type;
        this.component = component;
        this.description = description;
        this.priority = priority;
        this.assignee = assignee;
        this.created = created;
    }
    public int compareTo(Ticket t1)
    {
        if(this.priority == t1.priority)
            return 0;
        else if(this.priority > t1.priority)
            return -1;
        else
            return 1;
    }
    public String toString()
    {
        return "\nTicket ID: "+this.ticketId+" Assignee: "+this.assignee+" Created: "+this.created+" Priority: "+this.priority;
    }
}
