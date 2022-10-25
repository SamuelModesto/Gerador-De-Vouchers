package github.samuelmodesto.teste.getnet.service.impl;

import github.samuelmodesto.teste.getnet.model.Voucher;
import github.samuelmodesto.teste.getnet.repository.VoucherRepository;
import github.samuelmodesto.teste.getnet.service.ValidacaoVoucher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class VoucherServiceImplTest {

    public static final String ID = "63574a696cbe595a5ec0bcff";
    public static final String CODIGO_VOUCHER = "hs23hsg3";
    public static final double PERCENTUAL_DECONTO = 10.0;
    public static final LocalDate VALIDADE = LocalDate.now().plusDays(5);
    public static final LocalDate DATA_DE_USO = LocalDate.now();
    public static final boolean VOUCHER_USADO = false;

    @InjectMocks
    private VoucherServiceImpl service;

    @Mock
    private VoucherRepository repository;

    private Optional<Voucher> optionalVoucher;

    private List<ValidacaoVoucher> validacoes;

    private Voucher voucher;


    public VoucherServiceImplTest() {
        this.validacoes = validacoes;
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarObjetos();
    }

    @Test
    void quandGgerarCodigoVoucherRetorneUmaStringDeOitoDigitos() {
        String response = service.gerarCodigoVoucher();
        assertEquals(response.getClass(), CODIGO_VOUCHER.getClass());
        assertEquals(response.length(), CODIGO_VOUCHER.length());
    }

    @Test
    void quandoCriarVoucherRetornarUmVoucherComSucesso() {
        when(repository.save(any())).thenReturn(voucher);
        Optional<Voucher> response = service.criarVoucher(PERCENTUAL_DECONTO);
        assertNotNull(response);
        assertEquals(optionalVoucher.getClass(), response.getClass());
        assertEquals(PERCENTUAL_DECONTO, response.get().getPercentualDeconto());
    }

    @Test
    void distribuirVouchers() {
    }

    @Test
    void usarVoucher() {
    }

    @Test
    void validarVoucher() {
    }

    void iniciarObjetos() {
        voucher = new Voucher(ID, CODIGO_VOUCHER, PERCENTUAL_DECONTO,
                VALIDADE, DATA_DE_USO, VOUCHER_USADO);
        optionalVoucher = Optional.of(new Voucher(ID, CODIGO_VOUCHER, PERCENTUAL_DECONTO,
                VALIDADE, DATA_DE_USO, VOUCHER_USADO));
    }
}