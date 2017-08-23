package com.rest.excercise.domain.entities;

import java.util.ArrayList;
import java.util.Map;

public class Configuration {
	
	private ArrayList <Map <String, String>> entry;
	
	public Configuration() {
		super();
	}

	public Configuration(ArrayList<Map<String, String>> entry) {
		super();
		this.entry = entry;
	}

	public ArrayList<Map<String, String>> getEntry() {
		return entry;
	}

	public void setEntry(ArrayList<Map<String, String>> entry) {
		this.entry = entry;
	}
	
	

}
