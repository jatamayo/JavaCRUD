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
public class daoInventario {
    Conexion c;
    
    int idCompra;
    
    public daoInventario(){
        c = new Conexion();
    }
    
  
    
    //READ ALL CLIENTS
    public ArrayList<Inventario> read(){
         ArrayList<Inventario> lista = new ArrayList<Inventario>();
        try {
            String sql = "select * from proyecto_final.inventario";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Inventario myinventario = new Inventario();
                
                myinventario.setId_inventario(rs.getInt("Id_inventario"));
                myinventario.setId_compra(rs.getInt("Id_compra"));
                
                lista.add(myinventario);
            }
            ps.close();
            ps=null;
        } catch (SQLException ex) {
            System.out.println("Error obtener inventario");
            System.out.println(ex);
        }
        return lista;
    }
    
    // CREATE NEW INVENTARIO
    public boolean create(Inventario inv){
        try {
            String sql="insert into proyecto_final.inventario (id_compra) values (?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, idCompra);
            ps.execute();
            ps.close();
            ps = null;            
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("INVENTARIO NO SE INSERTO");
            return false;
        }
    }
    
    // GET ID COMPRA
    public void getIdCompra(){
        System.out.println("************ medio crack ***********");
        try {
            String sql="select id_compra as id from proyecto_final.compras as c order by id_compra desc limit 1";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                idCompra = (rs.getInt("id"));
            }
            ps.close();
            ps = null;            
        } catch (SQLException ex) {
            System.out.println("NO SE OBTUVO ID COMPRA");
            System.out.println(ex);
        }
    }
    
}
