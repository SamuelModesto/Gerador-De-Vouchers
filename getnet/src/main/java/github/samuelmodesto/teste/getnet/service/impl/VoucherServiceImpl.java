package github.samuelmodesto.teste.getnet.service.impl;

import github.samuelmodesto.teste.getnet.exception.ValidacaoException;
import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.model.Voucher;
import github.samuelmodesto.teste.getnet.repository.VoucherRepository;
import github.samuelmodesto.teste.getnet.service.DestinatarioService;
import github.samuelmodesto.teste.getnet.service.ValidacaoVoucher;
import github.samuelmodesto.teste.getnet.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private DestinatarioService destinatarioService;
    private static final int TAMANHO = 8;
    private static final int DIAS_DE_VALIDADE = 5;
    List<ValidacaoVoucher> validacoes;

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public String gerarCodigoVoucher() {
        String AlfabetoAlfaNumerico = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < TAMANHO; i++) {
            int index = (int) (AlfabetoAlfaNumerico.length() * Math.random());
            stringBuilder.append(AlfabetoAlfaNumerico.charAt(index));
        }
        return stringBuilder.toString();
    }

    @Override
    public Optional<Voucher> criarVoucher(Double percentualDesconto) {
        Voucher voucher = new Voucher();
        voucher.setCodigoVoucher(gerarCodigoVoucher());
        voucher.setValidade(LocalDate.now(ZoneId.of("UTC")).plusDays(DIAS_DE_VALIDADE));
        voucher.setPercentualDeconto(percentualDesconto);
        voucherRepository.save(voucher);
        return Optional.of(voucher);
    }

    public void distribuirVouchers(Double percentualDesconto) {
        List<Destinatario> destinatarios = destinatarioService.recuperarDestinatarios();
        destinatarios.forEach(destinatario -> destinatario.setVoucher(criarVoucher(percentualDesconto).get()));
        destinatarios.forEach(destinatario -> destinatarioService.atualizarDestinatarioComOVoucher(destinatario));
    }

    public void usarVoucher(Optional<Destinatario> destinatario) {
        Voucher voucher = destinatario.get().getVoucher();
        if (voucher.isVoucherUsado()) {
            throw new ValidacaoException("O voucher já foi utilizado");
        }
        voucher.setDataDeUso(LocalDate.now());
        voucher.setVoucherUsado(true);
        voucherRepository.save(voucher);
    }

    @Override
    public void validarVoucher(Optional<Destinatario> destinatario, String codigo) {
        validacoes.forEach(e -> e.validarVoucher(destinatario, codigo));
    }
}
