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
public class PersistenceMngr implements IPersistenceMgr
{
    
    // <editor-fold defaultstate="collapsed" desc="À VERIFIER">
    
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
    
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="PUBLIC METHODS">
    public DisplayRestaurant getRestaurant(int id){
        
        DisplayRestaurant displayResto = new DisplayRestaurant();
        RestoBookService wcf = new RestoBookService();
        
        displayResto = this.mapDisplayRestaurant(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id));
        
        return displayResto;
        
    }
    
    /**
     *
     * @return
     */
    public DisplayRestaurant getRdmRestaurant(){
       
        DisplayRestaurant displayResto = new DisplayRestaurant();
        RestoBookService wcf = new RestoBookService();
        
        displayResto = this.mapDisplayRestaurant(wcf.getBasicHttpBindingIRestoBookService().getRandomRestaurant());
        
        return displayResto;
         
    }
    
    /**
     *
     * @param name
     * @return
     */
    public List<LightRestaurant> getRestaurantByName (String name){
        List<LightRestaurant> restaurants = new ArrayList<LightRestaurant>();
        RestoBookService wcf = new RestoBookService();
        
        for(int i = 0; i < wcf.getBasicHttpBindingIRestoBookService().getRestaurantByName(name).getRestaurant().size(); i++)
        {
            LightRestaurant lightResto = this.mapLightRestaurant(wcf.getBasicHttpBindingIRestoBookService().getLightRestaurantByName(name).getLightRestaurant().get(i));

            restaurants.add(lightResto);
        }
        
        return restaurants;
    }
    
    /**
     *
     * @param name
     * @param type
     * @param city
     * @return
     */
    public List<LightRestaurant> getRestaurantAdvanced (String name, String type, String city){
        List<LightRestaurant> restaurants = new ArrayList<LightRestaurant>();
        RestoBookService wcf = new RestoBookService();
        for(int i = 0; i < wcf.getBasicHttpBindingIRestoBookService().getLightRestaurantAdvanced(name, type, city).getLightRestaurant().size(); i++)
        {
            LightRestaurant lightResto = this.mapLightRestaurant(wcf.getBasicHttpBindingIRestoBookService().getLightRestaurantAdvanced(name, type, city).getLightRestaurant().get(i));
            
            restaurants.add(lightResto);
        }
        
        return restaurants;
    }
    
    /**
     * Get all restaurants of a given food type.
     * @param ftEnum : The requested food type.
     * @param numberOfElements : The number of elements you want to receive. For all elements, send 0.
     * @return : An arraylist of lightrestaurant objects.
     */
    public List<LightRestaurant> getLightRestaurantsByFoodType(FoodTypeEnum ftEnum, int numberOfElements){
        
        List<LightRestaurant> mappedRestaurants = new ArrayList<>();
        RestoBookService service = new RestoBookService();
        
        List<org.datacontract.schemas._2004._07.restobook_common_model.LightRestaurant> restaurants = service.getBasicHttpBindingIRestoBookService().getLightRestaurantByFoodType((ftEnum.ordinal())).getLightRestaurant();
        
        // Check if user wants full list or only a sample of the list.
        if (numberOfElements == 0 || numberOfElements != restaurants.size()) {
            numberOfElements = restaurants.size();
        }
        
        // Initiate the random generator & needed variables
        Random random = new Random();
        int currentNumb = random.nextInt(numberOfElements);
        List<Integer> presentNumbers = new ArrayList<>();
        presentNumbers.add(currentNumb);
        
        for (int i = 0; i < numberOfElements; i++)
        {
            while (!presentNumbers.contains(currentNumb)) {
                presentNumbers.add(currentNumb);
            }
            mappedRestaurants.add(this.mapLightRestaurant(restaurants.get(currentNumb)));
            if (i != numberOfElements - 1) {
                while (presentNumbers.contains(currentNumb)) {
                    currentNumb = random.nextInt(numberOfElements);
                }
            }
        }
        
        return mappedRestaurants;
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="PRIVATE METHODS">
    private LightRestaurant mapLightRestaurant (org.datacontract.schemas._2004._07.restobook_common_model.LightRestaurant wcf){
        
        LightRestaurant lightResto = new LightRestaurant();
        
        lightResto.setId(wcf.getId());
        lightResto.setName(wcf.getName());
        lightResto.setFoodTypeName(wcf.getFoodTypeName());
        lightResto.setPictureLocation(wcf.getPictureLocation());
        lightResto.setDescription(wcf.getDescription());
        
        return lightResto;
        
    }
     
    private DisplayRestaurant mapDisplayRestaurant (org.datacontract.schemas._2004._07.restobook_common_model.Restaurant wcf){
        
        DisplayRestaurant displayResto = new DisplayRestaurant();
        
        displayResto.setId(wcf.getId());
        displayResto.setName(wcf.getName());
        displayResto.setMail(wcf.getMail());
        displayResto.setPhone(wcf.getPhone());
        displayResto.setDescription(wcf.getDescription());
        displayResto.setPlaceQuantity(wcf.getPlaceQuantity());
        displayResto.setDayOfClosing(wcf.getDayOfClosing());
        displayResto.setPictureLocation(wcf.getPictureLocation());
        displayResto.setFoodTypeName(wcf.getFoodType().getName());
        
        return displayResto;
        
    }
     
    private Restaurant mapFullRestaurant (org.datacontract.schemas._2004._07.restobook_common_model.Restaurant wcfRep){
        Restaurant result = new Restaurant();
        FoodType foodType = new FoodType();
        Owner owner = new Owner();
        List<Employee> emp = new ArrayList<Employee>();
        List<PriceList> pl = new ArrayList<PriceList>();
        
        // Assignation to Restaurant and FoodType from WCF.
        result.setDayOfClosing(wcfRep.getDayOfClosing());
        result.setId(wcfRep.getId());
        result.setDescription(wcfRep.getDescription());
        result.setMail(wcfRep.getMail());
        result.setName(wcfRep.getName());
        result.setPhone(wcfRep.getPhone());
        result.setPictureLocation(wcfRep.getPictureLocation());
        result.setPlaceQuantity(wcfRep.getPlaceQuantity());
        result.setIsEnable(true);
        result.setIsPremium(false);
        
        owner.setFirstName(wcfRep.getOwner().getFirstName());
        owner.setLastName(wcfRep.getOwner().getLastName());
        owner.setId(wcfRep.getOwner().getId());
        owner.setIsEnable(wcfRep.getOwner().isIsEnabled());
        
        foodType.setName(wcfRep.getFoodType().getName());
        foodType.setDescription(wcfRep.getFoodType().getDescription());
        foodType.setId(wcfRep.getFoodType().getId());
        foodType.setIsEnabled(true);
        
        for (int i = 0; i < wcfRep.getEmployees().getEmployee().size(); i++)
        {
            Employee employee = new Employee();
            
            employee.setEmail(wcfRep.getEmployees().getEmployee().get(i).getEmail());
            employee.setFirstName(wcfRep.getEmployees().getEmployee().get(i).getFirstName());
            employee.setId(wcfRep.getEmployees().getEmployee().get(i).getId());
            employee.setLastName(wcfRep.getEmployees().getEmployee().get(i).getLastName());
            employee.setLogin(wcfRep.getEmployees().getEmployee().get(i).getLogin());
            employee.setMobile(wcfRep.getEmployees().getEmployee().get(i).getMobile());
            employee.setPassword(wcfRep.getEmployees().getEmployee().get(i).getPassword());
            employee.setRestaurantId(wcfRep.getId());
            employee.setIsEnabled(true);
            
            emp.add(employee);
        }
        
        for (int i = 0; i < wcfRep.getPriceLists().getPriceList().size(); i++)
        {
            PriceList pricelist = new PriceList();
            
            pricelist.setId(wcfRep.getPriceLists().getPriceList().get(i).getId());
            pricelist.setDescription(wcfRep.getPriceLists().getPriceList().get(i).getDescription());
            pricelist.setMinimumPrice(wcfRep.getPriceLists().getPriceList().get(i).getMinimumPrice());
            pricelist.setMaximumPrice(wcfRep.getPriceLists().getPriceList().get(i).getMaximumPrice());
            pricelist.setIsEnabled(wcfRep.getPriceLists().getPriceList().get(i).isIsEnabled());
            
            pl.add(pricelist);
        }
        
        // Assignation
        result.setOwner(owner);
        result.setFoodType(foodType);
        result.setEmployee(emp);
        result.setPriceList(pl);
        result.setEmployee(emp);
                        
        return result;
    }
    //</editor-fold>

}
