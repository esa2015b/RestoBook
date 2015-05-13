/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jean-Louis
 */
public class Reservation
{

    // <editor-fold defaultstate="collapsed" desc="MEMBERS">
    private int id;
    private int customerId;
    private String customerMail;
    private String customerPhone;
    private int serviceId;
    private Date reservationDate;
    private String service;
    private int placeQuantity;
    private boolean restoConfirmation;
    private Date restoConfirmationDate;
    private String restoComments;
    private String reservationComments;
    private boolean isEnable;
    private ColorCodeEnum colorCode;
    private boolean restoRejection;
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORS">
    public Reservation(){
        
    }
    
    public Reservation(int id, int customerId, int serviceId, Date reservationDate, String service, int placeQuantity, String reservationComments){
        this.id = id;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.reservationDate = reservationDate;
        this.service = service;
        this.placeQuantity = placeQuantity;
        this.reservationComments = reservationComments;
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getCustomerId(){
        return this.customerId;
    }
    
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    
    public int getServiceId(){
        return this.serviceId;
    }
    
    public void setServiceId(int serviceId){
        this.serviceId = serviceId;
    }
    
    public Date getReservationDate(){
        return reservationDate;
    }
    
    public String getReservationDateSimple(){
        return new SimpleDateFormat("dd/MM/yyyy").format(this.reservationDate);
    }
    
    public void setReservationDate(Date reservationDate){
        this.reservationDate = reservationDate;
    }
    
    public String getService(){
        return this.service;
    }
    
    public void setService(String service){
        this.service = service;
    }
    
    public int getPlaceQuantity(){
        return this.placeQuantity;
    }
    
    public void setPlaceQuantity(int placeQuantity){
        this.placeQuantity = placeQuantity;
    }
    
    public boolean getRestoConfirmation(){
        return this.restoConfirmation;
    }
    
    public void setRestoConfirmation(boolean restoConfirmation){
        this.restoConfirmation = restoConfirmation;
    }
    
    @SuppressWarnings("ReturnOfDateField")
    public Date getRestoConfirmationDate(){
        return this.restoConfirmationDate;
    }
    
    public String getRestoConfirmationDateSimple()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(this.restoConfirmationDate);
    }
    
    @SuppressWarnings("AssignmentToDateFieldFromParameter")
    public void setRestoConfirmationDate(Date restoConfirmationDate){
        this.restoConfirmationDate = restoConfirmationDate;
    }
    
    public String getRestoComments (){
        return this.restoComments;
    }
    
    public void setRestoComments(String restoComments){
        this.restoComments = restoComments;
    }
    
    public boolean getIsEnable(){
        return this.isEnable;
    }
    
    public void setIsEnable(boolean isEnable){
        this.isEnable = isEnable;
    }

    public String getReservationComments()
    {
        return this.reservationComments;
    }
    
    public void setReservationComments(String reservationComments)
    {
        this.reservationComments = reservationComments;
    }
    
    /**
     * Gets the colorcode enumeration's name.
     * @return The colorcode enumeration as string.
     */
    public String getColorCodeName()
    {
        return this.colorCode.name();
    }
    
    /**
     * Gets the colorcode enumeration.
     * @return The colorcode enumeration.
     */
    public ColorCodeEnum getColorCode()
    {
        return this.colorCode;
    }
    
    /**
     * Sets the color code enumeration.
     * @param colorCode : The colorcode enumeration to set.
     */
    public void setColorCode(ColorCodeEnum colorCode)
    {
        this.colorCode = colorCode;
    }
    
    public String getCustomerMail()
    {
        return this.customerMail;
    }
    
    public void setCustomerMail(String mail)
    {
        this.customerMail = mail;
    }
    
    public String getCustomerPhone()
    {
        return this.customerPhone;
    }
    
    public void setCustomerPhone(String phone)
    {
        this.customerPhone = phone;
    }
    
    public String getRestoConfirmationChecked()
    {
        return this.restoConfirmation ? "checked" : "";
    }
    
    public void setRestoRejected(boolean restoRejection)
    {
        this.restoRejection = restoRejection;
    }
    
    public boolean getRestoRejected()
    {
        return this.restoRejection;
    }
    
    public String getRestoRejectedChecked()
    {
        return this.restoRejection ? "checked" : "";
    }
    // </editor-fold>
    
}