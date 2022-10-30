/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.domain.Entregador;
import br.com.pizzaria.factory.ConnectionFactory;
//import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ferfe
 */
public class EntregadorDAO {
    
    public void salvar(Entregador e) throws SQLException, ClassNotFoundException{
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO entregador ");
        sql.append("(ent_nome, ent_status, ent_data_cad)");
        sql.append("VALUES (?, ?, ?)");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, e.getEnt_nome());
        comando.setString(2, e.getEnt_status());
        comando.setDate(3, new java.sql.Date (e.getEnt_data_cad().getTime()));
        comando.execute();
        
    }
    
    public void deletar(Entregador e) throws SQLException, ClassNotFoundException{
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE from entregador ");
        sql.append("WHERE ent_cod = ?");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, e.getEnt_cod());
        comando.execute();
    }
    
   public void update (Entregador e) throws SQLException, ClassNotFoundException{
       StringBuilder sql = new StringBuilder();
       sql.append("UPDATE entregador ");
       sql.append("SET ent_nome = ? , ent_status = ? , ent_data_cad = ?");
       sql.append("WHERE ent_cod = ?");
       
       Connection conexao = ConnectionFactory.conectar();
       
       PreparedStatement comando = conexao.prepareStatement(sql.toString());
       comando.setString(1, e.getEnt_nome());
       comando.setString(2, e.getEnt_status());
       comando.setDate(3, new java.sql.Date (e.getEnt_data_cad().getTime()));
       
       comando.setLong(4, e.getEnt_cod());
       comando.execute();
   }
    
   public Entregador BuscaPorCodigo (Entregador e) throws SQLException, ClassNotFoundException{
       
       StringBuilder sql = new StringBuilder();
       sql.append("SELECT ent_cod, ent_nome  ,ent_status ,ent_data_cad ");
       sql.append("FROM entregador ");
       sql.append("WHERE ent_cod = ? ");
       
       Connection conexao = ConnectionFactory.conectar();
       
       PreparedStatement comando = conexao.prepareStatement(sql.toString());
       comando.setLong(1, e.getEnt_cod());
       
       ResultSet resultado = comando.executeQuery();
       
       Entregador retorno =  null;
       
       if(resultado.next()){
           retorno = new Entregador();
           retorno.setEnt_cod(resultado.getLong("ent_cod"));
           retorno.setEnt_nome(resultado.getString("ent_nome"));
           retorno.setEnt_status(resultado.getString("ent_status"));
           
       }
        return retorno;
               
   }
   
   public ArrayList<Entregador> listarEntregador() throws SQLException, ClassNotFoundException{
       StringBuilder sql = new StringBuilder();
       sql.append("SELECT * FROM entregador ");
       sql.append("ORDER BY ent_cod ASC ");
       
       Connection conexao = ConnectionFactory.conectar();
       
       PreparedStatement comando = conexao.prepareStatement(sql.toString());
       
       ResultSet resultado = comando.executeQuery();
       
       ArrayList<Entregador> listaEntregador = new ArrayList<Entregador>();
       
       while(resultado.next()){
           Entregador ent = new Entregador();
           ent.setEnt_cod(resultado.getLong("ent_cod"));
           ent.setEnt_nome(resultado.getString("ent_nome"));
           ent.setEnt_status(resultado.getString("ent_status"));
           ent.setEnt_data_cad(resultado.getDate("ent_data_cad"));
           
           listaEntregador.add(ent);
           
       }
       return listaEntregador;
   }
    public static void main(String [] args) throws ClassNotFoundException, SQLException{
        
        //Lista tudo
        /*EntregadorDAO edaolista = new EntregadorDAO();
        try{
            ArrayList<Entregador> listaEntregador = edaolista.listarEntregador();
            for(Entregador e: listaEntregador){
                System.out.println("Entregador: "+ e);
            }
        }catch(SQLException e){
            e.printStackTrace();
                System.out.println("Ocorreu um erro ao tentar listar os entregadores");
        }
         EntregadorDAO edao = new EntregadorDAO();*/
        /*
       

        //select por codigo
        Entregador ec = new Entregador();
        ec.setEnt_cod(4l);
        
        Entregador ec2 = new Entregador();
        ec2.setEnt_cod(7l);
        
        try {
            Entregador eBusca1 = edao.BuscaPorCodigo(ec);
            Entregador eBusca2 = edao.BuscaPorCodigo(ec2);
             System.out.println("Dados dos entregador exibidos com sucesso");
             System.out.println("Resultado Busca 1  : "+ eBusca1);
              System.out.println("Resultado Busca 2 : "+ eBusca2);
        } catch (Exception ex) {
             System.out.println("Erro ao buscar um entregador"); 
                 ex.printStackTrace();
        }
        edao.BuscaPorCodigo(ec);
        */
        /*
        //editar
        Entregador ee = new Entregador();
        ee.setEnt_nome("Rafael");
        ee.setEnt_cod(4l);
        ee.setEnt_Status("Ativo");
        ee.setEnt_data_cad(new Date());
         try {
             edao.update(ee);
             System.out.println("Dados dos entregador editados com sucesso");
        } catch (Exception ex) {
             System.out.println("Erro ao editar um entregador"); 
                 ex.printStackTrace();
        }
        */
        
        /*
        //deletar 
        Entregador ed = new Entregador();
        ed.setEnt_cod(2L);
        
        
        try {
             edao.deletar(ed);
             System.out.println("Dados dos entregador deletados com sucesso");
        } catch (Exception ex) {
             System.out.println("Erro ao deletar um entregador"); 
                 ex.printStackTrace();
        }
*/
        
        //salvar
        /*
        Entregador es = new Entregador();
        es.setEnt_nome("Daniel");
        es.setEnt_Status("Ativo");
        es.setEnt_data_cad(new Date());
        
        
         try{
             edao.salvar(es);
             
             System.out.println("Dados dos entregador salvo com sucesso");
         }catch(SQLException ex){
              System.out.println("Erro ao salvar um entregador"); 
                 ex.printStackTrace();
                 }*/
        
    }
}
