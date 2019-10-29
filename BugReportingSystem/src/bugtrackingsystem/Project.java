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
public class Project implements Serializable{
    String Projectname;
    int id;
    String type;
    String lead;
    String createdBy;
    private static final long serialVersionUID = 1L;
    
    public Project(String name,int id,String type,String lead,String created)
    {
        this.Projectname = name;
        this.id = id;
        this.type = type;
        this.lead = lead;
        this.createdBy = created;
    }
    public String toString()
    {
        return "\nProject Name: "+this.Projectname+" "
                + "CreatedBy: "+this.createdBy+"Lead: "+this.lead;
    }
}
