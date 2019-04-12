/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alexc
 */
public class ClsCargo {
    
  
    String nombre_cargo;
    float salario;
    int horas_semanales;
    String descripcion;
    
    public ClsCargo(){
       
    }

    public ClsCargo( String nombre_cargo, float salario, int horas_semanales, String descripcion) {
             this.nombre_cargo = nombre_cargo;
        this.salario = salario;
        this.horas_semanales = horas_semanales;
        this.descripcion = descripcion;
    }


    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getHoras_semanales() {
        return horas_semanales;
    }

    public void setHoras_semanales(int horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
  public String toString() {
        return nombre_cargo;
    }
    
}
