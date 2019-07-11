package br.exemplo.minicrm.business;

import br.exemplo.minicrm.model.EmpresaForm;
import br.exemplo.minicrm.model.entity.Empresa;
import br.exemplo.minicrm.repository.EmpresaJpaRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EmpresaServiceTests {

    @Mock
    private EmpresaJpaRepository empresaJpaRepository;

    @InjectMocks
    private EmpresaService empresaService = new EmpresaService();

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void deveRetornarListaDeEmpresas(){

        when(empresaJpaRepository.findAll()).thenReturn(mocktListaDeEmpresa());

        List<Empresa> grupoEmpresas = empresaService.buscaTodasEmpresas();

        assertThat(grupoEmpresas, is(not(empty())));
        assertThat(grupoEmpresas, contains(instanceOf(Empresa.class)));
    }

    @Test
    public void deveRetornarAEmpresaSalva(){

        EmpresaForm novaEmpresa = new EmpresaForm( "Empresa 1", "mail@mail.com");

        when(empresaJpaRepository.saveAndFlush(Mockito.any(Empresa.class))).thenReturn(mockNovaEmpresa());

        Empresa empresaSalva = empresaService.salva(novaEmpresa);

        assertThat(empresaSalva, is(instanceOf(Empresa.class)));
    }

    private List<Empresa> mocktListaDeEmpresa() {
        return Arrays.asList(mockNovaEmpresa());
    }

    private Empresa mockNovaEmpresa() {
        return new Empresa(1L, "Empresa 1", "mail@mail.com");
    }
}
