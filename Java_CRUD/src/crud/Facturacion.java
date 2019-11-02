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
public class Facturacion {
    int id_factura;
    int id_cliente;
    int id_compra;

    public Facturacion(int id_factura, int id_cliente, int id_compra) {
        this.id_factura = id_factura;
        this.id_cliente = id_cliente;
        this.id_compra = id_compra;
    }
    
    public Facturacion(){
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    @Override
    public String toString() {
        return "Facturacion{" + "id_factura=" + id_factura + ", id_cliente=" + id_cliente + ", id_compra=" + id_compra + '}';
    }

}
