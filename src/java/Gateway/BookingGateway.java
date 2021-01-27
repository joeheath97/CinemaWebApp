 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.BookingDTO;
import DTO.CinemaDTO;
import DTO.FilmDTO;
import DTO.ScreenDTO;
import DTO.ShowingDTO;
import DTO.UserDTO;
import dbase.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Joe Heath
 */
public class BookingGateway {
    private DBManager connection = new DBManager();
    
        
    public ArrayList<BookingDTO> findAll(String Username){
     
        Connection conn = connection.getConnect();
        System.out.println("Connecting Booking");
     ArrayList<BookingDTO> bookingList = new ArrayList<>();
          try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT Bookings.BookingId, Users.Username,Films.FilmId, Films.FilmName,Cinemas.CinemaId, Cinemas.CinemaName, Cinemas.Address, Screens.ScreenId, Showings.ShowingId, Showings.ShowingTime"
                 + " FROM BOOKINGS JOIN Users on Bookings.Username = Users.Username"
                 +                " JOIN Showings on Bookings.ShowingId = Showings.ShowingId"
                 +                " JOIN Films on Films.FilmId = Showings.FilmId"
                 +                " JOIN Screens on Showings.ScreenId = Screens.ScreenId"
                 +                " JOIN Cinemas on Screens.CinemaId = Cinemas.CinemaId"
                 + " WHERE Bookings.Username = ?"); 
         stmt.setString(1, Username);
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             
             UserDTO user = new UserDTO(rs.getString("Username"),"", "", "","", "","",null, false);
             FilmDTO film = new FilmDTO(rs.getInt("FilmId"),rs.getString("FilmName"), "", "");
             CinemaDTO cinema = new CinemaDTO(rs.getInt("CinemaId"), rs.getString("CinemaName"), rs.getString("Address"));
             ScreenDTO Screen = new ScreenDTO(rs.getString("ScreenId"), cinema);
             ShowingDTO showing = new ShowingDTO(rs.getInt("ShowingId"), film, Screen, rs.getString("ShowingTime"));
             BookingDTO booking = new BookingDTO(rs.getInt("BookingId"), user, showing);
             bookingList.add(booking);               
         }
         rs.close();
         stmt.close();
         conn.close();
     }
     catch(SQLException sqle)
     {
         System.out.println(sqle);
     }
     return bookingList; 
    }

    
    public BookingDTO findById(int BookingId)
    {
        BookingDTO booking = null;
        try
        {
        Connection conn = connection.getConnect();
        PreparedStatement stmt = conn.prepareStatement("SELECT Bookings.BookingId, Users.Username,Films.FilmId, Films.FilmName,Cinemas.CinemaId, Cinemas.CinemaName, Cinemas.Address, Screens.ScreenId, Showings.ShowingId, Showings.ShowingTime"
                 + " FROM BOOKINGS JOIN Users on Bookings.Username = Users.Username"
                 +                " JOIN Showings on Bookings.ShowingID = Showings.ShowingID"
                 +                " JOIN Films on Films.FilmId = Showings.FilmId"
                 +                " JOIN Screens on Showings.ScreenId = Screens.ScreenId"
                 +                " JOIN Cinemas on Screens.CinemaId = Cinemas.CinemaId"
                 + " WHERE BookingId = ?"); 
         stmt.setInt(1, BookingId);
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             
             UserDTO user = new UserDTO(rs.getString("Username"),"", "", "","", "","",null, false);
             FilmDTO film = new FilmDTO(rs.getInt("FilmId"),rs.getString("FilmName"), "", "");
             CinemaDTO cinema = new CinemaDTO(rs.getInt("CinemaId"), rs.getString("CinemaName"), rs.getString("Address"));
             ScreenDTO Screen = new ScreenDTO(rs.getString("ScreenId"), cinema);
             ShowingDTO showing = new ShowingDTO(rs.getInt("ShowingId"), film, Screen, rs.getString("ShowingTime"));
             booking = new BookingDTO(rs.getInt("BookingId"), user, showing);
         }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        return booking;
    }
    
    public boolean insert(BookingDTO booking){
        boolean insertOk = false;
        try 
        {
         Connection conn = connection.getConnect();
         System.out.println("Connecting Booking");
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO BOOKINGS (Username, ShowingId) values (?,?)");
        
         
         stmt.setString(1, booking.getUser().getUsername());
         stmt.setInt(2, booking.getShowing().getShowingId());
         
         int row = stmt.executeUpdate();
         
         insertOk = row == 1;
         
         stmt.close();
         conn.close();
         
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        return insertOk;
    }
    
    public boolean delete(int BookingId){
        try{
         Connection conn = connection.getConnect();
         System.out.println("Connecting Booking");
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM BOOKINGS WHERE BookingId = ?");
         stmt.setInt(1,BookingId);
         int row = stmt.executeUpdate();
         
         stmt.close();
         conn.close();  
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return true;
    }
    
}
