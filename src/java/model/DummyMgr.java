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
        Employee[] emp = new Employee[1];
        emp[0] = new Employee(0,"Thibaut","Clausse","tclausse@live.fr","tclausse","0475562191","password",1,true);
        PriceList[] pl = new PriceList[1];
        pl[0] = new PriceList(0,"Description de la PL",50,20,true);
        
        // Restaurant and FoodType creation
        Restaurant result = new Restaurant();
        FoodType foodType = new FoodType();
        
        // WebService creation
        RestoBookService wcf = new RestoBookService();
        
        // Assignation to Restaurant and FoodType from WCF.
        result.setDayOfClosing(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getDayOfClosing());
        result.setDescription(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getDescription());
        result.setMail(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getMail());
        result.setName(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getName());
        result.setPhone(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getPhone());
        result.setPictureLocation(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getPictureLocation());
        result.setPlaceQuantity(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getPlaceQuantity());
        result.setIsEnable(true);
        result.setIsPremium(false);
        
        foodType.setName(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getFoodType().getName());
        foodType.setDescription(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getFoodType().getDescription());
        foodType.setId(wcf.getBasicHttpBindingIRestoBookService().getRestaurantById(id).getFoodType().getId());
        foodType.setIsEnabled(true);
        
        // Assignation of static Employee and PriceList
        result.setFoodType(foodType);
        result.setEmployee(emp);
        result.setPriceList(pl);
        result.setId(id);
                        
        return result;
    }
    
    public Restaurant getRdmRestaurant(){
        
        
        List listeRestaurant = new ArrayList();  
        
        FoodType ft = new FoodType(0,"La Cuisine Italienne",true,"Italienne");
        Employee[] emp = new Employee[1];
        emp[0] = new Employee(0,"Thibaut","Clausse","tclausse@live.fr","tclausse","0475562191","password",1,true);
        PriceList[] pl = new PriceList[1];
        pl[0] = new PriceList(0,"Description de la PL",50,20,true);
        
        Restaurant resto1 = new Restaurant(1,"Chez Mario","info@chezmario.com","0123456","Le meilleur de la cuisine italienne",25,"Lundi","",true,false,pl,emp,ft);
        Restaurant resto2 = new Restaurant(2,"Les 3 Faisans","info@les3faisans.com","1234567","Le meilleur de la cuisine francaise",40,"Mardi","",true,false,pl,emp,ft);
        Restaurant resto3 = new Restaurant(3,"Au Lotus Bleu","info@lelotusbleu.com","2345678","Le meilleur de la cuisine chinoise",55,"Lundi","",true,false,pl,emp,ft);
        Restaurant resto4 = new Restaurant(4,"Chez Ismir","info@chezismir.com","3456789","Le meilleur de la cuisine turque",60,"Mercredi","",true,false,pl,emp,ft);
        
        listeRestaurant.add(resto1);
        listeRestaurant.add(resto2);
        listeRestaurant.add(resto3);
        listeRestaurant.add(resto4);
        
        Restaurant result = null;
        Random rand = new Random();
        int i = rand.nextInt(listeRestaurant.size());
        
        result = (Restaurant) listeRestaurant.get(i);
        
        return result;
         
    }
    
    public Restaurant[] getAllRestaurant(){
        
        List listeRestaurant = new ArrayList();  
        
        FoodType ft = new FoodType(0,"La Cuisine Italienne",true,"Italienne");
        Employee[] emp = new Employee[1];
        emp[0] = new Employee(0,"Thibaut","Clausse","tclausse@live.fr","tclausse","0475562191","password",1,true);
        PriceList[] pl = new PriceList[1];
        pl[0] = new PriceList(0,"Description de la PL",50,20,true);
        
        Restaurant resto1 = new Restaurant(1,"Chez Mario","info@chezmario.com","0123456","Le meilleur de la cuisine italienne",25,"Lundi","",true,false,pl,emp,ft);
        Restaurant resto2 = new Restaurant(2,"Les 3 Faisans","info@les3faisans.com","1234567","Le meilleur de la cuisine francaise",40,"Mardi","",true,false,pl,emp,ft);
        Restaurant resto3 = new Restaurant(3,"Au Lotus Bleu","info@lelotusbleu.com","2345678","Le meilleur de la cuisine chinoise",55,"Lundi","",true,false,pl,emp,ft);
        Restaurant resto4 = new Restaurant(4,"Chez Ismir","info@chezismir.com","3456789","Le meilleur de la cuisine turque",60,"Mercredi","",true,false,pl,emp,ft);
        
        listeRestaurant.add(resto1);
        listeRestaurant.add(resto2);
        listeRestaurant.add(resto3);
        listeRestaurant.add(resto4);
        
        
	return (Restaurant[]) (listeRestaurant.toArray(new Restaurant[listeRestaurant.size()]));
        
    }
    
}


    