/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ClienteDAO;
import DAO.SucursalDAO;
import Modelo.ClsCliente;
import Modelo.ClsConexion;
import Modelo.ClsSucursal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexc
 */
public class CtlCliente {

    ClsConexion conexion = new ClsConexion();

    public CtlCliente() {
    }

    public boolean SolicitudGuardarCliente(int cedula, String nombre, String apellido, Date fecha_Nacimiento, String correo, String usuario) {
        ClsCliente cliente = new ClsCliente(cedula, nombre, apellido, fecha_Nacimiento, correo,usuario);
        ClienteDAO clieDAO = new ClienteDAO();
        return clieDAO.guardarCliente(cliente);
    }

    public ClsCliente buscarCliente(int cedula) {
        ClienteDAO cliDAO = new ClienteDAO();
        return cliDAO.buscarPerfil(cedula);

    }

    public DefaultTableModel listarCliente() {
        ClienteDAO clienDao = new ClienteDAO();
        return clienDao.listarClientes();
    }

    public boolean solicitudEliminarCliente(int cedula) {
        ClienteDAO clieDAO = new ClienteDAO();
        return clieDAO.eliminarCliente(cedula);
    }
    
    public boolean modificarCliente(int cedula, String nombre,String apellido,Date fecha_nacimiento,String correo,String usuario){
        ClsCliente cliente = new ClsCliente(cedula, nombre, apellido, fecha_nacimiento, correo,usuario);
        ClienteDAO clienteDao= new ClienteDAO();
        return clienteDao.modificarCliente(cliente);
    }
    
    public ArrayList<ClsCliente> nombres() {
        ClienteDAO cliDAO = new ClienteDAO();
        return cliDAO.listaNombres();
    }
    
    public ArrayList cuentas(int cedula){
        ClienteDAO dao= new ClienteDAO();
        return dao.listaCuentas(cedula);
    }

    public boolean transferir(int origen,double valor,int destino){
        ClienteDAO dao= new ClienteDAO();
        return dao.realizarTransferencia(origen, valor, destino);
    }
    
    public boolean solicitarPrestamo(int cedula,java.sql.Date fecha,double valor){
        ClienteDAO dao=new ClienteDAO();
        return dao.solicitarPrestamo(cedula, fecha, valor);
    }
    
}
