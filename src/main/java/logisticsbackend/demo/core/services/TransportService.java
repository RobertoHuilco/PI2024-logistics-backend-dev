package logisticsbackend.demo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import logisticsbackend.demo.core.entities.Transport;
import logisticsbackend.demo.core.repositories.TransportRepository;

@Service
public class TransportService {
    @Autowired
    private TransportRepository transportRepository;

    // Create Transports
    public Transport save(Transport transport) {
        return transportRepository.save(transport);
    }

    // Read All Transpots
    public List<Transport> findAll() {
        return transportRepository.findAll();
    }

    // Read By ID
    public Transport findById(long id) {
        return transportRepository.findById(id).orElse(null);
    }

    // Delete Transports
    public void deleteById(long id) {
        transportRepository.deleteById(id);
    }

    // Partial Update
    public ResponseEntity<Transport> updateById(long id, Transport transportUpdate) {
        try {
            Transport transportExist = findById(id);
            if (transportExist == null)
                return ResponseEntity.notFound().build();
            // Update each field
            if (transportUpdate.getName() != null)
                transportExist.setName(transportUpdate.getName());
            if (transportUpdate.getPrice() != null)
                transportExist.setPrice(transportUpdate.getPrice());
            if (transportUpdate.getCapacity() != null)
                transportExist.setCapacity(transportUpdate.getCapacity());
            if (transportUpdate.getEnable() != null)
                transportExist.setCapacity(transportUpdate.getCapacity());
            // Save Data
            Transport transportSave = save(transportExist);
            return ResponseEntity.ok(transportSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };

}
