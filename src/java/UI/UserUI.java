/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DTO.BookingDTO;
import DTO.CinemaDTO;
import DTO.FilmDTO;
import DTO.ScreenDTO;
import DTO.ShowingDTO;
import DTO.UserDTO;
import Manager.BookingManager;
import Manager.CinemaManager;
import Manager.FilmManager;
import Manager.ScreenManager;
import Manager.ShowingManager;
import Manager.UserManager;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Joe Heath
 */
@Named(value = "userUI1")
@RequestScoped
public class UserUI {

    private FilmManager filmMgr = new FilmManager();
    private ScreenManager screenMgr = new ScreenManager();
    private CinemaManager cinemaMgr = new CinemaManager();
    private ShowingManager showingMgr = new ShowingManager();
    private BookingManager BookingMgr = new BookingManager();
    private UserManager UserMgr = new UserManager();
    public UserUI() {
    }
        
    public ArrayList<ShowingDTO> getAllShowing(){
        return showingMgr.getAllShowings();
    }
    
    public ShowingDTO getShowing(int ShowingID)
    {
        return showingMgr.getShowing(ShowingID);
    }

    public ArrayList<ShowingDTO> getAllSearchShowing(int FilmID){
        return showingMgr.searchShowing(FilmID);
    }
    
    public CinemaDTO getCinemaDetails(int CinemaID)
    {
        return cinemaMgr.findCinemaByID(CinemaID);
    }
   
    public ArrayList<BookingDTO> viewAllBookings(String UserName){
        return BookingMgr.getAllBookings(UserName);
    }
    
    public BookingDTO AddBooking(BookingDTO Booking){
                if(BookingMgr.makeBooking(Booking))
        {
            return BookingMgr.getBooking(Booking.getBookingID());
        }
        return null;
    }
    
    public boolean cancelBooking(int BookingId){
        return BookingMgr.cancelBooking(BookingId);
    }
    
    public UserDTO getUser(String UserName)
    {
        return UserMgr.getUser(UserName);
    }
    
    public UserDTO createAccount(UserDTO user){
        if(UserMgr.addUser(user))
        {
            return UserMgr.login(user.getUserName(), user.getPassword());
        }
        return null;
    }
    
    public ScreenDTO findScreen(String ScreenID){
        return screenMgr.findByScreenID(ScreenID);
    }
    
    public CinemaDTO findCinema (int cinemaID){
        return cinemaMgr.findCinemaByID(cinemaID);
    }
    
    public UserDTO login(String UserName, String Password){
        return UserMgr.login(UserName, Password);
    }   
    
}
