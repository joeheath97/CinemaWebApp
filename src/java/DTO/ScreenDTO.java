
package DTO;

public class ScreenDTO {
    
    private String SscreenId;
    private int cinemaId;

    public ScreenDTO(String SscreenId, int cinemaId) {
        this.SscreenId = SscreenId;
        this.cinemaId = cinemaId;
    }

    public String getScreenID() {
        return SscreenId;
    }

    public int getCinemaID() {
        return cinemaId;
    }




    
}
