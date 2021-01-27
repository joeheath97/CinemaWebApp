/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joe Heath
 */
public class ShowingDTOTest {
    
    public ShowingDTOTest() {
    }

    @Test
    public void testGetShowingID() {
        System.out.println("getShowingID");
        ShowingDTO instance = new ShowingDTO(1,null,null,"");
        int expResults = 1;
        int results = instance.getShowingId();
        assertEquals(expResults, results);
    }

    @Test
    public void testGetFilm() {
        System.out.println("getFilm");
        ShowingDTO instance = new ShowingDTO(1,new FilmDTO(1,"","",""),null,"");
        int expResults = 1;
        int results = instance.getFilm().getFilmId();
        assertEquals(expResults, results);
    }

    @Test
    public void testGetScreen() {
        System.out.println("getScreen");
        ShowingDTO instance = new ShowingDTO(1,null,new ScreenDTO("C1-S1",null),"");
        String expResults = "C1-S1";
        String results = instance.getScreen().getScreenId();
        assertEquals(expResults, results);
    }

    @Test
    public void testGetShowingTime() {
        System.out.println("getShowingTime");
        ShowingDTO instance = new ShowingDTO(1,null,null,"17:00");
        String expResults = "17:00";
        String results = instance.getShowingTime();
        assertEquals(expResults, results);
    }
    
}
