/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import java.util.Date;

/**
 *
 * @author ferfe
 */
public class Datt {
    private int cod;
    private Date datacol;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Date getDatacol() {
        return datacol;
    }

    public void setDatacol(Date datacol) {
        this.datacol = datacol;
    }
    //data no xhtml listar
    /* <p:column headerText="Data" sortBy="#{itens.cli_data_cad}" filterBy="#{itens.cli_data_cad}">
                        <h:outputText value="#{itens.cli_data_cad}"/>
                    </p:column> */
    
    //data no xhtml salvar
     /*<h:outputLabel value="Data: " />
                    <p:calendar value="#{MBCliente.clienteSalvar.cli_data_cad}"/>*/
}
