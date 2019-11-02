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
public class daoProveedor {
    Conexion c;
    
    public daoProveedor(){
        c = new Conexion();
    }
    
  
    
    //READ ALL CLIENTS
    public ArrayList<Proveedor> read(){
         ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
        try {
            String sql = "select * from proyecto_final.proveedores";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Proveedor myproveedor = new Proveedor();
                
                myproveedor.setId_proveedor(rs.getInt("Id_proveedor"));
                myproveedor.setNombre_proveedor(rs.getString("Nombre_proveedor"));
                myproveedor.setDireccion_proveedor(rs.getString("Direccion_proveedor"));
                myproveedor.setTelefono_proveedor(rs.getInt("Telefono_proveedor"));
                
                lista.add(myproveedor);
            }
            ps.close();
            ps=null;
        } catch (SQLException ex) {
            System.out.println("Error obtener proveedores");
            System.out.println(ex);
        }
        return lista;
    }
    
}
