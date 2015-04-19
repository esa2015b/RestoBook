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
    
    private int Id;
    private String Mail;
    private String Phone;
    
    public Customer(int Id, String Mail, String Phone){
        this.Id=Id;
        this.Mail=Mail;
        this.Phone=Phone;
    }
    
    public Customer(){
        
    }
    
    public int getId(){
        return this.Id;
    }
    
    public void setId(int Id){
        this.Id=Id;
    }
    
    public String getMail(){
        return Mail;
    }
    
    public void setMail(String Mail){
        this.Mail=Mail;
    }
    
    public String getPhone(){
        return this.Phone;
    }
    
    public void setPhone(String Phone){
        this.Phone=Phone;
    }
}
