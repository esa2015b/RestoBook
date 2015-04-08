/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Thibaut
 */
public class FoodType {
    
    private int Id;
    private String Description;
    private boolean IsEnabled;
    private String Name;

    public FoodType(int Id, String Description, Boolean IsEnabled, String Name){
        this.Id=Id;
        this.Description=Description;
        this.IsEnabled=IsEnabled;
        this.Name=Name;
    }
    
    public FoodType(){
        
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
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the IsEnabled
     */
    public boolean isIsEnabled() {
        return IsEnabled;
    }

    /**
     * @param IsEnabled the IsEnabled to set
     */
    public void setIsEnabled(boolean IsEnabled) {
        this.IsEnabled = IsEnabled;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }
    
    
}
