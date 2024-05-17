package logisticsbackend.demo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import logisticsbackend.demo.core.entities.Tour;
import logisticsbackend.demo.core.repositories.TourRepository;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    // Create Tours
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }

    // Read All Tours
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    // Read By ID
    public Tour findById(long id) {
        return tourRepository.findById(id).orElse(null);
    }

    // Delete Tours
    public void deleteById(long id) {
        tourRepository.deleteById(id);
    }

    // Partial Update
    public ResponseEntity<Tour> updateById(long id, Tour tourUpdate) {
        try {
            Tour tourExist = findById(id);
            if (tourExist == null)
                return ResponseEntity.notFound().build();
            // Update each Field
            if (tourUpdate.getName() != null)
                tourExist.setName(tourUpdate.getName());
            if (tourUpdate.getDescription() != null)
                tourExist.setDescription(tourUpdate.getDescription());
            if (tourUpdate.getPrice() != null)
                tourExist.setPrice(tourUpdate.getPrice());
            if (tourUpdate.getDays_duration() != null)
                tourExist.setDays_duration(tourUpdate.getDays_duration());
            if (tourUpdate.getSector() != null)
                tourExist.setSector(tourUpdate.getSector());
            if (tourUpdate.getCapacity_quotes() != null)
                tourExist.setCapacity_quotes(tourUpdate.getCapacity_quotes());
            if (tourUpdate.getStart_date() != null)
                tourExist.setStart_date(tourUpdate.getStart_date());
            if (tourUpdate.getEnable() != null)
                tourExist.setEnable(tourUpdate.equals(tourExist));
            // Save Data
            Tour tourSave = save(tourExist);
            return ResponseEntity.ok(tourSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };
}
