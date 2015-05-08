/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Jean-Louis
 */
public class Customer {
    
    // <editor-fold defaultstate="collapsed" desc="MEMBERS">
    private int id;
    private String mail;
    private String phone;
    private String name;
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORS">
    public Customer(){
        
    }
    
    public Customer(int Id, String Mail, String Phone){
        this.id = Id;
        this.mail = Mail;
        this.phone = Phone;
    }
    
    public Customer(int id, String mail, String phone, String name)
    {
        this.id = id;
        this.mail = mail;
        this.phone = phone;
        this.name = name;
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getMail(){
        return mail;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    // </editor-fold>
}
