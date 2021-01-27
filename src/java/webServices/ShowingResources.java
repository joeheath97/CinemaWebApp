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
@Path("myPath")
public class ShowingResources
{
    
    

    
    @Context
    private UriInfo context;
    private DBManager connection = new DBManager();

    @GET
    @Path("findAllShowings")
    @Produces(
            {
                 MediaType.APPLICATION_JSON
            })
    public ArrayList<ShowingDTO> findAll()
    {
    Connection conn = connection.getConnect();
     System.out.println("finding all");
     ArrayList<ShowingDTO> showingList = new ArrayList<>();
     
     try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT Showings.ShowingId, Films.filmId, Films.FilmName,"
                 + "Screens.ScreenId,Showings.ShowingTime,Cinemas.CinemaId, Cinemas.CinemaName, Cinemas.Address"
                 + " FROM Showings JOIN Films on Showings.FilmId = Films.FilmId"
                 +               " JOIN Screens on Showings.ScreenId = Screens.ScreenId"
                 +               " JOIN Cinemas on Screens.CinemaId = Cinemas.CinemaId"); // statement which gets everything in showing tabel
         ResultSet rs = stmt.executeQuery();
         while (rs.next())
         {
             FilmDTO film = new FilmDTO(rs.getInt("FilmId"),rs.getString("FilmName"), "", "");
             CinemaDTO cinema = new CinemaDTO(rs.getInt("CinemaId"), rs.getString("CinemaName"), rs.getString("Address"));
             ScreenDTO Screen = new ScreenDTO(rs.getString("ScreenId"), cinema);
             ShowingDTO showing = new ShowingDTO (rs.getInt("ShowingId"), film,Screen,rs.getString("ShowingTime"));
             System.out.println(showing);
                     showingList.add(showing);               
                     
         }
         rs.close();
         stmt.close();
         conn.close();
         return showingList;
     }
     catch(SQLException sqle)
     {
         System.out.println(sqle);
         return null;
     }
     
     }
}
    
