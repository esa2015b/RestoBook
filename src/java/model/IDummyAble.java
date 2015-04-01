/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Restaurant;

/**
 *
 * @author Thibaut
 */
public interface IDummyAble {
    public Restaurant[] getAllRestaurant();
    public Restaurant getRdmRestaurant();
    public Restaurant getRestaurant(int id);
}
