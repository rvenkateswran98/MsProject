package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Bike;
import com.vehicle.service.BikeService;

@RestController
public class BikeController {

	@Autowired
	BikeService bs;

	@PostMapping(value = "/setbike")
	public String setBike(@RequestBody Bike a) {
		return bs.setBike(a);
	}

	@PostMapping(value = "/setAllBikes")
	public String setAllBikes(@RequestBody List<Bike> ab) {

		return bs.setAllBikes(ab);
	}
	@GetMapping(value="/getbikes")
	public List<Bike> getBike(){
		return bs.getBike();
	}
	
	@GetMapping(value ="/getId/{r}")
	public Bike getById(@PathVariable int r) {
		return bs.getById(r);
	}
	
	@DeleteMapping(value ="delet/{t}")
	public String delte(@PathVariable int t) {
		return bs.delet(t);
	}
	
	@GetMapping(value ="getBrand/{q}")
	public List<Bike> getBrand(@PathVariable String q){
		return bs.getBrand(q);
	}
	
	@GetMapping(value ="getByRange/{a}/{b}")
	public List<Bike> getByRange(@PathVariable int a,@PathVariable int b){
		return bs.getByRange(a,b);
	}
	
	@GetMapping(value ="getbrandByColor/{cl}")
	public List<String> getBrandByColor(@PathVariable String cl){
		return bs.getBrandByColor(cl);
	}
	
	@GetMapping(value ="getMax")
	public Bike getMax() {
		return bs.getMax();
	}
	@GetMapping(value ="getMin")
	public Bike getMin() {
		return bs.getMax();
	}
	
	@GetMapping(value="getNet/{a}")
	public List<Bike> getReduceBike(@PathVariable int a){
		return bs.getReduceBike(a);
	}
	

	
	
	

}
