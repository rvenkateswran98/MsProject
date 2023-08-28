package com.vehicle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Bike;
import com.vehicle.repository.BikeRepository;

@Repository

public class BikeDao {
	@Autowired
	BikeRepository br;

	public String setBike(Bike b) {
		br.save(b);
		return "Saved Successfull";
	}

	public String setAllBike(List<Bike> ab) {
		br.saveAll(ab);
		
		return "All Saved ";
	}

	public List<Bike> getBike() {
		
		return br.findAll();
	}

	public Bike getById(int r) {
		
		return br.findById(r).get();
	}

	public String delet(int t) {
		
		 br.deleteById(t);;
	return "Delete SuccessFully";
	}

	

}
