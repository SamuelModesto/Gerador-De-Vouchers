package github.samuelmodesto.teste.getnet.service.impl;

import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.model.OfertaEspecial;
import github.samuelmodesto.teste.getnet.model.Voucher;
import github.samuelmodesto.teste.getnet.repository.OfertaEspecialRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class OfertaEspecialServiceImplTest {

    public static final String ID = "1";
    public static final String CODIGO_VOUCHER = "hs23hsg3";
    public static final double PERCENTUAL_DECONTO = 10.0;
    public static final LocalDate VALIDADE = LocalDate.now().plusDays(5);
    public static final LocalDate DATA_DE_USO = LocalDate.now();
    public static final boolean VOUCHER_USADO = false;
    public static final String ID_DESTINATARIO = "63574a696cbe595a5ec0bcff";
    public static final String NOME = "Samuel";
    public static final String EMAIL = "samuel@email.com";
    public static final String ID_OFERTA = "12344a696cbe595a5ec0bcss";
    public static final String OFERTA = "Natal";

    @InjectMocks
    private OfertaEspecialServiceImpl service;

    @Mock
    private OfertaEspecialRepository repository;

    private OfertaEspecial ofertaEspecial;

    private List<Destinatario> destinatarios;

    private Destinatario destinatario;

    private Voucher voucher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarObjetos();
    }

    @Test
    void quandoCriarOfertaEspecialRetorneSucesso() {
        when(repository.save(any())).thenReturn(ofertaEspecial);
        OfertaEspecial response = service.criarOfertaEspecial(ofertaEspecial, destinatarios);
        assertNotNull(response);
        assertEquals(OfertaEspecial.class, response.getClass());
        verify(repository, times(1)).save(any());
    }

    void iniciarObjetos() {
        voucher = new Voucher(ID, CODIGO_VOUCHER, PERCENTUAL_DECONTO,
                VALIDADE, DATA_DE_USO, VOUCHER_USADO);
        destinatario = new Destinatario(ID_DESTINATARIO, NOME, EMAIL, voucher);
        destinatarios = new ArrayList<>();
        destinatarios.add(destinatario);
        ofertaEspecial = new OfertaEspecial(ID_OFERTA, OFERTA, destinatarios);
    }
}