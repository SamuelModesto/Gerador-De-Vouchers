package github.samuelmodesto.teste.getnet.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class
Destinatario {

    @Id
    private String id;

    @NonNull
    private String nome;

    @NonNull
    private String email;

    @DBRef
    private Voucher voucher;

}
