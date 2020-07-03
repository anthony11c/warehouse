package com.example.partsUnlimited.model;

import java.util.UUID;

public class Car extends Brand {
	private final int  id;
	private final String name;
	
	public Car(int id, String name) {
		super(id, name);
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
