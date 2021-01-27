
package DTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class FilmDTO implements Serializable{
    
    private int filmId;
    private String filmName;
    private String leadActor;
    private String duration; 

    public FilmDTO(int filmId, String filmName, String leadActor, String duration) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.leadActor = leadActor;
        this.duration = duration;
    }

    public FilmDTO()
    {
        
    }

    public void setFilmId(int filmId)
    {
        this.filmId = filmId;
    }

    public void setFilmName(String filmName)
    {
        this.filmName = filmName;
    }

    public void setLeadActor(String leadActor)
    {
        this.leadActor = leadActor;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }
    
    public int getFilmId() {
        return filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public String getDuration() {
        return duration;
    }
    
}
