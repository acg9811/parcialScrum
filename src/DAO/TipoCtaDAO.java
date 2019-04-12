/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsConexion;
import Modelo.ClsSucursal;
import Modelo.ClsTipoCta;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class TipoCtaDAO extends ClsConexion {

    ClsTipoCta dao = new ClsTipoCta();

    public boolean guardarTipoCta(ClsTipoCta tipo) {
        String consulta = "insert into tipo_cuenta(nombre) values('" + tipo.getNombre() + "');";
        return super.ejecutar(consulta);
    }

    public ClsTipoCta buscarTipoCta(String nombre) {
        String consulta = "select id,nombre from tipo_cuenta where nombre='" + nombre + "'";
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {
                dao.setId(resultadoDB.getInt("id"));
                dao.setNombre(resultadoDB.getString("nombre"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Esto se tosto");
        }
        return dao;
    }

    public boolean modificarTipoCta(ClsTipoCta tipo) {
        String consulta = "update tipo_cuenta set nombre='" + tipo.getNombre() + "' where id= " + tipo.getId();
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }

    public ArrayList<ClsTipoCta> listaTipos() {
        ArrayList<ClsTipoCta> lista = new ArrayList<>();
        String consulta = "select nombre from tipo_cuenta";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                ClsTipoCta tipo = new ClsTipoCta();
                //stipo.setId(resultadoDB.getInt("id"));
                tipo.setNombre(resultadoDB.getString("nombre"));
                lista.add(tipo);
                System.out.println(tipo);

            }
        } catch (SQLException es) {
            es.printStackTrace();
            System.out.println("error");
        }
        return lista;
    }

}
