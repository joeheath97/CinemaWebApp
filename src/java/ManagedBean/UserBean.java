/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.UserDTO;
import UI.AdminUI;
import UI.UserUI;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joe Heath
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable{
    
    private AdminUI adminUI = new AdminUI();
    private UserUI userUI = new UserUI();
    private UserDTO userDetails = null;
    private String UserName;
    private String Password;
    private boolean loginCheck = false;
    
    
    public UserDTO getUserDetails()
    {
        return userDetails;
    }
    
    public void setUserDetails(UserDTO userDetails)
    {
        System.out.println("setting userdetails");
        this.userDetails = userDetails;
    }

    public ArrayList<UserDTO> getAllUsers()
    {
        ArrayList<UserDTO> allUsers = adminUI.getAllUser();
        
        return allUsers; 
    }
    
    
    public String CheckLogin()
    {
        System.out.println("checking login");
        try
        {
            this.setUserDetails(userUI.login(UserName, Password));
            loginCheck = true;
            if(loginCheck)
            {
                if(getUserDetails().isIsAdmin())
                {
                    System.out.println("AdminFound");
                    return "AdminPage"; 
                }
                else
                {
                    return "UserPage";
                }   
            }   
        }
        catch (Exception e)
        {
            System.out.println(e);;
        } 
        return null;
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
    
    public String LogOut(){
        ClearLoginDetails();
        return "index";
    }
    
    private void ClearLoginDetails(){
        this.UserName = "";
        this.Password = "";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }


    
}
