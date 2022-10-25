package github.samuelmodesto.teste.getnet.repository;

import github.samuelmodesto.teste.getnet.model.OfertaEspecial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfertaEspecialRepository extends MongoRepository<OfertaEspecial, String> {
}
