/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alexc
 */
public class ClsUsuario {
    String User;
    String Password;
    int id;
    
    public ClsUsuario(){
        
    }
   

    public ClsUsuario(String User, String Password ){
        
        this.User = User;
        this.Password = Password;
        
     
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    
}
