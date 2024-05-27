package logisticsbackend.demo.core.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import logisticsbackend.demo.core.entities.Restaurant;
import logisticsbackend.demo.core.repositories.RestaurantRepository;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    // Create Restaurants
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Read All Restaurants
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    // Read By ID
    public Restaurant findById(long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    // Delete Restaurants
    public void deleteById(long id) {
        restaurantRepository.deleteById(id);
    }

    // Parcial Update
    public ResponseEntity<Restaurant> updateById(long id, Restaurant restaurantUpdate) {
        try {
            Restaurant restaurantExist = findById(id);
            if (restaurantExist == null)
                return ResponseEntity.notFound().build();
            // Update each field
            if (restaurantUpdate.getName() != null)
                restaurantExist.setName(restaurantUpdate.getName());
            if (restaurantUpdate.getAddress() != null)
                restaurantExist.setAddress(restaurantUpdate.getAddress());
            if (restaurantUpdate.getEnable() != null)
                restaurantExist.setEnable(restaurantUpdate.getEnable());
            // Save Data
            Restaurant restaurantSave = save(restaurantExist);
            return ResponseEntity.ok(restaurantSave);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    };
}
