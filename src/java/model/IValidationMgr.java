/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * The Check manager interface.
 * Is used for all the validation cases. 
 * @author Mirko Manessi
 */
public interface IValidationMgr
{
    /**
     * Validates a time in string format in the following format :
     * hh:mm, and checks that it matches the 24h standard.
     * @param time : The string time to check.
     * @return : Whether it matches or not.
     */
    public boolean ValidateTime(String time);

}
