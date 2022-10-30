/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.domain;

import java.util.Date;

/**
 *
 * @author ferfe
 */
public class Pedido {
    private Long ped_cod;
    private Date ped_data;
    private Double ped_total;
    private Cliente cliente;
    //ped_fun_cod
    private Funcionario funcionario;
    //ped_ent_cod
    private Entregador entregador;
    //ped_status
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    //Codigo
    public Long getPed_cod() {
     return ped_cod;
    }
    
    public void setPed_cod(Long ped_cod){
        this.ped_cod = ped_cod;
    }
    
    //Data
    public Date getPed_data(){
        return ped_data;
    }
    public void setPed_data(Date ped_data){
        this.ped_data = ped_data;
    }
    
    //Total
    public Double getPed_total(){
        return ped_total;
    }
    public void setPed_total(Double ped_total){
        this.ped_total = ped_total;
    }
   
    
    // Ped_cli_cod

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
   
    //ped_ent_cod

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    //ped_fun_cod
    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }
   
    
}
