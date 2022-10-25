package github.samuelmodesto.teste.getnet.service.impl;

import github.samuelmodesto.teste.getnet.exception.ObjectNotFoundException;
import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.repository.DestinatarioRepository;
import github.samuelmodesto.teste.getnet.service.DestinatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinatarioServiceImpl implements DestinatarioService {

    @Autowired
    private DestinatarioRepository destinatarioRepository;


    @Override
    public void criarDestinatario(Destinatario destinatario) {
        destinatarioRepository.save(destinatario);
    }

    @Override
    public void atualizarDestinatarioComOVoucher(Destinatario destinatario) {
        destinatarioRepository.save(destinatario);
    }

    @Override
    public List<Destinatario> recuperarDestinatarios() {
        return destinatarioRepository.findAll();
    }

    @Override
    public Optional<Destinatario> resgatarDestinatarioPorEmail(String email) {
        Optional<Destinatario> destinatario = destinatarioRepository.findByEmail(email);
        return Optional.ofNullable(destinatario.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado")));
    }

    @Override
    public boolean validarEmailJaCadastrado(String email) {
        return destinatarioRepository.existsByEmail(email);
    }

}
