/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Jean-Louis
 */
public class Owner {
    
    private int Id;
    private String FirstName;
    private String LastName;
    private boolean IsEnable;
    
    public Owner(int Id, String FirstName, String LastName, boolean IsEnable){
        this.Id=Id;
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.IsEnable=IsEnable;
    }
    
    public Owner(){
        
    }
    
    public int getId(){
        return this.Id;
    }
    
    public void setId(int Id){
        this.Id=Id;
    }
    
    public String getFirstName(){
        return this.FirstName;
    }
    
    public void setFirstName(){
        this.FirstName=FirstName;
    }
    
    public boolean getIsEnable(){
        return this.IsEnable;
    }
    
    public void setIsEnable(){
        this.IsEnable=IsEnable;
    }   
}
