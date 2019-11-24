
package Manager;

import DTO.UserDTO;
import Gateway.UserGateway;
import java.util.*;


public class UserManager {
    
    private UserGateway gateway = new UserGateway();
    //private ArrayList<UserDTO> userList = new ArrayList<>();
    
    public ArrayList<UserDTO> getAllUser(){
        return gateway.findAll();
    }
    
    public UserDTO getUser(String UserName){
        return gateway.find(UserName);
    }
    
    public boolean addUser(UserDTO user)
    {
        return gateway.insert(user);
    }
    
    public UserDTO login(String Username, String Password)
    {
        return gateway.find(Username, Password); // this comes from gateway, UserDTO passes up from SQL search
    }

    
}
