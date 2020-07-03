package com.example.partsUnlimited.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.partsUnlimited.model.Brand;
import com.example.partsUnlimited.model.Car;
import com.example.partsUnlimited.model.Part;

public interface PartDao {
	
	int insertPart(Part part);
	
	List<Part> selectAllParts();
	
	Optional<Part> selectPartById(String serial_id);

	Optional<Part> selectPartByDate(String manufacturingDate);
	
	int deletePart(String serial_id);

	//Optional <Part> selectPartByBrandAndCarName(String BrandAndCarName);

	//List <Car>selectCountPartsForCarModel();
	
}
