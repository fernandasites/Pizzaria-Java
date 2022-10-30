/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.domain.Cliente;
import br.com.pizzaria.domain.Entregador;
import br.com.pizzaria.domain.Funcionario;
import br.com.pizzaria.domain.Pedido;
import br.com.pizzaria.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ferfe
 */
public class PedidoDAO {
    
    public void salvar(Pedido p) throws SQLException, ClassNotFoundException{
        
        StringBuilder sql = new  StringBuilder();
        sql.append("INSERT INTO pedido");
        sql.append("(ped_data, ped_total, ped_cli_cod, ped_fun_cod, ped_ent_cod, ped_status )");
        sql.append("VALUES (?, ?, ?, ?, ?, ?)");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        
        comando.setDate(1, new java.sql.Date (p.getPed_data().getTime()));
        comando.setDouble(2, p.getPed_total());
        comando.setLong(3, p.getCliente().getCli_codigo());
        comando.setLong(4, p.getFuncionario().getFun_cod());
        comando.setLong(5, p.getEntregador().getEnt_cod());
        comando.setString(6, p.getStatus());
       
        comando.execute();
        
    }
    public void deletar(Pedido p) throws SQLException, ClassNotFoundException{
        
        StringBuilder sql = new  StringBuilder();
        sql.append("DELETE from pedido ");
        sql.append("WHERE ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?)");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        
        comando.setDate(1, new java.sql.Date (p.getPed_data().getTime()));
        comando.setDouble(2, p.getPed_total());
        comando.setLong(3, p.getCliente().getCli_codigo());
        comando.setLong(4, p.getFuncionario().getFun_cod());
        comando.setLong(5, p.getEntregador().getEnt_cod());
        comando.setString(6, p.getStatus());
       
        comando.execute();
        
    }
     public void update(Pedido p) throws SQLException, ClassNotFoundException{
        StringBuilder sql= new StringBuilder();
        sql.append("UPDATE pedido ");
        sql.append("SET ped_cod = ? , ped_data = ? , ped_total = ? , ped_cli_cod = ? , ped_fun_cod = ?, ped_ent_cod, ped_status ");
        sql.append("WHERE ped_cod= ?");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, p.getPed_cod());
        comando.setDate(2, new java.sql.Date (p.getPed_data().getTime()));
        comando.setDouble(3, p.getPed_total());
        comando.setLong(4, p.getCliente().getCli_codigo());
        comando.setLong(5, p.getFuncionario().getFun_cod());
        comando.setLong(6, p.getEntregador().getEnt_cod());
        comando.setString(7, p.getStatus());
        
        comando.setLong(8, p.getPed_cod());
        comando.executeUpdate();
        
    }
     public Pedido BuscaPorCodigo(Pedido p)throws SQLException, ClassNotFoundException  {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ped_cod = ? , ped_data = ? , ped_total = ? , ped_cli_cod = ? , "
                + "ped_fun_cod = ?, ped_ent_cod, ped_status  ");
        sql.append("FROM pedido ");
        sql.append("WHERE ped_cod = ? ");
        
        Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, p.getPed_cod());
        
        ResultSet resultado = comando.executeQuery();
        
        Pedido retorno = null;
        
            if(resultado.next()){
                   retorno = new Pedido();
                   retorno.setPed_cod(resultado.getLong("ped_cod"));
                   retorno.setPed_data(resultado.getDate("ped_data"));
                   retorno.setPed_total(resultado.getDouble("ped_total"));
                   //retorno.getCliente().getCli_codigo()
                        //   codigo do cliente
                   //retorno.funcinario.codigo do funcionario
                   //retorno.entregador.codigo do entregador
                   //retorno.Status
            }
            return retorno;
    }
     public static void main(String[] args) throws ClassNotFoundException{}
     
     Cliente cs1 = new Cliente();
     Funcionario fs1 = new Funcionario();
     Entregador es1 = new Entregador();
     Pedido ps1 = new Pedido();
     
     //ps1.setPed_data(new Date());

     
}
