/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import dbase.DBManager;
import DTO.UserDTO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserGateway {
    
        private DBManager connection = new DBManager();
          // this creates connection to the database called "conn"
    
    
    public ArrayList<UserDTO> findAll(){
     Connection conn = connection.getConnect();
     ArrayList<UserDTO> userList = new ArrayList<>(); // creates an arraylist Of "userDTO"
     
     try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users"); // statement which gets everything in User tabel
         ResultSet rs = stmt.executeQuery();
         System.out.println("making DTO");
         while (rs.next())
         {
             UserDTO user = new UserDTO(        // this create a UserDTO called "user" 
                     rs.getString("Username"),
                     rs.getString("Password"),
                     rs.getString("AddressLine1"),
                     rs.getString("AddressLine2"),
                     rs.getString("Town"),
                     rs.getString("County"),
                     rs.getString("Postcode"),
                     rs.getString("DOB"),
                     rs.getBoolean("isAdmin"));
                     userList.add(user);                // adds the UserDTO to the arrayList
         }
         rs.close();
         stmt.close();
         conn.close();
     }
     catch(SQLException sqle)
     {
         System.out.println(sqle);
     }
     return userList; // passes the arrayList back to the UseraManager 
    }
    
    public UserDTO find(String Username, String Password){
        UserDTO user = null;    // set USerDTO to null so if perameters aren't found returns null
        String HashPass;
        
             try {
                 byte[] hash = MessageDigest.getInstance("SHA-256")
                         .digest(Password.getBytes(StandardCharsets.UTF_8));
                 HashPass = Base64.getEncoder().encodeToString(hash);
             } catch (NoSuchAlgorithmException ex) {
                 return null;
             }

        try{
        
        System.out.println("Getting user");
        Connection conn = connection.getConnect();
        String sqlStr = ("SELECT * FROM Users WHERE Username = ? AND Password = ?"); 
        PreparedStatement stmt = conn.prepareStatement(sqlStr);
        stmt.setString(1, Username);
        stmt.setString(2, HashPass);
        ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
             user = new UserDTO(
                     rs.getString("Username"),
                     rs.getString("Password"),
                     rs.getString("AddressLine1"),
                     rs.getString("AddressLine2"),
                     rs.getString("Town"),
                     rs.getString("County"),
                     rs.getString("Postcode"),
                     rs.getString("DOB"),
                     rs.getBoolean("isAdmin"));
            }
        }
        catch (SQLException sqle)
        {
        }
        return user;
    }
    
        public UserDTO find(String Username){
        UserDTO user = null;   
        try{
        
        System.out.println("Getting user");
        Connection conn = connection.getConnect();
        String sqlStr = ("SELECT * FROM Users WHERE UserName = ? "); 
        PreparedStatement stmt = conn.prepareStatement(sqlStr);
        stmt.setString(1, Username);
        ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
             user = new UserDTO(
                     rs.getString("UserName"),
                     rs.getString("Password"),
                     rs.getString("AddressLine1"),
                     rs.getString("AddressLine2"),
                     rs.getString("Town"),
                     rs.getString("County"),
                     rs.getString("Postcode"),
                     rs.getString("DOB"),
                     rs.getBoolean("isAdmin"));
            }
        }
        catch (SQLException sqle)
        {
        }
        return user;
    }
    
    public boolean insert(UserDTO user)
    {
        String HashPass;
        
        try {
                 byte[] hash = MessageDigest.getInstance("SHA-256")
                         .digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
                 HashPass = Base64.getEncoder().encodeToString(hash);
             } catch (NoSuchAlgorithmException ex) {
                 return false;
             }
        
        System.out.println("inserting");
        boolean insertOk = false;
        try 
        {
         Connection conn = connection.getConnect();
         
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (UserName, Password, AddressLine1, AddressLine2, Town, County, Postcode,DOB, isAdmin) values (?,?,?,?,?,?,?,?,?)");
        
         stmt.setString(1, user.getUsername());
         stmt.setString(2, HashPass);
         stmt.setString(3, user.getAddressLine1());
         stmt.setString(4, user.getAddressLine2());
         stmt.setString(5, user.getTown());
         stmt.setString(6, user.getCounty());
         stmt.setString(7, user.getPostCode());
         stmt.setString(8, user.getDateOfBirth());
         stmt.setBoolean(9, user.isIsAdmin());
         
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

}
