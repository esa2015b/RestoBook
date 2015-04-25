/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.*;
import java.util.List;

/**
 *
 * @author Thibaut
 */
public interface IDummyAble {
//    public Restaurant[] getAllRestaurant();
    public DisplayRestaurant getRdmRestaurant();
    public DisplayRestaurant getRestaurant(int id);
    public List<LightRestaurant> getRestaurantByName (String name);
    public List<LightRestaurant> getRestaurantAdvanced (String name, String type, String city);
}
