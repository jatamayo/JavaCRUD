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
public class Inventario {
    int id_inventario;
    int id_compra;

    public Inventario(int id_inventario, int id_compra) {
        this.id_inventario = id_inventario;
        this.id_compra = id_compra;
    }
    
    public Inventario(){
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id_inventario=" + id_inventario + ", id_compra=" + id_compra + '}';
    }
   
    
}
