package com.example.partsUnlimited.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Part {

	private String serial_id;
	
	private String manufacturingDate;

	public Part(@JsonProperty("serial_id") String serial_id, @JsonProperty("date") String manufacturingDate) {
		super();
		this.serial_id = serial_id;
		this.manufacturingDate = manufacturingDate;
	}
	
	public String getSerial_id() {
		return serial_id;
	}

	public String getDate() {
		return manufacturingDate;
	}
}
