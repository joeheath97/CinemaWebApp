
package DTO;

public class BookingDTO {
    
    private int bookingId;
    private String username;
    private int showingId;

    public BookingDTO(int bookingId, String username, int showingId) {
        this.bookingId = bookingId;
        this.username = username;
        this.showingId = showingId;
    }

    public int getBookingID() {
        return bookingId;
    }

    public String getUserName() {
        return username;
    }

    public int getShowingID() {
        return showingId;
    }






    
}
