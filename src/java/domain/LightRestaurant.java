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
    private int id;
    private String name;
    private String description;
    private String pictureLocation;
    private String foodTypeName;

    public LightRestaurant(){
        
    }
    
    /**
     * @return the Id
     */
    public int getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.id = Id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.name = Name;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.description = Description;
    }

    /**
     * @return the PictureLocation
     */
    public String getPictureLocation() {
        return pictureLocation;
    }

    /**
     * @param PictureLocation the PictureLocation to set
     */
    public void setPictureLocation(String PictureLocation) {
        this.pictureLocation = PictureLocation;
    }

    /**
     * @return the FoodTypeName
     */
    public String getFoodTypeName() {
        return foodTypeName;
    }

    /**
     * @param FoodTypeName the FoodTypeName to set
     */
    public void setFoodTypeName(String FoodTypeName) {
        this.foodTypeName = FoodTypeName;
    }
}
