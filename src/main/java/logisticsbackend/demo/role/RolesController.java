package logisticsbackend.demo.role;

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
@RequestMapping("/rol/")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    // create
    @PostMapping("/")
    public Role save(@RequestBody Role entity){
        return rolesService.save(entity);
    }
    // select by id
    @GetMapping("/{id}/")
    public Role findById(@PathVariable long id) {
        return rolesService.findById(id);
    }
    // Api update
    @PutMapping("/")
    public Role update(@RequestBody Role entity){
        return rolesService.save(entity);
    }
    // Api Delete
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id){
        rolesService.deleteById(id);
    }
    // read all
    @GetMapping("/")
    public List<Role> findAll(){
        return rolesService.findAll();
    }
    // Udate by id
    @PutMapping(value = "/{id}")
    public ResponseEntity <Role> updateById(@PathVariable Long id, @RequestBody Role entity){
        return rolesService.updateById(id, entity);
    }
}
