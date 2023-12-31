package com.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehicle.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {

	@Query(value = "select * from bus_details where name like ?", nativeQuery = true)
	List<Bus> getByName(String a);

}
