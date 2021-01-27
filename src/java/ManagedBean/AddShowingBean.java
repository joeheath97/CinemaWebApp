package ManagedBean;

import DTO.FilmDTO;
import DTO.ScreenDTO;
import DTO.ShowingDTO;
import UI.AdminUI;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "addShowingBean")
@RequestScoped
public class AddShowingBean {

    private int ShowingID;
    private int FilmID;
    private String ScreenID;
    private String ShowingTime;
    private AdminUI adminUI = new AdminUI();

    @Inject
    ShowingBean showingBean;

    public AddShowingBean() {
    }

    public String addShowing() {
        adminUI.addShowing(
                new ShowingDTO(
                        ShowingID,
                        new FilmDTO(FilmID, "", "", ""),
                        new ScreenDTO(ScreenID, null),
                        ShowingTime));
        return "ViewAllShowings";
    }

    public int getShowingID() {
        return ShowingID;
    }

    public void setShowingID(int ShowingID) {
        this.ShowingID = ShowingID;
    }

    public int getFilmID() {
        return FilmID;
    }

    public void setFilmID(int FilmID) {
        this.FilmID = FilmID;
    }

    public String getScreenID() {
        return ScreenID;
    }

    public void setScreenID(String ScreenID) {
        this.ScreenID = ScreenID;
    }

    public String getShowingTime() {
        return ShowingTime;
    }

    public void setShowingTime(String showingTime) {
        this.ShowingTime = showingTime;
    }

}
