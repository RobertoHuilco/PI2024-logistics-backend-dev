package logisticsbackend.demo.core.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import logisticsbackend.demo.core.entities.Role;
import logisticsbackend.demo.core.repositories.RoleRepository;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // Create
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    // Read All
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    // Read By ID
    public Role findById(long id) {
        return roleRepository.findById(id).orElse(null);
    }

    // Delete Role
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }

    // Update By ID - Partial
    public ResponseEntity<Role> updateById(Long id, Role roleUpdate) {
        try {
            Role roleExist = findById(id);
            if (roleUpdate == null) return ResponseEntity.notFound().build();
            // Update each field
            if (roleUpdate.getName() != null) roleExist.setName(roleUpdate.getName());
            // Save Data
            Role roleSave = save(roleExist);
            return ResponseEntity.ok(roleSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };
}
