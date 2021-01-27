/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;


import DTO.CinemaDTO;
import DTO.FilmDTO;
import DTO.ScreenDTO;
import DTO.ShowingDTO;
import dbase.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Joe Heath
 */
public class ShowingGateway {
    
    private DBManager connection = new DBManager();
        
    public ArrayList<ShowingDTO> findAll(){
     Connection conn = connection.getConnect();
     System.out.println("finding all");
     ArrayList<ShowingDTO> showingList = new ArrayList<>();
     
     try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT Showings.ShowingId, Films.filmId, Films.FilmName,Screens.ScreenId,Showings.ShowingTime,Cinemas.CinemaId, Cinemas.CinemaName, Cinemas.Address"
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
                     showingList.add(showing);               
                     
         }
         rs.close();
         stmt.close();
         conn.close();
     }
     catch(SQLException sqle)
     {
         System.out.println(sqle);
     }
     return showingList;
    }
       
    public ShowingDTO findByID(int ShowingId){
        ShowingDTO showing = null;
        try
        {
        Connection conn = connection.getConnect();
        PreparedStatement stmt = conn.prepareStatement("SELECT Showings.ShowingId, Films.filmId, Films.FilmName, Films.Duration,Screens.ScreenId,Showings.ShowingTime,Cinemas.CinemaId, Cinemas.CinemaName, Cinemas.Address"
                 + " FROM Showings JOIN Films on Showings.FilmId = Films.FilmId"
                 +               " JOIN Screens on Showings.ScreenId = Screens.ScreenId"
                 +               " JOIN Cinemas on Screens.CinemaId = Cinemas.CinemaId"
                 + " WHERE Showings.ShowingId = ?"); 
        stmt.setInt(1, ShowingId);
         ResultSet rs = stmt.executeQuery();
         while (rs.next())
         {
             FilmDTO film = new FilmDTO(rs.getInt("FilmId"),rs.getString("FilmName"), "", rs.getString("Duration"));
             CinemaDTO cinema = new CinemaDTO(rs.getInt("CinemaId"), rs.getString("CinemaName"), rs.getString("Address"));
             ScreenDTO Screen = new ScreenDTO(rs.getString("ScreenId"), cinema);
             showing = new ShowingDTO (       
                     rs.getInt("ShowingId"),
                     film,
                     Screen,
                     rs.getString("ShowingTime"));               
                     
         }
         rs.close();
         stmt.close();
         conn.close();
     }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        return showing;
    }
    
    public ArrayList<ShowingDTO> findAllBySearched(int filmId){
     Connection conn = connection.getConnect();
     ArrayList<ShowingDTO> SearchedShowingList = new ArrayList<>();
     
     try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT Films.FilmId, Films.FilmName, Cinemas.CinemaId, Cinemas.CinemaName, Cinemas.Address, Screens.ScreenId, Showings.ShowingId, Showings.ShowingTime"
                 + " FROM Showings JOIN Films on Showings.FilmId = Films.FilmId"
                 +               " JOIN Screens on Showings.ScreenId = Screens.ScreenId"
                 +               " JOIN Cinemas on Screens.CinemaId = Cinemas.CinemaId"
                 + " WHERE Showings.FilmId = ?");
         stmt.setInt(1, filmId);
         ResultSet rs = stmt.executeQuery();
         while (rs.next())
         {
             FilmDTO film = new FilmDTO(rs.getInt("FilmID"),rs.getString("FilmName"), "", "");
             CinemaDTO cinema = new CinemaDTO(rs.getInt("CinemaID"), rs.getString("CinemaName"), rs.getString("Address"));
             ScreenDTO screen = new ScreenDTO(rs.getString("ScreenID"), cinema);
             ShowingDTO showing = new ShowingDTO(         
                     rs.getInt("ShowingID"),
                     film,
                     screen,
                     rs.getString("ShowingTime"));
                     SearchedShowingList.add(showing);               
         }
         rs.close();
         stmt.close();
         conn.close();
     }
     catch(SQLException sqle)
     {
         System.out.println(sqle);
     }
     return SearchedShowingList;
    }
    
    public boolean insert(ShowingDTO showing){
        boolean insertOk = false;
        try 
        {  
         Connection conn = connection.getConnect();
         System.out.println("inserting");
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO SHOWINGS (FilmId, ScreenId, ShowingTime) values (?,?,?)");
        
         stmt.setInt(1, showing.getFilm().getFilmId());
         stmt.setString(2, showing.getScreen().getScreenId());
         stmt.setString(3, showing.getShowingTime());
         
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
    
    public boolean update(ShowingDTO showing){
        boolean updateOk = false;
    try{
        Connection conn = connection.getConnect();
        System.out.println("updating showing");
        PreparedStatement stmt = conn.prepareStatement("UPDATE SHOWINGS SET FilmId = ?, ScreenId = ?, ShowingTime = ? WHERE ShowingId=? ");
                 
         stmt.setInt(1, showing.getFilm().getFilmId());
         stmt.setString(2, showing.getScreen().getScreenId());
         stmt.setString(3, showing.getShowingTime());
         stmt.setInt(4,showing.getShowingId());
         int row = stmt.executeUpdate();
         updateOk = row == 1;
         
         stmt.close();
         conn.close(); 
         
    }
            
    catch (SQLException sqle)
    {
       System.out.println(sqle);
    }
    return updateOk;
    
    
    
    }
    
    public boolean delete(int ShowingId){
        try{
         Connection conn = connection.getConnect();
         System.out.println("Connecting Showing");
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM showings WHERE ShowingId = ?");
         stmt.setInt(1,ShowingId);
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
