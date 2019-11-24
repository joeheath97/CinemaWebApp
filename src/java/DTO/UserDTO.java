/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Joe Heath
 */
public class UserDTO {
    

    private String UserName;
    private String Password;
    private String AddressLine1;
    private String AddressLine2;
    private String Town;
    private String county;
    private String PostCode;
    private boolean isAdmin = false;

    public UserDTO(String UserName, String Password, String AddressLine1, String AddressLine2, String Town, String county, String PostCode, boolean isAdmin) {
        this.UserName = UserName;
        this.Password = Password;
        this.AddressLine1 = AddressLine1;
        this.AddressLine2 = AddressLine2;
        this.Town = Town;
        this.county = county;
        this.PostCode = PostCode;
        this.isAdmin = isAdmin;
    }
    
 

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public String getTown() {
        return Town;
    }

    public String getCounty() {
        return county;
    }

    public String getPostCode() {
        return PostCode;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }
    
    
}
