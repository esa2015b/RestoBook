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

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the IsEnable
     */
    public boolean isIsEnable() {
        return IsEnable;
    }

    /**
     * @param IsEnable the IsEnable to set
     */
    public void setIsEnable(boolean IsEnable) {
        this.IsEnable = IsEnable;
    }
}
