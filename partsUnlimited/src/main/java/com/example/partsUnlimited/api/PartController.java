package com.example.partsUnlimited.api;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.partsUnlimited.model.Part;
import com.example.partsUnlimited.service.PartService;

@RequestMapping("/api/v1/warehouse")
@RestController
public class PartController {

	private final PartService partService;
	
	@Autowired
	public PartController(PartService partService) {
		super();
		this.partService = partService;
	}

	@PostMapping
	public void addPart(@RequestBody Part part) {
		partService.addPart(part);
	}

	@GetMapping
	public List<Part> getAllParts(){
		return partService.getAllParts();
	}
	
	@GetMapping(path = "{serial_id}")
	public Part getPartById(@PathVariable("serial_id") String serial_id) {
		return partService.getPartById(serial_id)
				.orElse(null);
	}

	@GetMapping(path = "/date/{date}")
	public Part getPartByDate(@PathVariable("date") String manufacturingDate) {
		return partService.getPartByDate(manufacturingDate)
				.orElse(null);
	}

	@DeleteMapping(path = "{serial_id}")
	public void deletePartById(@PathVariable("serial_id")String serial_id) {
		partService.deletePart(serial_id);
	}
}
