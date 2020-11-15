package com.example.ahmed.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ahmed.exception.ResourceNotFoundException;
import com.example.ahmed.model.Car;
import com.example.ahmed.model.CarRepository;



@RestController
@RequestMapping("yelo/") 
public class CarCrudController {
	@Autowired
	CarRepository carRepository; 
	
	@PostMapping("cars/save")
	  public Car saveCAr( @RequestBody Car car) {
		  return carRepository.save(car);
	  }
	 @PutMapping("/cars/{id}")
	  public ResponseEntity<Car> updateCar(@PathVariable  long id , @RequestBody Car carRequest){
		  Car car=carRepository.findById(id)
				  .orElseThrow(()-> new ResourceNotFoundException("employee not exists with id "+id ));
		  car.setName(carRequest.getName());
		  car.setModel(carRequest.getModel());
		  car.setColor(carRequest.getColor());
		  car.setOwner(carRequest.getOwner());
		  
		  Car carResponse=carRepository.save(car);
		return ResponseEntity.ok(carResponse);   
	}
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteCar(@PathVariable  long id){
		 Car car=carRepository.findById(id)
				  .orElseThrow(()-> new ResourceNotFoundException("employee not exists with id "+id ));
		 carRepository.delete(car);
		Map<String,Boolean> resultMap=new HashMap<>();
		resultMap.put("deleted", Boolean.TRUE);
		return  ResponseEntity.ok(resultMap);
	}
	
}
