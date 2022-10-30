/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.domain.Cliente;
import br.com.pizzaria.factory.ConnectionFactory;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author ferfe
 */
public class ClienteDAO {
    
    public void salvar(Cliente c) throws SQLException, ClassNotFoundException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO cliente ");
       // sql.append("(cli_nome, cli_rua");
        sql.append("(cli_nome, cli_rua, cli_bairro, cli_telefone, cli_data_cad)");
        //sql.append("VALUES (?,?) ");
        sql.append("VALUES (?,?,?,?,?) ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        
        comando.setString(1, c.getCli_nome());
        comando.setString(2, c.getCli_rua());
        comando.setString(3, c.getCli_bairro());
        comando.setString(4, c.getCli_telefone());
        comando.setDate(5, new java.sql.Date (c.getCli_data_cad().getTime()));
        comando.executeUpdate();
        
    }
    
    public void deletar(Cliente c) throws SQLException, ClassNotFoundException{
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE from cliente ");
        sql.append("WHERE cli_cod = ? ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, c.getCli_codigo());
        comando.executeUpdate();   
    }
    public void update(Cliente c) throws SQLException, ClassNotFoundException{
        StringBuilder sql= new StringBuilder();
        sql.append("UPDATE cliente ");
        sql.append("SET cli_nome = ? , cli_rua = ? , cli_bairro = ? , cli_telefone = ? , cli_data_cad = ? ");
        sql.append("WHERE cli_cod= ?");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, c.getCli_nome());
        comando.setString(2, c.getCli_rua());
        comando.setString(3, c.getCli_bairro());
        comando.setString(4, c.getCli_telefone());
        comando.setDate(5, new java.sql.Date (c.getCli_data_cad().getTime()));
        
        comando.setLong(6, c.getCli_codigo());
        comando.executeUpdate();
        
    }
    public Cliente BuscaPorCodigo(Cliente c)throws SQLException, ClassNotFoundException  {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT cli_cod, cli_nome, cli_rua, cli_bairro, cli_telefone, cli_data_cad ");
        sql.append("FROM cliente ");
        sql.append("WHERE cli_cod = ? ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, c.getCli_codigo());
        
        ResultSet resultado = comando.executeQuery();
        
        Cliente retorno = null;
        
            if(resultado.next()){
                   retorno = new Cliente();
                   retorno.setCli_codigo(resultado.getLong("cli_cod"));
                   retorno.setCli_nome(resultado.getString("cli_nome"));
                   retorno.setCli_rua(resultado.getString("cli_rua"));
                   retorno.setCli_bairro(resultado.getString("cli_bairro"));
                   retorno.setCli_telefone(resultado.getString("cli_telefone"));
                   retorno.setCli_data_cad(resultado.getDate("cli_data_cad"));
            }
            return retorno;
    }
    public ArrayList<Cliente> listarCliente() throws SQLException, ClassNotFoundException{
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM cliente ");
        //ordenar
        sql.append("ORDER BY cli_cod ASC ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        
        ResultSet resultado = comando.executeQuery();
        
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        
        while(resultado.next()){
            Cliente c = new Cliente();
            c.setCli_codigo(resultado.getLong("cli_cod"));
            c.setCli_nome(resultado.getString("cli_nome"));
            c.setCli_rua(resultado.getString("cli_rua"));
            c.setCli_bairro(resultado.getString("cli_bairro"));
            c.setCli_telefone(resultado.getString("cli_telefone"));
            c.setCli_data_cad(resultado.getDate("cli_data_cad"));
            
            listaCliente.add(c);
        }
         return listaCliente;
        
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        
        //Lista tudo
        /*
        ClienteDAO  cdaolista = new ClienteDAO();
        try{
           ArrayList<Cliente> listaCliente = cdaolista.listarCliente();
           for(Cliente c: listaCliente){
               System.out.println("Resultado: "+ c);
           }
        }catch(SQLException e){
             System.out.println("Ocorreu um erro ao tentar listar os entregadores");
            e.printStackTrace();
        }*/
        /*
        //Busca por Codigo
        Cliente c4 = new Cliente();
        c4.setCli_codigo(28L);
        
        Cliente c5 = new Cliente();
        c5.setCli_codigo(5L);
        
        ClienteDAO cdao6 = new ClienteDAO();
        
        try{
            Cliente cBusca= cdao6.BuscaPorCodigo(c4);
            Cliente cBusca1 = cdao6.BuscaPorCodigo(c5);
            System.out.println("Resultado 2 : "+ cBusca);
            System.out.println("Resultado 2 : "+ cBusca1);
        }catch (ClassNotFoundException ex){
            System.out.println("Erro ao buscar um Cliente");
            ex.printStackTrace();         
        }
       */
        //editar
        /*
        Cliente c3 = new Cliente();
        c3.setCli_nome("Maria");
        c3.setCli_rua("rua : Synval");
        c3.setCli_bairro("Augusta");
        c3.setCli_telefone("41-99999-9999");
        c3.setCli_data_cad(new Date());
        c3.setCli_codigo(28L);
        
        ClienteDAO cdao3 = new ClienteDAO();
        
        try{
            cdao3.update(c3);
            System.out.println("Cliente atualizado com sucesso");
        }catch(ClassNotFoundException ex){
             System.out.println("Erro ao editar Cliente");
            ex.printStackTrace();  
        }
        */
        
       /*
        //deletar
        Cliente c2 = new Cliente();
        c2.setCli_codigo(20l);
        
        ClienteDAO cdao2 = new ClienteDAO();
        
        try{
            cdao2.deletar(c2);
            System.out.println("Dados deletado com sucesso");
        }catch (SQLException ex){
             ex.printStackTrace();
            System.out.println("Erro ao deletar");
        }
        */
        //salvar
        Cliente c1 = new Cliente();
        c1.setCli_nome("Fer ");
        c1.setCli_rua("fer");
        c1.setCli_bairro("fer");
        c1.setCli_telefone("41-77777-9999");
        c1.setCli_data_cad(new Date());
        
        ClienteDAO cdao3 = new ClienteDAO();
        try {
             cdao3.salvar(c1); 
             System.out.println("Dados dos clientes salvo com sucesso");
        }catch (SQLException ex){
            System.out.println("Erro ao salvar um cliente");
            ex.printStackTrace();
        }
       
        
       
        //c1.setCli_data_cad(1989-05-02);
        /*
        data
        LocalDate data = ...
        // gravar o LocalDate
        PreparedStatement ps = ...
        ps.setObject(1, data);

        // obter o LocalDate do banco
        ResultSet rs = ...
        LocalDate data = rs.getObject(1, LocalDate.class);        
*/
        
        
        
    }
}
