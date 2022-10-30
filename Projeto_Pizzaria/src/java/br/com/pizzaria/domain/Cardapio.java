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
public class Cardapio {
    private Long car_cod;
    private String car_descricao;
    private String car_tipo;
    private Double car_valor;
   

    public Long getCar_cod() {
        return car_cod;
    }

    public void setCar_cod(Long car_cod) {
        this.car_cod = car_cod;
    }

    public String getCar_descricao() {
        return car_descricao;
    }

    public void setCar_descricao(String car_descricao) {
        this.car_descricao = car_descricao;
    }

    public String getCar_tipo() {
        return car_tipo;
    }

    public void setCar_tipo(String car_tipo) {
        this.car_tipo = car_tipo;
    }

    public Double getCar_valor() {
        return car_valor;
    }

    public void setCar_valor(Double car_valor) {
        this.car_valor = car_valor;
    }
    @Override
    public String toString(){
        String saida = car_cod + " - " + car_descricao + " - " + car_tipo + " - " + car_valor;
        return saida;
    }
    
    
}
