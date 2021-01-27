/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.BookingDTO;
import Gateway.BookingGateway;
import java.util.*;

/**
 *
 * @author Joe Heath
 */
public class BookingManager {
    
    private ArrayList<BookingDTO> BookingList = new ArrayList<>();
    private BookingGateway gateway = new BookingGateway();
    
    public boolean makeBooking(BookingDTO booking){
        return gateway.insert(booking);
        
    }
    public BookingDTO getBooking(int BookingId){
        return gateway.findById(BookingId);
    }
    public boolean cancelBooking(int BookingId){
        return gateway.delete(BookingId);
    }
    
    public ArrayList<BookingDTO> getAllBookings(String Username){
        return gateway.findAll(Username);
    }
}
