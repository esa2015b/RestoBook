package model;

import java.util.List;
import java.util.ArrayList;
import domain.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.datacontract.schemas._2004._07.restobook_common_model.ObjectFactory;
import org.tempuri.RestoBookService;
import sun.util.BuddhistCalendar;

/**
 *
 * @author Jean-Louis
 */
public class PersistenceMgr implements IPersistenceMgr
{
    // <editor-fold defaultstate="collapsed" desc="MEMBERS">
    private ObjectFactory objectFactory;
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    public PersistenceMgr()
    {
        this.objectFactory = new ObjectFactory();
    }
    // </editor-fold>
    
    
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
        if (numberOfElements == 0 || numberOfElements > restaurants.size()) {
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
    
    /**
     * Gets the full restaurant object for a restaurant identifier.
     * @param restaurantId : The restaurant identifier.
     * @return : The full restaurant object.
     */
    public Restaurant getFullRestaurant(int restaurantId)
    {
        RestoBookService service = new RestoBookService();
        
        org.datacontract.schemas._2004._07.restobook_common_model.Restaurant serviceResto = service.getBasicHttpBindingIRestoBookService().getRestaurantById(restaurantId);
        
        return this.mapFullRestaurant(serviceResto);
    }
    
    /**
     * Creates a new reservation for a customer.
     * @param reservation : The reservation to create.
     * @param customer : The customer who created the reservation.
     * @return True in case of successful creation, false in case of failure.
     * @throws DatatypeConfigurationException
     */
    public boolean CreateReservation(Reservation reservation, Customer customer) throws DatatypeConfigurationException
    {
        RestoBookService service = new RestoBookService();
        
        // Map the received Reservation to the reservation object
        org.datacontract.schemas._2004._07.restobook_common_model.Reservation res = objectFactory.createReservation();
        res.setCustomerId(customer.getId());
        res.setIsEnabled(true);
        res.setPlaceQuantity(reservation.getPlaceQuantity());
        
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(reservation.getReservationDate());
        
        res.setReservationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(g));
        res.setService(reservation.getService());
        res.setServiceId(reservation.getServiceId());
        
        res.setServiceDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(g));
        
        res.setRestoComments(customer.getName() + " \r\n " + customer.getMail() + " \r\n " + customer.getPhone() + " \r\n " + reservation.getReservationComments());
        
        // Map the received Customer to the service.customer object
        org.datacontract.schemas._2004._07.restobook_common_model.Customer cus = objectFactory.createCustomer();
        cus.setIsEnable(true);
        cus.setMail(customer.getMail());
        cus.setPhone(customer.getPhone());
        
        // Call the service and return the valid insertion response.
        boolean response = service.getBasicHttpBindingIRestoBookService().createReservation(res, cus);
        
