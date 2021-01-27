
package DTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShowingDTO implements Serializable{
    
    private int showingId;
    private FilmDTO film;
    private ScreenDTO screen;
    private String showingTime;

    
    public ShowingDTO(int showingId, FilmDTO film, ScreenDTO screen, String showingTime) {
        this.showingId = showingId;
        this.film = film;
        this.screen = screen;
        this.showingTime = showingTime;
    }
    
    public ShowingDTO()
    {
        
    }

    public void setShowingId(int showingId)
    {
        this.showingId = showingId;
    }

    public void setFilm(FilmDTO film)
    {
        this.film = film;
    }

    public void setScreen(ScreenDTO screen)
    {
        this.screen = screen;
    }

    public void setShowingTime(String showingTime)
    {
        this.showingTime = showingTime;
    }
    
    

    public int getShowingId() {
        return showingId;
    }

    public FilmDTO getFilm() {
        return film;
    }

    public ScreenDTO getScreen() {
        return screen;
    }

    public String getShowingTime() {
        return showingTime;
    }


    
    
    


    
}
