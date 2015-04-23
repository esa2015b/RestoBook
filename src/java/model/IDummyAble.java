/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Restaurant;
import java.util.List;

/**
 *
 * @author Thibaut
 */
public interface IDummyAble {
//    public Restaurant[] getAllRestaurant();
    public int getRdmRestaurant();
    public Restaurant getRestaurant(int id);
    public List<Restaurant> getRestaurantByName (String name);
    public List<Restaurant> getRestaurantAdvanced (String name, String type, String city);
}
