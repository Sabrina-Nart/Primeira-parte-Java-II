
package abstratas;

import java.sql.*;

public class Dados {
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/bancoObjetos";
        String usr = "postgres";
        String pwd = "postgres";
        if (connection==null){
            connection = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Banco Conectado");
        }
        return connection;
    }    
} 
        