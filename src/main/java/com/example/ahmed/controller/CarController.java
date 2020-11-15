package com.example.ahmed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ahmed.model.Car;
import com.example.ahmed.model.CarRepository;

@RestController
@RequestMapping("yelo/")
public class CarController {

@Autowired
CarRepository carRepository;

@GetMapping("/cars")
public List <Car> getAllCars(){
     return carRepository.findAll();	
}
@GetMapping("/cars/name/{name}")
public List<Car> findCarsByName(@PathVariable String name){
	 return carRepository.findByname(name); // var name > carName
}

@GetMapping("/cars/model/{model}")
public List<Car> findCarsByModel(@PathVariable String model){
	 return carRepository.findBymodel(model);
}

@GetMapping("/cars/orderedName/name")
public List<Car> findCarsByNameOrdered(@PathVariable String name){
	 return  carRepository.findBynameOrderByNameAsc(name);
}


@GetMapping("/cars/orderedModel/model")
public List<Car> findCarsByModelOrdered(@PathVariable String model){
	 return  carRepository.findBymodelOrderByModelAsc(model);
}

	
	
	
}
