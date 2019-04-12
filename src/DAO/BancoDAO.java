/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsBanco;
import Modelo.ClsConexion;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian
 */
public class BancoDAO extends ClsConexion {
    
    ClsBanco dao = new ClsBanco();
    
    public boolean guardarBanco(ClsBanco clsBanco) {
        String consulta = "insert into banco" + "(nit_banco,nombre_banco,mision,vision,direccion_sede)" + " values (" + clsBanco.getNit_banco() + ", '" + clsBanco.getNombre_banco() + "','"+ clsBanco.getMision() + "' ,'" + clsBanco.getVision() + "','" + clsBanco.getDireccion_sede() + "')";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }
    
    public boolean modificarBanco(ClsBanco clsBanco) {
        String consulta = "update banco set nit_banco=" + clsBanco.getNit_banco() + ""
                + ",nombre_banco='" + clsBanco.getNombre_banco()+ "'"
                + ",mision='" + clsBanco.getMision() + "'"
                + ",vision ='" + clsBanco.getVision() + "'"
                + ",direccion_sede='" + clsBanco.getDireccion_sede()+ "'";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }
    
    public ClsBanco buscarBanco(int nit_banco) {
        String consulta="select nit_banco,nombre_banco,mision,vision,direccion_sede"
                + " from banco where nit_banco="+""+nit_banco+"";
        System.out.println(consulta);
      
        super.ejecutarRetorno(consulta);
        try{
            if(resultadoDB.next()){
                dao.setNit_banco(resultadoDB.getInt("nit_banco"));
                dao.setNombre_banco(resultadoDB.getString("nombre_banco"));
                dao.setMision(resultadoDB.getString("mision"));
                dao.setVision(resultadoDB.getString("vision"));
                dao.setDireccion_sede(resultadoDB.getString("direccion_sede"));
            }
            System.out.println(dao);
        }catch(SQLException ex){
            System.out.print("error");
            return null;
        }
        return  dao;
    }
    
    public DefaultTableModel listarBanco() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"NIT", "Nombre Banco", "Mision", "Vision", "Direccion Sede"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select nit_banco, nombre_banco, mision, vision, direccion_sede from banco";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("nit_banco"),
                    resultadoDB.getString("nombre_banco"),
                    resultadoDB.getString("mision"),
                    resultadoDB.getString("vision"),
                    resultadoDB.getString("direccion_sede"),});
                System.out.println(resultadoDB);
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }
    
    public boolean eliminarBanco(int nit_banco) {
        String consulta = "delete from banco where nit_banco = '" + nit_banco + "'";
        return super.ejecutar(consulta);
    }
}
