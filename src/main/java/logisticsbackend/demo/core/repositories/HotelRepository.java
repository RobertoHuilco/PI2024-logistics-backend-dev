package logisticsbackend.demo.core.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import logisticsbackend.demo.core.entities.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
    @SuppressWarnings("null")
    List<Hotel> findAll();
}
