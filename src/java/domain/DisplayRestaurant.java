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
public class DisplayRestaurant {
    
    private int Id;
    private String Name;
    private String Mail;
    private String Phone;
    private String Description;
    private int PlaceQuantity;
    private String DayOfClosing;
    private String PictureLocation;
    private String FoodTypeName;
    
    public DisplayRestaurant(){
        
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
     * @return the Mail
     */
    public String getMail() {
        return Mail;
    }

    /**
     * @param Mail the Mail to set
     */
    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
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
     * @return the PlaceQuantity
     */
    public int getPlaceQuantity() {
        return PlaceQuantity;
    }

    /**
     * @param PlaceQuantity the PlaceQuantity to set
     */
    public void setPlaceQuantity(int PlaceQuantity) {
        this.PlaceQuantity = PlaceQuantity;
    }

    /**
     * @return the DayOfClosing
     */
    public String getDayOfClosing() {
        return DayOfClosing;
    }

    /**
     * @param DayOfClosing the DayOfClosing to set
     */
    public void setDayOfClosing(String DayOfClosing) {
        this.DayOfClosing = DayOfClosing;
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
