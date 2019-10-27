package crud;

/**
 *
 * @author jalej
 */
public class Clientes {
    int id_cliente;
    String nombre_cliente;
    String direccion_cliente;
    int telefono_cliente;
    String estado_cliente;
    double saldo_cliente;

    public static void main(String[] args){
        System.out.println("model clientes");
    }
    
    public Clientes(){
        System.out.println("se creo cliente");
    }

    public Clientes(int id_cliente, String nombre_cliente, String direccion_cliente, int telefono_cliente, String estado_cliente, double saldo_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
        this.estado_cliente = estado_cliente;
        this.saldo_cliente = saldo_cliente;
    }

    public Clientes(String nombre_cliente, String direccion_cliente, int telefono_cliente, String estado_cliente, double saldo_cliente) {
        this.nombre_cliente = nombre_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
        this.estado_cliente = estado_cliente;
        this.saldo_cliente = saldo_cliente;
    }
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public int getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(int telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getEstado_cliente() {
        return estado_cliente;
    }

    public void setEstado_cliente(String estado_cliente) {
        this.estado_cliente = estado_cliente;
    }

    public double getSaldo_cliente() {
        return saldo_cliente;
    }

    public void setSaldo_cliente(double saldo_cliente) {
        this.saldo_cliente = saldo_cliente;
    }

    @Override
    public String toString() {
        return "Clientes{" + "id_cliente=" + id_cliente + ", nombre_cliente=" + nombre_cliente + ", direccion_cliente=" + direccion_cliente + ", telefono_cliente=" + telefono_cliente + ", estado_cliente=" + estado_cliente + ", saldo_cliente=" + saldo_cliente + '}';
    }


}
