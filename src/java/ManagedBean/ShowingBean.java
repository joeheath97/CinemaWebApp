/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.CinemaDTO;
import DTO.ShowingDTO;
import UI.AdminUI;
import UI.UserUI;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Joe Heath
 */

        
@Named(value = "showingBean")
@SessionScoped
public class ShowingBean implements Serializable{
    
@Inject 
CinemaBean CinemaBean;
@Inject 
ScreenBean ScreenBean;
 
    private AdminUI adminUI = new AdminUI();
    private UserUI userUI = new UserUI();
    private ShowingDTO ShowingDetails = null;
    private ArrayList<ShowingDTO> searchResults = new ArrayList<>();
    private int search;
    private CinemaDTO CinemaDetails = null;
    
    public ShowingBean() {
    }
        
    public ArrayList<ShowingDTO> getAllShowings()
    {
        ArrayList<ShowingDTO> allShowings = adminUI.getAllShowings();

        return allShowings; 
    }
     
    public ShowingDTO getShowingDetails(int ShowingID)
    {
       ShowingDetails = userUI.getShowing(ShowingID);
       return ShowingDetails;
    }
    
    public ShowingDTO findShowing(int ShowingID) 
    {
       ShowingDetails = userUI.getShowing(ShowingID);
       return ShowingDetails;
    }
        
    public String findShowingTime(int ShowingID) 
    {
       ShowingDetails = userUI.getShowing(ShowingID);
       return ShowingDetails.getShowingTime();
    }
    
    public void setShowingDetails(ShowingDTO ShowingDetails) 
    {
        this.ShowingDetails = ShowingDetails;
    }
  
    public ShowingDTO getShowingInfo()
    {
        return ShowingDetails;
    }
    
    public ArrayList<ShowingDTO> getSearchedInfo(){
        return searchResults;
    }
   
    public String ViewShowing(int ShowingID, String ScreenID)
    {    
        ShowingDetails = userUI.getShowing(ShowingID);
        ScreenBean.setScreenDetails(userUI.findScreen(ScreenID));
        CinemaBean.setCinemaDetails(userUI.getCinemaDetails(ScreenBean.getScreenDetails().getCinemaID()));
        return "ViewShowing";  
    }
    
    
    public ArrayList<ShowingDTO> getAllSearchedList()
    {
        searchResults = userUI.getAllSearchShowing(search);
        return  searchResults;
    }   

    public int getSearch() {
        return search;
    }

    public void setSearch(int search) {
        this.search = search;
    }
    
    
}
