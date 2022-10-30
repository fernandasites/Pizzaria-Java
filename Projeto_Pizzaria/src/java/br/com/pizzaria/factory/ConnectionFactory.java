/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ferfe
 */
public class ConnectionFactory {
    
    private static final String USUARIO = "root";
    private static final String SENHA = "q1w2e3r4";
    private static final String URL = "jdbc:mysql://localhost:3307/pizzaria?autoReconnect=true&useSSL=false";
    
        public static Connection conectar() throws SQLException, ClassNotFoundException {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            return conexao;
        }
        
        
        public static void main(String[] args){
            try {
                Connection conexao = ConnectionFactory.conectar();
                  System.out.println("Conectado com sucesso");
                    JOptionPane.showMessageDialog(null, "Conectado com Sucesso", "Conectado", 1);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
                 System.out.println("Não foi possivel realizar a conexao");
                 JOptionPane.showMessageDialog(null, "Erro ao Conectar com o Banco", "Erro", 0);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            
            
            }
        }
        
}
    

