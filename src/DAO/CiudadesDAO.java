/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsCiudades;
import Modelo.ClsJuntaDirectiva;
import java.util.ArrayList;
import Modelo.ClsConexion;
import java.sql.SQLException;


/**
 *
 * @author alexc
 */
public class CiudadesDAO extends ClsConexion {
    ClsCiudades dao= new ClsCiudades();
    
    public ArrayList<ClsCiudades> listadeCargos() {
        ArrayList<ClsCiudades> lista = new ArrayList<>();
        String consulta = "select nombre_ciudad from ciudades";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                ClsCiudades ciudades = new ClsCiudades();
                ciudades.setNombre_ciudad(resultadoDB.getString("nombre_ciudad"));
                lista.add(ciudades);
               System.out.println(ciudades+"ciu");

            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return lista;
    }
}
