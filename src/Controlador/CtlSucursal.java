/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CargoDAO;
import DAO.EmpleadoDAO;
import Modelo.ClsEmpleado;
import DAO.SucursalDAO;
//import Modelo.ClsCargo;
import Modelo.ClsSucursal;
import Modelo.ClsConexion;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian
 */
public class CtlSucursal {

    ClsConexion conexion = new ClsConexion();

    public CtlSucursal() {
    }

    public ArrayList<ClsSucursal> sucursales() {
        SucursalDAO sucursalDAO = new SucursalDAO();
        return sucursalDAO.listaSurcursal();
    }

    public boolean guardarSucursal(int idSucursal, String nombre_sucursal, String direccion_sucursal, String municipio, int cedula_gerente) {
        ClsSucursal clsSucursal = new ClsSucursal(idSucursal, nombre_sucursal, direccion_sucursal, municipio, cedula_gerente);
        SucursalDAO sucursal = new SucursalDAO();
        return sucursal.guardarSucursal(clsSucursal);
    }

    public DefaultTableModel listarSucursal() {
        SucursalDAO sucursal = new SucursalDAO();
        return sucursal.listarSucursal();
    }

    public ClsSucursal buscarSucursal(int id_sucursal) {
        SucursalDAO sucursal = new SucursalDAO();
        return sucursal.buscarSucursal(id_sucursal);
    }

    public boolean eliminarSucursal(int id_sucursal) {
       SucursalDAO sucursal = new SucursalDAO();
        return sucursal.eliminarSucursal(id_sucursal);
    }
    
    
      public boolean modificarSucursal(int idSucursal, String nombre_sucursal, String direccion_sucursal, String municipio, int cedula_gerente) {
        ClsSucursal clsSucursal = new ClsSucursal(idSucursal, nombre_sucursal, direccion_sucursal, municipio, cedula_gerente);
        SucursalDAO sucursal = new SucursalDAO();
        return sucursal.modificarSucursal(clsSucursal);
    }
}
