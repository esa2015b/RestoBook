/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.ArrayList;
import domain.*;
import java.util.Calendar;
import java.util.Locale;
import org.tempuri.RestoBookService;

/**
 *
 * @author Thibaut
 */
public class DummyMgr implements IDummyAble
{
    
    // <editor-fold defaultstate="collapsed" desc="PUBLIC METHODS">
    public DisplayRestaurant getRestaurant(int id){
        
        DisplayRestaurant displayResto = new DisplayRestaurant();
        RestoBookService wcf = new RestoBookService();
        
        displayResto = this.mapDisplayRestaurant(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id));
        
        return displayResto;
        
    }
    
    public DisplayRestaurant getRdmRestaurant(){
       
        DisplayRestaurant displayResto = new DisplayRestaurant();
        
        RestoBookService wcf = new RestoBookService();
        displayResto = this.mapDisplayRestaurant(wcf.getBasicHttpBindingIRestoBookService().getRandomRestaurant());
        
        return displayResto;
         
    }
    
    public List<LightRestaurant> getRestaurantByName (String name)
    {
        List<LightRestaurant> restaurants = new ArrayList<LightRestaurant>();
        RestoBookService wcf = new RestoBookService();
        
        List<org.datacontract.schemas._2004._07.restobook_common_model.Restaurant> wcfRestos = wcf.getBasicHttpBindingIRestoBookService().getRestaurantByName(name).getRestaurant();
        
        for(int i = 0; i < wcfRestos.size(); i++)
        {
            LightRestaurant lightResto = this.mapLightRestaurant(wcfRestos.get(i));

            restaurants.add(lightResto);
        }
        
        return restaurants;
    }
    
    public List<LightRestaurant> getRestaurantAdvanced (String name, String type, String city)
    {
        List<LightRestaurant> restaurants = new ArrayList<LightRestaurant>();
        RestoBookService wcf = new RestoBookService();
        
        List<org.datacontract.schemas._2004._07.restobook_common_model.LightRestaurant> wcfRestos = wcf.getBasicHttpBindingIRestoBookService().getLightRestaurantAdvanced(name, type, city).getLightRestaurant();
        
        for(int i = 0; i < wcfRestos.size(); i++)
        {
            LightRestaurant lightResto = this.mapLightRestaurant(wcfRestos.get(i));
            
            restaurants.add(lightResto);
        }
        
        return restaurants;
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
        lightResto.setCity(wcf.getCity());
        
        return lightResto;
        
    }
    
    private LightRestaurant mapLightRestaurant (org.datacontract.schemas._2004._07.restobook_common_model.Restaurant wcf){
        
        LightRestaurant lightResto = new LightRestaurant();
        
        lightResto.setId(wcf.getId());
        lightResto.setName(wcf.getName());
        lightResto.setFoodTypeName(wcf.getFoodType().getName());
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
        displayResto.setFoodTypeName(wcf.getFoodType() == null ? "" : wcf.getFoodType().getName());
        Address address = wcf.getAddresses().getAddress() == null ? new Address() : new Address(wcf.getAddresses().getAddress().get(0).getId(),
                                        wcf.getId(),
                                        wcf.getAddresses().getAddress().get(0).getStreet().getValue(),
                                        wcf.getAddresses().getAddress().get(0).getNumber().getValue(), 
                                        wcf.getAddresses().getAddress().get(0).getZipCode().getValue(), 
                                        wcf.getAddresses().getAddress().get(0).getCity().getValue(), 
                                        wcf.getAddresses().getAddress().get(0).getCountry().getValue(),
                                        true, 
                                        true);
        displayResto.setAddress(address);
        ArrayList<Service> services = new ArrayList<>();
        
        if (wcf.getServices() != null)
        {
            for (int i = 0; i < wcf.getServices().getService().size(); i++)
            {   
//                Calendar c = wcf.getServices().getService().get(i).getServiceDate().toGregorianCalendar();
//                String dayOfWeek = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.FRENCH);
                
                Service s = new Service(wcf.getServices().getService().get(i).getId(), 
                                        wcf.getServices().getService().get(i).getServiceDate().toGregorianCalendar().getTime(),
                                        wcf.getServices().getService().get(i).getServiceDate().toGregorianCalendar().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.FRENCH),
                                        wcf.getServices().getService().get(i).getTypeService(), 
                                        wcf.getServices().getService().get(i).getBeginShift(),
                                        wcf.getServices().getService().get(i).getEndShift(),
                                        wcf.getServices().getService().get(i).getPlaceQuantity(),
                                        wcf.getServices().getService().get(i).isIsEnabled());

                services.add(s);
            }
        }
        displayResto.setServices(services);
        
        return displayResto;
    }
     
    private Restaurant mapFullRestaurant (org.datacontract.schemas._2004._07.restobook_common_model.Restaurant wcfRep){
        Restaurant result = new Restaurant();
        FoodType foodType = new FoodType();
        Owner owner = new Owner();
        List<Employee> emp = new ArrayList<>();
        List<PriceList> pl = new ArrayList<>();
        
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
   