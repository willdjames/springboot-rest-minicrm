package br.exemplo.minicrm.model;

import br.exemplo.minicrm.model.entity.Empresa;

import java.util.List;
import java.util.stream.Collectors;

public class EmpresaDto {

    private Long id;

    private String nome;

    private String email;

    public EmpresaDto(Empresa empresa) {
        id = empresa.getId();
        nome = empresa.getNome();
        email = empresa.getEmail();
    }

    public static List<EmpresaDto> getListaEmpresas(List<Empresa> colecaoEmpresa) {
        return colecaoEmpresa.stream().map(EmpresaDto::new).collect(Collectors.toList());
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
}
