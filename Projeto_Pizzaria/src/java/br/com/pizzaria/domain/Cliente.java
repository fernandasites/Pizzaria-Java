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
public class Cliente {
    private Long cli_codigo;
    private String cli_nome;
    private String cli_rua;
    private String cli_bairro;
    private String cli_telefone;
    private Date cli_data_cad;

    public Long getCli_codigo() {
        return cli_codigo;
    }

    public void setCli_codigo(Long cli_codigo) {
        this.cli_codigo = cli_codigo;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_rua() {
        return cli_rua;
    }

    public void setCli_rua(String cli_rua) {
        this.cli_rua = cli_rua;
    }

    public String getCli_bairro() {
        return cli_bairro;
    }

    public void setCli_bairro(String cli_bairro) {
        this.cli_bairro = cli_bairro;
    }

    public String getCli_telefone() {
        return cli_telefone;
    }

    public void setCli_telefone(String cli_telefone) {
        this.cli_telefone = cli_telefone;
    }

    public Date getCli_data_cad() {
        return cli_data_cad;
    }

    public void setCli_data_cad(Date cli_data_cad) {
        this.cli_data_cad = cli_data_cad;
    }
    @Override
    public String toString(){
        String saida = cli_codigo + " - " + cli_nome + " - "+ cli_bairro + " - "+cli_telefone+ " - " + cli_telefone + " - "+cli_data_cad ;
        return saida;
    }
    
}
