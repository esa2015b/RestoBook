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
public class Restaurant {
     
    private int restaurantId;
    private String name;
    private String mail;
    private String phone;
    private String description;
    private int placeQuantity;
    private String dayOfClosing;
    private String picture;
    private boolean enable;
    private boolean isPremium;
    
    public Restaurant (int restaurantId, String name, String mail, String phone, String description, int placeQuantity, String dayOfClosing, String picture, boolean enable, boolean isPremium){
        this.restaurantId = restaurantId;
        this.name=name;
        this.mail=mail;
        this.phone=phone;
        this.description=description;
        this.placeQuantity=placeQuantity;
        this.dayOfClosing=dayOfClosing;
        this.picture=picture;
        this.enable=enable;
        this.isPremium=isPremium;
    }
    
    

    /**
     * @return the restaurantId
     */
    public int getRestaurantId() {
        return restaurantId;
    }

    /**
     * @param restaurantId the restaurantId to set
     */
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the placeQuantity
     */
    public int getPlaceQuantity() {
        return placeQuantity;
    }

    /**
     * @param placeQuantity the placeQuantity to set
     */
    public void setPlaceQuantity(int placeQuantity) {
        this.placeQuantity = placeQuantity;
    }

    /**
     * @return the dayOfClosing
     */
    public String getDayOfClosing() {
        return dayOfClosing;
    }

    /**
     * @param dayOfClosing the dayOfClosing to set
     */
    public void setDayOfClosing(String dayOfClosing) {
        this.dayOfClosing = dayOfClosing;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the enable
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * @param enable the enable to set
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * @return the isPremium
     */
    public boolean isIsPremium() {
        return isPremium;
    }

    /**
     * @param isPremium the isPremium to set
     */
    public void setIsPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }
 
}
