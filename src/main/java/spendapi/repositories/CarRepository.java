package spendapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spendapi.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}  
