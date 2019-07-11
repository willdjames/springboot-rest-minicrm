package br.exemplo.minicrm.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_EMPRESA")
public class Empresa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    public Empresa() {
    }

    public Empresa(Long id, String nome, String mail) {
        this.id = id;
        this.nome = nome;
        this.email = mail;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }
}
