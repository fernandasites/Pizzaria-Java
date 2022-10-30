/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.domain;

/**
 *
 * @author ferfe
 */
public class ItemControler {
    private Long item_quantidade;
    private Long item_cod;
    //item_ent_cod
    private Entregador entregadorItem;
    // item_fun_cod
    private Funcionario funcionarioItem;
    // item_cli_cod
    private Cliente clienteItem;
    // item_ped_cod
    private Pedido pedidoItem;
    // item_car_cod
    private Cardapio cardapioItem;
    
    //quantidade
    public Long getItem_quantidade(){
        return item_quantidade;
    }
    public void setItem_quantidade(Long item_quantidade){
        this.item_quantidade = item_quantidade;
    }
    
    //codigo
    public Long getItem_cod(){
        return item_cod;
    }
    public void setItem_cod(Long item_cod){
        this.item_cod = item_cod;
    }  

    //item_ent_cod Entregador
    public Entregador getEntregadorItem() {
        return entregadorItem;
    }

    public void setEntregadorItem(Entregador entregadorItem) {
        this.entregadorItem = entregadorItem;
    }

    //Funcionario item_fun_cod
    public Funcionario getFuncionarioItem() {
        return funcionarioItem;
    }

    public void setFuncionarioItem(Funcionario funcionarioItem) {
        this.funcionarioItem = funcionarioItem;
    }

    //Cliente item_cli_cod
    public Cliente getClienteItem() {
        return clienteItem;
    }

    public void setClienteItem(Cliente clienteItem) {
        this.clienteItem = clienteItem;
    }

    //Pedido item_ped_cod
    public Pedido getPedidoItem() {
        return pedidoItem;
    }

    public void setPedidoItem(Pedido pedidoItem) {
        this.pedidoItem = pedidoItem;
    }

    //Cardapio item_car_cod
    public Cardapio getCardapioItem() {
        return cardapioItem;
    }

    public void setCardapioItem(Cardapio cardapioItem) {
        this.cardapioItem = cardapioItem;
    }
    

   
   
}
