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

    public AdminUI() {
    }

    public ArrayList<ShowingDTO> getAllShowings() {

        return showingMgr.getAllShowings();
    }

    public boolean addShowing(ShowingDTO showing) {
        return showingMgr.addShowing(showing);
    }

    public ShowingDTO getShowing(int ShowingId) {
        return showingMgr.getShowing(ShowingId);
    }

    public ShowingDTO modifyShowing(ShowingDTO showing) {
        if (showingMgr.modifyShowing(showing)) {
            return showingMgr.getShowing(showing.getShowingId());
        }
        return null;
    }

    public boolean removeShowing(int ShowingId) {
        return showingMgr.romoveShowing(ShowingId);
    }

    public ArrayList<UserDTO> getAllUser() {
        return UserMgr.getAllUser();
    }

    public FilmDTO getFilm(int filmId) {
        return filmMgr.findFilm(filmId);
    }

    public ArrayList<FilmDTO> getAllFilms() {
        return filmMgr.getAllFilms();
    }

    public FilmDTO addFilm(FilmDTO film) {
        if (filmMgr.addFilm(film)) {
            return filmMgr.findFilm(film.getFilmId());
        }
        return null;

    }

    public boolean removeFilm(int FilmId) {
        return filmMgr.removeFilm(FilmId);
    }

    public ArrayList<CinemaDTO> getAllCinema() {
        return cinemaMgr.getAllCinema();
    }

    public ArrayList<ScreenDTO> getAllScreen() {
        return screenMgr.getAllScreens();
    }

}
