/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsConexion;
import Modelo.ClsCosto;
import java.sql.SQLException;

/**
 *
 * @author Alejandro
 */
public class CostoDAO extends ClsConexion {

    ClsCosto dao = new ClsCosto();

    public boolean guardarCosto(ClsCosto costo) {
        String consulta = "insert into costo (nombre,valor) values('" + costo.getNombre() + "'," + costo.getValor() + ");";
        return super.ejecutar(consulta);
    }

    public ClsCosto buscarCosto(int id) {
        String consulta = "select id,nombre,valor from costo where id=" + id;
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {
                dao.setId(resultadoDB.getInt("id"));
                dao.setNombre(resultadoDB.getString("nombre"));
                dao.setValor(resultadoDB.getDouble("costo"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Esto se tosto");
        }
        return dao;
    }

}
