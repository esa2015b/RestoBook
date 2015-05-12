/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thibaut
 */
public class DisplayRestaurant {
    
    // <editor-fold defaultstate="collapsed" desc="MEMBERS">
    private int id;
    private String name;
    private String mail;
    private String phone;
    private String description;
    private int placeQuantity;
    private String dayOfClosing;
    private String pictureLocation;
    private String foodTypeName;
    private List<Service> services;
    private Address address;
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORS">
    public DisplayRestaurant(){
        this.services = new ArrayList<>();
    }
    
    public DisplayRestaurant(int id, 
                             String name, 
                             String mail,
                             String phone, 
                             String description, 
                             int placeQuantity, 
                             String dayOfClosing,
                             String pictureLocation,
                             String foodTypeName,
                             Address address)
    {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.description = description;
        this.placeQuantity = placeQuantity;
        this.dayOfClosing = dayOfClosing;
        this.pictureLocation = pictureLocation;
        this.foodTypeName = foodTypeName;
        this.services = new ArrayList<>();
        this.address = address;
    }
    // </editor-fold>
    

    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">
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
     * @return the Mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param Mail the Mail to set
     */
    public void setMail(String Mail) {
        this.mail = Mail;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.phone = Phone;
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
     * @return the PlaceQuantity
     */
    public int getPlaceQuantity() {
        return placeQuantity;
    }

    /**
     * @param PlaceQuantity the PlaceQuantity to set
     */
    public void setPlaceQuantity(int PlaceQuantity) {
        this.placeQuantity = PlaceQuantity;
    }

    /**
     * @return the DayOfClosing
     */
    public String getDayOfClosing() {
        return dayOfClosing;
    }

    /**
     * @param DayOfClosing the DayOfClosing to set
     */
    public void setDayOfClosing(String DayOfClosing) {
        this.dayOfClosing = DayOfClosing;
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
    
    /**
     *
     * @return The restaurant's address.
     */
    public Address getAddress()
    {
        return this.address;
    }
    
    /**
     *
     * @param address : Sets the restaurant's address.
     */
    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    /**
     *
     * @return The list of services for this restaurant.
     */
    public List<Service> getServices()
    {
        return this.services;
    }
    
    /**
     *
     * @param services The services to set.
     */
    public void setServices(List<Service> services)
    {
        this.services = services;
    }
    // </editor-fold>
    
}
