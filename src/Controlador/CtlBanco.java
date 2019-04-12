/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.BancoDAO;
import Modelo.ClsBanco;
import Modelo.ClsConexion;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian
 */
public class CtlBanco {
    
    ClsConexion conexion = new ClsConexion();
    
    public CtlBanco() {
    }
    
    public boolean guardarBanco(int nit_banco, String nombre_banco, String mision, String vision, String direccion_sede) {
        ClsBanco clsBanco = new ClsBanco(nit_banco, nombre_banco, mision, vision, direccion_sede);
        BancoDAO bancoDAO = new BancoDAO();
        return bancoDAO.guardarBanco(clsBanco);
    }
    
    public boolean modificarBanco(int nit_banco, String nombre_banco, String mision, String vision, String direccion_sede) {
        ClsBanco clsBanco = new ClsBanco(nit_banco, nombre_banco, mision, vision, direccion_sede);
        BancoDAO bancoDAO = new BancoDAO();
        return bancoDAO.modificarBanco(clsBanco);
    }
    
    public ClsBanco buscarBanco(int nit_banco) {
        BancoDAO bancoDAO = new BancoDAO();
        return bancoDAO.buscarBanco(nit_banco);
    }
    
    public DefaultTableModel listarBanco() {
        BancoDAO bancoDAO = new BancoDAO();
        return bancoDAO.listarBanco();

    }
    
    public boolean eliminarBanco(int nit_banco) {
        BancoDAO bancoDAO = new BancoDAO();
        return bancoDAO.eliminarBanco(nit_banco);
    }
}
