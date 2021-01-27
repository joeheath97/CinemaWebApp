/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;
import DTO.FilmDTO;
import DTO.ScreenDTO;
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

    private int ShowingId;
    private int FilmId;
    private String ScreenId;
    private String ShowingTime;
    
    private AdminUI admin = new AdminUI();
    @Inject
    ShowingBean showingBean;
    
    public ModifyShowingBean() {
    }
    
    public String gotoModify(int showingId){
        showingBean.setShowingDetails(admin.getShowing(showingId));
        return "ModifyShowingPage";   
    }
    
    public String modifyShowing(){
        
        ShowingId = showingBean.getShowingInfo().getShowingId();
        
        admin.modifyShowing(new ShowingDTO(ShowingId,
                new FilmDTO(FilmId,"","",""),
                new ScreenDTO(ScreenId,null),
                              ShowingTime));
        
        return "ViewAllShowings";

    }


    

    public int getShowingId() {
        return ShowingId;
    }


    public int getFilmId() {
        return FilmId;
    }

    public void setFilmId(int FilmId) {
        this.FilmId = FilmId;
    }

    public String getScreenId() {
        return ScreenId;
    }

    public void setScreenId(String ScreenId) {
        this.ScreenId = ScreenId;
    }

    public String getShowingTime() {
        return ShowingTime;
    }

    public void setShowingTime(String ShowingTime) {
        this.ShowingTime = ShowingTime;
    }
    
}
