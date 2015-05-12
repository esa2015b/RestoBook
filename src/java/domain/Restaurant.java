/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.*;

/**
 *
 * @author Thibaut
 */
public class Restaurant {
     
    private int Id;
    private String Name;
    private String Mail;
    private String Phone;
    private String Description;
    private int PlaceQuantity;
    private String DayOfClosing;
    private String PictureLocation;
    private boolean IsEnable;
    private boolean IsPremium;
    private List<PriceList> PriceList;
    private List<Employee> Employee;
    private List<Service> Services;
    private FoodType FoodType;
    private Owner owner;
    
    public Restaurant(){
        
    }
    
    /**
     * @return the RestaurantId
     */
    public int getId() {
        return Id;
    }

    /**
     * @param RestaurantId the RestaurantId to set
     */
    public void setId(int RestaurantId) {
        this.Id = RestaurantId;
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

    /**
     * @return the IsPremium
     */
    public boolean isIsPremium() {
        return IsPremium;
    }

    /**
     * @param IsPremium the IsPremium to set
     */
    public void setIsPremium(boolean IsPremium) {
        this.IsPremium = IsPremium;
    }

    /**
     * @return the PriceList
     */
    public List<PriceList> getPriceList() {
        return PriceList;
    }

    /**
     * @param PriceList the PriceList to set
     */
    public void setPriceList(List<PriceList> PriceList) {
        this.PriceList = PriceList;
    }

    /**
     * @return the Employee
     */
    public List<Employee> getEmployee() {
        return Employee;
    }

    /**
     * @param Employee the Employee to set
     */
    public void setEmployee(List<Employee> Employee) {
        this.Employee = Employee;
    }

    /**
     * @return the FoodType
     */
    public FoodType getFoodType() {
        return FoodType;
    }

    /**
     * @param FoodType the FoodType to set
     */
    public void setFoodType(FoodType FoodType) {
        this.FoodType = FoodType;
    }

    /**
     * @return the owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    
    /**
     *
     * @return the list of services of the restaurant.
     */
    public List<Service> getServices(){
        return this.Services;
    }
    
    /**
     *
     * @param services Sets the services for the restaurant.
     */
    public void setServices(List<Service> services){
        this.Services = services;
    }
   
}