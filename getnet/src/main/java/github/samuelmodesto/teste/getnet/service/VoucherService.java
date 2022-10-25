package github.samuelmodesto.teste.getnet.service;

import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.model.Voucher;

import java.util.Optional;

public interface VoucherService {

    String gerarCodigoVoucher();

    Optional<Voucher> criarVoucher(Double percentualDesconto);

    void distribuirVouchers(Double percentualDesconto);

    void usarVoucher(Optional<Destinatario> destinatario);

    void validarVoucher(Optional<Destinatario> destinatario, String codigo);

}
