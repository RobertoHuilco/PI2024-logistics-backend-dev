package logisticsbackend.demo.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import logisticsbackend.demo.core.entities.StarsCategory;
import logisticsbackend.demo.core.repositories.StarsCategoryRepository;

@Service
public class StarsCategoryService {
    @Autowired
    private StarsCategoryRepository starsCategoryRepository;

    // Create Stars
    public StarsCategory save(StarsCategory starsCategory) {
        return starsCategoryRepository.save(starsCategory);
    }

    // Read All Stars
    public List<StarsCategory> findAll() {
        return starsCategoryRepository.findAll();
    }

    // Read By ID
    public StarsCategory findById(long id) {
        return starsCategoryRepository.findById(id).orElse(null);
    }

    // Delete Stars
    public void deleteById(long id) {
        starsCategoryRepository.deleteById(id);
    }

    // Partial Update
    public ResponseEntity<StarsCategory> updateById(long id, StarsCategory starsCategoryUpdate) {
        try {
            StarsCategory starsCategoryExist = findById(id);
            if (starsCategoryExist == null)
                return ResponseEntity.notFound().build();
            // Update each field
            if (starsCategoryUpdate.getName() != null)
                starsCategoryExist.setName(starsCategoryUpdate.getName());
            // Save Data
            StarsCategory starsCategorySave = save(starsCategoryExist);
            return ResponseEntity.ok(starsCategorySave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };
}
