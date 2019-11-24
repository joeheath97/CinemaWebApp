/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.FilmDTO;import UI.AdminUI;
import java.io.Serializable;
;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Joe Heath
 */
@Named(value = "filmBean")
@SessionScoped
public class FilmBean implements Serializable{
    

    private AdminUI adminUI = new AdminUI();
    private FilmDTO FilmDetails = null;
    public FilmBean() {
    }
    
    public void setFilmDetails(FilmDTO FilmDetails)
    {
        this.FilmDetails = FilmDetails;
    }
    
    public FilmDTO getFilmDetails()
    {
        return FilmDetails;
    }
    
    public String findFilm(int filmID)
    {
        FilmDetails = adminUI.getFilm(filmID);
        return FilmDetails.getFilmName();
    }

    public ArrayList<FilmDTO> getAllFilm()
    {
        ArrayList<FilmDTO> allFilms = adminUI.getAllFilms();

        return allFilms; 
    }
    
}
