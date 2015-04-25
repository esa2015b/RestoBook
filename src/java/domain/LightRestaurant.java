/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author Thibaut
 */
public class LightRestaurant {
    private int Id;
    private String Name;
    private String Description;
    private String PictureLocation;
    private String FoodTypeName;

    public LightRestaurant(){
        
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
     * @return the PictureLocation
     */
    public String getPictureLocation() {
        return PictureLocation;
    }

    /**
     * @param PictureLocation the PictureLocation to set
     */
    public void setPictureLocation(String PictureLocation) {
        this.PictureLocation = PictureLocation;
    }

    /**
     * @return the FoodTypeName
     */
    public String getFoodTypeName() {
        return FoodTypeName;
    }

    /**
     * @param FoodTypeName the FoodTypeName to set
     */
    public void setFoodTypeName(String FoodTypeName) {
        this.FoodTypeName = FoodTypeName;
    }
}
