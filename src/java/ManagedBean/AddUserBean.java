/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.UserDTO;
import UI.UserUI;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Joe Heath
 */
@Named(value = "addUserBean")
@RequestScoped
public class AddUserBean {

    private UserUI userUI = new UserUI();
    
    @Inject
    UserBean userBean;
    
        
    private String UserName;
    private String Password;
    private String AddressLine1;
    private String AddressLine2;
    private String Town;
    private String county;
    private String PostCode;
    private boolean isAdmin;
    
    public AddUserBean() {
    }
    
    public String addUser()
    {
        userBean.setUserDetails(
                userUI.createAccount(
                        new UserDTO(
                                UserName,
                                Password,
                                AddressLine1,
                                AddressLine2,
                                Town, county,
                                PostCode,
                                isAdmin)));
        return "index";
    }

    public UserUI getUserUI() {
        return userUI;
    }

    public void setUserUI(UserUI userUI) {
        this.userUI = userUI;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String Town) {
        this.Town = Town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
}