        return response;
    }
    
    /**
     * Gets the reservations for a given restaurant.
     * @param restaurantId : The restaurant identifier.
     * @return An arraylist of Model.Reservation.
     */
    public ArrayList<Reservation> GetReservationsByRestaurantId(int restaurantId)
    {
        // Create the restobookservice link.
        RestoBookService service = new RestoBookService();
        // Prepare the arraylist of services to return
        ArrayList<Reservation> reservations = new ArrayList<>();
        // Get the reservations from the wcf service.
        List<org.datacontract.schemas._2004._07.restobook_common_model.Reservation> wcfReservations = service.getBasicHttpBindingIRestoBookService().getAllReservations().getReservation();
        
        for (org.datacontract.schemas._2004._07.restobook_common_model.Reservation wcfReservation : wcfReservations)
        {
            reservations.add(this.MapReservation(wcfReservation));
        }
        
        return reservations;
    }
    
    /**
     * Modifies the reservations as requested.
     * @param reservations : An arraylist of reservations to modify.
     * @return True in case of successful modification, false if one or all modifications went wrong.
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public boolean ModifyReservations(ArrayList<Reservation> reservations) throws DatatypeConfigurationException
    {
        List<Boolean> successfuls = new ArrayList<>();
        
        // Create the restobookservice link.
        RestoBookService service = new RestoBookService();
        // For each Reservation in the list, call the service for the modifications
        for (Reservation r : reservations)
        {
            org.datacontract.schemas._2004._07.restobook_common_model.Reservation wcfRes = this.MapReservation(r);
            successfuls.add(service.getBasicHttpBindingIRestoBookService().modifyReservationsFromCustomer(wcfRes));
        }
        // Check if all modifications went right
        Boolean successful = !successfuls.contains(false);
        
        return successful;
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
        List<Service> services = new ArrayList<>();
        
        // Assignation to Restaurant and FoodType from WCF.
        if (wcfRep != null)
        {
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

            for (int i = 0; i < wcfRep.getServices().getService().size(); i++) {

                Service service = new Service();

                service.setId(wcfRep.getServices().getService().get(i).getId());
                service.setBeginShift(wcfRep.getServices().getService().get(i).getBeginShift());
                service.setDayOfWeek(wcfRep.getServices().getService().get(i).getServiceDay().toString());
                service.setEndShift(wcfRep.getServices().getService().get(i).getEndShift());
                service.setPlaceQuantity(wcfRep.getServices().getService().get(i).getPlaceQuantity());
                service.setTypeService(wcfRep.getServices().getService().get(i).getTypeService());

                services.add(service);
                //Date wcfRep.getServices().getService().get(i).getServiceDate();
                //service.setServiceDate();
            }

            // Assignation
            result.setOwner(owner);
            result.setFoodType(foodType);
            result.setEmployee(emp);
            result.setPriceList(pl);
            result.setEmployee(emp);
            result.setServices(services);
        }                
        return result;
    }
    
    /**
     * Maps a wcf reservation object to a model.reservation object.
     * @param wcfRes : The reservation to map.
     * @return The mapped reservation.
     */
    private Reservation MapReservation(org.datacontract.schemas._2004._07.restobook_common_model.Reservation wcfRes)
    {
        Reservation resa = new Reservation();
        resa.setId(wcfRes.getId());
        resa.setCustomerId(wcfRes.getCustomerId());
        resa.setPlaceQuantity(wcfRes.getPlaceQuantity());
        resa.setReservationComments(wcfRes.getRestoComments());
        resa.setReservationDate(wcfRes.getReservationDate().toGregorianCalendar().getTime());
        resa.setRestoComments(wcfRes.getRestoComments());
        resa.setRestoConfirmationDate(wcfRes.getRestoConfirmationDate() == null ? 
                                            new Date(Long.MAX_VALUE) : 
                                            wcfRes.getRestoConfirmationDate().getValue().toGregorianCalendar().getTime());
        resa.setRestoConfirmation(resa.getRestoConfirmationDate( ) == new Date(Long.MAX_VALUE));
        resa.setService(wcfRes.getService());
        resa.setServiceId(wcfRes.getServiceId());
        
        if (wcfRes.getCustomer() != null)
        {
            resa.setCustomerMail(wcfRes.getCustomer().getMail());
            resa.setCustomerPhone(wcfRes.getCustomer().getPhone());
        }
        
        Date dateToday = new Date();
        
        
        // If reservation's not confirmed yet AND the reservation's for in less than 24h
        if (!resa.getRestoConfirmation() && this.daysBetween(dateToday, resa.getReservationDate()) < 1)
        {
            resa.setColorCode(ColorCodeEnum.danger);
        }
        // If the reservation's not confirmed yet AND the reservation's for between tomorrow and next week
        else if(!resa.getRestoConfirmation() && this.daysBetween(dateToday, resa.getReservationDate()) < 6)
        {
            resa.setColorCode(ColorCodeEnum.warning);
        }
        // If the reservation's not been confirmed yet for after next week
        else if (!resa.getRestoConfirmation() && this.daysBetween(dateToday, resa.getReservationDate()) > 7)
        {
            resa.setColorCode(ColorCodeEnum.info);
        }
        // If the reservation's been confirmed and reservationdate is in the past
        else if (resa.getRestoConfirmation() && this.daysBetween(dateToday, resa.getReservationDate()) < 1)
        {
            resa.setColorCode(ColorCodeEnum.active);
        }
        // If the reservation's been confirmed for the future
        else
        {
            resa.setColorCode(ColorCodeEnum.success);
        }
        
        return resa;
    }
    
    /**
     * Maps model.reservation object to a wcf reservation object.
     * @param wcfRes : The reservation to map.
     * @return The mapped reservation.
     */
    private org.datacontract.schemas._2004._07.restobook_common_model.Reservation MapReservation(Reservation r) throws DatatypeConfigurationException
    {
        // Map the received Reservation to the reservation object
        org.datacontract.schemas._2004._07.restobook_common_model.Reservation res = objectFactory.createReservation();
        res.setId(r.getId());
        res.setCustomerId(r.getCustomerId());
        res.setRestoConfirmation(r.getRestoConfirmation());
        res.setIsEnabled(r.getIsEnable());
        res.setPlaceQuantity(r.getPlaceQuantity());
        
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(r.getReservationDate());
        res.setReservationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(g));
        
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(r.getRestoConfirmationDate());
        res.setRestoConfirmationDate(this.objectFactory.createReservationRestoConfirmationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc)));

        res.setService(r.getService());
        res.setServiceId(r.getServiceId());
        
        res.setRestoComments(r.getRestoComments());
        
        return res;
    }
    
    private int daysBetween(Date d1, Date d2)
    {
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    //</editor-fold>
}
