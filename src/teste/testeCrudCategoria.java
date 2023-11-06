
package teste;

import crud.crudCategoria;
import java.sql.SQLException;
import java.sql.*;

public class testeCrudCategoria {
    public static void main(String[] args) {
        try{
            //create
            //System.out.println(crudCategoria.create("plano básico", 50));
            //System.out.println(crudCategoria.create("plano intermediario", 75));
            //System.out.println(crudCategoria.create("plano plus", 100));
            //System.out.println(crudCategoria.create("plano inicial", 10));
            //update
            //System.out.println(crudCategoria.update(5, "plano premium", 125));
            //delete
            //System.out.println(crudCategoria.delete(3));
            //read com parametro
            ResultSet rs = crudCategoria.read(4);
            if (rs.next()){
                System.out.println(rs.getInt("id") + "\t" + 
                        rs.getString("nome") + "\t" + 
                        rs.getDouble("valor"));
            }else{
                System.out.println("Não localizado");
            }
            //read sem parametro
            rs = crudCategoria.read();
            while (rs.next()){
                System.out.println(rs.getInt("id") + "\t" + 
                        rs.getString("nome") + "\t" + 
                        rs.getDouble("valor"));                
            }
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
        
    }
    
}
