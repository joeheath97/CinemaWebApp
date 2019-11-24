
package DTO;

public class ShowingDTO {
    
    private int showingId;
    private int filmId;
    private String screenId;
    private String showingTime;

    public ShowingDTO(int showingId, int filmId, String screenId, String showingTime) {
        this.showingId = showingId;
        this.filmId = filmId;
        this.screenId = screenId;
        this.showingTime = showingTime;
    }

    public int getShowingID() {
        return showingId;
    }

    public int getFilmID() {
        return filmId;
    }

    public String getScreenID() {
        return screenId;
    }

    public String getShowingTime() {
        return showingTime;
    }

    
    
    


    
}
