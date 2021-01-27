/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

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
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author h016195h
 */
@Path("booking")
public class BookingResources
{
    
    @Context
    private UriInfo context;
    private DBManager connection = new DBManager();
    
    @POST
    @Path("addBooking")
    @Consumes(
            {
                MediaType.APPLICATION_JSON
            })
    @Produces({
    
        MediaType.APPLICATION_JSON
    })
    public boolean create(BookingDTO booking)
    {boolean insertOk = false;
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
    
    @POST
    @Path("Delete")
    @Consumes(
            {
                MediaType.APPLICATION_JSON
            })
        @Produces(
            {
                MediaType.APPLICATION_JSON
            })
    public boolean delete(BookingDTO booking)
    {boolean insertOk = false;
        try{
         Connection conn = connection.getConnect();
         System.out.println("Connecting Booking");
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM BOOKINGS WHERE BookingId = ?");
         stmt.setInt(1, booking.getBookingId());
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
 
    @GET
    @Path("findBookingByID/{bookingId}")
    @Produces(
            {
                 MediaType.APPLICATION_JSON
            })
    public BookingDTO find(@PathParam("bookingId") int bookingID)
    {
        BookingDTO booking = null;
        try
        {
        Connection conn = connection.getConnect();
        PreparedStatement stmt = conn.prepareStatement("SELECT Bookings.BookingId, Users.Username,Films.FilmId, Films.FilmName,Cinemas.CinemaId, Cinemas.CinemaName, Cinemas.Address, Screens.ScreenId, Showings.ShowingId, Showings.ShowingTime"
                 + " FROM BOOKINGS JOIN Users on Bookings.Username = Users.Username"
                 +                " JOIN Showings on Bookings.ShowingId = Showings.ShowingId"
                 +                " JOIN Films on Films.FilmId = Showings.FilmId"
                 +                " JOIN Screens on Showings.ScreenId = Screens.ScreenId"
                 +                " JOIN Cinemas on Screens.CinemaId = Cinemas.CinemaId"
                 + " WHERE BookingId = ?"); 
         stmt.setInt(1, bookingID);
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             
             UserDTO user = new UserDTO(rs.getString("Username"),"", "", "","", "","","", false);
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
    

    @POST
    @Path("findAllBookingUsername")
    @Consumes(
            {
                MediaType.APPLICATION_JSON
            })
    @Produces(
            {
                 MediaType.APPLICATION_JSON
            })
    public ArrayList<BookingDTO> findAll(UserDTO User){
     
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
         stmt.setString(1, User.getUsername());
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             
             UserDTO user = new UserDTO(rs.getString("Username"),"", "", "","", "","","", false);
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
    
}
