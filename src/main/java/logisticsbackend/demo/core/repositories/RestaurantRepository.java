package logisticsbackend.demo.core.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import logisticsbackend.demo.core.entities.Restaurant;

public interface RestaurantRepository extends CrudRepository <Restaurant, Long> {
    @SuppressWarnings("null")
    List<Restaurant> findAll();
}
