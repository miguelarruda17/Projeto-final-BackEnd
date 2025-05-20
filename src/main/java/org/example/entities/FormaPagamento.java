package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class FormaPagamento  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FPG_ID")
    private Long fpgId;

    @NotBlank(message = "Formato é obrigatório.")
    @Column(name = "FPG_FORMATO")
    private String fpgFormato;

    @NotBlank(message = "Tipo é Obrigatório")
    @Column(name = "FPG_TIPO")
    private String fpgTipo;

    public FormaPagamento() {
    }

    public FormaPagamento(Long fpgId, String fpgFormato, String fpgTipo) {
        this.fpgId = fpgId;
        this.fpgFormato = fpgFormato;
        this.fpgTipo = fpgTipo;
    }

    public Long getFpgId() {
        return fpgId;
    }

    public void setFpgId(Long fpgId) {
        this.fpgId = fpgId;
    }

    public String getFpgFormato() {
        return fpgFormato;
    }

    public void setFpgFormato(String fpgFormato) {
        this.fpgFormato = fpgFormato;
    }

    public String getFpgTipo() {
        return fpgTipo;
    }

    public void setFpgTipo(String fpgTipo) {
        this.fpgTipo = fpgTipo;
    }
}