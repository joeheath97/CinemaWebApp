/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.BookingDTO;
import DTO.ShowingDTO;
import UI.UserUI;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Joe Heath
 */
@Named(value = "addBookingBean")
@RequestScoped
public class AddBookingBean {

    private int BookingID;
    private String UserName;
    private int ShowingID;
    private UserUI userUI = new UserUI();
    private ShowingDTO showingdetails = null;
    public AddBookingBean() {
        
    }
    
    @Inject
    UserBean userBean;
    @Inject
    ShowingBean showingBean;

    public int getBookingID() {
        return BookingID;
    }

    public String getUserName() {
        return UserName;
    }

    public int getShowingID() {
        return ShowingID;
    }


    
    
    
    
    @Inject
    BookingBean bookingBean;
    public String makeBooking()
    {   
     UserName = userBean.getUserDetails().getUserName();
     ShowingID = showingBean.getShowingInfo().getShowingID();
             
        bookingBean.setBookingDetails(userUI.AddBooking(new BookingDTO(
                                                            BookingID,
                                                            UserName,
                                                            ShowingID)));
              return "UserPage";                                              
    }
    
}
