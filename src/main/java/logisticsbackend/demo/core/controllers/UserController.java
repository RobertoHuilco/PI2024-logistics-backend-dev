package logisticsbackend.demo.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import logisticsbackend.demo.core.entities.Users;
import logisticsbackend.demo.core.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1")
@CrossOrigin({ "*" })
public class UserController {
    @Autowired
    private UserService userService;

    // CREATE
    @PostMapping(value = "/users")
    public Users save(@RequestBody Users users) {
        return userService.save(users);
    }

    // READ ALL
    @GetMapping(value = "/users")
    public List<Users> getAll() {
        return userService.findAll();
    }

    // READ BY ID
    @GetMapping(value = "users/{id}")
    public Users getById(@PathVariable long id) {
        return userService.findById(id);
    }

    // DELETE
    @DeleteMapping(value = "users/{id}")
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }

    // UPDATE
    @PutMapping(value = "users/{id}")
    public Users update(@RequestBody Users users) {
        return userService.save(users);
    }

    // PARTIAL UPDATE
    @PatchMapping(value = "users/{id}")
    public ResponseEntity<Users> updateById(@PathVariable long id, @RequestBody Users users) {
        return userService.updateById(id, users);
    };
}
