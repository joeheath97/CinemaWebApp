/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.BookingDTO;
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
    DBManager connection = new DBManager();
    
        
    public ArrayList<BookingDTO> findAll(String UserName){
     
        Connection conn = connection.getConnect();
        System.out.println("Connecting Booking");
     ArrayList<BookingDTO> bookingList = new ArrayList<>();
          try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM BOOKINGS WHERE UserName = ?"); 
         stmt.setString(1, UserName);
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             BookingDTO booking = new BookingDTO(         
                     rs.getInt("BookingId"),
                     rs.getString("UserName"),
                     rs.getInt("ShowingID"));
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
     return bookingList; // passes the arrayList back to the FilmManager 
    }

    
    public BookingDTO findByID(int BookingID)
    {
        BookingDTO booking = null;
        try
        {
        Connection conn = connection.getConnect();
        System.out.println("Connecting Booking");
        String sqlStr = ("SELECT * FROM BOOKINGS WHERE BookingID = ?"); 
        PreparedStatement stmt = conn.prepareStatement(sqlStr);
        stmt.setInt(1, BookingID);
        ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
             booking = new BookingDTO(
                     rs.getInt("BookingID"),
                     rs.getString("UserName"),
                     rs.getInt("ShowingId"));
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
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO BOOKINGS (UserName, ShowingID) values (?,?)");
        
         
         stmt.setString(1, booking.getUserName());
         stmt.setInt(2, booking.getShowingID());
         
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
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM BOOKINGS WHERE BookingID = ?");
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
