/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import DTO.UserDTO;
import dbase.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author h016195h
 */
@Path("myPath")
public class UserResources

{

    @Context
    private UriInfo context;
    private DBManager connection = new DBManager();

    /**
     * Creates a new instance of SampleFacade
     */
    public UserResources()
    {
    }

    
    @POST
    @Path("register")
    @Consumes(
            {
                MediaType.APPLICATION_JSON
            })
    @Produces(
            {
                MediaType.APPLICATION_JSON
            })
    public UserDTO create(UserDTO user)
    { 
        try 
        {
         Connection conn = connection.getConnect();
         
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (Username, Password, AddressLine1, AddressLine2, "
                                                          + "Town, County, Postcode,DOB, isAdmin) values (?,?,?,?,?,?,?,?,?)");
        
         stmt.setString(1, user.getUsername());
         stmt.setString(2, user.getPassword());
         stmt.setString(3, user.getAddressLine1());
         stmt.setString(4, user.getAddressLine2());
         stmt.setString(5, user.getTown());
         stmt.setString(6, user.getCounty());
         stmt.setString(7, user.getPostCode());
         stmt.setString(8, user.getDateOfBirth());
         stmt.setBoolean(9, user.isIsAdmin()); 
         int row = stmt.executeUpdate();

         stmt.close();
         conn.close();
         
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return user;
    }

    @POST
    @Path("update")
    @Consumes(
            {
                MediaType.APPLICATION_JSON
            })
    @Produces(
            {
                MediaType.APPLICATION_JSON
            })
    public UserDTO update(UserDTO user){
      try{
          
          
            Connection conn = connection.getConnect();
            PreparedStatement stmt = conn.prepareStatement("UPDATE USERS SET AddressLine1 = ?, AddressLine2 = ?,"
                                                            + "TOWN = ? , COUNTY= ?, POSTCODE = ? WHERE username = ?");
            
            stmt.setString(1, user.getAddressLine1());
            stmt.setString(2, user.getAddressLine2());
            stmt.setString(3, user.getTown());
            stmt.setString(4, user.getCounty());
            stmt.setString(5, user.getPostCode());
            stmt.setString(6, user.getUsername());
            int rows = stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
                    
       }catch(SQLException SQLE){
            System.out.println(SQLE);
       }    
       return user;
    }

    
    @GET
    @Path("{username}")
    @Produces(
            {
                 MediaType.APPLICATION_JSON
            })
    public UserDTO find(@PathParam("username") String username)
    {
 
        UserDTO user = null;   
        try{
        
        Connection conn = connection.getConnect();
        String sqlStr = ("SELECT * FROM Users WHERE Username = ? "); 
        PreparedStatement stmt = conn.prepareStatement(sqlStr);
        stmt.setString(1, username);
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
    
    @POST
    @Path("/validate")
    @Consumes(
            {
                MediaType.APPLICATION_JSON
            })
    @Produces(
            {
                MediaType.APPLICATION_JSON
            })
    public UserDTO login(UserDTO user)
    {      
        System.out.println("Attempting login");
        UserDTO userdetails = null;
        try{
        
        Connection conn = connection.getConnect();
        String sqlStr = ("SELECT * FROM Users WHERE Username = ? AND Password = ?");
        System.out.println("username: " + user.getUsername());
        PreparedStatement stmt = conn.prepareStatement(sqlStr);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                
             userdetails = new UserDTO(
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
                System.out.println(sqle);
        }
        System.out.println(userdetails.getUsername());
        return userdetails;
    }
    

    @GET
    @Path("findAllUsers")
    @Produces(
            {
                 MediaType.APPLICATION_JSON
            })
    public ArrayList<UserDTO> findAll()
    {
      Connection conn = connection.getConnect();
     ArrayList<UserDTO> userList = new ArrayList<>(); // creates an arraylist Of "userDTO"
     
     try
     {
         
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users"); // statement which gets everything in User tabel
         ResultSet rs = stmt.executeQuery();
         while (rs.next())
         {
             UserDTO user = new UserDTO(        // this create a UserDTO called "user" 
                     rs.getString("UserName"),
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
     return userList;
    }

    

}


