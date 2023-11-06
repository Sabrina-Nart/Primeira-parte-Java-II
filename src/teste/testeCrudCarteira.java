
package teste;

import crud.crudCarteira;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;

public class testeCrudCarteira {
    public static void main(String[] args) {
        try{
            //create
            System.out.println(crudCarteira.create(1, LocalDate.of(2023, Month.MARCH, 1), 2, true));
            System.out.println(crudCarteira.create(1, LocalDate.of(2022, Month.DECEMBER, 15), 1, true));
            System.out.println(crudCarteira.create(1, LocalDate.of(2022, Month.APRIL, 11), 4, false));
            System.out.println(crudCarteira.create(1, LocalDate.of(2020, Month.MARCH, 19), 2, false));
            //update
            System.out.println(crudCarteira.update(2, 1, LocalDate.of(2022, Month.DECEMBER, 15), 2, false));
            //delete
            System.out.println(crudCarteira.detele(3));
            //read com parametro
            ResultSet rs = crudCarteira.read(4);
            if (rs.next()){
                System.out.println(rs.getInt("id") + "\t" + 
                        rs.getInt("id_cliente") + "\t" + 
                        rs.getInt("id_categoria") + "\t" + 
                        rs.getBoolean("ativo"));
            }else{
                System.out.println("Não localizado");
            }
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
    }
}
