/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsCargo;
import Modelo.ClsEmpleado;
import Modelo.ClsConexion;
import Modelo.ClsSucursal;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian
 */
public class EmpleadoDAO extends ClsConexion {

    ClsEmpleado dao = new ClsEmpleado();

    public ClsEmpleado buscarEmpleado(int cedula_empleado) {
        String consulta = "select cedula,nombre_empleado,apellido_empleado,fecha_Nacimineto,fecha_Ingreso,"
                + "cargo,sucursal,usuario from empleado where cedula=" + "" + cedula_empleado + "";
        System.out.println(consulta);
        ClsEmpleado dao = new ClsEmpleado();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {
                dao.setCedula(resultadoDB.getInt("cedula"));
                dao.setNombre_empleado(resultadoDB.getString("nombre_empleado"));
                dao.setApellido_empleado(resultadoDB.getString("apellido_empleado"));
                dao.setFecha_nacimiento(resultadoDB.getDate("fecha_Nacimineto"));
                dao.setFecha_ingreso(resultadoDB.getDate("fecha_Ingreso"));
                dao.setCargo(resultadoDB.getInt("cargo"));
                dao.setSucursal(resultadoDB.getInt("sucursal"));
                dao.setUsuario(resultadoDB.getString("usuario"));

            }
            System.out.println(dao);
        } catch (SQLException ex) {
            System.out.print("error");
            return null;
        }
        return dao;
    }

    public ArrayList<ClsEmpleado> listadeGerentes() {
        ArrayList<ClsEmpleado> lista = new ArrayList<>();
        String consulta = "select  e.nombre_empleado from empleado e join cargo c on e.cargo=c.id_cargo where upper(c.nombre_Cargo)='GERENTE'";
        super.ejecutarRetorno(consulta);
        System.out.println(consulta);
        try {
            while (resultadoDB.next()) {
                ClsEmpleado empleado = new ClsEmpleado();
                empleado.setNombre_empleado(resultadoDB.getString("nombre_empleado"));
                lista.add(empleado);
                System.out.println(empleado);

            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return lista;
    }

    public ArrayList<ClsEmpleado> listadeEmpleados() {
        ArrayList<ClsEmpleado> lista = new ArrayList<>();
        String consulta = "select cedula from empleado";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                ClsEmpleado empleado = new ClsEmpleado();
                empleado.setCedula(resultadoDB.getInt("cedula"));
                lista.add(empleado);
                System.out.println(empleado);

            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return lista;
    }

    public boolean guardarEmpleado(ClsEmpleado empleadoDAO) {
        String consulta = "insert into empleado" + "(cedula,nombre_Empleado,apellido_Empleado,fecha_Nacimineto,fecha_Ingreso,cargo,sucursal,usuario)" + " values (" + empleadoDAO.getCedula() + ", '" + empleadoDAO.getNombre_empleado() + "','" + empleadoDAO.getApellido_empleado() + "' ,'" + empleadoDAO.getFecha_nacimiento() + "','" + empleadoDAO.getFecha_ingreso() + "'," + empleadoDAO.getCargo() + " , " + empleadoDAO.getSucursal() + ", '" + empleadoDAO.getUsuario() + "')";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }

    public boolean modificarEmpleado(ClsEmpleado empleado) {
        String consulta = "update empleado set cedula=" + empleado.getCedula() + ""
                + ",nombre_Empleado='" + empleado.getNombre_empleado() + "'"
                + ",apellido_Empleado='" + empleado.getApellido_empleado() + "'"
                + ",fecha_Nacimineto ='" + empleado.getFecha_nacimiento() + "'"
                + ",fecha_Ingreso='" + empleado.getFecha_ingreso() + "'"
                + ",cargo=" + empleado.getCargo() + ""
                + ",sucursal=" + empleado.getSucursal() + ""
                + " where cedula=" + empleado.getCedula() + "";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }

    public boolean eliminarEmpleado(int cedula) {
        String consulta = "delete from empleado where cedula = " + cedula + "";
        return super.ejecutar(consulta);
    }

    public DefaultTableModel listarEmpleado() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "Usuario", "Nombre de sucursal", "Cargo"
        };
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select t.cedula,t.nombre_empleado,t.apellido_empleado,t.usuario,t.nombre_sucursal,c.nombre_cargo from(\n"
                + "SELECT * FROM empleado e LEFT JOIN sucursal s  ON e.sucursal=s.id_sucursal \n"
                + "UNION ALL\n"
                + "SELECT * FROM empleado e RIGHT JOIN sucursal s ON e.sucursal=s.id_sucursal\n"
                + "WHERE e.sucursal IS NULL) t join cargo c on t.cargo=c.id_cargo";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("t.cedula"),
                    resultadoDB.getString("t.nombre_empleado"),
                    resultadoDB.getString("t.apellido_empleado"),
                    resultadoDB.getString("t.usuario"),
                    resultadoDB.getString("t.nombre_sucursal"),
                    resultadoDB.getString("c.nombre_cargo"),});
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }

    public DefaultTableModel listarEmpleadoGerente() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "Fecha de Nacimiento", "Fecha de Ingreso", "Cargo", "Usuario"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select e.cedula, e.nombre_empleado,e.apellido_empleado,e.fecha_Nacimineto,e.fecha_Ingreso,e.usuario,c.nombre_cargo from empleado e join cargo c on e.cargo = c.id_cargo;";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("e.cedula"),
                    resultadoDB.getString("e.nombre_empleado"),
                    resultadoDB.getString("e.apellido_empleado"),
                    resultadoDB.getString("e.fecha_Nacimineto"),
                    resultadoDB.getString("e.fecha_Ingreso"),
                    resultadoDB.getString("c.nombre_cargo"),
                    resultadoDB.getString("e.usuario"),});
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }
}
