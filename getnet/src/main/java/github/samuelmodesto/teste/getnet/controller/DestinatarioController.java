package github.samuelmodesto.teste.getnet.controller;

import github.samuelmodesto.teste.getnet.dto.DestinatarioDto;
import github.samuelmodesto.teste.getnet.model.Destinatario;
import github.samuelmodesto.teste.getnet.service.DestinatarioService;
import github.samuelmodesto.teste.getnet.service.VoucherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinatarios")
public class DestinatarioController {

    @Autowired
    private DestinatarioService destinatarioService;

    @Autowired
    private VoucherService voucherService;


    @PostMapping("/registrar")
    public ResponseEntity<Object> registrarDestinatario(@RequestBody DestinatarioDto destinatarioDto) {
        var destinatario = new Destinatario();
        if (destinatarioService.validarEmailJaCadastrado(destinatarioDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email ja existe");
        }
        BeanUtils.copyProperties(destinatarioDto, destinatario);
        destinatarioService.criarDestinatario(destinatario);
        return ResponseEntity.status(HttpStatus.CREATED).body(destinatario);
    }

    @GetMapping
    public ResponseEntity<List<Destinatario>> recuperarDestinatarios() {
        List<Destinatario> destinatarios = destinatarioService.recuperarDestinatarios();
        if (destinatarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(destinatarios);
    }

    @GetMapping("/resgatar")
    public ResponseEntity<Object> resgatarValorDescontoPorEmailECodigoDoVoucher(@RequestParam("email") String email,
                                                                                @RequestParam("codigo") String codigo) {
        Optional<Destinatario> destinatario = destinatarioService.resgatarDestinatarioPorEmail(email);
        voucherService.validarVoucher(destinatario, codigo);
        voucherService.usarVoucher(destinatario);
        return ResponseEntity.ok(destinatario.get().getVoucher().getPercentualDeconto());
    }
}
