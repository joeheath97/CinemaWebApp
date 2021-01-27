
package DTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookingDTO implements Serializable{
    
    private int bookingId;
    private UserDTO user;
    private ShowingDTO showing;
    
    public BookingDTO(){
        
    }

    public BookingDTO(int bookingId, UserDTO user, ShowingDTO showing) {
        this.bookingId = bookingId;
        this.user = user;
        this.showing = showing;
    }

    public void setBookingId(int bookingId)
    {
        this.bookingId = bookingId;
    }

    public void setUser(UserDTO user)
    {
        this.user = user;
    }

    public void setShowing(ShowingDTO showing)
    {
        this.showing = showing;
    }

    public int getBookingId() {
        return bookingId;
    }

    public UserDTO getUser() {
        return user;
    }

    public ShowingDTO getShowing() {
        return showing;
    }




    
}
