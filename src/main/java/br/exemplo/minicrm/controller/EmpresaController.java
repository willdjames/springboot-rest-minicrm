package br.exemplo.minicrm.controller;

import br.exemplo.minicrm.business.EmpresaService;
import br.exemplo.minicrm.model.EmpresaDto;
import br.exemplo.minicrm.model.EmpresaForm;
import br.exemplo.minicrm.model.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<EmpresaDto>> buscaTodasEmpresas() {

        List<Empresa> colecaoEmpresa = empresaService.buscaTodasEmpresas();

        List<EmpresaDto> corpoResponse = EmpresaDto.getListaEmpresas(colecaoEmpresa);

        return ResponseEntity.status(HttpStatus.OK).body(corpoResponse);
    }


    @PostMapping
    public ResponseEntity<EmpresaDto> salvaNovaEmpresa(@RequestBody EmpresaForm novaEmpresa) {
        Empresa empresaSalva = empresaService.salva(novaEmpresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EmpresaDto(empresaSalva));
    }
}
