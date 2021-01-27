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
public class ScreenManagerTest {
    
    public ScreenManagerTest() {
    }

    @Test
    public void testGetAllScreens() {
        System.out.println("GetAllScreen");
        ScreenManager instance = new ScreenManager();
        assertTrue(!instance.getAllScreens().isEmpty());
    }

//    @Test
//    public void testFind() {
//        System.out.println("GetScreen");
//        ScreenManager instance = new ScreenManager();
//        String expResults = "C1-S1";
//        String results = instance.find("C1-S1").getScreenID(); 
//        System.out.println(results);
//        assertEquals(expResults, results);
//    }
    
}
