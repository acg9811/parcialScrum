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
public class ClsBanco {
    
    int nit_banco;
    String nombre_banco;
    String  mision;
    String vision;
    String direccion_sede;
    
    public ClsBanco(){
       
    }

    public ClsBanco(int nit_banco, String nombre_banco, String mision, String vision, String direccion_sede) {
        this.nit_banco = nit_banco;
        this.nombre_banco = nombre_banco;
        this.mision = mision;
        this.vision = vision;
        this.direccion_sede = direccion_sede;
    }

    public int getNit_banco() {
        return nit_banco;
    }

    public void setNit_banco(int nit_banco) {
        this.nit_banco = nit_banco;
    }

    public String getNombre_banco() {
        return nombre_banco;
    }

    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getDireccion_sede() {
        return direccion_sede;
    }

    public void setDireccion_sede(String direccion_sede) {
        this.direccion_sede = direccion_sede;
    }
}
