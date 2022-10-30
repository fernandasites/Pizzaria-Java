/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.domain.Funcionario;
import br.com.pizzaria.factory.ConnectionFactory;
import com.sun.jndi.ldap.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ferfe
 */
public class FuncionarioDAO {
   
    public void salvar(Funcionario f) throws SQLException, ClassNotFoundException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO funcionario ");
        sql.append("(fun_nome, fun_cargo, fun_data_cad)");
        sql.append("VALUES (?,?,?) ");
        
        java.sql.Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getFun_nome());
        comando.setString(2, f.getFun_cargo());
        comando.setDate(3, new java.sql.Date (f.getFun_data_cad().getTime()));
        comando.executeUpdate();
        
    }
    public void deletar(Funcionario f) throws SQLException, ClassNotFoundException {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE from funcionario ");
        sql.append("WHERE fun_cod = ?");
        
        java.sql.Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setLong(1, f.getFun_cod());
        comando.executeUpdate();
        
    }
     public void update(Funcionario f) throws SQLException, ClassNotFoundException{
        StringBuilder sql= new StringBuilder();
        sql.append("UPDATE funcionario ");
        sql.append("SET fun_nome = ? , fun_cargo = ? , fun_data_cad = ? ");
        sql.append("WHERE fun_cod= ? ");
        
        java.sql.Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, f.getFun_nome());
        comando.setString(2, f.getFun_cargo());
        comando.setDate(3, new java.sql.Date (f.getFun_data_cad().getTime()));
        
        comando.setLong(4, f.getFun_cod());
        comando.executeUpdate();
        
    }
     public Funcionario BuscaPorCodigo(Funcionario f) throws SQLException, ClassNotFoundException{
         StringBuilder sql = new StringBuilder();
         sql.append("SELECT fun_cod, fun_nome, fun_cargo, fun_data_cad ");
         sql.append("FROM funcionario ");
         sql.append("WHERE fun_cod = ? ");
         
         java.sql.Connection conexao = ConnectionFactory.conectar();
         
         PreparedStatement comando = conexao.prepareStatement(sql.toString());
        
         comando.setLong(1, f.getFun_cod());
        
         ResultSet resultado = comando.executeQuery();
         
         Funcionario retorno = null;
         
         if(resultado.next()){
             retorno = new Funcionario();
             retorno.setFun_cod(resultado.getLong("fun_cod"));
             retorno.setFun_nome(resultado.getString("fun_nome"));
             retorno.setFun_cargo(resultado.getString("fun_cargo"));
             retorno.setFun_data_cad(resultado.getDate("fun_data_Cad"));
             
         }
         return retorno;
     }
    public ArrayList<Funcionario> listarFuncionario() throws SQLException, ClassNotFoundException{
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM funcionario ");
        sql.append("ORDER BY fun_cod ASC ");
        
        java.sql.Connection conexao = ConnectionFactory.conectar();
        
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        
        ResultSet resultado = comando.executeQuery();
        
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        while(resultado.next()){
            Funcionario func = new Funcionario();
            func.setFun_cod(resultado.getLong("fun_cod"));
            func.setFun_nome(resultado.getString("fun_nome"));
            func.setFun_cargo(resultado.getString("fun_cargo"));
            func.setFun_data_cad(resultado.getDate("fun_data_cad"));
            
            listaFuncionario.add(func);
        }
        return listaFuncionario;
    }

        public static void main(String[] args) throws SQLException, ClassNotFoundException{
            
            //Lista tudo
            /*FuncionarioDAO fdaolista = new FuncionarioDAO();
            try{
                ArrayList<Funcionario> listaFuncionario = fdaolista.listarFuncionario();
                for(Funcionario f: listaFuncionario){
                    System.out.println("Entregador: "+ f);
                }
            }catch(SQLException e){
                e.printStackTrace();
                System.out.println("Ocorreu um erro ao tentar listar os funcionarios");
            }*/
        }
        }
            /*
            //select 
            Funcionario fl = new Funcionario();
            fl.setFun_cod(6L);
            
            Funcionario fl1 = new Funcionario();
            fl1.setFun_cod(2L);
            
            FuncionarioDAO fdao = new FuncionarioDAO();
            
            try{
               Funcionario fBusca1 = fdao.BuscaPorCodigo(fl);
               Funcionario fBusca2 = fdao.BuscaPorCodigo(fl1);
               System.out.println("Resultado Busca 1  : "+ fBusca1);
               System.out.println("Resultado Busca 2 : "+ fBusca2);
           }catch (ClassNotFoundException ex){
               System.out.println("Erro ao buscar um Funcionario");
               ex.printStackTrace();         
           }
        */
        //salvar
        /*
            FuncionarioDAO fdao = new FuncionarioDAO();
            Funcionario fs = new Funcionario();
            fs.setFun_nome("Rafael");
            fs.setFun_cargo("Gerente");
            fs.setFun_data_cad(new Date());
            
            try {
                     fdao.salvar(fs); 
                     System.out.println("Dados dos funcionarios salvo com sucesso");
                }catch (SQLException ex){
                    System.out.println("Erro ao salvar um funcionario");
                    ex.printStackTrace();
                }
            }*/

            /*
            //editar
            FuncionarioDAO fdao = new FuncionarioDAO();
            Funcionario fe = new Funcionario();
            fe.setFun_nome("Jose");
            fe.setFun_cargo("Lider");
            fe.setFun_data_cad(new Date());
            fe.setFun_cod(6L);
            
            try {
                     fdao.update(fe);
                     System.out.println("Dados do funcionario editado com sucesso ");
                }catch (SQLException ex){
                    System.out.println("Erro ao editar um funcionario");
                    ex.printStackTrace();
                }
        }
            
}*/

            
            
            
            /*
            //deletar
            Funcionario fd = new Funcionario();
            Funcionario fd1 = new Funcionario();
            fd.setFun_cod(5L);
            fd1.setFun_cod(1L);
                try {
                     fdao.deletar(fd);
                     fdao.deletar(fd1);
                     System.out.println("Dados do funcionario deletado com sucesso "+ fd + "-"+ fd1);
                }catch (SQLException ex){
                    System.out.println("Erro ao deletar um funcionario");
                    ex.printStackTrace();
                }
            }*/
           
            
        
        
