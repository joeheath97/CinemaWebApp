/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.ScreenDTO;
import Gateway.ScreenGateway;
import java.util.ArrayList;

public class ScreenManager {
    
    private ArrayList<ScreenDTO> FilmList = new ArrayList<>();
    private ScreenGateway gateway = new ScreenGateway();
    
        
    public ArrayList<ScreenDTO> getAllScreens(){
        return gateway.findAll();
    }
    
    public ScreenDTO findByScreenID (String ScreenID){
        return gateway.findByScreenID(ScreenID);
    }
        
    
}
