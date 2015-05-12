package model;

import domain.*;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 * 
 * @author Jean-Louis
 */
public interface IPersistenceMgr {
    
    public List<FoodType> getFoodType();
    
    public List<Restaurant> getRestaurantbyFoodType (String foodtype);
    
    public Restaurant getRestaurantbyName (String name);
    
    public Restaurant getRandomRestaurant ();
    
    public Restaurant getRestaurantbyId(int restaurantid);
    
    public DisplayRestaurant getRestaurant(int id);
    
    /**
     *
     * @return
     */
    public DisplayRestaurant getRdmRestaurant();
    
    /**
     *
     * @param name
     * @return
     */
    public List<LightRestaurant> getRestaurantByName (String name);
    
    /**
     *
     * @param name
     * @param type
     * @param city
     * @return
     */
    public List<LightRestaurant> getRestaurantAdvanced (String name, String type, String city);
    
    /**
     * Get all restaurants of a given food type.
     * @param ftEnum : The requested food type.
     * @param numberOfElements : The number of elements you want to receive. For all elements, send 0.
     * @return : An arraylist of lightrestaurant objects.
     */
    public List<LightRestaurant> getLightRestaurantsByFoodType(FoodTypeEnum ftEnum, int numberOfElements);
    
    /**
     * Gets the full restaurant object for a restaurant identifier.
     * @param restaurantId : The restaurant identifier.
     * @return : The full restaurant object.
     */
    public Restaurant getFullRestaurant(int restaurantId);
    
    
    public boolean CreateReservation(Reservation reservation, Customer customer) throws DatatypeConfigurationException;
}
