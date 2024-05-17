package logisticsbackend.demo.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import logisticsbackend.demo.core.entities.Tour;
import logisticsbackend.demo.core.services.TourService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin({ "*" })
public class TourController {
    @Autowired
    private TourService tourService;

    // CREATE
    @PostMapping(value = "/tours")
    public Tour save(@RequestBody Tour tour) {
        return tourService.save(tour);
    }

    // GET ALL
    @GetMapping(value = "/tours")
    public List<Tour> getAll() {
        return tourService.findAll();
    }

    // GET BY ID
    @GetMapping(value = "/tours/{id}")
    public Tour getById(@PathVariable long id) {
        return tourService.findById(id);
    }

    // DELETE
    @DeleteMapping(value = "tours/{id}")
    public void deleteById(@PathVariable long id) {
        tourService.deleteById(id);
    }

    // UPDATE
    @PutMapping(value = "/tours/{id}")
    public Tour update(@RequestBody Tour tour) {
        return tourService.save(tour);
    }

    // PARTIAL UPDATE
    @PatchMapping(value = "/tours/{id}")
    public ResponseEntity<Tour> updateById(@PathVariable long id, @RequestBody Tour tour) {
        return tourService.updateById(id, tour);
    }
}
