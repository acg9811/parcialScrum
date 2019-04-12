/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsConexion;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class CajeroDAO extends ClsConexion {

    public CajeroDAO() {

    }

    public boolean guardarTransferencia(int origen, int destino, int cedula, double monto) {
        String consulta = "insert into transferencia (origen,destino,cedula,monto) values "
                + "(" + origen + "," + destino + "," + cedula + "," + monto + ");";
        return super.ejecutar(consulta);
    }

    public DefaultTableModel listarTransferencias() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Cuenta de origen","Cuenta de destino", "Cedula remitente", "Monto"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select origen,destino, cedula,monto from transferencia";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("origen")+"",
                    resultadoDB.getInt("destino") + "",
                    resultadoDB.getInt("cedula") + "",
                    resultadoDB.getDouble("monto") + ""});
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }

    public boolean guardarConsignacion(int cedula, int destino, double monto) {
        String consulta = "insert into consignacion (cedula,destino,monto) values "
                + "(" + cedula + "," + destino + "," + monto + ");";
        String c2="update cuenta set saldo=(saldo + "+monto+") where id="+destino;
        return super.ejecutar(consulta) && super.ejecutar(c2);
    }

    public DefaultTableModel listarConsignaciones() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Cedula remitente", "Cuenta destino", "Monto"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select destino, cedula,monto from consignacion";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("cedula") + "",
                    resultadoDB.getInt("destino") + "",
                    resultadoDB.getDouble("monto") + ""});
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }

    public boolean guardarRetiro(int cuenta, double monto,String password) {
        String consulta = "insert into retiro (cuenta,monto,password) values "
                + "(" + cuenta + "," + monto + ",'"+password+"');";
        String c2= "update cuenta set saldo= (saldo- "+monto+") where id="+cuenta;
        return super.ejecutar(consulta) && super.ejecutar(c2);
    }
    
    public DefaultTableModel listarRetiros() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"Cuenta", "Monto retirado"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select cuenta,monto from retiro";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("cuenta") + "",
                    resultadoDB.getDouble("monto") + ""});
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }
}
