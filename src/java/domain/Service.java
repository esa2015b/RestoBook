/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Thibaut
 */
public class Service {
    
    private int Id;
    private Date ServiceDate;
    private String DayOfWeek;
    private String TypeService;
    private int BeginShift;
    private int EndShift;
    private int PlaceQuantity;
    private boolean IsEnable;
    
    public Service(){
        
    }
    
    public int getId(){
        return this.Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the ServiceDate
     */
    public Date getServiceDate() {
        return ServiceDate;
    }

    /**
     * @param ServiceDate the ServiceDate to set
     */
    public void setServiceDate(Date ServiceDate) {
        this.ServiceDate = ServiceDate;
    }

    /**
     * @return the DayOfWeek
     */
    public String getDayOfWeek() {
        return DayOfWeek;
    }

    /**
     * @param DayOfWeek the DayOfWeek to set
     */
    public void setDayOfWeek(String DayOfWeek) {
        this.DayOfWeek = DayOfWeek;
    }

    /**
     * @return the TypeService
     */
    public String getTypeService() {
        return TypeService;
    }

    /**
     * @param TypeService the TypeService to set
     */
    public void setTypeService(String TypeService) {
        this.TypeService = TypeService;
    }

    /**
     * @return the BeginShift
     */
    public int getBeginShift() {
        return BeginShift;
    }

    /**
     * @param BeginShift the BeginShift to set
     */
    public void setBeginShift(int BeginShift) {
        this.BeginShift = BeginShift;
    }

    /**
     * @return the EndShift
     */
    public int getEndShift() {
        return EndShift;
    }

    /**
     * @param EndShift the EndShift to set
     */
    public void setEndShift(int EndShift) {
        this.EndShift = EndShift;
    }

    /**
     * @return the PlaceQuantity
     */
    public int getPlaceQuantity() {
        return PlaceQuantity;
    }

    /**
     * @param PlaceQuantity the PlaceQuantity to set
     */
    public void setPlaceQuantity(int PlaceQuantity) {
        this.PlaceQuantity = PlaceQuantity;
    }

    /**
     * @return the IsEnable
     */
    public boolean isIsEnable() {
        return IsEnable;
    }

    /**
     * @param IsEnable the IsEnable to set
     */
    public void setIsEnable(boolean IsEnable) {
        this.IsEnable = IsEnable;
    }
    
    
}
