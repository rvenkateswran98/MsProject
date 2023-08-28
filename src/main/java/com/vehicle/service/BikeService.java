package com.vehicle.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.BikeDao;
import com.vehicle.entity.Bike;

@Service
public class BikeService {
	@Autowired
	BikeDao bd;

	public String setBike(Bike b) {
		return bd.setBike(b);
	}

	public String setAllBikes(List<Bike> ab) {
		return bd.setAllBike(ab);
	}

	public List<Bike> getBike() {

		return bd.getBike();
	}

	public Bike getById(int r) {

		return bd.getById(r);
	}

	public String delet(int t) {

		return bd.delet(t);
	}

	public List<Bike> getBrand(String q) {

		List<Bike> g = getBike();
		List<Bike> list = g.stream().filter(x -> x.getBrand().equalsIgnoreCase(q)).collect(Collectors.toList());
		return list;
	}

	public List<Bike> getByRange(int a, int b) {
		List<Bike> h = getBike();

		List<Bike> lst1 = h.stream().filter(x -> x.getPrice()> a && x.getPrice() < b)
				.collect(Collectors.toList());

		return lst1;
	}

	public List<String> getBrandByColor(String cl) {
		List<Bike> cc=getBike();
		List<String> list2 = cc.stream().filter(x -> x.getColor().equalsIgnoreCase(cl)).map(d->d.getBrand()).collect(Collectors.toList());
		return list2;
	}

	public Bike getMax() {
		List<Bike> gg=getBike();
		Bike maxx = gg.stream().max(Comparator.comparing(Bike::getPrice)).get();
		return maxx;
	}
	
	public Bike getMin() {
		List<Bike> gg=getBike();
		Bike minn = gg.stream().min(Comparator.comparing(Bike::getPrice)).get();
		return minn;
	}

	public List<Bike> getReduceBike(int a) {
	
		return getBike().stream().peek(c->c.setPrice(c.getPrice()-c.getPrice()*a/100)).collect(Collectors.toList());
			
		
	}
	
	

}
