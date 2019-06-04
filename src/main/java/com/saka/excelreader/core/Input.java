package com.saka.excelreader.core;

import java.util.List;

public class Input {

	String sheet;
	List <Infields> fields;

	public Input(Input ip) {
		// TODO Auto-generated constructor stub
		this.setSheet(ip.getSheet());
		this.setFields(ip.getFields());
	}
	
	public Input() {
		// TODO Auto-generated constructor stub
	}

	public String getSheet() {
		return sheet;
	}
	public void setSheet(String sheet) {
		this.sheet = sheet;
	}
	public List<Infields> getFields() {
		return fields;
	}
	public void setFields(List<Infields> fields) {
		this.fields = fields;
	}
	@Override
	public String toString() {
		return "Input [sheet=" + sheet + ", fields=" + fields + "]";
	}
	
		
}
