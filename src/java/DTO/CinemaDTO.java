/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joe Heath
 */
@XmlRootElement
public class CinemaDTO implements Serializable{
    
    private int cinemaId;
    private String cinemaName;
    private String address;

    public CinemaDTO(int cinemaId, String cinemaName, String address) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.address = address;
    }
    
    public CinemaDTO()
    {
        
    }

    public void setCinemaId(int cinemaId)
    {
        this.cinemaId = cinemaId;
    }

    public void setCinemaName(String cinemaName)
    {
        this.cinemaName = cinemaName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public String getAddress() {
        return address;
    }
    
}
