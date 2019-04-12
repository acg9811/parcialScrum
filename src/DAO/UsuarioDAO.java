/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsCliente;
import Modelo.ClsConexion;
import Modelo.ClsEmpleado;
import Modelo.ClsUsuario;
import java.sql.SQLException;

/**
 *
 * @author alexc
 */
public class UsuarioDAO extends ClsConexion {

    ClsUsuario dao = new ClsUsuario();

    public boolean guardarUsuario(ClsUsuario usuario) {
        String consulta = "insert into usuario" + "(User, Password) values ('" + usuario.getUser() + "', '" + usuario.getPassword() + "')";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }

    public ClsUsuario buscarUsuario(String usuario) {
        String consulta = "select id,User,Password from usuario where User='" + usuario + "'";
        System.out.println(consulta);
ClsUsuario da = new ClsUsuario();
        super.ejecutarRetorno(consulta);
        
        try {
            if (resultadoDB.next()) {
                da.setUser(resultadoDB.getString("User"));
                da.setPassword(resultadoDB.getString("Password"));
                da.setId(resultadoDB.getInt("id"));
            }

        } catch (SQLException ex) {
            System.out.println("erro");
           return da;
        }
        return da;
    }

    public boolean modificarUsuario(ClsUsuario usuario) {
        String consulta = "update usuario set User=" + usuario.getUser() + ""
                + ",Password='" + usuario.getPassword() + "'"
                + " where User=" + usuario.getUser() + "";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }
}
