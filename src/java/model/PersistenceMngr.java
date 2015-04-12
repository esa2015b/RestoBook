package model;

import java.util.List;
import java.util.ArrayList;
import domain.*;
import java.util.Random;
import org.tempuri.RestoBookService;
/**
 *
 * @author Jean-Louis
 */

/**
 * MUST BE MODIFIED TO IMPLEMENT IPersistenceMng
 * @author Jean-Louis
 */
public class PersistenceMngr {
    
    /**
     * Gets FoodTypes from Web Service
     * @return FoodType foodtype
     */
    public List<FoodType> getFoodType(){
        List<FoodType> foodtype = new ArrayList<>();
        return foodtype;
    }
        
    /**
     * Gets list of Restaurant by type of food
     * @param foodtype
     * @return restaurantList
     */
    public List<Restaurant> getRestaurantbyFoodType (String foodtype){
        List<Restaurant> restaurantList = new ArrayList<>();
        return restaurantList;
    }
    
    /**
     * Gets a restaurant from list of all restaurant by his name
     * @param name
     * @return 
     */
    public Restaurant getRestaurantbyName (String name){
        Restaurant restaurant = new Restaurant();
        return restaurant;
    }
    
    /**
     * Get a restaurnant from list of all restraurant by random choice
     * TO BE COMPLETED when method getRestaurnantList will be implemented
     * ACTUALLY return one restaurant from a list of 4 restaurants
     * @return Restaurant oneRandomRestaurant
     */
    public Restaurant getRandomRestaurant (){
         
        Restaurant restaurant =  new Restaurant();
        restaurant = null;
        
        Random rand = new Random();
        
        int i = rand.nextInt(5);
        
        if (i < 1 || i > 4)
        {
            i = rand.nextInt(5);
        }
        restaurant = (Restaurant) getRestaurantbyId(i);
        
        return restaurant;
     }
    
    /**
     * Gets a restaurant from list of all restaurant by his Id
     * @param restaurantid
     * @return restaurant
     */
    public Restaurant getRestaurantbyId(int restaurantid){
        
        RestoBookService ws = new RestoBookService();
        Restaurant restaurant = new Restaurant();
        List<Employee> employee = new ArrayList<>();
        
        FoodType foodtype = new FoodType();
        PriceList pricelist = new PriceList();
        //Address address =  new Address();

    //restaurants
        //name
        restaurant.setName(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getName());
        //mail
        restaurant.setMail(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getMail());
        //phone
        restaurant.setPhone(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getPhone());
        //description
        restaurant.setDescription(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getDescription());
        //placequantity
        restaurant.setPlaceQuantity(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getPlaceQuantity());
        //dayofclosing
        restaurant.setDayOfClosing(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getDayOfClosing());
        //picturelocation
        restaurant.setPictureLocation(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getPictureLocation());
        //isenable
        restaurant.setIsEnable(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).isIsEnabled());
        //ispremium
        restaurant.setIsPremium(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).isIsPremium());

    //foodtype
        foodtype.setName(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getFoodType().getName());
        foodtype.setDescription(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getFoodType().getDescription());
        restaurant.setFoodType(foodtype);
    
    //employee
        
    //pricelist
        pricelist.setMaximumPrice(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getPriceLists().getPriceList().get(1).getMaximumPrice());
        pricelist.setMinimumPrice(ws.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantid).getPriceLists().getPriceList().get(1).getMinimumPrice());

    //address
  
        return restaurant ;
    }
    
}
