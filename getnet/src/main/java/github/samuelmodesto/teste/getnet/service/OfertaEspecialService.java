package github.samuelmodesto.teste.getnet.service;

import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.model.OfertaEspecial;

import java.util.List;


public interface OfertaEspecialService {

    OfertaEspecial criarOfertaEspecial(OfertaEspecial especial, List<Destinatario> destinatarios);

}
