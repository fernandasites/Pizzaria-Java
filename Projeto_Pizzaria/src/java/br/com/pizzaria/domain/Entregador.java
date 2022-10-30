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
public class Entregador {
    private Long ent_cod;
    private String ent_status;
    private String ent_nome;
    private Date ent_data_cad;

    public Long getEnt_cod() {
        return ent_cod;
    }

    public void setEnt_cod(Long ent_cod) {
        this.ent_cod = ent_cod;
    }

    public String getEnt_status() {
        return ent_status;
    }

    public void setEnt_status(String ent_status) {
        this.ent_status = ent_status;
    }

    public String getEnt_nome() {
        return ent_nome;
    }

    public void setEnt_nome(String ent_nome) {
        this.ent_nome = ent_nome;
    }

    public Date getEnt_data_cad() {
        return ent_data_cad;
    }

    public void setEnt_data_cad(Date ent_data_cad) {
        this.ent_data_cad = ent_data_cad;
    }

    
    
    @Override
    public String toString(){
        String saida = ent_cod + "-" + ent_nome + "-" + ent_status + "-" + ent_data_cad;
        return saida;
    }
   
    
}
