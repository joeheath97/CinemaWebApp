
package DTO;

public class FilmDTO {
    
    private int filmId;
    private String filmName;
    private String leadActor;
    private String duration; 

    public FilmDTO(int filmId, String filmName, String leadActor, String duration) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.leadActor = leadActor;
        this.duration = duration;
    }

    public int getFilmID() {
        return filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public String getDuration() {
        return duration;
    }
    
}
