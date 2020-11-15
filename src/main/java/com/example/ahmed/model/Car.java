package com.example.ahmed.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="cars")
public class Car {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id ;

private String name ;
private String color;
private String  model;
private String owner;

@JsonProperty(access = Access.WRITE_ONLY)
private boolean hideMe;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public boolean isHideMe() {
	return hideMe;
}
public void setHideMe(boolean hideMe) {
	this.hideMe = hideMe;
}

	
	
	
}
