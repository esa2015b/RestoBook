/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Check manager.
 * Is used for all the validation cases.
 * @author Mirko Manessi
 */
public class ValidationMgr implements IValidationMgr
{
    
    // <editor-fold defaultstate="collapsed" desc="MEMBERS">
    private Pattern pattern;
    private Matcher matcher;
    private final String time24HoursPattern =  "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORS">
    public ValidationMgr()
    {
        pattern = Pattern.compile(time24HoursPattern);
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="PUBLIC METHODS">
    
    /**
     * Validates a time in string format in the following format :
     * hh:mm, and checks that it matches the 24h standard.
     * @param time : The string time to check.
     * @return : Whether it matches or not.
     */
    public boolean ValidateTime(String time)
    {
        matcher = pattern.matcher(time);
        return matcher.matches();
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="PRIVATE METHODS">
    
    // </editor-fold>
    
}
