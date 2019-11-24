/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import UI.AdminUI;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "removeFilmBean")
@RequestScoped
public class RemoveFilmBean {
    
    private AdminUI adminUI = new AdminUI();

    public RemoveFilmBean() {
    }
    
    public String removeFilm(int filmID)
    {
        adminUI.removeFilm(filmID);
        return "ViewAllFilms";  
    }
    
}