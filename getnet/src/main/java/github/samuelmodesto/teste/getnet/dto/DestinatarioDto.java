package github.samuelmodesto.teste.getnet.dto;

import github.samuelmodesto.teste.getnet.model.Voucher;
import lombok.Data;

@Data
public class DestinatarioDto {

    private String nome;
    private String email;
    private Voucher voucher;
}
