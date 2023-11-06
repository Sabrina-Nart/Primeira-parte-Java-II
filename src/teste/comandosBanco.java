
package teste;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;

/*
1-SQL
2-Statement / Prepared
3-Parametro
4-executar
*/
public class comandosBanco {
    public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        PreparedStatement pst = null;
        
        String url = "jdbc:postgresql://localhost:5432/bancoObjetos";
        String usr = "postgres";
        String pwd = "postgres";
        try {
            //
            connection = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Conectado");
        } catch (SQLException ex) {
            System.out.println("ERRO:"+ex.getMessage());
        }
        
        try{
            st = connection.createStatement();
            String nome="CURITIBA";
            String estado = "PR";
            //System.out.println(st.executeUpdate("insert into cidade (nome,estado) "
            //        + "values ('"+nome+"','"+estado+"')"));
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
        
        try{
            pst=connection.prepareStatement("insert into cliente "
                    + "(nome,nascimento,cpf,id_cidade) "
                    + "values (?,?,?,?)");
            pst.setString(1, "JOSE DA SILVA");
            pst.setObject(2, LocalDate.of(2000, Month.MARCH, 10));
            pst.setString(3, "123.456.789-00");
            pst.setInt(4, 333);
            //
            //System.out.println(pst.executeUpdate());
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
        
        //select
        try{
            PreparedStatement prep = 
            connection.prepareStatement("select * from cidade");
            ResultSet rs = prep.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nome"));
                System.out.println(rs.getString("estado"));
            }
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
        
    }
    
}
