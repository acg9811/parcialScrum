/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ClienteDAO;
import DAO.EmpleadoDAO;
import Modelo.ClsCliente;
import DAO.UsuarioDAO;
import Modelo.ClsEmpleado;
import Modelo.ClsUsuario;
import com.google.gson.Gson;
import java.util.Date;

/**
 *
 * @author alexc
 */
public class CtlUsuario {

    public CtlUsuario() {
    }

    public String convertirGson(ClsUsuario us) {
        Gson gson = new Gson();
        String objeto = gson.toJson(us);
        return objeto;
    }
    String tabla = "usuario";

    public ClsUsuario login(String user, String pass) {
        String consulta = "select * from " + tabla + " where User='" + user + "' and Password='" + pass + "'";
        ClienteDAO usuarioDAO = new ClienteDAO();
        String res = usuarioDAO.login(consulta);
        Gson json = new Gson();
        ClsUsuario usu = json.fromJson(res, ClsUsuario.class);
        return usu;
    }

    public boolean GuardarUsuario(String User, String Password) {
        ClsUsuario usuario = new ClsUsuario(User, Password);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.guardarUsuario(usuario);
    }

    public ClsUsuario buscarUsuario(String usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.buscarUsuario(usuario);
    }

    public boolean modificarUsuario(String User, String Password) {
        ClsUsuario clsUsuario = new ClsUsuario(User, Password);
         UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.modificarUsuario(clsUsuario);
    }
}
