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
public class Proveedor {
    int id_proveedor;
    String nombre_proveedor;
    String direccion_proveedor;
    int telefono_proveedor;
    
    public Proveedor(int id_proveedor, String nombre_proveedor, String direccion_proveedor, int telefono_proveedor) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.telefono_proveedor = telefono_proveedor;
    }
    public Proveedor(){
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public int getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(int telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", direccion_proveedor=" + direccion_proveedor + ", telefono_proveedor=" + telefono_proveedor + '}';
    }
    
}
