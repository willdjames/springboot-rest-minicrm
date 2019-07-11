package br.exemplo.minicrm.controller;

import br.exemplo.minicrm.business.EmpresaService;
import br.exemplo.minicrm.model.EmpresaDto;
import br.exemplo.minicrm.model.EmpresaForm;
import br.exemplo.minicrm.model.entity.Empresa;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EmpresaControllerTests {

    @Mock
    private EmpresaService empresaService;

    @InjectMocks
    private EmpresaController empresaController = new EmpresaController();

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    public void deveRetornarStatus200EListaDeEmpresasDTO(){

        when(empresaService.buscaTodasEmpresas()).thenReturn(colecaoEmpresasMock());

        ResponseEntity<List<EmpresaDto>> respostaAPI = empresaController.buscaTodasEmpresas();

        assertThat(respostaAPI.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(respostaAPI.getBody(), contains(instanceOf(EmpresaDto.class)));
    }

    @Test
    public void deveRetornarStatus201ERecursoSalvo(){

        EmpresaForm empresa = new EmpresaForm("Empresa 1","m@mail.com");

        when(empresaService.salva(empresa)).thenReturn(new Empresa(2L, "Empresa 1","m@mail.com"));

        ResponseEntity<EmpresaDto> respostaAPI = empresaController.salvaNovaEmpresa(empresa);

        assertThat(respostaAPI.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(respostaAPI.getBody().getId(), is(notNullValue()));
    }

    private List<Empresa> colecaoEmpresasMock() {
        return Arrays.asList(new Empresa());
    }

}
