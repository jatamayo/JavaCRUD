package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author jalej
 */
public class Conexion {
    Connection cx;
    String db ="proyecto_final";
    String url="jdbc:mysql://localhost:3306/" + db;
    String user="root";
    String password = "";
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cx=(Connection)DriverManager.getConnection(url, user, password);
            System.out.println("Conexion EXITOSA");
        }catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Conexion fallida");
            System.out.println(ex);
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
            System.out.println("Conexion terminada con EXITO");
        } catch (SQLException ex) {
            System.out.println("Conexion NO terminada");
        }
    }
    
    public static void main(String[] args){
        Conexion c=new Conexion();
        c.conectar();
        c.desconectar();
    }
}
