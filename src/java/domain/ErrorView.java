/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Mirko Manessi
 */
public class ErrorView 
{
    
    // <editor-fold defaultstate="collapsed" desc="MEMBERS">
    private ArrayList<String> errors;
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    public ErrorView()
    {
        this.errors = new ArrayList<>();
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="PUBLIC METHODS">
    public void setError(String error)
    {
        this.errors.add(error);
    }
    
    public ArrayList<String> getErrors()
    {
        return this.errors;
    }
    
    public void removeError(int place)
    {
        this.errors.remove(place);
    }
    
    public void removeError(String error)
    {
        this.errors.remove(error);
    }
    
    public void resetErrors()
    {
        this.errors.clear();
    }
    // </editor-fold>
}
