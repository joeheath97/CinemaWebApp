/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.FilmDTO;
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
public class FilmGateway {
    DBManager connection = new DBManager();
        
    public ArrayList<FilmDTO> findAll(){
     Connection conn = connection.getConnect();
     System.out.println("Connecting Film");
     ArrayList<FilmDTO> filmList = new ArrayList<>();
     try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Films"); // statement which gets everything in Film tabel
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             FilmDTO film = new FilmDTO(        // this create a FilmDTO called "film" 
                     rs.getInt("FilmId"),
                     rs.getString("FilmName"),
                     rs.getString("LeadActor"),
                     rs.getString("Duration"));
                     filmList.add(film);                // adds the FilmDTO to the arrayList
         }
         rs.close();
         stmt.close();
         conn.close();
     }
     catch(SQLException sqle)
     {
         System.out.println(sqle);
     }
     return filmList; // passes the arrayList back to the FilmManager 
    }
    
    public FilmDTO findByID(int FilmID){
        FilmDTO film = null;
        try
        {
        Connection conn = connection.getConnect();
        System.out.println("Connecting Film");
        String sqlStr = ("SELECT * FROM Films WHERE FilmID = ?"); 
        PreparedStatement stmt = conn.prepareStatement(sqlStr);
        stmt.setInt(1, FilmID);
        ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
             film = new FilmDTO(
                     rs.getInt("FilmID"),
                     rs.getString("FilmName"),
                     rs.getString("LeadActor"),
                     rs.getString("Duration"));
            }
        }
        catch (SQLException sqle)
        {
        }
        return film;
    }
    
    public boolean insert(FilmDTO film){
        boolean insertOk = false;
        try 
        {
         Connection conn = connection.getConnect();
         System.out.println("Connecting Film");
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Films (FilmName, LeadActor, Duration) values (?,?,?)");
        
         stmt.setString(1, film.getFilmName());
         stmt.setString(2, film.getLeadActor());
         stmt.setString(3, film.getDuration());
         
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

    
    public boolean delete(int FilmId){
        try{
         Connection conn = connection.getConnect();
         System.out.println("Connecting Film");
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM showings WHERE FilmID = ?");
         stmt.setInt(1,FilmId);
         int row = stmt.executeUpdate();
         stmt = conn.prepareStatement("DELETE FROM films WHERE filmID = ?");
         stmt.setInt(1,FilmId);
         row = stmt.executeUpdate();
         
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
