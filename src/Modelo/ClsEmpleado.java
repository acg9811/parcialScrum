/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Sebastian
 */
public class ClsEmpleado {
    
    int cedula;
    String nombre_empleado;
    String apellido_empleado;
    Date fecha_nacimiento;
    Date fecha_ingreso;
    int cargo;
    int sucursal;
    String usuario;
   
    
    public ClsEmpleado(){
       
    }

    public ClsEmpleado(int cedula, String nombre_empleado, String apellido_empleado, Date fecha_nacimiento, Date fecha_ingreso, int cargo, int sucursal, String usuario) {
        this.cedula = cedula;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_ingreso = fecha_ingreso;
        this.cargo = cargo;
        this.sucursal = sucursal;
        this.usuario = usuario;
    
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    
    
}
