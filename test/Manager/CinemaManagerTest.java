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
public class CinemaManagerTest {
    
    public CinemaManagerTest() {
    }

    @Test
    public void testGetAllCinema() {
        System.out.println("GetAllCinema");
        CinemaManager instance = new CinemaManager();
        assertTrue(!instance.getAllCinema().isEmpty());
    }

    @Test
    public void testFindCinemaByID() {
        System.out.println("GetCinema");
        CinemaManager instance = new CinemaManager();
        int expResults = 1;
        int results = instance.findCinemaByID(1).getCinemaId(); 
        assertEquals(expResults, results);
    }
    
}
