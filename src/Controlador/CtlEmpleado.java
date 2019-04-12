/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CargoDAO;
import DAO.EmpleadoDAO;
import Modelo.ClsCargo;
import Modelo.ClsEmpleado;
import Modelo.ClsConexion;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian
 */
public class CtlEmpleado {

    ClsConexion conexion = new ClsConexion();

    public CtlEmpleado() {
    }

    public ClsEmpleado buscarEmpleado(int cedula_empleado) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        return empleadoDAO.buscarEmpleado(cedula_empleado);
    }
    
    public ArrayList<ClsEmpleado> listaGerente() {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        return empleadoDAO.listadeGerentes();
    }

    public DefaultTableModel listarEmpleado() {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        return empleadoDAO.listarEmpleado();
    }

    public DefaultTableModel listarEmpleadoGerente() {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        return empleadoDAO.listarEmpleadoGerente();
    }
    public ArrayList<ClsEmpleado> listaDeEmpleados() {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        return empleadoDAO.listadeEmpleados();
    }

    public boolean guardarEmpleado(int cedula, String nombre_empleado, String apellido_empleado, Date fecha_nacimiento, Date fecha_ingreso, int cargo, int sucursal, String usuario) {
        ClsEmpleado empleado = new ClsEmpleado(cedula, nombre_empleado, apellido_empleado, fecha_nacimiento, fecha_ingreso, cargo, sucursal, usuario);
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        return empleadoDAO.guardarEmpleado(empleado);

    }

    public boolean modificarEmpleado(int cedula, String nombre_empleado, String apellido_empleado, Date fecha_nacimiento, Date fecha_Ingreso, int cargo, int sucursal, String usuario) {
        ClsEmpleado clsEmpleado = new ClsEmpleado(cedula, nombre_empleado, apellido_empleado, fecha_nacimiento, fecha_Ingreso, cargo, sucursal, usuario);
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        return empleadoDAO.modificarEmpleado(clsEmpleado);
    }

    public boolean eliminarEmpleado(int cedula) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        return empleadoDAO.eliminarEmpleado(cedula);
    }
}
