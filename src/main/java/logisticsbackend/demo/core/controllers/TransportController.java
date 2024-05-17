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

import logisticsbackend.demo.core.entities.Transport;
import logisticsbackend.demo.core.services.TransportService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin({ "*" })
public class TransportController {
    @Autowired
    private TransportService transportService;

    // CREATE
    @PostMapping(value = "/transports")
    public Transport save(@RequestBody Transport transport) {
        return transportService.save(transport);
    }

    // GET ALL
    @GetMapping(value = "/transports")
    public List<Transport> getAll() {
        return transportService.findAll();
    }

    // GET BY ID
    @GetMapping(value = "/transports/{id}")
    public Transport getById(@PathVariable long id) {
        return transportService.findById(id);
    }

    // DELETE
    @DeleteMapping(value = "/transports/{id}")
    public void deleteById(@PathVariable long id) {
        transportService.deleteById(id);
    }

    // UPDATE
    @PutMapping(value = "/transports/{id}")
    public Transport update(@RequestBody Transport transport) {
        return transportService.save(transport);
    }

    // PARTIAL UPDATE
    @PatchMapping(value = "/transports/{id}")
    public ResponseEntity<Transport> updateById(@PathVariable long id, @RequestBody Transport transport) {
        return transportService.updateById(id, transport);
    };
}
