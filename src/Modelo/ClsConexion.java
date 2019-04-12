/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alexc
 */
public class ClsConexion {

    protected String driver = "com.mysql.jdbc.Driver"; //nombre del driver
    public String db = "ScrumBanco";
    protected String connectString = "jdbc:mysql://localhost:3306/" + db; //ubicacion de la base de datos, para postgres esta es por defecto
    protected String user = "root"; //usuario de la base de datos
    protected String password = ""; //password de la base de datos
    protected Connection conexionDB; // variable que permite la conexion
    protected Statement sentenciaSQL; //permite la ejecucion de sentencias SQL
    protected ResultSet resultadoDB;//almacena el resultado de una consulta

    public void conectar() {
        try {
            Class.forName(driver); //se carga el driver en memoria
            conexionDB = DriverManager.getConnection(connectString, user, password);//conexion a la base de datos
            sentenciaSQL = conexionDB.createStatement();//variable que permite ejecutar las sentencias SQL                                
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean ejecutar(String sentencia) {
        try {
            conectar();
            sentenciaSQL.executeUpdate(sentencia); // algo en la base d edatos va a cambiar DELETE UPDATE INSERT..
//            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void ejecutarRetorno(String sentencia) {
        try {
            conectar();
            resultadoDB = sentenciaSQL.executeQuery(sentencia);// busqueda SELECT
//            desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
