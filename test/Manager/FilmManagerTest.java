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
public class FilmManagerTest {
    
    public FilmManagerTest() {
    }

    @Test
    public void testGetAllFilms() {
        System.out.println("GetAllShowing");
        FilmManager instance = new FilmManager();
        assertTrue(!instance.getAllFilms().isEmpty());
    }

    @Test
    public void testFindFilm() {
        System.out.println("GetShowing");
        FilmManager instance = new FilmManager();
        int expResults = 1;
        int results = instance.findFilm(1).getFilmId(); 
        assertEquals(expResults, results);
    }

    
}
