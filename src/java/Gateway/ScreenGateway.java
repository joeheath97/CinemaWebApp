/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.CinemaDTO;
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
         
         String sqlStr = "SELECT Screens.ScreenId, Cinemas.CinemaId, Cinemas.CinemaName, Cinemas.Address"
                 + " FROM Screens JOIN Cinemas on Screens.CinemaId = Cinemas.CinemaId"; 
         PreparedStatement stmt = conn.prepareStatement(sqlStr); 
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             CinemaDTO cinema = new CinemaDTO(rs.getInt("CinemaId"), rs.getString("CinemaName"), rs.getString("Address"));
             ScreenDTO Screen = new ScreenDTO(         
                     rs.getString("ScreenId"),
                     cinema);
                     ScreenList.add(Screen);                
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
    
//    public ScreenDTO find(String ScreenID){ 
//        System.out.println("beginning screen find");
//        ScreenDTO Screen = null;
//        try
//        {
//           
//        Connection conn = connection.getConnect();
//        String sqlStr = "SELECT Screens.ScreenID, Cinemas.CinemaID, Cinemas.CinemaName, Cinemas.Address"
//                 + " FROM Screens JOIN Cinemas on Screens.CinemaID = Cinemas.CinemaID"
//                + "WHERE Screens.ScreenID =?"; 
//         PreparedStatement stmt = conn.prepareStatement(sqlStr); 
//         stmt.setString(1,ScreenID);
//         ResultSet rs = stmt.executeQuery();
//         System.out.println("making DTO");
//         while (rs.next())
//         {
//             CinemaDTO cinema = new CinemaDTO(rs.getInt("CinemaID"), rs.getString("CinemaName"), rs.getString("Address"));
//             Screen = new ScreenDTO(         
//                     rs.getString("ScreenID"),
//                     cinema);
//  
//        }
//        }
//        catch (SQLException sqle)
//        {
//            System.out.println(sqle);
//            sqle.printStackTrace();
//        }
//        
//        return Screen;
//    }

    
}
