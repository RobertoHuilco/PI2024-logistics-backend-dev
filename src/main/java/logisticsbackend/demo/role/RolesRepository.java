package logisticsbackend.demo.role;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RolesRepository extends CrudRepository<Role, Long>
{
    List<Role> findAll();    
}