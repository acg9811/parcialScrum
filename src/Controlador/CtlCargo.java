/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClsConexion;
import Modelo.ClsCargo;
import DAO.CargoDAO;
import DAO.EmpleadoDAO;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexc
 */
public class CtlCargo {

    ClsConexion conexion = new ClsConexion();

    public CtlCargo() {
    }

    public boolean guardarCargo(String nombre_cargo, float salario, int horas_semanales, String descripcion) {
        ClsCargo cargo = new ClsCargo(nombre_cargo, salario, horas_semanales, descripcion);
        CargoDAO cargoDao = new CargoDAO();
        return cargoDao.guardarCargo(cargo);

    }

    public ClsCargo buscarCargo(String nombre_cargo) {
        CargoDAO cargoDAO = new CargoDAO();
        return cargoDAO.buscarCargo(nombre_cargo);
    }

    public DefaultTableModel listarCargo() {
        CargoDAO cargoDao = new CargoDAO();
        return cargoDao.listarCargos();
    }

    public ArrayList<ClsCargo> listaCargos() {
        CargoDAO vehiDAO = new CargoDAO();
        return vehiDAO.listadeCargos();
    }

    public boolean modificarCargo(String nombre_cargo, float salario, int horas_semanales, String descripcion) {
        ClsCargo clscargo = new ClsCargo(nombre_cargo, salario, horas_semanales, descripcion);
        CargoDAO cargoDAO = new CargoDAO();
        return cargoDAO.modificarCargo(clscargo);
    }
    
    public boolean solicitudEliminarCargo(String nombre_cargo) {
        CargoDAO cargoDAO = new CargoDAO();
        return cargoDAO.eliminarCargo(nombre_cargo);
    }
}
