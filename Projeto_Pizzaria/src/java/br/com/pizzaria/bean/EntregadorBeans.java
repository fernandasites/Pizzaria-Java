/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.bean;

import br.com.pizzaria.dao.EntregadorDAO;
import br.com.pizzaria.domain.Entregador;
import br.com.pizzarua.util.JSFUtil;
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
@ManagedBean(name = "MBEntregador")
@ViewScoped
public class EntregadorBeans {
    
    //salvar
    private Entregador entSalvar;
    private ListDataModel<Entregador> itens_e;

    public Entregador getEntSalvar() {
        return entSalvar;
    }

    public void setEntSalvar(Entregador entSalvar) {
        this.entSalvar = entSalvar;
    }
   
    
    public ListDataModel<Entregador> getItens_e() {
        return itens_e;
    }

    public void setItens_e(ListDataModel<Entregador> itens_e) {
        this.itens_e = itens_e;
    }
    
    @PostConstruct //chama antes de desenhar a tela
    //carregar o DAO
    //lista na tela
    public void prepararPesquisaEnt(){
       
        try {
            
             //cria o DAO
            EntregadorDAO edaotela = new EntregadorDAO();
            //pesquisa listar(dados do banco)
            ArrayList<Entregador> lista_ent = edaotela.listarEntregador();
             //converter lista para data model
            itens_e = new ListDataModel<Entregador>(lista_ent);
            JSFUtil.adicionarMensagemSucesso("Entregador salvo com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntregadorBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    //limpa tela
    public void prepararNovoEntregador(){
        entSalvar = new Entregador();
    }
    
    //lista no botao novo
    public void salvarEntregador(){
        EntregadorDAO daoent = new EntregadorDAO();
        try {
            daoent.salvar(entSalvar);
            ArrayList<Entregador> listaEntregador = daoent.listarEntregador();
            itens_e = new ListDataModel<Entregador>(listaEntregador);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntregadorBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
