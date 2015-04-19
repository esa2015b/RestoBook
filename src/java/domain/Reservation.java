/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Jean-Louis
 */
public class Reservation {

    private int Id;
    private int CustomerId;
    private int ServiceId;
    private Date ReservationDate;
    private String Service;
    private int PlaceQuantity;
    private boolean RestoConfirmation;
    private Date RestoConfirmationDate;
    private String RestoComments;
    private boolean IsEnable;
    
    /*public Reservation(int Id, int CustomerId, int ServiceId, Date ReservationDate, String Service, int PlaceQuantity){
        this.Id=Id;
        this.CustomerId=CustomerId;
        this.ServiceId=ServiceId;
        this.ReservationDate=ReservationDate;
        this.Service=Service;
        this.PlaceQuantity=PlaceQuantity;
    }*/
    
    public Reservation(){
        
    }
    
    public int getId(){
        return this.Id;
    }
    
    public void setId(int Id){
        this.Id=Id;
    }
    
    public int getCustomerId(){
        return this.CustomerId;
    }
    
    public void setCustomerId(int CustomerId){
        this.CustomerId=CustomerId;
    }
    
    public int getServiceId(){
        return this.ServiceId;
    }
    
    public void setServiceId(int ServiceId){
        this.ServiceId=ServiceId;
    }
    
    public Date getReservationDate(){
        return ReservationDate;
    }
    
    public void setReservationDate(){
        this.ReservationDate=ReservationDate;
    }
    
    public String getService(){
        return this.Service;
    }
    
    public void setService(String Service){
        this.Service=Service;
    }
    
    public int getPlaceQuantity(){
        return this.PlaceQuantity;
    }
    
    public void setPlaceQuantity(int PlaceQuantity){
        this.PlaceQuantity=PlaceQuantity;
    }
    
    public boolean getRestoConfirmation(){
        return this.RestoConfirmation;
    }
    
    public void setRestoConfirmation(boolean restoConfirmation){
        this.RestoConfirmation=restoConfirmation;
    }
    
    @SuppressWarnings("ReturnOfDateField")
    public Date getRestoConfirmationDate(){
        return this.RestoConfirmationDate;
    }
    
    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setRestoConfirmationDate(Date RestoConfirmationDate){
        this.RestoConfirmationDate=RestoConfirmationDate;
    }
    
    public String getRestoComments (){
        return this.RestoComments;
    }
    
    public void setRestoComments(String RestoComments){
        this.RestoComments=RestoComments;
    }
    
    public boolean getIsEnable(){
        return this.IsEnable;
    }
    
    public void setIsEnable(boolean IsEnable){
        this.IsEnable=IsEnable;
    }
}
