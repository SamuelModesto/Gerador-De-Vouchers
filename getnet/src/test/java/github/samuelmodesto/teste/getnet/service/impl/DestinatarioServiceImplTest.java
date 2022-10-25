package github.samuelmodesto.teste.getnet.service.impl;

import github.samuelmodesto.teste.getnet.exception.ObjectNotFoundException;
import github.samuelmodesto.teste.getnet.exception.ValidacaoException;
import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.model.Voucher;
import github.samuelmodesto.teste.getnet.repository.DestinatarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DestinatarioServiceImplTest {

    public static final String ID = "1";
    public static final String CODIGO_VOUCHER = "hs23hsg3";
    public static final double PERCENTUAL_DECONTO = 10.0;
    public static final LocalDate VALIDADE = LocalDate.now().plusDays(5);
    public static final LocalDate DATA_DE_USO = LocalDate.now();
    public static final boolean VOUCHER_USADO = false;
    public static final String ID_DESTINATARIO = "63574a696cbe595a5ec0bcff";
    public static final String NOME = "Samuel";
    public static final String EMAIL = "samuel@email.com";

    @InjectMocks
    private DestinatarioServiceImpl service;

    @Mock
    private DestinatarioRepository repository;

    private Optional<Destinatario> optionalDestinatario;

    private Destinatario destinatario;

    private Voucher voucher;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarObjetos();
    }

    @Test
    void quandoCriarUmDestinatarioRetorneSucesso() {
        when(repository.save(any())).thenReturn(destinatario);
        service.criarDestinatario(destinatario);
        verify(repository, times(1)).save(any());
    }

    @Test
    void atualizarDestinatarioComOVoucherRetorneSucesso() {
        when(repository.save(any())).thenReturn(destinatario);
        service.atualizarDestinatarioComOVoucher(destinatario);
        verify(repository, times(1)).save(any());
    }

    @Test
    void quandoBuscarDestinatariosRetorneUmaListaDeDestinatarios() {
        when(repository.findAll()).thenReturn(List.of(destinatario));
        List<Destinatario> response = service.recuperarDestinatarios();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Destinatario.class, response.get(0).getClass());
    }

    @Test
    void quandoBuscarDestinatarioPorEmailRetorneInstaciaOptionalDestinatario() {
        when(repository.findByEmail(Mockito.anyString())).thenReturn(optionalDestinatario);
        Optional<Destinatario> response = service.resgatarDestinatarioPorEmail(EMAIL);
        assertNotNull(response);
        assertEquals(optionalDestinatario.getClass(), response.getClass());
        assertEquals(ID_DESTINATARIO, response.get().getId());
    }

    @Test
    void quandoBuscarDestinatarioPorEmailRetorneExcecaoDeObjetoNaoEncontrado() {
        when(repository.findByEmail(Mockito.anyString())).thenThrow(new ObjectNotFoundException("Objeto nao encontrado"));
        try {
            service.resgatarDestinatarioPorEmail(EMAIL);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto nao encontrado", ex.getMessage());
        }
    }

    @Test
    void quandoCriarDestinatarioComEmailJaCadastradoRetorneExcecao() {
        when(repository.existsByEmail(anyString())).thenReturn(true);
        boolean response = service.validarEmailJaCadastrado(EMAIL);
        assertEquals(response, true);
    }

    private void iniciarObjetos() {
        voucher = new Voucher(ID, CODIGO_VOUCHER, PERCENTUAL_DECONTO,
                VALIDADE, DATA_DE_USO, VOUCHER_USADO);
        optionalDestinatario = Optional.of(new Destinatario(ID_DESTINATARIO, NOME, EMAIL, voucher));
        destinatario = new Destinatario(ID_DESTINATARIO, NOME, EMAIL, voucher);
    }
}