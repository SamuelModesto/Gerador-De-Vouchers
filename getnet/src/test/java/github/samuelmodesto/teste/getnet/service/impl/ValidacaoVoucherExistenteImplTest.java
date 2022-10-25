package github.samuelmodesto.teste.getnet.service.impl;

import github.samuelmodesto.teste.getnet.exception.ValidacaoException;
import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.model.Voucher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidacaoVoucherExistenteImplTest {

    public static final String ID = "1";
    public static final String CODIGO_VOUCHER = "hs23hsg3";
    public static final double PERCENTUAL_DECONTO = 10.0;
    public static final LocalDate VALIDADE = LocalDate.now().plusDays(5);
    public static final LocalDate DATA_DE_USO = LocalDate.now();
    public static final boolean VOUCHER_USADO = false;
    public static final String ID_DESTINATARIO = "63574a696cbe595a5ec0bcff";
    public static final String NOME = "Samuel";
    public static final String EMAIL = "samuel@email.com";
    public static final String CODIGO = "76ysgte6";

    @InjectMocks
    private ValidacaoVoucherExistenteImpl service;

    private Optional<Destinatario> optionalDestinatario;

    private Voucher voucher;

    private String codigo;


    @BeforeEach
    void setUp() {
        inciarObjetos();
    }

    @Test
    void quandoValidarCodigoVoucherNaoExistirRetornarExcecao() {
        try {
            service.validarVoucher(optionalDestinatario, codigo);
        } catch (Exception ex) {
            assertEquals(ValidacaoException.class, ex.getClass());
            assertEquals("Voucher não encontrado", ex.getMessage());
        }
    }

    void inciarObjetos() {
        voucher = new Voucher(ID, CODIGO_VOUCHER, PERCENTUAL_DECONTO,
                VALIDADE, DATA_DE_USO, VOUCHER_USADO);
        optionalDestinatario = Optional.of(new Destinatario(ID_DESTINATARIO, NOME, EMAIL, voucher));
        this.codigo = CODIGO;
    }
}