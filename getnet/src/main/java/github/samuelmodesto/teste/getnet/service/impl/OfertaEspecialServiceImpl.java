package github.samuelmodesto.teste.getnet.service.impl;

import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.model.OfertaEspecial;
import github.samuelmodesto.teste.getnet.repository.OfertaEspecialRepository;
import github.samuelmodesto.teste.getnet.service.OfertaEspecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaEspecialServiceImpl implements OfertaEspecialService {

    @Autowired
    private OfertaEspecialRepository ofertaEspecialRepository;

    @Override
    public OfertaEspecial criarOfertaEspecial(OfertaEspecial ofertaEspecial, List<Destinatario> destinatarios) {
        ofertaEspecial.setDestinatarios(destinatarios);
        return ofertaEspecialRepository.save(ofertaEspecial);
    }
}
