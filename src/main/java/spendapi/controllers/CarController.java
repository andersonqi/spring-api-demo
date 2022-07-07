package spendapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spendapi.entities.Car;
import spendapi.services.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    
    private final CarService service;

    CarController(CarService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Car> createCar(@RequestBody Car payload) {
        return new ResponseEntity<>(service.createCar(payload), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody Car payload, @PathVariable("id") Long id) {

        if(service.existsById(id)) {
            return new ResponseEntity<>(service.updateCar(payload), HttpStatus.ACCEPTED);
        }
        
        throw new IllegalArgumentException("Car with id " + id + "not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable("id") Long id) {
        service.deleteCar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
