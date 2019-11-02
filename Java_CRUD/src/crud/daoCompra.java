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
public class daoCompra{
    Conexion c;
    
    public daoCompra(){
        c = new Conexion();
    }
    
    // CREATE NEW COMPRA
    public boolean create(Compra com){
        try {
            String sql="insert into proyecto_final.compras (id_proveedor, nombre_articulo, cantidad_articulo, precio_articulo) values (?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, com.getId_proveedor());
            ps.setString(2, com.getNombre_articulo());
            ps.setInt(3, com.getCantidad_articulo());
            ps.setInt(4, com.getPrecio_articulo());
            ps.execute();
            ps.close();
            ps = null;            
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("COMPRA NO SE INSERTO");
            return false;
        }
    }
    
    //READ ALL COMPRAS
    public ArrayList<Compra> read(){
        ArrayList<Compra> lista = new ArrayList<Compra>();
        try {
            String sql = "select * from proyecto_final.compras";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Compra myCompra = new Compra();
                
                myCompra.setId_compra(rs.getInt("Id_compra"));
                myCompra.setId_proveedor(rs.getInt("Id_proveedor"));                
                myCompra.setNombre_articulo(rs.getString("Nombre_articulo"));
                myCompra.setCantidad_articulo(rs.getInt("Cantidad_articulo"));
                myCompra.setPrecio_articulo(rs.getInt("Precio_articulo"));
                
                lista.add(myCompra);
            }
            ps.close();
            ps=null;
        } catch (SQLException ex) {
            System.out.println("Error obtener compras");
            System.out.println(ex);
        }
        return lista;
    }
    
    
    //DELETE COMPRA
    public boolean delete(int id){
        try {
            String sql = "delete from proyecto_final.compras where id_compra = ?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR al eliminar comrpa");
            System.out.println(ex);
            return false;
        }        
    }
    
    //UPDATE
    public boolean update(Compra com){
        try{
            String sql="update proyecto_final.compras set id_proveedor=?, nombre_articulo=?, cantidad_articulo=?, precio_articulo=? where id_compra=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1, com.getId_proveedor());
            ps.setString(2, com.getNombre_articulo());
            ps.setInt(3, com.getCantidad_articulo());
            ps.setInt(4, com.getPrecio_articulo());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
            
        }catch(SQLException ex){
            return false;
        }
    }
    
    //READ COMPRA
    public Compra read(int id){
        Compra mycompra = new Compra();
        try {
            String sql = "select * from proyecto_final.compras where id_ccompra=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){          
                mycompra.setId_compra(rs.getInt("Id_cliente"));
                mycompra.setId_proveedor(rs.getInt("Id_proveedor"));
                mycompra.setNombre_articulo(rs.getString("Nombre_articulo"));
                mycompra.setCantidad_articulo(rs.getInt("Cantidad_articulo"));
                mycompra.setPrecio_articulo(rs.getInt("Precio_articulo"));
            }
            ps.close();
            ps=null;
        } catch (SQLException ex) {
            System.out.println("Error obtener compras/update");
            System.out.println(ex);
        }
        return mycompra;
    }
}
