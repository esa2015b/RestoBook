package model;

import domain.*;
import java.util.List;

/**
 * TO BE IMPLEMENTED when Web Service will be completed
 * @author Jean-Louis
 */
public interface IPersistenceMgr {
    
    public List<FoodType> getFoodType();
    
    public List<Restaurant> getRestaurantbyFoodType (String foodtype);
    
    public Restaurant getRestaurantbyName (String name);
    
    public Restaurant getRandomRestaurant ();
    
    public Restaurant getRestaurantbyId(int restaurantid);
    
}
