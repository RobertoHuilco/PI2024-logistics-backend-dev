package logisticsbackend.demo.role;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    // Create
    public Role save(Role entity)
    {
        return rolesRepository.save(entity);
    }
    // select by id
    public Role findById(long id){
        return rolesRepository.findById(id).orElse(null);
    }
    // Delete
    public void deleteById(long id){
        rolesRepository.deleteById(id);
    }

    // select all
    public List<Role> findAll(){
        return rolesRepository.findAll();
    }
    // update by id
    public ResponseEntity<Role> updateById(Long id, Role roleActualizada){
        try
        {
            Role roleExistente=findById(id);
            if (roleExistente == null) {
                return ResponseEntity.notFound().build();
            }
            // Actualizar los campos
            if (roleActualizada.getName()!=null) {
                roleExistente.setName(roleActualizada.getName());
            }
            // Guardar los datos
            Role RoleGuardada= save(roleExistente);
            // Return
            return ResponseEntity.ok(RoleGuardada);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
            // return ResponseEntity.status(HttpStatusCode)
        }
    }
}
