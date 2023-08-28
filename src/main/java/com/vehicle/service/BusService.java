package com.vehicle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.customexecption.BrandNotFoundException;
import com.vehicle.customexecption.IdNotFoundException;
import com.vehicle.customexecption.InvalidBoardException;
import com.vehicle.dao.BusDao;
import com.vehicle.entity.Bus;

@Service
public class BusService {

	@Autowired
	BusDao bd;

	public String setBus(Bus b) throws InvalidBoardException {
		try {
			if (b.getBoard().equalsIgnoreCase("White")) {
				return bd.setBus(b);
			} else {
				throw new InvalidBoardException("Invalid Data");
			}
		}

		catch (InvalidBoardException e) {
			return "Not ";
		}

	}

	public String setAllBus(List<Bus> b) throws InvalidBoardException {
		List<Bus> s = b.stream()
				.filter(f -> f.getBoard().equalsIgnoreCase("White") || f.getBoard().equalsIgnoreCase("Yellow"))
				.collect(Collectors.toList());

		if (s.isEmpty()) {
			throw new InvalidBoardException("Not Acceptable");
		} else {

			return bd.setAllBus(s);
		}
	}

	public List<Bus> getAllBus() {
		return bd.getAllBus();
	}

	public Bus getById(int a) throws IdNotFoundException {

		return bd.getById(a);
	}

	public List<Bus> getByName(String a) throws BrandNotFoundException {

		List<Bus> n = bd.getByName(a);

		if (n.isEmpty()) {

			throw new BrandNotFoundException("Brand Not ex");
		} else {
			return n;
		}
	}

	public String Update(int id, Bus b) throws IdNotFoundException {
		Bus x = getById(id);
		Bus y = b;
		x.setId(id);
		x.setBoard(x.getBoard());
		x.setName(y.getName());
		x.setBrand(y.getBrand());
		x.setNoOfSeat(y.getNoOfSeat());
		x.setNoPlate(y.getNoPlate());
		x.setType(y.getType());

		bd.setBus(x);

		return "Updated Saved";
	}

}
