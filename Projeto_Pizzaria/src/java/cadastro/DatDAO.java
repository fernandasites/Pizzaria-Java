/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import br.com.pizzaria.domain.Cliente;
import cadastro.Datt;
import br.com.pizzaria.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.YEAR;
import java.util.Date;

/**
 *
 * @author ferfe
 */
public class DatDAO {
    public void salvar(Datt d) throws SQLException, ClassNotFoundException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO dat ");
        sql.append("(datcol)");
        sql.append("VALUES (?) ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        //comando = stmt
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setDate(1, new java.sql.Date(d.getDatacol().getTime()) );
        comando.executeUpdate(); 
        
    }
     public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException{
        
        Datt d1 = new Datt();
        
        d1.setDatacol(new Date());
        
        DatDAO cdao = new DatDAO();
        cdao.salvar(d1);
         System.out.println("data "+d1);
        try {
             cdao.salvar(d1); 
             System.out.println(" Data salvo com sucesso");
        }catch (SQLException ex){
            System.out.println("Erro ao salvar uma data");
            ex.printStackTrace();
        }
     
    /*
        Calendar hoje = Calendar.getInstance();
        int dia = hoje.get(DAY_OF_MONTH);
        int ano = hoje.get(YEAR);
        int mes = hoje.get(MONTH);
        
       
         hoje.set(2018, 1, 1);
         
         System.out.printf("hoje é %02d/%02d/%d", dia, (mes+1), ano);
        
        //cal.setTime(Calendar.MINUTE);
        /*int dia;
        dia = cal.get(Calendar. YEAR);
         System.out.println("Data " + dia);
         
         Calendar calendar = Calendar.getInstance();
         cal.set(Calendar.YEAR,         2014);
         cal.set(Calendar.MONTH,        05);
         cal.set(Calendar.DAY_OF_MONTH, 29);
         Date dt = calendar.getTime();
         System.out.println("Data " + dt);
         
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String str = "08/03/2012";   // Data como String
            Date data = null;
                    try {
                            data = format.parse(str); 
	} 
            catch (ParseException e) {
                       System.out.println("Data no formato errado");
                       e.printStackTrace();
               }
    	System.out.println("Data = " + data);
         // formato da data 
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 

        // aqui você passa o Date para converter
        String result = fmt.format(new Date()); 

        // este é uma data armazenada
        //java.util.Date dt = …; 

        // Dentro de um exemplo de PreparedStatement
        //pst.setDate(5, new java.sql.Date(dt.getTime()) ); 

*/
     }
      
}
