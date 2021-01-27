/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.BookingDTO;
import DTO.ShowingDTO;
import DTO.UserDTO;
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

    private int BookingId;
    private String UserName;
    private int ShowingId;
    private UserUI userUI = new UserUI();
    //private ShowingDTO showingdetails = null;
    public AddBookingBean() {
        
    }
    
    @Inject
    UserBean userBean;
    @Inject
    ShowingBean showingBean;

    public int getBookingId() {
        return BookingId;
    }

    public String getUserName() {
        return UserName;
    }

    public int getShowingId() {
        return ShowingId;
    }

    @Inject
    BookingBean bookingBean;
    public String makeBooking()
    {   
     UserName = userBean.getUserDetails().getUsername();
     ShowingId = showingBean.getShowingInfo().getShowingId();
             
        userUI.AddBooking(new BookingDTO(BookingId,
                          new UserDTO(UserName,"","","","","","",null,false),
                          new ShowingDTO(ShowingId, null,null,"")));
              return "UserPage";                                              
    }
    
}

