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
    
    
    // <editor-fold defaultstate="collapsed" desc="MEMBERS">
    private int id;
    private Date serviceDate;
    private String dayOfWeek;
    private String typeService;
    private int beginShift;
    private int endShift;
    private int placeQuantity;
    private boolean isEnable;
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORS">
    public Service(){
        
    }
    
    public Service(int id, Date serviceDate, String dayOfWeek, String typeService, int beginShift, int endShift, int availablePlaces, boolean isEnabled)
    {
        this.id = id;
        this.serviceDate = serviceDate;
        this.dayOfWeek = dayOfWeek;
        this.typeService = typeService;
        this.beginShift = beginShift;
        this.endShift = endShift;
        this.placeQuantity = availablePlaces;
        this.isEnable = isEnabled;
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">
    public int getId(){
        return this.id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.id = Id;
    }

    /**
     * @return the ServiceDate
     */
    public Date getServiceDate() {
        return serviceDate;
    }

    /**
     * @param ServiceDate the ServiceDate to set
     */
    public void setServiceDate(Date ServiceDate) {
        this.serviceDate = ServiceDate;
    }

    /**
     * @return the DayOfWeek
     */
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * @param DayOfWeek the DayOfWeek to set
     */
    public void setDayOfWeek(String DayOfWeek) {
        this.dayOfWeek = DayOfWeek;
    }

    /**
     * @return the TypeService
     */
    public String getTypeService() {
        return typeService;
    }

    /**
     * @param TypeService the TypeService to set
     */
    public void setTypeService(String TypeService) {
        this.typeService = TypeService;
    }

    /**
     * @return the BeginShift
     */
    public int getBeginShift() {
        return beginShift;
    }

    /**
     * @param BeginShift the BeginShift to set
     */
    public void setBeginShift(int BeginShift) {
        this.beginShift = BeginShift;
    }

    /**
     * @return the EndShift
     */
    public int getEndShift() {
        return endShift;
    }

    /**
     * @param EndShift the EndShift to set
     */
    public void setEndShift(int EndShift) {
        this.endShift = EndShift;
    }

    /**
     * @return the PlaceQuantity
     */
    public int getPlaceQuantity() {
        return placeQuantity;
    }

    /**
     * @param PlaceQuantity the PlaceQuantity to set
     */
    public void setPlaceQuantity(int PlaceQuantity) {
        this.placeQuantity = PlaceQuantity;
    }

    /**
     * @return the IsEnable
     */
    public boolean isIsEnable() {
        return isEnable;
    }

    /**
     * @param IsEnable the IsEnable to set
     */
    public void setIsEnable(boolean IsEnable) {
        this.isEnable = IsEnable;
    }
    //</editor-fold>
    
}
