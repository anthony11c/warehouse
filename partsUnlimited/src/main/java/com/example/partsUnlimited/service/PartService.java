package com.example.partsUnlimited.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.partsUnlimited.dao.PartDao;
import com.example.partsUnlimited.model.Part;

@Service
public class PartService {

	private final PartDao partDao;
	
	@Autowired
	public PartService(@Qualifier("mysql") PartDao partDao) {
		super();
		this.partDao = partDao;
	}
	
	public int addPart(Part part) {
		return partDao.insertPart(part);
	}
	
	public List<Part> getAllParts(){
		return partDao.selectAllParts();
	}
	
	public Optional<Part> getPartById(String serial_id){
		return partDao.selectPartById(serial_id);
	}

	public Optional<Part> getPartByDate(String manufacturingDate) {
		return partDao.selectPartByDate(manufacturingDate);
	}
	
	public int deletePart(String serial_id) {
		return partDao.deletePart(serial_id);
	}

}
 