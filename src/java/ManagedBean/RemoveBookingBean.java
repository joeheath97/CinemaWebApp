/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import UI.UserUI;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Joe Heath
 */
@Named(value = "removeBookingBean")
@RequestScoped
public class RemoveBookingBean {

    /**
     * Creates a new instance of RemoveBookingBean
     */
    private UserUI userUI = new UserUI();
    public RemoveBookingBean() {
    }
    
    public String removeBooking(int BookingId){
        
        userUI.cancelBooking(BookingId);
        return "ViewAllBookings";
        
    }
    
}
