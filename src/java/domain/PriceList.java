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
public class PriceList {
    
    private int Id;
    private String Description;
    private int MaximumPrice;
    private int MinimumPrice;
    private boolean IsEnabled;
   
    public PriceList(){
        
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
     * @return the MaximumPrice
     */
    public int getMaximumPrice() {
        return MaximumPrice;
    }

    /**
     * @param MaximumPrice the MaximumPrice to set
     */
    public void setMaximumPrice(int MaximumPrice) {
        this.MaximumPrice = MaximumPrice;
    }

    /**
     * @return the MinimumPrice
     */
    public int getMinimumPrice() {
        return MinimumPrice;
    }

    /**
     * @param MinimumPrice the MinimumPrice to set
     */
    public void setMinimumPrice(int MinimumPrice) {
        this.MinimumPrice = MinimumPrice;
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
    
}
