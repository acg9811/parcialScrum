/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author alexc
 */
public class ClsCliente {
    
    int cedula;
    String nombre;
    String apellido;
    Date   fecha_nacimiento;
    String correo;
    String usuario;
   
    public ClsCliente(){
        this.cedula=0;
        this.nombre="";
        this.apellido="";
       // this.fecha_nacimiento=0;
        this.correo="";
        this.usuario="";
       
    }

    public ClsCliente(int cedula, String nombre, String apellido, Date fecha_nacimiento, String correo, String usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.usuario = usuario;
       
    }

    public ClsCliente(int cedula, String nombre, String apellido, String fecha_Nacimiento, String correo, ClsCliente usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }    
    
}
