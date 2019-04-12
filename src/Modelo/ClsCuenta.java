/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alejandro
 */
public class ClsCuenta {

    private int id;
    private int usuario;
    private int tipo;
    private int sucursal;
    private double saldo;
    private String estado;

    public ClsCuenta(int id, int usuario, int tipo, int sucursal, double saldo, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.tipo = tipo;
        this.sucursal = sucursal;
        this.saldo = saldo;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClsCuenta() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
