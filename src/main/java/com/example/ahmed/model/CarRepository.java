package com.example.ahmed.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long> {
   List<Car>  findByname(String name);
   List<Car>  findBymodel(String model);
   List <Car>  findBynameOrderByNameAsc(String name);
   List <Car>  findBymodelOrderByModelAsc(String model);	
}
