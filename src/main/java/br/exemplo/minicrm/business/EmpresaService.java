package br.exemplo.minicrm.business;

import br.exemplo.minicrm.model.EmpresaForm;
import br.exemplo.minicrm.model.entity.Empresa;
import br.exemplo.minicrm.repository.EmpresaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaJpaRepository empresaJPARepository;

    public List<Empresa> buscaTodasEmpresas(){
        return empresaJPARepository.findAll();
    }

    public Empresa salva(EmpresaForm novaEmpresa) {
        return empresaJPARepository.saveAndFlush(novaEmpresa.getEmpresa());
    }

}
