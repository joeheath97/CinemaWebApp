/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.CinemaDTO;
import Gateway.CinemaGateway;
import java.util.ArrayList;

/**
 *
 * @author Joe Heath
 */
public class CinemaManager {
    
    private ArrayList<CinemaDTO> CinemaList = new ArrayList<>();
    private CinemaGateway gateway = new CinemaGateway();
    
        public ArrayList<CinemaDTO> getAllCinema(){
        return gateway.findAll();
    }
    
    public CinemaDTO findCinemaByID(int CinemaID){
        return gateway.findByID(CinemaID);
    }
    
}
