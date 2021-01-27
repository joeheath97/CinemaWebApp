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
public class BookingDTOTest {
    
    public BookingDTOTest() {
    }

    @Test
    public void testGetBookingID() {
        System.out.println("getID");
        BookingDTO instance = new BookingDTO(1,null,null);
        int expResults = 1;
        int results = instance.getBookingId();
        assertEquals(expResults, results);
    }

    @Test
    public void testGetUser() {
        System.out.println("getUser");
        BookingDTO instance = new BookingDTO(1,new UserDTO("TestUsername","","","","","","",null,false),null);
        String expResults = "TestUsername";
        String results = instance.getUser().getUsername();
        assertEquals(expResults, results);
    }

    @Test
    public void testGetShowing() {
        System.out.println("getShowing");
        BookingDTO instance = new BookingDTO(1,null, new ShowingDTO(1,null,null,""));
        int expResults = 1;
        int results = instance.getShowing().getShowingId();
        assertEquals(expResults, results);
    }
    
}
