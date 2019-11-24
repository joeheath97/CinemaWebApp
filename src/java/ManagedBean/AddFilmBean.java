
package ManagedBean;

import DTO.FilmDTO;
import UI.AdminUI;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "addFilmBean")
@RequestScoped
public class AddFilmBean {

    private int FilmID;
    private String FilmName;
    private String LeadActor;
    private String Duration;
    private AdminUI adminUI = new AdminUI();

    public int getFilmID() {
        return FilmID;
    }

    public void setFilmID(int FilmID) {
        this.FilmID = FilmID;
    }

    public String getFilmName() {
        return FilmName;
    }

    public void setFilmName(String FilmName) {
        this.FilmName = FilmName;
    }

    public String getLeadActor() {
        return LeadActor;
    }

    public void setLeadActor(String LeadActor) {
        this.LeadActor = LeadActor;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }
   
    
    @Inject
    FilmBean filmBean;
    
    public AddFilmBean() 
    {
    }
    
    public String addFilm()
    {
        filmBean.setFilmDetails(
                                adminUI.addFilm(
                                new FilmDTO(
                                FilmID,
                                FilmName,
                                LeadActor,
                                Duration)));
        return "ViewAllFilms";
    }
    
}
