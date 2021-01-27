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
public class BookingManagerTest {
    
    public BookingManagerTest() {
    }



//    @Test
//    public void testGetBooking() {   
//        System.out.println("GetBooking");
//        BookingManager instance = new BookingManager();
//        int expResults = 5;
//        int results = instance.getBooking(5).getBookingID(); 
//        assertEquals(expResults, results);
//    }

    @Test
    public void testGetAllBookings() {
        System.out.println("GetAllCinema");
        CinemaManager instance = new CinemaManager();
        assertTrue(!instance.getAllCinema().isEmpty());
    }
    
}
