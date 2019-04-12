/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CostoDAO;
import Modelo.ClsConexion;
import Modelo.ClsCosto;

/**
 *
 * @author Alejandro
 */
public class CtlCosto {

    ClsConexion conexion = new ClsConexion();

    public CtlCosto() {
    }

    public boolean solicitudGuardar(int id, String nombre, double valor) {
        ClsCosto costo = new ClsCosto(id, nombre, valor);
        CostoDAO dao = new CostoDAO();
        return dao.guardarCosto(costo);
    }

    public ClsCosto solicitudBuscar(int id) {
        CostoDAO dao = new CostoDAO();
        return dao.buscarCosto(id);
    }

}
