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
public class ClsCiudades {
    
    int id_ciudad;
   
    String nombre_ciudad;
    
    public ClsCiudades(){     
    
    }

    public ClsCiudades(int id_ciudad, String nombre_ciudad) {
        this.id_ciudad = id_ciudad;
        this.nombre_ciudad = nombre_ciudad;
    }



    
    
    
    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }
    
      @Override
  public String toString() {
        return nombre_ciudad;
    }
    
}
