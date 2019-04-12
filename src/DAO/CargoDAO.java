/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsCargo;
import Modelo.ClsCliente;
import Modelo.ClsConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexc
 */
public class CargoDAO extends ClsConexion {

    ClsCargo dao = new ClsCargo();

    public boolean guardarCargo(ClsCargo cargoDAO) {
        String consulta = "insert into cargo" + "(id_cargo,nombre_Cargo,horas_semanalas,salario,descripcion)"
                + "values (" + "null" + ", '" + cargoDAO.getNombre_cargo() + "', '" + cargoDAO.getHoras_semanales() + "'," + " '" + cargoDAO.getSalario() + "', '" + cargoDAO.getDescripcion() + "')";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }

    public DefaultTableModel listarCargos() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Nombre Cargo", "Horas Semanales", "Salario", "Descripcion"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select nombre_cargo, horas_semanalas,salario,descripcion from cargo";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getString("nombre_cargo"),
                    resultadoDB.getString("horas_semanalas"),
                    resultadoDB.getString("salario"),
                    resultadoDB.getString("descripcion"),});
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }

    public ArrayList<ClsCargo> listadeCargos() {
        ArrayList<ClsCargo> lista = new ArrayList<>();
        String consulta = "select nombre_Cargo from cargo";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                ClsCargo cargo = new ClsCargo();
                cargo.setNombre_cargo(resultadoDB.getString("nombre_Cargo"));
                lista.add(cargo);
                System.out.println(cargo);

            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return lista;
    }
    
    
    public ClsCargo buscarCargo(String nombre_cargo) {
        String consulta="select nombre_Cargo,horas_semanalas,salario,descripcion from cargo "
                + "where nombre_cargo="+"'"+nombre_cargo+"'";
        System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try{
            if(resultadoDB.next()){
                dao.setNombre_cargo(resultadoDB.getString("nombre_Cargo"));
                dao.setHoras_semanales(resultadoDB.getInt("horas_semanalas"));
                dao.setSalario(resultadoDB.getInt("salario"));
                dao.setDescripcion(resultadoDB.getString("descripcion"));
            }
        }catch(SQLException ex){
            System.out.print("error");
            return null;
        }
        return  dao;
    }
    
    public boolean modificarCargo(ClsCargo cargo) {
        String consulta = "update cargo set nombre_Cargo='" + cargo.getNombre_cargo() + "'"
                + ",horas_semanalas='" + cargo.getHoras_semanales() + "',"
                + "salario='" + cargo.getSalario() + "',"
                + "descripcion ='" + cargo.getDescripcion() + "'"
                + " where nombre_cargo='"+cargo.getNombre_cargo()+"'";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }

    public boolean eliminarCliente(int cedula) {
        String consulta = "delete from cliente where cedula = '" + cedula + "'";
        return super.ejecutar(consulta);
    }
    public boolean eliminarCargo(String nombre_cargo) {
        String consulta = "delete from cargo where nombre_cargo =upper( '" + nombre_cargo + "')";
        return super.ejecutar(consulta);
    } 
    


}
