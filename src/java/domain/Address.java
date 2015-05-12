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
public class Address {
    
    private int Id;
    private int RestaurantId;
    private String Street;
    private String Number;
    private String ZipCode;
    private String City;
    private String Country;
    private boolean HeadOffice;
    private boolean IsEnable;
    
    
    
    public Address(int Id, int RestaurantId, String Street, String Number, String ZipCode, String City, String Country, boolean HeadOffice, boolean IsEnable ){
        this.Id = Id;
        this.RestaurantId = RestaurantId;
        this.Street = Street;
        this.Number = Number;
        this.ZipCode = ZipCode;
        this.City = City;
        this.Country = Country;
        this.HeadOffice = HeadOffice;
        this.IsEnable = IsEnable;
    }
    
    
    
    public Address(){
        
    }
    
    public int getId(){
        return Id;
    }
    
    public void setId(int Id){
        this.Id = Id;
    }
    
    public int getRestaurantId(){
        return this.RestaurantId;
    }
    
    public void setRestaurantId(int RestaurantId){
        this.RestaurantId=RestaurantId;
    }
    
    public String getStreet(){
        return this.Street;
    }
    
    public void setStreet(String Street){
        this.Street=Street;
    }
    
    public String getNumber(){
        return this.Number;
    }
    
    public void setNumber(String Number){
        this.Number=Number;
    }
    
    public String getZipCode(){
        return this.ZipCode;
    }
    
    public void setZipCode(String ZipCode){
        this.ZipCode=ZipCode;
    }
    
    public String getCity(){
        return this.City;
    }
    
    public void setCity(String City){
        this.City=City;
    }
    
    public String getCountry(){
        return this.Country;
    }
    
    public void setCountry(String Country){
        this.Country=Country;
    }
    
    public boolean getHeadOffice(){
        return this.HeadOffice;
    }
    
    public void setHeadOffice(boolean HeadOffice){
        this.HeadOffice=HeadOffice;
    }
    
    public boolean getIsEnable(){
        return this.IsEnable;
    }
    
    public void setIsEnable(boolean IsEnable){
        this.IsEnable=IsEnable;
    }
}
