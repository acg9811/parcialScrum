/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CargoDAO;
import DAO.CuentaDAO;
import DAO.TipoCtaDAO;
import Modelo.ClsCargo;
import Modelo.ClsConexion;
import Modelo.ClsCuenta;
import Modelo.ClsTipoCta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class CtlCuenta {

    ClsConexion conexion = new ClsConexion();

    public CtlCuenta() {

    }

    public boolean guardarCuenta(int id,int usuario,int tipo,int sucursal,double saldo,String estado) {
        ClsCuenta cuenta = new ClsCuenta(id, usuario, tipo, sucursal, saldo,estado);
        CuentaDAO cuentaDao = new CuentaDAO();
        return cuentaDao.guardarCuenta(cuenta);
    }
    
    public ClsCuenta buscarCuenta(int id) {
        CuentaDAO cuentaDAO = new CuentaDAO();
        return cuentaDAO.buscarCuenta(id);
    }
    
    public boolean solicitudModificar(int id,int usuario,int tipo,int sucursal,double saldo,String estado){
        ClsCuenta cuenta= new ClsCuenta(id, usuario, tipo, sucursal, saldo,estado);
        CuentaDAO dao= new CuentaDAO();
        return dao.modificarCta(cuenta);
    }
    
    public boolean eliminarCuenta(int id){
        CuentaDAO dao= new CuentaDAO();
        return dao.eliminarCta(id);
    }
    
    public DefaultTableModel solicitudListar(){
        CuentaDAO dao= new CuentaDAO();
        return dao.listarCuentas();
    }

}
