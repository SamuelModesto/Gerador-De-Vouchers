package github.samuelmodesto.teste.getnet.service.impl;

import github.samuelmodesto.teste.getnet.exception.ValidacaoException;
import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.service.ValidacaoVoucher;

import java.util.Optional;

public class ValidacaoVoucherExistenteImpl implements ValidacaoVoucher {
    @Override
    public void validarVoucher(Optional<Destinatario> destinatario, String codigo) {
        if (!destinatario.get().getVoucher().getCodigoVoucher().equals(codigo)) {
            throw new ValidacaoException("Voucher não encontrado");
        }
    }
}
