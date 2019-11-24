/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DTO.CinemaDTO;
import DTO.UserDTO;
import DTO.FilmDTO;
import DTO.ScreenDTO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import DTO.ShowingDTO;
import ManagedBean.CinemaBean;
import Manager.CinemaManager;
import Manager.FilmManager;
import Manager.ScreenManager;
import Manager.ShowingManager;
import Manager.UserManager;
import java.util.*;

/**
 *
 * @author Joe Heath
 */
@Named(value = "adminUI")
@RequestScoped
public class AdminUI {
    
    private FilmManager filmMgr = new FilmManager();
    private UserManager UserMgr = new UserManager();
    private ShowingManager showingMgr = new ShowingManager();
    private ScreenManager screenMgr = new ScreenManager();
    private CinemaManager cinemaMgr = new CinemaManager();
    
    public AdminUI()
    {
    }
    
    public ArrayList<ShowingDTO> getAllShowings(){
        
        return showingMgr.getAllShowings();
    }
    
    public ShowingDTO addShowing(ShowingDTO showing){
                if(showingMgr.addShowing(showing))
        {
            return showingMgr.getShowing(showing.getShowingID());
        }
        return null;
    }
    
    public ShowingDTO getShowing(int ShowingID)
    {
        return showingMgr.getShowing(ShowingID);
    }
    
    public ShowingDTO modifyShowing(ShowingDTO showing){
        if(showingMgr.modifyShowing(showing))
        {
            return showingMgr.getShowing(showing.getShowingID());
        }
        return null;
    }
    
    public boolean removeShowing(int ShowingID){
        return showingMgr.romoveShowing(ShowingID);
    }
    
    public ArrayList<UserDTO> getAllUser(){
        return UserMgr.getAllUser();
    }
    
    public FilmDTO getFilm(int filmID)
    {
        return filmMgr.findFilm(filmID);
    }
    
    public ArrayList<FilmDTO> getAllFilms(){
        return filmMgr.getAllFilms();
    }
    
    public FilmDTO addFilm(FilmDTO film){
        if(filmMgr.addFilm(film))
        {
            return filmMgr.findFilm(film.getFilmID());
        }
        return null;

    }
    
    public boolean removeFilm (int FilmID){
        return filmMgr.removeFilm(FilmID);
    }
    

    
    public ArrayList<CinemaDTO> getAllCinema(){
        return cinemaMgr.getAllCinema();
    }
    
    public ArrayList<ScreenDTO> getAllScreen(){
        return screenMgr.getAllScreens();
    }
    

    
}
