package github.samuelmodesto.teste.getnet.controller;

import github.samuelmodesto.teste.getnet.dto.OfertaEspecialDto;
import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.model.OfertaEspecial;
import github.samuelmodesto.teste.getnet.service.DestinatarioService;
import github.samuelmodesto.teste.getnet.service.OfertaEspecialService;
import github.samuelmodesto.teste.getnet.service.VoucherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ofertas")
public class OfertaEspecialController {

    @Autowired
    private OfertaEspecialService ofertaEspecialService;

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private DestinatarioService destinatarioService;

    @PostMapping
    public OfertaEspecial criarOferta(@RequestBody OfertaEspecialDto ofertaEspecialDto, @RequestParam Double percentualDesconto) {

        var ofertaEspecial = new OfertaEspecial();
        BeanUtils.copyProperties(ofertaEspecialDto, ofertaEspecial);
        List<Destinatario> destinatarios = destinatarioService.recuperarDestinatarios();
        voucherService.distribuirVouchers(percentualDesconto);
        return ofertaEspecialService.criarOfertaEspecial(ofertaEspecial, destinatarios);
    }
}
