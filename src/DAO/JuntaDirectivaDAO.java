/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsCliente;
import Modelo.ClsConexion;
import Modelo.ClsJuntaDirectiva;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexc
 */
public class JuntaDirectivaDAO extends ClsConexion {

    ClsJuntaDirectiva dao = new ClsJuntaDirectiva();

    public boolean guardarJunta(ClsJuntaDirectiva juntaDAO) {
        String consulta = "insert into juntaDirectiva" + "(cedula,nombre,apellido,fecha_Nacimiento,ciudad_nacimiento,porcentaje_acciones) values (" + juntaDAO.getCedula() + ", '" + juntaDAO.getNombre() + "', '"
                + juntaDAO.getApellido() + "', '" + juntaDAO.getFecha_nacimiento() + "', " + juntaDAO.getCiudadNacimiento() + ", " + juntaDAO.getNumeroAcciones() + ")";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }

    public DefaultTableModel listarJunta() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "Fecha de Nacimiento", "ciudad de nacimiento", "porcentaje de acciones"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select j.cedula, j.nombre, j.apellido, j.fecha_nacimiento,c.nombre_ciudad,j.porcentaje_acciones from juntaDirectiva j join ciudades c on j.ciudad_nacimiento=c.id_ciudad";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("j.cedula"),
                    resultadoDB.getString("j.nombre"),
                    resultadoDB.getString("j.apellido"),
                    resultadoDB.getString("j.fecha_nacimiento"),
                    resultadoDB.getString("c.nombre_ciudad"),
                    resultadoDB.getString("j.porcentaje_acciones"),});
                System.out.println(resultadoDB);
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }

    public ClsJuntaDirectiva buscarJunta(int cedula) {
        String consulta = "select cedula, nombre, apellido, fecha_nacimiento,porcentaje_acciones from juntaDirectiva where cedula=" + cedula + "";
        System.out.println(consulta);

        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {
                dao.setCedula(resultadoDB.getInt("cedula"));
                dao.setNombre(resultadoDB.getString("nombre"));
                dao.setApellido(resultadoDB.getString("apellido"));
                dao.setFecha_nacimiento(resultadoDB.getDate("fecha_nacimiento"));
                //      dao.setCiudadNacimiento(resultadoDB.getInt("nombre_ciudad"));
                dao.setNumeroAcciones(resultadoDB.getInt("porcentaje_acciones"));

            }
            System.out.println(dao);
        } catch (SQLException ex) {
            System.out.print("error");
            return null;
        }
        return dao;
    }

    public boolean eliminarJunta(int cedula) {
        String consulta = "delete from juntaDirectiva where cedula = '" + cedula + "'";
        return super.ejecutar(consulta);
    }
}
