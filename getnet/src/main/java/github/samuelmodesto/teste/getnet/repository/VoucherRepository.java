package github.samuelmodesto.teste.getnet.repository;

import github.samuelmodesto.teste.getnet.model.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoucherRepository extends MongoRepository<Voucher, String> {

}

