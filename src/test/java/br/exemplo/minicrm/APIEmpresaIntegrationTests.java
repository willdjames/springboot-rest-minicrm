package br.exemplo.minicrm;

import br.exemplo.minicrm.business.EmpresaService;
import br.exemplo.minicrm.controller.EmpresaController;
import br.exemplo.minicrm.model.entity.Empresa;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class APIEmpresaIntegrationTests {

    @MockBean
    private EmpresaService empresaService;

    @Autowired
    private EmpresaController empresaController;

    private MockMvc mockMvc;

    private String endpoint = "/empresas";

    @Before
    public void setup(){
        initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(empresaController).build();
    }

    @Test
    public void retorna200() throws Exception {

        when(empresaService.buscaTodasEmpresas()).thenReturn(mockListaDeEmpresa());

        mockMvc.perform(get(endpoint))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(jsonResposta()))
                .andDo(print());
    }
    
    @Test
    public void retorna201() throws Exception {

        Empresa empresaSalva = new Empresa(201L, "Empresa", "m@mail.c");

        when(empresaService.salva(any())).thenReturn(empresaSalva);

        mockMvc.perform(
                post(endpoint)
                .content("{\"nome\":\"Empresa\", \"email\":\"m@mail.c\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(201))
                .andDo(print());

    }

    private String jsonResposta() {
        return   "["
                +     "{"
                +       "'id':1,"
                +       "'nome':'Empresa 1',"
                +       "'email':'mail@mail.com'"
                +     "}"
                +"]";
    }

    private List<Empresa> mockListaDeEmpresa() {
        return Arrays.asList(
                new Empresa(1L, "Empresa 1", "mail@mail.com")
        );
    }
}
