/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.CinemaDTO;
import UI.AdminUI;
import UI.UserUI;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Joe Heath
 */
@Named(value = "cinemaBean")
@SessionScoped
public class CinemaBean implements Serializable {
    
    private AdminUI adminUI = new AdminUI();
    private UserUI UserUI = new UserUI();
    private CinemaDTO CinemaDetails = null;
    
    public ArrayList<CinemaDTO> getAllCinema(){
        ArrayList<CinemaDTO> allCinemas = adminUI.getAllCinema();
        return allCinemas;
    }

    public CinemaDTO getCinemaDetails() {
        
        System.out.println("getting details");
        return CinemaDetails;
    }

    public void setCinemaDetails(CinemaDTO CinemaDetails) {
        this.CinemaDetails = CinemaDetails;
        System.out.println("setting details");
    }
    
    public CinemaDTO findCinema(int CinemaID)
    {
        CinemaDetails = UserUI.getCinemaDetails(CinemaID);
        return CinemaDetails;
    }
        
    public String findCinemaAddress(int CinemaID)
    {
        CinemaDetails = UserUI.getCinemaDetails(CinemaID);
        return CinemaDetails.getAddress();
    }

}
