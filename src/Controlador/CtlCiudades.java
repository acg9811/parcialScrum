/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ClsConexion;
import java.util.ArrayList;
import Modelo.ClsCiudades;
import DAO.CiudadesDAO;

/**
 *
 * @author alexc
 */
public class CtlCiudades extends ClsConexion {
    
     ClsConexion conexion = new ClsConexion();
     
      public ArrayList<ClsCiudades> listaCargos() {
        CiudadesDAO ciudadDAO = new CiudadesDAO();
        return ciudadDAO.listadeCargos();
          
    }

}
