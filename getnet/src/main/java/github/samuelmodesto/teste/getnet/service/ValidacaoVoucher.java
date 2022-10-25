package github.samuelmodesto.teste.getnet.service;

import github.samuelmodesto.teste.getnet.model.Destinatario;

import java.util.Optional;

public interface ValidacaoVoucher {

    void validarVoucher(Optional<Destinatario> destinatario, String codigo);
}
