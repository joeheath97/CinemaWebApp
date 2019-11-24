/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.ShowingDTO;
import Gateway.ShowingGateway;
import java.util.*;

/**
 *
 * @author Joe Heath
 */
public class ShowingManager {
    
    private ArrayList<ShowingDTO> ShowingList = new ArrayList<>();
    private ShowingGateway gateway = new ShowingGateway();
    
    public ArrayList<ShowingDTO> getAllShowings(){
        return gateway.findAll();
    }
    
    public ShowingDTO getShowing(int ShowingID){
        return gateway.findByID(ShowingID);
    }
    
    public ArrayList<ShowingDTO> searchShowing(int FilmID){
        return gateway.findAllBySearched(FilmID);
    }
    
    public boolean addShowing(ShowingDTO showing){
        return gateway.insert(showing);
    }
    
    public boolean romoveShowing(int ShowingID){
        return gateway.delete(ShowingID);
    }
    
    public boolean modifyShowing(ShowingDTO showing){
        return gateway.update(showing);
    }
    
}
