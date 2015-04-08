/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Thibaut
 */
public class Employee {
    
    private int Id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Login;
    private String Mobile;
    private String Password;
    private int RestaurantId;
    private boolean IsEnabled;
    
    public Employee(int Id, String FirstName, String LastName, String Email, String Login, String Mobile, String Password, int RestaurantId, boolean isEnabled){
        this.Id=Id;
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.Email=Email;
        this.Login=Login;
        this.Mobile=Mobile;
        this.Password=Password;
        this.RestaurantId=RestaurantId;
        this.IsEnabled=IsEnabled;
    }
    
    public Employee(){
        
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the Mobile
     */
    public String getMobile() {
        return Mobile;
    }

    /**
     * @param Mobile the Mobile to set
     */
    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the RestaurantId
     */
    public int getRestaurantId() {
        return RestaurantId;
    }

    /**
     * @param RestaurantId the RestaurantId to set
     */
    public void setRestaurantId(int RestaurantId) {
        this.RestaurantId = RestaurantId;
    }

    /**
     * @return the IsEnabled
     */
    public boolean isIsEnabled() {
        return IsEnabled;
    }

    /**
     * @param IsEnabled the IsEnabled to set
     */
    public void setIsEnabled(boolean IsEnabled) {
        this.IsEnabled = IsEnabled;
    }
    
    
}
