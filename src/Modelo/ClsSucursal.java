/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Sebastian
 */
public class ClsSucursal {
    
    int idsucursal;
    String nombre_sucursal;
    String direccion_sucursal;
    String municipio;
    int cedula_gerente;
    
    public ClsSucursal(){
       
    }

    public ClsSucursal(int idsucursal, String nombre_sucursal, String direccion_sucursal, String municipio, int cedula_gerente) {
        this.idsucursal = idsucursal;
        this.nombre_sucursal = nombre_sucursal;
        this.direccion_sucursal = direccion_sucursal;
        this.municipio = municipio;
        this.cedula_gerente = cedula_gerente;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getDireccion_sucursal() {
        return direccion_sucursal;
    }

    public void setDireccion_sucursal(String direccion_sucursal) {
        this.direccion_sucursal = direccion_sucursal;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getCedula_gerente() {
        return cedula_gerente;
    }

    public void setCedula_gerente(int cedula_gerente) {
        this.cedula_gerente = cedula_gerente;
    }
}
