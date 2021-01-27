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
public class ScreenDTOTest {
    
    public ScreenDTOTest() {
    }

    @Test
    public void testGetScreenID() {
        System.out.println("getScreen");
        ScreenDTO instance = new ScreenDTO("C1-S1",null);
        String expResults = "C1-S1";
        String results = instance.getScreenId();
        assertEquals(expResults, results);
    }

    @Test
    public void testGetCinema() {
        System.out.println("getCinema");
        ScreenDTO instance = new ScreenDTO("",new CinemaDTO(1,"",""));
        int expResults = 1;
        int results = instance.getCinema().getCinemaId();
        assertEquals(expResults, results);
    }
    
}
