/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.FilmDTO;
import DTO.ScreenDTO;
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
public class ScreenGateway {
    
        DBManager connection = new DBManager();
            
        
    public ArrayList<ScreenDTO> findAll(){
     Connection conn = connection.getConnect();
     System.out.println("Connecting Screen");
     ArrayList<ScreenDTO> ScreenList = new ArrayList<>();
     try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Screens"); // statement which gets everything in Screen tabel
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             ScreenDTO Screen = new ScreenDTO(        // this create a ScreenDTO called "film" 
                     rs.getString("ScreenId"),
                     rs.getInt("CinemaID"));
                     ScreenList.add(Screen);                // adds the ScreenDTO to the arrayList
         }
         rs.close();
         stmt.close();
         conn.close();
     }
     catch(SQLException sqle)
     {
         System.out.println(sqle);
     }
     return ScreenList; // passes the arrayList back to the ScreenManager 
    }
    
    public ScreenDTO findByScreenID(String ScreenID){ 
        System.out.println("beginning screen find");
        ScreenDTO screen = null;
        try
        {
        Connection conn = connection.getConnect();
        System.out.println("Connecting Screen");
        String sqlStr = ("SELECT * FROM Screens WHERE ScreenID = ?"); 
        PreparedStatement stmt = conn.prepareStatement(sqlStr);
        stmt.setString(1, ScreenID);
        ResultSet rs = stmt.executeQuery();
            System.out.println("constructing DTO");
            while (rs.next())
            {
               
             screen = new ScreenDTO(
                     rs.getString("ScreenID"),
                     rs.getInt("CinemaID"));
            }
            System.out.println("complete.");
        }
        
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        return screen;
    }
    
    public boolean insert(String ScreenID, int CinemaID){ // not needed
        return true;
    }

    
}
