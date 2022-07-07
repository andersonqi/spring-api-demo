package spendapi.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import spendapi.entities.Car;
import spendapi.repositories.CarRepository;


@Service
public class CarService {

    private final CarRepository repository;

    CarService(CarRepository repository){
        this.repository = repository;
    }

    public List<Car> listAll() {
        return repository.findAll();
    }

    public Car findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public Car createCar(Car payload) {
        return repository.save(payload);
    }

    public Car updateCar(Car payload) {
        return repository.save(payload);
    }

    public void deleteCar(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
