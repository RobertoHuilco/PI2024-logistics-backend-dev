package logisticsbackend.demo.user;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    // create
    @PostMapping("/")
    public Users save(@RequestBody Users entity) {
        return usersService.save(entity);
    }

    // select by id
    @GetMapping("/{id}/")
    public Users findById(@PathVariable long id) {
        return usersService.findById(id);
    }

    // Api update
    @PutMapping("/")
    public Users update(@RequestBody Users entity) {
        return usersService.save(entity);
    }

    // Api Delete
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id) {
        usersService.deleteById(id);
    }

    // read all
    @GetMapping("/")
    public List<Users> findAll() {
        return usersService.findAll();
    }

    // Udate by id
    @PutMapping(value = "users/{id}")
    public ResponseEntity<Users> updateById(@PathVariable Long id, @RequestBody Users entity) {
        return usersService.updateById(id, entity);
    }
}
