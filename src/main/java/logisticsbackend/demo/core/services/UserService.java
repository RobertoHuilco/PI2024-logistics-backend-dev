package logisticsbackend.demo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import logisticsbackend.demo.core.entities.Users;
import logisticsbackend.demo.core.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create Users
    public Users save(Users users) {
        return userRepository.save(users);
    }

    // Read All Users
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    // Read By ID
    public Users findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Delete User
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    // Update By ID - Partial
    public ResponseEntity<Users> updateById(Long id, Users userUpdate) {
        try {
            Users userExist = findById(id);
            if (userExist == null)
                return ResponseEntity.notFound().build();
            // Update each field
            if (userUpdate.getFullNames() != null)
                userExist.setFullNames(userUpdate.getFullNames());
            if (userUpdate.getLastNames() != null)
                userExist.setLastNames(userUpdate.getLastNames());
            if (userUpdate.getDni() != null)
                userExist.setDni(userUpdate.getDni());
            if (userUpdate.getPhone() != null)
                userExist.setPhone(userUpdate.getPhone());
            if (userUpdate.getEmail() != null)
                userExist.setEmail(userUpdate.getEmail());
            if (userUpdate.getPassword() != null)
                userExist.setPassword(userUpdate.getPassword());
            if (userUpdate.getAddress() != null)
                userExist.setAddress(userUpdate.getAddress());
            if (userUpdate.getGenre() != null)
                userExist.setGenre(userUpdate.getGenre());
            if (userUpdate.getBloodType() != null)
                userExist.setBloodType(userUpdate.getBloodType());
            if (userUpdate.getBirthday() != null)
                userExist.setBirthday(userUpdate.getBirthday());
            if (userUpdate.getMaritalState() != null)
                userExist.setMaritalState(userUpdate.getMaritalState());
            if (userUpdate.getEmergencyContact() != null)
                userExist.setEmergencyContact(userUpdate.getEmergencyContact());
            if (userUpdate.getEmergencyPhone() != null)
                userExist.setEmergencyPhone(userUpdate.getEmergencyPhone());
            if (userUpdate.getDisease() != null)
                userExist.setDisease(userUpdate.getDisease());
            if (userUpdate.getDisability() != null)
                userExist.setDisability(userUpdate.getDisability());
            if (userUpdate.getEnable() != null)
                userExist.setEnable(userUpdate.getEnable());
            // Save Data
            Users userSave = save(userExist);
            return ResponseEntity.ok(userSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };
}
