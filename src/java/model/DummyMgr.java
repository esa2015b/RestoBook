/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.ArrayList;
import domain.*;
import java.util.Random;
import org.tempuri.RestoBookService;

/**
 *
 * @author Thibaut
 */
public class DummyMgr implements IDummyAble{
    
    public Restaurant getRestaurant(int id){
        
        // Some Static Employee and PriceList for testing purpose
        /*
        Employee emp = new Employee[1];
        emp[0] = new Employee(0,"Thibaut","Clausse","tclausse@live.fr","tclausse","0475562191","password",1,true);
        PriceList[] pl = new PriceList[1];
        pl[0] = new PriceList(0,"Description de la PL",50,20,true);
        */
        
        // Restaurant and FoodType creation
        Restaurant result = new Restaurant();
        FoodType foodType = new FoodType();
        Owner owner = new Owner();
        List<Employee> emp = new ArrayList<Employee>();
        List<PriceList> pl = new ArrayList<PriceList>();
        
        // WebService creation
        RestoBookService wcf = new RestoBookService();
        org.datacontract.schemas._2004._07.restobook_common_model.Restaurant wcfRep = wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id);
        
        // Assignation to Restaurant and FoodType from WCF.
        result.setDayOfClosing(wcfRep.getDayOfClosing());
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
            employee.setRestaurantId(id);
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
        result.setId(id);
                        
        return result;
    }
    
    public int getRdmRestaurant(){
       
        RestoBookService wcf = new RestoBookService();
        
        int id = wcf.getBasicHttpBindingIRestoBookService().getRandomRestaurant().getId();
        
        return id;
         
    }
    /*
    public Restaurant[] getAllRestaurant(){
        
        List listeRestaurant = new ArrayList();  
        
        FoodType ft = new FoodType(0,"La Cuisine Italienne",true,"Italienne");
        Owner owner = new Owner();
        Employee[] emp = new Employee[1];
        emp[0] = new Employee(0,"Thibaut","Clausse","tclausse@live.fr","tclausse","0475562191","password",1,true);
        PriceList[] pl = new PriceList[1];
        pl[0] = new PriceList(0,"Description de la PL",50,20,true);
        
        Restaurant resto1 = new Restaurant(1,"Chez Mario","info@chezmario.com","0123456","Le meilleur de la cuisine italienne",25,"Lundi","",true,false,pl,emp,ft,owner);
        Restaurant resto2 = new Restaurant(2,"Les 3 Faisans","info@les3faisans.com","1234567","Le meilleur de la cuisine francaise",40,"Mardi","",true,false,pl,emp,ft,owner);
        Restaurant resto3 = new Restaurant(3,"Au Lotus Bleu","info@lelotusbleu.com","2345678","Le meilleur de la cuisine chinoise",55,"Lundi","",true,false,pl,emp,ft,owner);
        Restaurant resto4 = new Restaurant(4,"Chez Ismir","info@chezismir.com","3456789","Le meilleur de la cuisine turque",60,"Mercredi","",true,false,pl,emp,ft,owner);
        
        listeRestaurant.add(resto1);
        listeRestaurant.add(resto2);
        listeRestaurant.add(resto3);
        listeRestaurant.add(resto4);
        
        
	return (Restaurant[]) (listeRestaurant.toArray(new Restaurant[listeRestaurant.size()]));
        
    }
    */
    public List<Restaurant> getRestaurantByName (String name)
    {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        RestoBookService wcf = new RestoBookService();
        
        for(int i = 0; i < wcf.getBasicHttpBindingIRestoBookService().getRestaurantByName(name).getRestaurant().size(); i++)
        {
            int id = wcf.getBasicHttpBindingIRestoBookService().getRestaurantByName(name).getRestaurant().get(i).getId();
            Restaurant resto = this.getRestaurant(id);
            restaurants.add(resto);
        }
        
        return restaurants;
    }
    
    public List<Restaurant> getRestaurantAdvanced (String name, String type, String city)
    {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        RestoBookService wcf = new RestoBookService();
        
        for(int i = 0; i < wcf.getBasicHttpBindingIRestoBookService().getRestaurantAdvanced(name, type, city).getRestaurant().size(); i++)
        {
            int id = wcf.getBasicHttpBindingIRestoBookService().getRestaurantAdvanced(name, type, city).getRestaurant().get(i).getId();
            Restaurant resto = this.getRestaurant(id);
            restaurants.add(resto);
        }
        
        return restaurants;
    }
}
   