package com.vehicle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.customexecption.IdNotFoundException;
import com.vehicle.entity.Bus;
import com.vehicle.repository.BusRepository;

@Repository
public class BusDao {

	@Autowired
	BusRepository br;

	public String setBus(Bus b) {
		
		
		br.save(b);
		
		return "Saved ";
	}

	public String setAllBus(List<Bus> b) {
		br.saveAll(b);
		return "Saved All Buses";
	}

	public List<Bus> getAllBus() {

		return br.findAll();
	}

	public Bus getById(int a) throws IdNotFoundException {
		
		return br.findById(a).orElseThrow(()->new IdNotFoundException("ID NOT FOUND "));
	}

	public List<Bus> getByName(String a) {
		return br.getByName(a);
	}

}
