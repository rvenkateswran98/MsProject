package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.customexecption.BrandNotFoundException;
import com.vehicle.customexecption.IdNotFoundException;
import com.vehicle.customexecption.InvalidBoardException;
import com.vehicle.entity.Bus;
import com.vehicle.service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {

	@Autowired
	BusService bs;

	@PatchMapping(value = "/setBus")
	public String setBus(@RequestBody Bus b) throws InvalidBoardException {
		return bs.setBus(b);

	}

	@PostMapping(value = "/setAllBus")
	public String setAllBus(@RequestBody List<Bus> b) throws InvalidBoardException {
		return bs.setAllBus(b);

	}

	@GetMapping(value = "/getAllBus")
	public List<Bus> getAllBus() {
		return bs.getAllBus();

	}

	@GetMapping(value = "/getById/{a}")
	public Bus getById(@PathVariable int a) throws IdNotFoundException {
		return bs.getById(a);

	}

	@GetMapping(value = "/getByName/{a}")
	public List<Bus> getByName(@PathVariable String a) throws BrandNotFoundException {
		return bs.getByName(a);
	}

	@PutMapping(value = "/update/{id}")
	public String update(@PathVariable int id, @RequestBody Bus b) throws IdNotFoundException {

		return bs.Update(id, b);
	}

}
