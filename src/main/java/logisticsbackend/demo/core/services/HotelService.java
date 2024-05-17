package logisticsbackend.demo.core.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import logisticsbackend.demo.core.entities.Hotel;
import logisticsbackend.demo.core.repositories.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    // Create Hotels
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Read All Hotels
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    // Read By ID
    public Hotel findById(long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    // Delete Hotels
    public void deleteById(long id) {
        hotelRepository.deleteById(id);
    }

    // Parcial Update
    public ResponseEntity<Hotel> updateById(long id, Hotel hotelUpdate) {
        try {
            Hotel hotelExist = findById(id);
            if (hotelExist == null)  return ResponseEntity.notFound().build();
            // Update each field
            if (hotelUpdate.getName() != null) hotelExist.setName(hotelUpdate.getName());
            if (hotelUpdate.getAddress() != null) hotelExist.setAddress(hotelUpdate.getAddress());
            if (hotelUpdate.getPhone() != null) hotelExist.setPhone(hotelExist.getPhone());
            if (hotelUpdate.getEmail() != null) hotelExist.setEmail(hotelUpdate.getEmail());
            if (hotelUpdate.getEnable() != null) hotelExist.setEnable(hotelUpdate.getEnable());
            // Save Data
            Hotel hotelSave = save(hotelExist);
            return ResponseEntity.ok(hotelSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };
}
