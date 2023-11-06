
package crud;

import abstratas.Dados;
import java.time.LocalDate;
import java.sql.*;

public class crudCarteira {
    //c - create
    public static int create(int id_cliente, LocalDate validade, int id_categoria, boolean ativo) throws SQLException{
        String SQL="insert into carteira (id_cliente, validade, id_categoria, ativa) values (?,?,?,?)";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setInt   (1, id_cliente);
        pst.setObject(2, validade);
        pst.setInt   (3, id_categoria);
        pst.setObject(4, ativo);
        return pst.executeUpdate();
    }
    //r - read
    public static ResultSet read(int id) throws SQLException{
        String SQL="select carteira.*, cliente.nome as nomecliente, categoria.nome as nomecategoria from carteira where id=?";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setInt(1, id);
        return pst.executeQuery();
    }
    public static ResultSet read() throws SQLException{
        String SQL="select carteira.*, cliente.nome as nomecliente, categoria.nome as nomecategoria from carteira order by carteira.validade";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        return pst.executeQuery();
    }    
    //u - update
    public static int update(int id, int id_cliente, LocalDate validade, int id_categoria, boolean ativo) throws SQLException{
        String SQL="update carteira set id_cliente=?, validade=?, id_categoria=?, ativa=? where id=?";
        PreparedStatement pst = Dados.getConnection().prepareStatement(SQL);
        pst.setInt   (1, id_cliente);
        pst.setObject(2, validade);
        pst.setInt   (3, id_categoria);
        pst.setObject(4, ativo);
        pst.setInt   (5, id);
        return pst.executeUpdate();
        
    }
    //d - delete
    public static int detele(int id) throws SQLException{
        String SQL="delete from carteira where id="+id;
        Statement st = Dados.getConnection().createStatement();
        return st.executeUpdate(SQL);        
    }
    
}
