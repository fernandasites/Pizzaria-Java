/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.bean;

import br.com.pizzaria.dao.PedidoDAO;
import br.com.pizzaria.domain.Cardapio;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;

/**
 *
 * @author ferfe
 */
@ManagedBean(name = "MBPedido")
@javax.faces.bean.ViewScoped
public class PedidoBeans {
    
    //util JSFUtil.adicionarMensagemSucesso("Pedido salvo com sucesso");
    // JSFUtil.adicionarMensagemErro("Erro ao listar os Fabricante");
    //JSFUtil.adicionarMensagemErro(ex.getMessage());
    //
    private ListDataModel<Cardapio> intens_ped;

    public ListDataModel<Cardapio> getIntens_ped() {
        return intens_ped;
    }

    public void setIntens_ped(ListDataModel<Cardapio> intens_ped) {
        this.intens_ped = intens_ped;
    }

    
    @PostConstruct
    public void pesquisaPedido(){
        
            PedidoDAO cdaotela = new PedidoDAO();
           // ArrayList<Pedido> listaCardapio = cdaotela.listarPedido();
           // intens_ped = new ListDataModel<Cardapio>(listaCardapio);
}

}
