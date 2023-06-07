package br.com.fiap.rpgenc.model.character;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String habilidadePrincipal;
    private String habilidadeSecundaria;

    public Character(DadosCadastroCharacter dados) {
        this.nome = dados.nome();
        this.habilidadePrincipal = dados.habprincipal();
        this.habilidadeSecundaria = dados.habsecundaria();
    }

    public Character() {}

    @Override
    public String toString() {
        return "Character{" +
                "nome='" + nome + '\'' +
                ", habilidadePrincipal=" + habilidadePrincipal +
                ", habilidadeSecundaria=" + habilidadeSecundaria + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getHabilidadePrincipal() {
        return habilidadePrincipal;
    }

    public String getHabilidadeSecundaria() {
        return habilidadeSecundaria;
    }

    public void atualizaDados(DadosAlteracaoCharacter dados) {
        this.nome = dados.nome();
        this.habilidadePrincipal = dados.habprincipal();
        this.habilidadeSecundaria = dados.habsecundaria();
    }
}
