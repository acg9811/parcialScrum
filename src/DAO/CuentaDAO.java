/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsConexion;
import Modelo.ClsCuenta;
import Modelo.ClsTipoCta;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class CuentaDAO extends ClsConexion {

    ClsCuenta dao = new ClsCuenta();
    
    public boolean guardarCuenta(ClsCuenta cuenta) {
        String consulta = "insert into cuenta (usuario,tipo,sucursal,saldo,estado)"
                + " values(" + cuenta.getUsuario() + "," + cuenta.getTipo() + "," + cuenta.getSucursal() + "," + cuenta.getSaldo() + ",'" + cuenta.getEstado() + "');";
        return super.ejecutar(consulta);
    }
    
    public ClsCuenta buscarCuenta(int id) {
        String consulta = "select id,usuario,tipo,sucursal,saldo,estado from cuenta where id=" + id;
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {
                dao.setId(resultadoDB.getInt("id"));
                dao.setUsuario(resultadoDB.getInt("usuario"));
                dao.setTipo(resultadoDB.getInt("tipo"));
                dao.setSucursal(resultadoDB.getInt("sucursal"));
                dao.setSaldo(resultadoDB.getDouble("saldo"));
                dao.setEstado(resultadoDB.getString("estado"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Esto se tosto");
        }
        return dao;
    }
    
    public boolean modificarCta(ClsCuenta cta) {
        String consulta = "update cuenta set saldo=" + cta.getSaldo() + ",tipo= " + cta.getTipo() +",sucursal="+cta.getSucursal()+ " where id= " + cta.getId();
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }
    
     public boolean eliminarCta(int cta) {
        String consulta = "update cuenta set estado='inactiva' where id= " + cta;
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }
     
     
    public DefaultTableModel listarCuentas() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"N° Cuenta", "Propietario", "Tipo de Cuenta", "Sucursal", "Saldo","Estado"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select u.id, c.nombre_Cliente,c.apellido_Cliente,t.nombre,s.nombre_sucursal,u.saldo,u.estado from cuenta u"
                + " join cliente c on u.usuario= c.id join tipo_cuenta t on u.tipo=t.id join sucursal s on u.sucursal=s.id_sucursal";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("u.id"),
                    resultadoDB.getString("c.nombre_cliente")+" "+resultadoDB.getString("c.apellido_cliente"),
                    resultadoDB.getString("t.nombre"),
                    resultadoDB.getString("s.nombre_sucursal"),
                    resultadoDB.getDouble("u.saldo"),
                    resultadoDB.getString("u.estado")
                    });
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }
}
