package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOR_ID")
    private Long forId;

    @NotBlank(message = "Nome fantasia é obrigatório.")
    @Size(max = 100, message = "Nome Fantasia deve ter no máximo 100 caracteres.")
    @Column(name = "FOR_NOME_FANTASIA", nullable = false, length = 100)
    private String forNomeFantasia;

    @NotBlank(message = "Razão social é obrigatório.")
    @Size(max = 100, message = "Razão social deve ter no máximo 100 caracteres.")
    @Column(name = "FOR_RAZAO_SOCIAL", nullable = false, length = 100)
    private String forRazaoSocial;

    @NotBlank(message = "CNPJ é obrigatório.")
    @Column(name = "FOR_CNPJ", nullable = false, unique = true, length = 18)
    private String forCnpj;

    @NotBlank(message = "Razão social é obrigatório.")
    @Column(name = "FOR_STATUS", nullable = false)
    private String forStatus;

    @OneToMany(mappedBy = "conFornecedor", cascade = CascadeType.ALL)
    private List<Contato> Contatos = new ArrayList<>();

    @OneToMany(mappedBy = "endFornecedor", cascade = CascadeType.ALL)
    private List<Endereco> Enderecos = new ArrayList<>();

    public Fornecedor() {
    }

    public Fornecedor(Long forId, String forNomeFantasia, String forRazaoSocial, String forCnpj, String forStatus) {
        this.forId = forId;
        this.forNomeFantasia = forNomeFantasia;
        this.forRazaoSocial = forRazaoSocial;
        this.forCnpj = forCnpj;
        this.forStatus = forStatus;
    }

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

    public List<Contato> getContatos() {
        return Contatos;
    }

    public void setForContatos(List<Contato> Contatos) {
        this.Contatos = Contatos;
    }

    public List<Endereco> getEnderecos() {
        return Enderecos;
    }

    public void setForEnderecos(List<Endereco> Enderecos) {
        this.Enderecos = Enderecos;
    }
}
