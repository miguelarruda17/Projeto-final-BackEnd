package org.example.dto;

import org.hibernate.validator.constraints.br.CNPJ;

public class FornecedorDTO {

    //FORNECEDOR//
    private Long forId;
    private String forNomeFantasia;
    private String forRazaoSocial;
    @CNPJ(message = "CNPJ inválido.")
    private String forCnpj;

    private String forStatus;
    //CONTATO
    private String conCelular;
    private String conTelefoneComercial;
    private String conEmail;
    //ENDEREÇO
    private String endRua;
    private String endNumero;
    private String endCidade;
    private String endCep;
    private String endEstado;

    //CONSTRUTOR VAZIO//
    public FornecedorDTO() {  }

    //SETTERS e GETTER//


    public Long getForId() {
        return forId;
    }

    public void setForId(Long forId) {
        this.forId = forId;
    }

    public String getForNomeFantasia() {
        return forNomeFantasia;
    }

    public void setForNomeFantasia(String forNomeFantasia) {
        this.forNomeFantasia = forNomeFantasia;
    }

    public String getForRazaoSocial() {
        return forRazaoSocial;
    }

    public void setForRazaoSocial(String forRazaoSocial) {
        this.forRazaoSocial = forRazaoSocial;
    }

    public String getForCnpj() {
        return forCnpj;
    }

    public void setForCnpj(String forCnpj) {
        this.forCnpj = forCnpj;
    }

    public String getForStatus() {
        return forStatus;
    }

    public void setForStatus(String forStatus) {
        this.forStatus = forStatus;
    }

    public String getConCelular() {
        return conCelular;
    }

    public void setConCelular(String conCelular) {
        this.conCelular = conCelular;
    }

    public String getConTelefoneComercial() {
        return conTelefoneComercial;
    }

    public void setConTelefoneComercial(String conTelefoneComercial) {
        this.conTelefoneComercial = conTelefoneComercial;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

}
