/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CajeroDAO;
import Modelo.ClsConexion;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class CtlCajero {
    ClsConexion conexion= new ClsConexion();
    
    public boolean solicitudGuardar(int origen,int destino,int cedula,double valor){
        CajeroDAO dao= new CajeroDAO();
        return dao.guardarTransferencia(origen,destino, cedula, valor);
    }
    
    public DefaultTableModel listarTransferencias(){
        CajeroDAO dao= new CajeroDAO();
        return dao.listarTransferencias();
    }
    
    public boolean guardarConsignacion(int cedula,int destino,double monto){
        CajeroDAO dao= new CajeroDAO();
        return dao.guardarConsignacion(cedula, destino, monto);
    }
    
    public DefaultTableModel listarConsignaciones(){
        CajeroDAO dao= new CajeroDAO();
        return dao.listarConsignaciones();
    }
    
    public boolean guardarRetiro(int cuenta,double monto,String password){
        CajeroDAO dao= new CajeroDAO();
        return dao.guardarRetiro(cuenta, monto,password);
        
    }
    
    public DefaultTableModel listarRetiros(){
        CajeroDAO dao= new CajeroDAO();
        return dao.listarRetiros();
    }
}
