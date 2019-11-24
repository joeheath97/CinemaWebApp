/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Joe Heath
 */
public class CinemaDTO {
    
    private int cinemaId;
    private String cinemaName;
    private String address;

    public CinemaDTO(int cinemaId, String cinemaName, String address) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.address = address;
    }

    public int getCinemaID() {
        return cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public String getAddress() {
        return address;
    }
    
}
