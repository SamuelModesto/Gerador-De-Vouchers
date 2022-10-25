package github.samuelmodesto.teste.getnet.repository;

import github.samuelmodesto.teste.getnet.model.Destinatario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DestinatarioRepository extends MongoRepository<Destinatario, String> {

    Optional<Destinatario> findByEmail(String email);

    boolean existsByEmail(String email);
}

