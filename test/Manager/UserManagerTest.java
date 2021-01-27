/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joe Heath
 */
public class UserManagerTest {
    
    public UserManagerTest() {
    }

    @Test
    public void testGetAllUser() {
        System.out.println("GetAllUser");
        UserManager instance = new UserManager();
        assertTrue(!instance.getAllUser().isEmpty());
    }

    @Test
    public void testGetUser() {
    }

    @Test
    public void testAddUser() {
    }

    @Test
    public void testLogin() {
    }
    
}
