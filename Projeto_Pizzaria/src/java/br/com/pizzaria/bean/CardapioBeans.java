/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.bean;

import br.com.pizzaria.dao.CardapioDAO;
import br.com.pizzaria.domain.Cardapio;
import br.com.pizzarua.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ferfe
 */
@ManagedBean(name = "MBCardapio")
@javax.faces.bean.ViewScoped


public class CardapioBeans {
    
    //salvar
    private Cardapio cardapioSalvar;

    public Cardapio getCardapioSalvar() {
        return cardapioSalvar;
    }

    public void setCardapioSalvar(Cardapio cardapioSalvar) {
        this.cardapioSalvar = cardapioSalvar;
    }
    
    private ListDataModel<Cardapio> intens_car;

    public ListDataModel<Cardapio> getIntens_car() {
        return intens_car;
    }

    public void setIntens_car(ListDataModel<Cardapio> intens_car) {
        this.intens_car = intens_car;
    }
    
    @PostConstruct
    public void pesquisaCardapio(){
        
           
        try {
            CardapioDAO cdaotela = new CardapioDAO();
            ArrayList<Cardapio> listaCardapio = cdaotela.listarCardapio();
            intens_car = new ListDataModel<Cardapio>(listaCardapio);

        } catch (SQLException ex) {
            System.out.println("erro ao carregar o cardapio");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
             ex.printStackTrace();
            //Logger.getLogger(CardapioBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void prepararNovoCardapio(){
        cardapioSalvar = new Cardapio();
    }
    public void salvarCardapio(){
        CardapioDAO daocad = new CardapioDAO();
        try {
            daocad.salvar(cardapioSalvar);
            ArrayList<Cardapio> listaCardapio = daocad.listarCardapio();
            intens_car = new ListDataModel<Cardapio>(listaCardapio);
            JSFUtil.adicionarMensagemSucesso("Cardapio salvo com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
             JSFUtil.adicionarMensagemErro(ex.getMessage());
            //Logger.getLogger(CardapioBeans.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(CardapioBeans.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    
    
}
