package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jalej
 */
public class daoFacturacion {
    Conexion c;
    boolean StatusBalance;
    
    public daoFacturacion(){
        c = new Conexion();
    }
    
    // CREATE NEW FACTURA
    public boolean create(Facturacion fac){
        System.out.println("SUPER CRACK ********************");
        try {
            String sql="insert into proyecto_final.clientes (nombre_cliente, direccion_cliente, telefono_cliente, estado_cliente, saldo_cliente) values (?,?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, fac.getId_cliente());
            ps.setInt(2, fac.getId_compra());
            ps.execute();
            ps.close();
            ps = null;            
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("FACTURA NO SE CREO");
            return false;
        }
    }
    
    //READ ALL FACTURAS
    public ArrayList<Facturacion> read(){
         ArrayList<Facturacion> lista = new ArrayList<Facturacion>();
        try {
            String sql = "select * from proyecto_final.facturacion";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Facturacion myfactura = new Facturacion();
   
                myfactura.setId_cliente(rs.getInt("Id_cliente"));
                myfactura.setId_compra(rs.getInt("Id_compra"));
                
                lista.add(myfactura);
            }
            ps.close();
            ps=null;
        } catch (SQLException ex) {
            System.out.println("Error obtener facturas");
            System.out.println(ex);
        }
        return lista;
    }
    
    
}
