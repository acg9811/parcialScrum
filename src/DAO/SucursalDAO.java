/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsCargo;
import Modelo.ClsEmpleado;
import Modelo.ClsSucursal;
import Modelo.ClsConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian
 */
public class SucursalDAO extends ClsConexion {
    
    ClsSucursal dao = new ClsSucursal();
    
    public ArrayList<ClsSucursal> listaSurcursal() {
        ArrayList<ClsSucursal> lista = new ArrayList<>();
        String consulta = "select nombre_sucursal from sucursal";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                ClsSucursal sucursal = new ClsSucursal();
                sucursal.setNombre_sucursal(resultadoDB.getString("nombre_sucursal"));
                lista.add(sucursal);
                System.out.println(sucursal);

            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return lista;
    }
    
    public boolean guardarSucursal(ClsSucursal sucursal) {
        String consulta = "insert into sucursal" + "(id_sucursal,nombre_sucursal,direccion_sucursal,municipio,cedula_gerente)" + " values (" + sucursal.getIdsucursal() + ", '" + sucursal.getNombre_sucursal() + "','"+ sucursal.getDireccion_sucursal() + "' ,'" + sucursal.getMunicipio()+ "'," + sucursal.getCedula_gerente() + ")";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }
    
    public DefaultTableModel listarSucursal() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"N° Sucursal", "Nombre Sucursal", "Direccion Sucursal", "Municipio", "Cedula Gerente"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select id_sucursal, nombre_sucursal,direccion_sucursal,municipio,cedula_gerente from sucursal";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("id_sucursal"),
                    resultadoDB.getString("nombre_sucursal"),
                    resultadoDB.getString("direccion_sucursal"),
                    resultadoDB.getString("municipio"),
                    resultadoDB.getInt("cedula_gerente"),
                    });
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }
    
    public ClsSucursal buscarSucursal(int id_sucursal) {
        String consulta="select id_sucursal,nombre_sucursal,direccion_sucursal,municipio,cedula_gerente"
                + " from sucursal where id_sucursal="+""+id_sucursal+";";
        System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try{
            if(resultadoDB.next()){
                dao.setIdsucursal(resultadoDB.getInt("id_sucursal"));
                dao.setNombre_sucursal(resultadoDB.getString("nombre_sucursal"));
                dao.setDireccion_sucursal(resultadoDB.getString("direccion_sucursal"));
                dao.setMunicipio(resultadoDB.getString("municipio"));
                dao.setCedula_gerente(resultadoDB.getInt("cedula_gerente"));                
            }
        }catch(SQLException ex){
            System.out.print("error");
            return null;
        }
        return  dao;
    }
    
    public boolean eliminarSucursal(int id_sucursal) {
        String consulta = "delete from sucursal where id_sucursal = '" + id_sucursal + "'";
        return super.ejecutar(consulta);
    }
    
      public boolean modificarSucursal(ClsSucursal clsSucursal) {
        String consulta = "update sucursal set id_sucursal=" + clsSucursal.getIdsucursal()+ ""
                + ",nombre_sucursal='" + clsSucursal.getNombre_sucursal()+ "'"
                + ",direccion_sucursal='" + clsSucursal.getDireccion_sucursal() + "'"
                + ",municipio ='" + clsSucursal.getMunicipio() + "'"
                + ",cedula_gerente=" + clsSucursal.getCedula_gerente()+ ""
                + " where id_sucursal="+clsSucursal.getIdsucursal()+"";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }
    
}
