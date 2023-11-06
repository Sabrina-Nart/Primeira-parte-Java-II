
package crud;

import abstratas.Dados;
import java.sql.*;

/*
1-SQL
2-Statement / Prepared
3-Parametro
4-executar
*/
public class crudCategoria {
     // C - create (insert)
    public static int create(String nome, double valor) throws SQLException{
        String SQL="insert into categoria(nome,valor) values (?,?)";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setString(1, nome.toUpperCase());
        pst.setDouble(2, valor);
        return pst.executeUpdate();
    }
     // R - read (select)
    public static ResultSet read(int id) throws SQLException{
        String SQL="select * from categoria where id=? order by nome";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setInt(1, id);
        return pst.executeQuery();
    }
    public static ResultSet read() throws SQLException{
        String SQL="select * from categoria order by nome";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        return pst.executeQuery();        
    }
     // U - update
    public static int update(int id, String nome, double valor) throws SQLException{
        String SQL="update categoria set nome=?, valor=? where id=?";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setString(1, nome.toUpperCase());
        pst.setDouble(2, valor);
        pst.setInt(3, id);
        return pst.executeUpdate();        
    }
     // D - delete
    public static int delete(int id) throws SQLException{
        String SQL="delete from categoria where id="+id;
        Statement st = Dados.getConnection().createStatement();
        return st.executeUpdate(SQL);
    }
}
