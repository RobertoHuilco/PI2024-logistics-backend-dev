package logisticsbackend.demo.core.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import logisticsbackend.demo.core.entities.Users;

public interface UserRepository extends CrudRepository<Users, Long> {
    @SuppressWarnings("null")
    List<Users> findAll();
}
