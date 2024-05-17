package logisticsbackend.demo.core.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import logisticsbackend.demo.core.entities.Transport;

public interface TransportRepository extends CrudRepository<Transport, Long> {
    @SuppressWarnings("null")
    List<Transport> findAll();
}
