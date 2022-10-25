package github.samuelmodesto.teste.getnet.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
@AllArgsConstructor
@NoArgsConstructor
public class OfertaEspecial {

    @Id
    private String id;
    private String nome;
    private List<Destinatario> destinatarios;
}
