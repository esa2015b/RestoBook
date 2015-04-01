/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.*;
import java.util.List;
import java.util.ArrayList;
import domain.*;
import java.util.Random;

/**
 *
 * @author Thibaut
 */
public class DummyMgr implements IDummyAble{
    
    public Restaurant getRestaurant(int id){
        
        List listeRestaurant = new ArrayList();  
        
        Restaurant resto1 = new Restaurant(1,"Chez Mario","info@chezmario.com","0123456","Le meilleur de la cuisine italienne",25,"Lundi","",true,false);
        Restaurant resto2 = new Restaurant(2,"Les 3 Faisans","info@les3faisans.com","1234567","Le meilleur de la cuisine francaise",40,"Mardi","",true,false);
        Restaurant resto3 = new Restaurant(3,"Au Lotus Bleu","info@lelotusbleu.com","2345678","Le meilleur de la cuisine chinoise",55,"Lundi","",true,false);
        Restaurant resto4 = new Restaurant(4,"Chez Ismir","info@chezismir.com","3456789","Le meilleur de la cuisine turque",60,"Mercredi","",true,false);
        
        listeRestaurant.add(resto1);
        listeRestaurant.add(resto2);
        listeRestaurant.add(resto3);
        listeRestaurant.add(resto4);
        
        Restaurant result = null;
        
        for (int i = 0; i < listeRestaurant.size(); i++){
            result = (Restaurant) listeRestaurant.get(i);
            if (result.getRestaurantId() == id) break; 
        }
        return result;
    }
    
    public Restaurant getRdmRestaurant(){
        
        List listeRestaurant = new ArrayList();  
        
        Restaurant resto1 = new Restaurant(1,"Chez Mario","info@chezmario.com","0123456","Le meilleur de la cuisine italienne",25,"Lundi","",true,false);
        Restaurant resto2 = new Restaurant(2,"Les 3 Faisans","info@les3faisans.com","1234567","Le meilleur de la cuisine francaise",40,"Mardi","",true,false);
        Restaurant resto3 = new Restaurant(3,"Au Lotus Bleu","info@lelotusbleu.com","2345678","Le meilleur de la cuisine chinoise",55,"Lundi","",true,false);
        Restaurant resto4 = new Restaurant(4,"Chez Ismir","info@chezismir.com","3456789","Le meilleur de la cuisine turque",60,"Mercredi","",true,false);
        
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
        
        Restaurant resto1 = new Restaurant(1,"Chez Mario","info@chezmario.com","0123456","Le meilleur de la cuisine italienne",25,"Lundi","",true,false);
        Restaurant resto2 = new Restaurant(2,"Les 3 Faisans","info@les3faisans.com","1234567","Le meilleur de la cuisine francaise",40,"Mardi","",true,false);
        Restaurant resto3 = new Restaurant(3,"Au Lotus Bleu","info@lelotusbleu.com","2345678","Le meilleur de la cuisine chinoise",55,"Lundi","",true,false);
        Restaurant resto4 = new Restaurant(4,"Chez Ismir","info@chezismir.com","3456789","Le meilleur de la cuisine turque",60,"Mercredi","",true,false);
        
        listeRestaurant.add(resto1);
        listeRestaurant.add(resto2);
        listeRestaurant.add(resto3);
        listeRestaurant.add(resto4);
        
	return (Restaurant[]) (listeRestaurant.toArray(new Restaurant[listeRestaurant.size()]));
        
    }
    
}


    