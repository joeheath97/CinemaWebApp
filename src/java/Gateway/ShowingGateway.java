/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;


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
         
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Showings"); // statement which gets everything in showing tabel
         ResultSet rs = stmt.executeQuery();
         while (rs.next())
         {
             ShowingDTO showing = new ShowingDTO(        // this create a ShowingDTO called "showing" 
                     rs.getInt("ShowingID"),
                     rs.getInt("FilmID"),
                     rs.getString("ScreenId"),
                     rs.getString("ShowingTime"));
                     showingList.add(showing);                // adds the ShowingDTO to the arrayList
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
       
    public ShowingDTO findByID(int ShowingID){
        ShowingDTO showing = null;
        try
        {
        Connection conn = connection.getConnect();
        System.out.println("finding by ID");
        String sqlStr = ("SELECT * FROM Showings WHERE ShowingID = ?"); 
        PreparedStatement stmt = conn.prepareStatement(sqlStr);
        stmt.setInt(1, ShowingID);
        ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
             showing = new ShowingDTO(
                     rs.getInt("ShowingID"),
                     rs.getInt("FilmID"),
                     rs.getString("ScreenID"),
                     rs.getString("ShowingTime"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        return showing;
    }
    
    public ArrayList<ShowingDTO> findAllBySearched(int filmID){
     Connection conn = connection.getConnect();
     System.out.println("Connecting all by searched");
     ArrayList<ShowingDTO> SearchedShowingList = new ArrayList<>();
     
     try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Showings WHERE FilmID = ?");
         stmt.setInt(1, filmID);
         ResultSet rs = stmt.executeQuery();
         while (rs.next())
         {
             ShowingDTO showing = new ShowingDTO(         
                     rs.getInt("ShowingID"),
                     rs.getInt("FilmID"),
                     rs.getString("ScreenId"),
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
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO SHOWINGS (FilmID, ScreenID, ShowingTime) values (?,?,?)");
        
         stmt.setInt(1, showing.getFilmID());
         stmt.setString(2, showing.getScreenID());
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
        PreparedStatement stmt = conn.prepareStatement("UPDATE SHOWINGS SET FILMID = ?, SCREENID = ?, SHOWINGTIME = ? WHERE SHOWINGID=? ");
                 
         stmt.setInt(1, showing.getFilmID());
         stmt.setString(2, showing.getScreenID());
         stmt.setString(3, showing.getShowingTime());
         stmt.setInt(4,showing.getShowingID());
         int row = stmt.executeUpdate();
         updateOk = row == 1;
         
         stmt.close();
         conn.close(); 
         System.out.println("updated showing successfully: " + showing.getShowingID());
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
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM showings WHERE ShowingID = ?");
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
