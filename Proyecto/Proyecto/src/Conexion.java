
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private String url="localhost/cfscores";
    private String usuario="root";
    private String clave="";
    
    private static Connection cnx = null;

    public Conexion() {
        try {
            obtener();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public  Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://"+this.url, this.usuario,this.clave);  
                System.out.println("$$$$$$$$$ Conectado Exitosamente $$$$$$$$ \n");
            } catch (SQLException ex) {
//                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
    
    public static void insertar(String sentencia) throws SQLException{
    PreparedStatement consulta = cnx.prepareStatement(sentencia);
    consulta.execute(sentencia);
    
    }
    
    public static void eliminar(String sentencia) throws SQLException{
    PreparedStatement consulta = cnx.prepareStatement(sentencia);
    consulta.execute(sentencia);
    
    }
    
    public static void actualizar(String sentencia) throws SQLException{
    PreparedStatement consulta = cnx.prepareStatement(sentencia);
    consulta.execute(sentencia);
    
    }
    
    public static ResultSet buscar(String sentencia) throws SQLException{
    ResultSet resultado=null;
    PreparedStatement consulta = cnx.prepareStatement(sentencia);
    resultado = consulta.executeQuery();      
    
    return resultado;
    }
    
}

