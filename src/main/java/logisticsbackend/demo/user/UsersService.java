package logisticsbackend.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    // Create
    public Users save(Users entity) {
        return usersRepository.save(entity);
    }

    // select by id
    public Users findById(long id) {
        return usersRepository.findById(id).orElse(null);
    }

    // Delete
    public void deleteById(long id) {
        usersRepository.deleteById(id);
    }

    // select all
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    // update by id
    public ResponseEntity<Users> updateById(Long id, Users usersActualizada) {
        try {
            Users usersExistente = findById(id);
            if (usersExistente == null) {
                return ResponseEntity.notFound().build();
            }
            // Actualizar los campos
            if (usersActualizada.getLast_names() !=null) {
                usersActualizada.setLast_names(usersActualizada.getLast_names());
            }
            if (usersActualizada.getFirstNames() !=null) {
                usersActualizada.setFirstNames(usersActualizada.getFirstNames());
            }
            if (usersActualizada.getDni() !=null) {
                usersActualizada.setDni(usersActualizada.getDni());
            }
            if (usersActualizada.getPhone() !=null) {
                usersActualizada.setPhone(usersActualizada.getPhone());
            }
            if (usersActualizada.getEmail() !=null) {
                usersActualizada.setEmail(usersActualizada.getEmail());
            }
            if (usersActualizada.getPassword() !=null) {
                usersActualizada.setPassword(usersActualizada.getPassword());
            }
            if (usersActualizada.getAddress() !=null) {
                usersActualizada.setAddress(usersActualizada.getAddress());
            }
            if (usersActualizada.getGenre() !=null) {
                usersActualizada.setGenre(usersActualizada.getGenre());
            }
            if (usersActualizada.getBloodType() !=null) {
                usersActualizada.setBloodType(usersActualizada.getBloodType());
            }
            if (usersActualizada.getBirthday() !=null) {
                usersActualizada.setBirthday(usersActualizada.getBirthday());
            }
            if (usersActualizada.getMaritalState() !=null) {
                usersActualizada.setMaritalState(usersActualizada.getMaritalState());
            }
            if (usersActualizada.getEmergencyContact() !=null) {
                usersActualizada.setEmergencyContact(usersActualizada.getEmergencyContact());
            }
            if (usersActualizada.getEmergencyPhone() !=null) {
                usersActualizada.setEmergencyPhone(usersActualizada.getEmergencyPhone());
            }
            if (usersActualizada.getDisease() !=null) {
                usersActualizada.setDisease(usersActualizada.getDisease());
            }
            if (usersActualizada.getDisability() !=null) {
                usersActualizada.setDisability(usersActualizada.getDisability());
            }
            if (usersActualizada.getLast_names() !=null) {
                usersActualizada.setLast_names(usersActualizada.getLast_names());
            }
            if (usersActualizada.getEnable() !=null) {
                usersActualizada.setEnable(usersActualizada.getEnable());
            }
            // Guardar los datos
            Users UsersGuardada = save(usersExistente);
            // Return
            return ResponseEntity.ok(UsersGuardada);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
            // return ResponseEntity.status(HttpStatusCode)
        }
    }
}
