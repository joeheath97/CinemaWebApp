/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.BookingDTO;
import UI.UserUI;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Joe Heath
 */
@Named(value = "bookingBean")
@SessionScoped
public class BookingBean implements Serializable {

    /**
     * Creates a new instance of BookingBean
     */
    private UserUI userUI = new UserUI();
    private BookingDTO bookingDetails = null;
   
    
    public BookingDTO getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDTO bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
    
        public ArrayList<BookingDTO> getAllBookings(String Username)
    {
        ArrayList<BookingDTO> allFilms = userUI.viewAllBookings(Username);

        return allFilms; 
    }
    
    public BookingBean() {
    }
    
    
    
}
