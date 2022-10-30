/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.domain.Cardapio;
import br.com.pizzaria.factory.ConnectionFactory;
//import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ferfe
 */
public class CardapioDAO {
    
    public void salvar(Cardapio c) throws SQLException, ClassNotFoundException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO cardapio ");
        sql.append("(car_descricao, car_tipo, car_valor)");
        sql.append("VALUES (? , ? ,?)");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        
        comando.setString(1, c.getCar_descricao());
        comando.setString(2, c.getCar_tipo());
        comando.setDouble(3, c.getCar_valor());
        
        comando.execute();
         
    }
    
    public void deletar(Cardapio c) throws SQLException, ClassNotFoundException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE from cardapio ");
        sql.append("WHERE car_cod = ? ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        
        comando.setLong(1, c.getCar_cod());
        comando.execute();
    }
    
    public void update(Cardapio c) throws SQLException, ClassNotFoundException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE cardapio ");
        sql.append("SET car_descricao = ? , car_tipo = ? , car_valor = ? ");
        sql.append("WHERE car_cod = ? ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, c.getCar_descricao());
        comando.setString(2, c.getCar_tipo());
        comando.setDouble(3, c.getCar_valor());
        
        comando.setLong(4, c.getCar_cod());
        comando.execute();
        
    }
    public Cardapio BuscaPorCodigo(Cardapio c) throws SQLException, ClassNotFoundException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM cardapio ");
        sql.append("WHERE car_cod = ? ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, c.getCar_cod());
        
        ResultSet resultado = comando.executeQuery();
        
        Cardapio retorno = null;
        
        if(resultado.next()){
            retorno = new Cardapio();
            retorno.setCar_cod(resultado.getLong("car_cod"));
            retorno.setCar_descricao(resultado.getString("car_descricao"));
            retorno.setCar_tipo("car_tipo");
            
        }        
        return retorno;
        
    }
    //metodo listar
    public ArrayList<Cardapio> listarCardapio() throws SQLException, ClassNotFoundException{
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM cardapio ");
        sql.append("ORDER BY car_cod ASC ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        
        ArrayList<Cardapio> listaCardapio = new ArrayList<Cardapio>();
        
        while (resultado.next()){
            Cardapio card = new Cardapio();
            card.setCar_cod(resultado.getLong("car_cod"));
            card.setCar_descricao(resultado.getString("car_descricao"));
            card.setCar_tipo(resultado.getString("car_tipo"));
            card.setCar_valor(resultado.getDouble("car_valor"));
            
            listaCardapio.add(card);
        }
        return listaCardapio;
        
    }
    
    public static void main (String[] args) throws SQLException, ClassNotFoundException{
        
        //Lista tudo 
        try {
        CardapioDAO cdaolista = new CardapioDAO();
        ArrayList<Cardapio> listaCardapio = cdaolista.listarCardapio();
            for(Cardapio c: listaCardapio){
                System.err.println("Cardapio: "+ c);
            }
        }catch(SQLException e){
                e.printStackTrace();
                System.out.println("Ocorreu um erro ao tentar listar o cardapio");
            }
       
    
    //salvar
    /*
        CardapioDAO cdao = new CardapioDAO();
         Cardapio cs = new Cardapio();
         cs.setCar_descricao("Pizza Calabresa");
         cs.setCar_tipo("Pizza");
         cs.setCar_valor(35.90D);
         
         try {
              cdao.salvar(cs);
              System.out.println("Cardapio salvo om sucesso");
        } catch (Exception e) {
             System.out.println("Erro ao salvar o cardápio");
            e.printStackTrace();
            }
    */
    }

        
    
    }
       
         
         //select
        /* Cardapio cs = new Cardapio();
         cs.setCar_cod(4L);
         try {
            cdao.BuscaPorCodigo(cs);
            Cardapio cBusca1 = cdao.BuscaPorCodigo(cs);
             System.out.println("Resultado da Busca1: " +cBusca1);
            System.out.println("Cardapio selecionado com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao selecionar o cardapio ");
             ex.printStackTrace();
              cdao.BuscaPorCodigo(cs);
        }*/
    
        /* 
         //editar
         Cardapio ce = new Cardapio();
         ce.setCar_descricao("Hamburger");
         ce.setCar_tipo("Lanches");
         ce.setCar_valor(12.90);
         
         ce.setCar_cod(4L);
         
         try {
            cdao.update(ce);
            System.out.println("Cardapio editado com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao editar o cardapio ");
             ex.printStackTrace();
        }
         */
         /*
         //deletar
         Cardapio cd = new Cardapio();
         cd.setCar_cod(3L);
         
         try {
            cdao.deletar(cd);
             System.out.println("Cardapio deletado com sucesso");
        } catch (Exception ex) {
             System.out.println("Erro ao deletar o cardapio ");
             ex.printStackTrace();
        }
         */
         
         
    
      
    

