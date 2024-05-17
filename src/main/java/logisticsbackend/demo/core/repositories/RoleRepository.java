package logisticsbackend.demo.core.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import logisticsbackend.demo.core.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    @SuppressWarnings("null")
    List<Role> findAll();
}
