
package Manager;

import DTO.FilmDTO;
import Gateway.FilmGateway;
import java.util.*;

public class FilmManager {
        private ArrayList<FilmDTO> FilmList = new ArrayList<>();
    private FilmGateway gateway = new FilmGateway();

    
    public ArrayList<FilmDTO> getAllFilms(){
        return gateway.findAll();
    }
    
    public boolean addFilm(FilmDTO film){
        return gateway.insert(film);
    }
    
    public FilmDTO findFilm(int filmID){
        return gateway.findByID(filmID);
    }
    
    public boolean removeFilm(int FilmID){
        return gateway.delete(FilmID);
    }
    
}
