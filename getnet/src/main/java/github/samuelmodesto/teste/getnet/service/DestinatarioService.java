package github.samuelmodesto.teste.getnet.service;

import github.samuelmodesto.teste.getnet.model.Destinatario;

import java.util.List;
import java.util.Optional;

public interface DestinatarioService {

    void criarDestinatario(Destinatario destinatario);

    void atualizarDestinatarioComOVoucher(Destinatario destinatario);

    List<Destinatario> recuperarDestinatarios();

    Optional<Destinatario> resgatarDestinatarioPorEmail(String email);

    boolean validarEmailJaCadastrado(String email);
}
