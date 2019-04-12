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
public class ClsJuntaDirectiva {
    
    int cedula;
    String nombre;
    String apellido;
    Date fecha_nacimiento;
    int ciudadNacimiento;
    double numeroAcciones;
    
    public ClsJuntaDirectiva(){
        
    }

    public ClsJuntaDirectiva(int cedula, String nombre, String apellido, Date fecha_nacimiento, int ciudadNacimiento, double numeroAcciones) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.ciudadNacimiento = ciudadNacimiento;
        this.numeroAcciones = numeroAcciones;
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

    public int getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(int ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public double getNumeroAcciones() {
        return numeroAcciones;
    }

    public void setNumeroAcciones(double numeroAcciones) {
        this.numeroAcciones = numeroAcciones;
    }
    
  
    
    
}
