package logisticsbackend.demo.core.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import logisticsbackend.demo.core.entities.StarsCategory;

public interface StarsCategoryRepository extends CrudRepository<StarsCategory, Long>{
    @SuppressWarnings("null")
    List<StarsCategory> findAll();
}
