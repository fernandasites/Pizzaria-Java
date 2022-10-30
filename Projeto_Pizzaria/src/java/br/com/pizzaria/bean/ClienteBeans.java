/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.bean;


import br.com.pizzaria.dao.ClienteDAO;
import br.com.pizzaria.domain.Cliente;
import br.com.pizzarua.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
@ManagedBean(name = "MBCliente")
@javax.faces.bean.ViewScoped
public class ClienteBeans {
    
    //salvar
    private Cliente clienteSalvar;

    public Date getDataHoje() {
        return dataHoje;
    }

    public void setDataHoje(Date dataHoje) {
        this.dataHoje = dataHoje;
    }
    private Date dataHoje;

    public Cliente getClienteSalvar() {
        return clienteSalvar;
    }

    public void setClienteSalvar(Cliente clienteSalvar) {
        this.clienteSalvar = clienteSalvar;
    }
    
    
    //lista
    private ListDataModel<Cliente> itensc;  

    public ListDataModel<Cliente> getItensc() {
        return itensc;
    }

    public void setItensc(ListDataModel<Cliente> itensc) {
        this.itensc = itensc;
    }
    
    @PostConstruct
    //actions
    //imprime na tela
    public void pesquisaCliente(){
        
        try{
            ClienteDAO cdaotela = new ClienteDAO();
            ArrayList<Cliente> listaCliente = cdaotela.listarCliente();
            itensc = new ListDataModel<Cliente>(listaCliente);
            
            JSFUtil.adicionarMensagemSucesso("Cliente salvo com sucesso");
        } catch (SQLException e) {
           e.printStackTrace(); 
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void prepararNovoCliente(){
        clienteSalvar = new Cliente();
    }
    public void salvarCliente(){
        
       ClienteDAO daocli = new ClienteDAO();
        try {
            daocli.salvar(clienteSalvar);
            //lista atualizada
            ArrayList<Cliente> listaCliente = daocli.listarCliente();
            itensc = new ListDataModel<Cliente>(listaCliente);
             JSFUtil.adicionarMensagemSucesso("Cliente salvo com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Erro ao salvar 2");
            //Logger.getLogger(ClienteBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
