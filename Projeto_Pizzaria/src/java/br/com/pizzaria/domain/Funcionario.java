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
public class Funcionario {
    private Long fun_cod;
    private String fun_nome;
    private String fun_cargo;
    private Date fun_data_cad;

    public Long getFun_cod() {
        return fun_cod;
    }

    public void setFun_cod(Long fun_cod) {
        this.fun_cod = fun_cod;
    }

    public String getFun_nome() {
        return fun_nome;
    }

    public void setFun_nome(String fun_nome) {
        this.fun_nome = fun_nome;
    }

    public String getFun_cargo() {
        return fun_cargo;
    }

    public void setFun_cargo(String fun_cargo) {
        this.fun_cargo = fun_cargo;
    }

    public Date getFun_data_cad() {
        return fun_data_cad;
    }

    public void setFun_data_cad(Date fun_data_cad) {
        this.fun_data_cad = fun_data_cad;
    }
    
    public String toString(){
        String saida = fun_cod + " - " + fun_nome + " - "+ fun_cargo + " - " + fun_data_cad;
        return saida;
        
    }
    
    
}
