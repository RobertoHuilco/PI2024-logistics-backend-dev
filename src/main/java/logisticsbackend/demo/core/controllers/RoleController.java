package logisticsbackend.demo.core.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// Role Module
import logisticsbackend.demo.core.entities.Role;
import logisticsbackend.demo.core.services.RoleService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin({ "*" })
public class RoleController {
    @Autowired
    private RoleService roleService;

    // CREATE ROLE
    @PostMapping(value = "/roles")
    public Role save(@RequestBody Role role) {
        return roleService.save(role);
    }

    // GET ALL ROLES
    @GetMapping(value = "/roles")
    public List<Role> getAll() {
        return roleService.findAll();
    }

    // GET BY ID
    @GetMapping(value = "/roles/{id}")
    public Role getById(@PathVariable long id) {
        return roleService.findById(id);
    }

    // DELETE ROLE
    @DeleteMapping(value = "/roles/{id}")
    public void deleteById(@PathVariable long id) {
        roleService.deleteById(id);
    }

    // UPDATE ROLE
    @PutMapping(value = "/roles/{id}")
    public Role update(@RequestBody Role entity) {
        return roleService.save(entity);
    }

    // PARTIAL UPDATE
    @PatchMapping(value = "/roles/{id}")
    public ResponseEntity<Role> updateById(@PathVariable Long id, @RequestBody Role role) {
        return roleService.updateById(id, role);
    }
}
