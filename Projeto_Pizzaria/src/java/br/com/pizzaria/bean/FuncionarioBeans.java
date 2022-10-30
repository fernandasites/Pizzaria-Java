/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.bean;

import br.com.pizzaria.dao.FuncionarioDAO;
import br.com.pizzaria.domain.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

/**
 *
 * @author ferfe
 */

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionarioBeans {
    
    private Funcionario funcionarioSalvar;

    public Funcionario getFuncionarioSalvar() {
        return funcionarioSalvar;
    }

    public void setFuncionarioSalvar(Funcionario funcionarioSalvar) {
        this.funcionarioSalvar = funcionarioSalvar;
    }
    private ListDataModel<Funcionario> itens_fun;

   

    public ListDataModel<Funcionario> getItens_fun() {
        return itens_fun;
    }

    public void setItens_fun(ListDataModel<Funcionario> itens_fun) {
        this.itens_fun = itens_fun;
    }
    @PostConstruct
    //lista na tela
    public void pesquisaFuncionario(){
        
        try {
            FuncionarioDAO fdaotela = new FuncionarioDAO();
            ArrayList<Funcionario> listaFuncionario = fdaotela.listarFuncionario();
            itens_fun = new ListDataModel<Funcionario>(listaFuncionario);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("erro ao carregar");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void prepararNovoFuncionario(){
        funcionarioSalvar = new Funcionario();
    }
    //lista no botao novo
    public void salvarFuncionario(){
        
        try {
            FuncionarioDAO daofunc = new FuncionarioDAO();
            daofunc.salvar(funcionarioSalvar);
            ArrayList<Funcionario> listaFuncionario = daofunc.listarFuncionario();
            itens_fun = new ListDataModel<Funcionario>(listaFuncionario);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioBeans.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
