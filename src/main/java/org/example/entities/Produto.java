package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @NotBlank(message = "Nome é obrigatório.")
    @Column(name = "PRO_NOME")
    private String proNome;

    @NotBlank(message = "Descrição é obrigatório.")
    @Column(name = "PRO_DESCRICAO")
    private String proDescricao;

    @NotBlank(message = "Preço de custo é obrigatório.")
    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2)
    private Double proPrecoCusto;

    @NotBlank(message = "Preço de venda é obrigatório.")
    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2)
    private Double proPrecoVenda;

    @NotBlank(message = "Estoque é obrigatório.")
    @Column(name = "PRO_QUANT_ESTOQUE")
    private Integer proQuantidadeEstoque; // Ex: 120

    @NotBlank(message = "Categoria é obrigatório.")
    @Column(name = "PRO_CATEGORIA")
    private String proCategoria; // Ex: "Bebidas"

    @NotBlank(message = "Código de barras é obrigatório.")
    @Size(max = 12, message = "Código de barras deve ter no máximo 12 caracteres.")
    @Column(name = "PRO_COD_BARRAS")
    private String proCodigoBarras; //* Ex: "7894900011517"

    @NotBlank(message = "Marca é obrigatório.")
    @Column(name = "PRO_MARCA")
    private String proMarca; // Ex: "Coca-Cola"

    @NotBlank(message = "Unidade de medida é obrigatório.")
    @Column(name = "PRO_UNID_MEDIDA")
    private String proUnidadeMedida; // Ex: "Litro"

    @NotBlank(message = "Status é obrigatório.")
    @Column(name = "PRO_STATUS")
    private String proStatus;

    @NotBlank(message = "Data de cadastro é obrigatório.")
    @Column(name = "PRO_DATA_CADASTRO")
    private LocalDateTime proDataCadastro; // Ex: LocalDateTime.now()

    @Column(name = "PRO_DATA_ATUALIZACAO")
    private LocalDateTime proDataAtualizacao; // Ex: LocalDateTime.now()

    public Produto() {
    }

    public Produto(Long proId, String proNome, String proDescricao, Double proPrecoCusto, Double proPrecoVenda, Integer proQuantidadeEstoque, String proCategoria,
                   String proCodigoBarras, String proMarca, String proUnidadeMedida,String proStatus) {

        this.proId = proId;
        this.proNome = proNome;
        this.proDescricao = proDescricao;
        this.proPrecoCusto = proPrecoCusto;
        this.proPrecoVenda = proPrecoVenda;
        this.proQuantidadeEstoque = proQuantidadeEstoque;
        this.proCategoria = proCategoria;
        this.proCodigoBarras = proCodigoBarras;
        this.proMarca = proMarca;
        this.proUnidadeMedida = proUnidadeMedida;
        this.proStatus = proStatus;

        this.proDataCadastro = LocalDateTime.now(); // Garantir data de cadastro
        this.proDataAtualizacao = LocalDateTime.now(); // Garantir data de atualização
    }

    public Long getProId() { return proId; }

    public void setProId(Long proId) { this.proId = proId; }

    public String getProNome() { return proNome; }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public String getProDescricao() { return proDescricao; }

    public void setProDescricao(String proDescricao) { this.proDescricao = proDescricao; }

    public Double getProPrecoCusto() { return proPrecoCusto; }

    public void setProPrecoCusto(Double proPrecoCusto) { this.proPrecoCusto = proPrecoCusto; }

    public Double getProPrecoVenda() { return proPrecoVenda; }

    public void setProPrecoVenda(Double proPrecoVenda) { this.proPrecoVenda = proPrecoVenda; }

    public Integer getProQuantidadeEstoque() {
        return proQuantidadeEstoque;
    }

    public void setProQuantidadeEstoque(Integer proQuantidadeEstoque) {
        this.proQuantidadeEstoque = proQuantidadeEstoque;
    }

    public String getProCategoria() {
        return proCategoria;
    }

    public void setProCategoria(String proCategoria) {
        this.proCategoria = proCategoria;
    }

    public String getProCodigoBarras() {
        return proCodigoBarras;
    }

    public void setProCodigoBarras(String proCodigoBarras) {
        this.proCodigoBarras = proCodigoBarras;
    }

    public String getProMarca() {
        return proMarca;
    }

    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    public String getProUnidadeMedida() {
        return proUnidadeMedida;
    }

    public void setProUnidadeMedida(String proUnidadeMedida) {
        this.proUnidadeMedida = proUnidadeMedida;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public LocalDateTime getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(LocalDateTime proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    public LocalDateTime getProDataAtualizacao() {
        return proDataAtualizacao;
    }

    public void setProDataAtualizacao(LocalDateTime proDataAtualizacao) {
        this.proDataAtualizacao = proDataAtualizacao;
    }

}