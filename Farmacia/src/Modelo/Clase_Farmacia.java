/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author carlos
 */
public class Clase_Farmacia {
    
    private int id;
    private String nombre;
    private String tipo;
    private int cantidad;
    private String distri;
    private String lug_farmacia;

    public Clase_Farmacia() {
    }

    public Clase_Farmacia(int id, String nombre, String tipo, int cantidad, String distri, String lug_farmacia) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.distri = distri;
        this.lug_farmacia = lug_farmacia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDistri() {
        return distri;
    }

    public void setDistri(String distri) {
        this.distri = distri;
    }

    public String getLug_farmacia() {
        return lug_farmacia;
    }

    public void setLug_farmacia(String lug_farmacia) {
        this.lug_farmacia = lug_farmacia;
    }
    
    
    
}
