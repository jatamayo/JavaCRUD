/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

/**
 *
 * @author jalej
 */
public class Compra {
    int id_compra;
    int id_proveedor;
    String nombre_articulo;
    int cantidad_articulo;
    int precio_articulo;

    public Compra(int id_compra, int id_proveedor, String nombre_articulo, int cantidad_articulo, int precio_articulo) {
        this.id_compra = id_compra;
        this.id_proveedor = id_proveedor;
        this.nombre_articulo = nombre_articulo;
        this.cantidad_articulo = cantidad_articulo;
        this.precio_articulo = precio_articulo;
    }

    public Compra() {
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public int getCantidad_articulo() {
        return cantidad_articulo;
    }

    public void setCantidad_articulo(int cantidad_articulo) {
        this.cantidad_articulo = cantidad_articulo;
    }

    public int getPrecio_articulo() {
        return precio_articulo;
    }

    public void setPrecio_articulo(int precio_articulo) {
        this.precio_articulo = precio_articulo;
    }

    @Override
    public String toString() {
        return "Compra{" + "id_compra=" + id_compra + ", id_proveedor=" + id_proveedor + ", nombre_articulo=" + nombre_articulo + ", cantidad_articulo=" + cantidad_articulo + ", precio_articulo=" + precio_articulo + '}';
    }


    
}
