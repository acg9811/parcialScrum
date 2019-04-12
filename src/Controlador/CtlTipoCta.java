/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.SucursalDAO;
import DAO.TipoCtaDAO;
import Modelo.ClsConexion;
import Modelo.ClsSucursal;
import Modelo.ClsTipoCta;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class CtlTipoCta {
    ClsConexion conexion= new ClsConexion();
    
    public CtlTipoCta(){
        
    }
    
    public boolean solicitudGuardar(int id, String nombre){
        ClsTipoCta tipo= new ClsTipoCta(id, nombre);
        TipoCtaDAO dao= new TipoCtaDAO();
        return dao.guardarTipoCta(tipo);
    }
    
    public ClsTipoCta solicitudBuscar(String nombre){
        TipoCtaDAO dao= new TipoCtaDAO();
        return dao.buscarTipoCta(nombre);
    }
    
    public boolean solicitudModificar(int id,String nombre){
        ClsTipoCta tipo= new ClsTipoCta(id, nombre);
        TipoCtaDAO dao= new TipoCtaDAO();
        return dao.modificarTipoCta(tipo);
    }
    
    public ArrayList<ClsTipoCta> tipos() {
        TipoCtaDAO tipoDAO = new TipoCtaDAO();
        return tipoDAO.listaTipos();
    }
}
