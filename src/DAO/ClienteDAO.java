/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ClsCliente;
import Modelo.ClsConexion;
import Modelo.ClsTipoCta;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexc
 */
public class ClienteDAO extends ClsConexion {

    ClsCliente dao = new ClsCliente();

    public ClsCliente buscarPerfil(int cedula) {
        String consulta = "select cedula, nombre_Cliente, apellido_Cliente, fecha_Nacimineto, email_Cliente,usuario"
                + " from cliente where cedula=" + cedula + "";
        System.out.println(consulta);
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {
                dao.setCedula(resultadoDB.getInt("cedula"));
                dao.setNombre(resultadoDB.getString("nombre_Cliente"));
                dao.setApellido(resultadoDB.getString("apellido_Cliente"));
                dao.setFecha_nacimiento(resultadoDB.getDate("fecha_nacimineto"));
                dao.setCorreo(resultadoDB.getString("email_Cliente"));
                 dao.setUsuario(resultadoDB.getString("usuario"));

            }
        } catch (SQLException ex) {
            System.out.print("error");
            return null;
        }
        return dao;
    }

    public boolean guardarCliente(ClsCliente clienteDAO) {
        String consulta = "insert into cliente" + "(cedula,nombre_Cliente,apellido_Cliente,fecha_Nacimineto,email_Cliente,usuario) values (" + clienteDAO.getCedula() + ", '" + clienteDAO.getNombre() + "', '"
                + clienteDAO.getApellido() + "', '" + clienteDAO.getFecha_nacimiento() + "', '" + clienteDAO.getCorreo() + "', '" + clienteDAO.getUsuario() + "')";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }

//    public boolean login(ClsCliente cliente){
//       String consulta = "select * from cliente where email_Cliente='" + cliente.getCorreo() + "' and contraseña='" + cliente.getContraseña() + "'";
//        return super.ejecutar(consulta);
//    }
    public DefaultTableModel listarClientes() {
        DefaultTableModel modelTabla;
        String nombreColumnas[] = {"cedula", "Nombre", "apellidos", "Fecha de Nacimiento", "Email"};
        modelTabla = new DefaultTableModel(new Object[][]{}, nombreColumnas);
        String consulta = "select cedula, nombre_Cliente,apellido_Cliente,fecha_Nacimineto,email_Cliente from cliente";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                modelTabla.addRow(new Object[]{
                    resultadoDB.getInt("cedula"),
                    resultadoDB.getString("nombre_Cliente"),
                    resultadoDB.getString("apellido_Cliente"),
                    resultadoDB.getString("fecha_Nacimineto"),
                    resultadoDB.getString("email_Cliente"),});
            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return modelTabla;
    }

    public boolean modificarCliente(ClsCliente cliente) {
        String consulta = "update cliente set nombre_Cliente='" + cliente.getNombre() + "'"
                + ",apellido_Cliente='" + cliente.getApellido() + "',"
                + "fecha_Nacimineto='" + cliente.getFecha_nacimiento() + "',"
                + "email_Cliente ='" + cliente.getCorreo() + "'"
                 + " where cedula=" + cliente.getCedula() + "";
        System.out.println(consulta);
        return super.ejecutar(consulta);
    }

    public boolean eliminarCliente(int cedula) {
        String consulta = "delete from cliente where cedula = '" + cedula + "'";
        return super.ejecutar(consulta);
    }

    public String login(String consulta) {
        //se concatena un select * from... donde se indica la tabla, el campo y el id
        super.ejecutarRetorno(consulta);
        //Se inicia un string que va a crear la cadena json
        String resultado = "{ ";
        try {
            //Si hay un resultado
            if (resultadoDB.next()) {
                //se toma la cantidad de columnas en la búsqueda
                int res = resultadoDB.getMetaData().getColumnCount();
                //pasamos por cada una de las columnas
                for (int i = 1; i <= res; i++) {
                    //se concatena en forma de llave : valor cada resultado en la búsqueda
                    resultado += "'" + resultadoDB.getMetaData().getColumnName(i) + "' : '";
                    //si es la última columna no se separa por coma, por suu condición de último
                    if (i == res) {
                        resultado += resultadoDB.getString(i) + "'";
                    } else {
                        //De lo contrario agrega una coma para terminar el valor clave
                        resultado += resultadoDB.getString(i) + "', ";
                    }
                }
            }
            //finalizo el objeto json con }
            resultado += "}";
            System.out.println(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Esto se tosto");
        }
        return resultado;
    }

    public ArrayList<ClsCliente> listaNombres() {
        ArrayList<ClsCliente> lista = new ArrayList<>();
        String consulta = "select cedula,nombre_Cliente from cliente";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                ClsCliente cli = new ClsCliente();
                cli.setCedula(resultadoDB.getInt("cedula"));
                cli.setNombre(resultadoDB.getString("nombre_Cliente"));
                lista.add(cli);
                System.out.println(cli);

            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return lista;
    }
    
   public ArrayList<ClsCliente> listaCuentas(int cedula) {
        ArrayList lista = new ArrayList<>();
        String consulta = "select cu.id from cliente c join cuenta cu on c.id=cu.usuario where c.cedula ="+cedula+" and cu.estado='activa'";
        super.ejecutarRetorno(consulta);

        try {
            while (resultadoDB.next()) {
                
               
                lista.add(resultadoDB.getInt("id")+"");
             

            }
        } catch (SQLException es) {
            System.out.println("error");
        }
        return lista;
    }
   
   public boolean realizarTransferencia(int origen,double monto,int destino){
       String consulta="update cuenta set saldo=( saldo-"+monto+") where id ="+origen+";";
       String c=  "update cuenta set saldo=(saldo+"+monto+") where id="+destino+";";
              
       return super.ejecutar(consulta) && super.ejecutar(c);
   }
   
   public boolean solicitarPrestamo(int cedula,Date fecha,double monto){
       String consulta="insert into prestamo(cedula,fecha,monto,estado) values("
               +cedula+",'"+fecha+"',"+monto+",'solicitado');";
       return super.ejecutar(consulta);
   }
   
}
