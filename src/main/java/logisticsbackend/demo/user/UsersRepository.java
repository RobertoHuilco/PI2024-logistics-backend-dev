package logisticsbackend.demo.user;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {

    List<Users> findAll();
}
