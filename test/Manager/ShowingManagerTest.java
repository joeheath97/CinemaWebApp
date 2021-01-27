/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.CinemaDTO;
import DTO.FilmDTO;
import DTO.ScreenDTO;
import DTO.ShowingDTO;
import javax.enterprise.inject.Instance;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joe Heath
 */
public class ShowingManagerTest {
    
    public ShowingManagerTest() {
    }

    @Test
    public void testGetAllShowings() {
        System.out.println("GetAllShowing");
        ShowingManager instance = new ShowingManager();
        assertTrue(!instance.getAllShowings().isEmpty());
    }

    @Test
    public void testGetShowing() {
        System.out.println("GetShowing");
        ShowingManager instance = new ShowingManager();
        int expResults = 1;
        int results = instance.getShowing(1).getShowingId(); 
        assertEquals(expResults, results);
       
    }

    @Test
    public void testSearchShowing() {   
        System.out.println("GetSearched");
        ShowingManager instance = new ShowingManager();
        assertTrue(!instance.searchShowing(1).isEmpty());
    }
// uncomment when what to test!!!
//    @Test
//    public void testAddShowing() {
//        System.out.println("AddShowing");
//        ShowingManager instance = new ShowingManager();
//        ShowingDTO showing = new ShowingDTO(10,new FilmDTO(1,"","",""),new ScreenDTO("Test",new CinemaDTO(0, "", "")), "24:00");
//        boolean result = instance.addShowing(showing);
//        assertTrue(result);
//    }

    
}
