/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.JuntaDirectivaDAO;
import Modelo.ClsConexion;
import Modelo.ClsJuntaDirectiva;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexc
 */
public class CtlJuntaDirectiva {

    ClsConexion conexion = new ClsConexion();

    public CtlJuntaDirectiva() {
    }

    public boolean SolicitudGuardarCliente(int cedula, String nombre, String apellido, Date fecha_Nacimiento, int ciudadNacimiento, double numeroAcciones) {
        ClsJuntaDirectiva junta = new ClsJuntaDirectiva(cedula, nombre, apellido, fecha_Nacimiento, ciudadNacimiento, numeroAcciones);
        JuntaDirectivaDAO juntaDAO = new JuntaDirectivaDAO();
        return juntaDAO.guardarJunta(junta);
    }

    public DefaultTableModel listarJuntaDirectiva() {
        JuntaDirectivaDAO juntaDAO = new JuntaDirectivaDAO();
        return juntaDAO.listarJunta();

    }

    public ClsJuntaDirectiva buscarJunta(int cedula) {
        JuntaDirectivaDAO juntaDAO = new JuntaDirectivaDAO();
        return juntaDAO.buscarJunta(cedula);
    }

    public boolean eliminarJunta(int cedula) {
        JuntaDirectivaDAO juntaDAO = new JuntaDirectivaDAO();
        return juntaDAO.eliminarJunta(cedula);
    }
}
