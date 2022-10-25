package github.samuelmodesto.teste.getnet.service.impl;

import github.samuelmodesto.teste.getnet.exception.ValidacaoException;
import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.service.ValidacaoVoucher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
public class ValidacaoValidadeVoucherImpl implements ValidacaoVoucher {
    @Override
    public void validarVoucher(Optional<Destinatario> destinatario, String codigo) {
        LocalDate dataAtual = LocalDate.now();
        if (destinatario.get().getVoucher().getValidade().compareTo(dataAtual) < 0) {
            throw new ValidacaoException("Voucher fora da validade");
        }
    }
}
