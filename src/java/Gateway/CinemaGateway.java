/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.CinemaDTO;
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
public class CinemaGateway {
    DBManager connection = new DBManager();
        
    public ArrayList<CinemaDTO> findAll()
            {
     Connection conn = connection.getConnect();
     System.out.println("Connecting Cinema");
     ArrayList<CinemaDTO> ScreenList = new ArrayList<>();
     try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Cinemas"); // statement which gets everything in Screen tabel
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             CinemaDTO Cinema = new CinemaDTO(        // this create a ScreenDTO called "film" 
                     rs.getInt("CinemaID"),
                     rs.getString("CinemaName"),
                     rs.getString("CinemaAddress"));
                     ScreenList.add(Cinema);                // adds the ScreenDTO to the arrayList
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
    
        
    public CinemaDTO findByID(int CinemaID){
        System.out.println("beginning cinema find");
        CinemaDTO Cinema = null;
        try
        {
        Connection conn = connection.getConnect();
        System.out.println("Connecting Cinema");
        String sqlStr = ("SELECT * FROM Cinemas WHERE CinemaID = ?"); 
        PreparedStatement stmt = conn.prepareStatement(sqlStr);
        stmt.setInt(1, CinemaID);
        ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
             Cinema = new CinemaDTO(
                     rs.getInt("CinemaID"),
                     rs.getString("CinemaName"),
                     rs.getString("Address"));
            }
            System.out.println("cinema DTO constructed");
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return Cinema;
    }
    
    
}
