package br.exemplo.minicrm.model;

import br.exemplo.minicrm.model.entity.Empresa;

public class EmpresaForm {

    private String nome;

    private String email;

    public EmpresaForm() {
    }

    public EmpresaForm(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Empresa getEmpresa() {
        return new Empresa(null, nome, email);
    }
}
