
package dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
    
    public Connection getConnect(){
        
        try{
        
        DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
        return DriverManager.getConnection("jdbc:derby://localhost:1527/CinemaDataBase","app","app");
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
            return null;
        }
        
    } 
    
}
