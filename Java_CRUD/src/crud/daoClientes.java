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
public class daoClientes {
    Conexion c;
    
    public daoClientes(){
        c = new Conexion();
    }
    
    // CREATE NEW CLIENT
    public boolean create(Clientes p){
        try {
            String sql="insert into proyecto_final.clientes (nombre_cliente, direccion_cliente, telefono_cliente, estado_cliente, saldo_cliente) values (?,?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre_cliente());
            ps.setString(2, p.getDireccion_cliente());
            ps.setInt(3, p.getTelefono_cliente());
            ps.setString(4, p.getEstado_cliente());
            ps.setDouble(5, p.getSaldo_cliente());
            ps.execute();
            ps.close();
            ps = null;            
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("CLIENTE NO SE INSERTO");
            return false;
        }
    }
    
    //READ ALL CLIENTS
    public ArrayList<Clientes> read(){
         ArrayList<Clientes> lista = new ArrayList<Clientes>();
        try {
            String sql = "select * from proyecto_final.clientes";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Clientes mycliente = new Clientes();
                
                mycliente.setId_cliente(rs.getInt("Id_cliente"));
                mycliente.setNombre_cliente(rs.getString("Nombre_cliente"));
                mycliente.setDireccion_cliente(rs.getString("Direccion_cliente"));
                mycliente.setTelefono_cliente(rs.getInt("Telefono_cliente"));
                mycliente.setEstado_cliente(rs.getString("Estado_cliente"));
                mycliente.setSaldo_cliente(rs.getDouble("Saldo_cliente"));
                
                lista.add(mycliente);
            }
            ps.close();
            ps=null;
        } catch (SQLException ex) {
            System.out.println("Error obtener clientes");
            System.out.println(ex);
        }
        return lista;
    }
    
    
    //DELETE METHOD
    public boolean delete(int id){
        try {
            String sql = "delete from proyecto_final.clientes where id_cliente = ?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR al eliminar cliente");
            System.out.println(ex);
            return false;
        }        
    }
    
    //UPDATE
    public boolean update(Clientes p){
        try{
            String sql="update proyecto_final.clientes set nombre_cliente=?, direccion_cliente=?, telefono_cliente=?, estado_cliente=?, saldo_cliente=? where id_cliente=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre_cliente());
            ps.setString(2, p.getDireccion_cliente());
            ps.setInt(3, p.getTelefono_cliente());
            ps.setString(4, p.getEstado_cliente());
            ps.setDouble(5, p.getSaldo_cliente());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
            
        }catch(SQLException ex){
            return false;
        }
    }
    
    //READ CLIENT
    public Clientes read(int id){
        Clientes mycliente = new Clientes();
        try {
            String sql = "select * from proyecto_final.clientes where id_cliente=?";
            PreparedStatement ps = c.conectar().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){          
                mycliente.setId_cliente(rs.getInt("Id_cliente"));
                mycliente.setNombre_cliente(rs.getString("Nombre_cliente"));
                mycliente.setDireccion_cliente(rs.getString("Direccion_cliente"));
                mycliente.setTelefono_cliente(rs.getInt("Telefono_cliente"));
                mycliente.setEstado_cliente(rs.getString("Estado_cliente"));
                mycliente.setSaldo_cliente(rs.getDouble("Saldo_cliente"));
            }
            ps.close();
            ps=null;
        } catch (SQLException ex) {
            System.out.println("Error obtener clientes/update");
            System.out.println(ex);
        }
        return mycliente;
    }
    
    
}
