/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.ScreenDTO;
import UI.AdminUI;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Joe Heath
 */
@Named(value = "screenBean")
@SessionScoped
public class ScreenBean implements Serializable {

    private AdminUI adminUI = new AdminUI();
    private ScreenDTO ScreenDetails = null;

    public ScreenDTO getScreenDetails() {
        System.out.println("getting screen details");
        return ScreenDetails;
    }

    public void setScreenDetails(ScreenDTO ScreenDetails) {
        this.ScreenDetails = ScreenDetails;
        System.out.println("setting screen details");
    }
    public ScreenBean() {
    }
    
    public ArrayList<ScreenDTO> getAllScreen()
    {
        ArrayList<ScreenDTO> allScreens = adminUI.getAllScreen();
        return allScreens;
    }
    
}
