package com.example.partsUnlimited.model;

import java.util.UUID;

public class Brand {

	private final int  id;
	private final String name;
	
	public Brand(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
