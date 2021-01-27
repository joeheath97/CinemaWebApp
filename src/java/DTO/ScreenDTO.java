
package DTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ScreenDTO implements Serializable{
    
    private String screenId;
    private CinemaDTO cinema;

    public ScreenDTO(String screenId, CinemaDTO cinema) {
        this.screenId = screenId;
        this.cinema = cinema;
    }
    
    public ScreenDTO()
    {
        
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public CinemaDTO getCinema() {
        return cinema;
    }

    public void setCinema(CinemaDTO cinema) {
        this.cinema = cinema;
    }
   
}
