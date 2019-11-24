/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;
import UI.AdminUI;
import javax.inject.Named;
import DTO.ShowingDTO;
import javax.enterprise.context.RequestScoped;
 

/**
 *
 * @author Joe Heath
 */
import javax.inject.Inject;
@Named(value = "modifyShowingBean")
@RequestScoped
public class ModifyShowingBean {

    private int ShowingID;
    private int FilmID;
    private String ScreenID;
    private String ShowingTime;
    
    private AdminUI admin = new AdminUI();
    @Inject
    ShowingBean showingBean;
    
    public ModifyShowingBean() {
    }
    
    public String gotoModify(int showingID){
        showingBean.setShowingDetails(admin.getShowing(showingID));
        return "ModifyShowingPage";   
    }
    
    public String modifyShowing(){
        
        ShowingID = showingBean.getShowingInfo().getShowingID();
        
        System.out.println("FilmID : " + FilmID);
        System.out.println("ScreenId : " + ScreenID);
        System.out.println("Showing Time : " + ShowingTime);
        
        admin.modifyShowing(new ShowingDTO(ShowingID,FilmID,ScreenID,ShowingTime));
        
        return "ViewAllShowings";

    }


    

    public int getShowingID() {
        return ShowingID;
    }


    public int getFilmID() {
        return FilmID;
    }

    public void setFilmID(int FilmID) {
        this.FilmID = FilmID;
    }

    public String getScreenId() {
        return ScreenID;
    }

    public void setScreenId(String ScreenID) {
        this.ScreenID = ScreenID;
    }

    public String getShowingTime() {
        return ShowingTime;
    }

    public void setShowingTime(String ShowingTime) {
        this.ShowingTime = ShowingTime;
    }
    
}
