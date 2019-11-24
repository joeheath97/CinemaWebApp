/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import UI.AdminUI;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Joe Heath
 */
@Named(value = "removeShowingBean")
@RequestScoped
public class RemoveShowingBean {

    private AdminUI adminUI = new AdminUI();

    public RemoveShowingBean() {
    }
    
    public String removeShowing(int ShowingID){
        
        adminUI.removeShowing(ShowingID);
        return "ViewAllShowings";
        
    }
    
}
