package com.example.demo.models;

public class LocationStats {

	
	private String state;
	private String country;
	private int LetestTotalcases;
	private int diff;
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLetestTotalcases() {
		return LetestTotalcases;
	}
	public void setLetestTotalcases(int letestTotalcases) {
		LetestTotalcases = letestTotalcases;
	}
	

	
	public String toString(){
		
		
		return "LoactionStates {"+"states='"+state+'\''+",Country='"+country+'\''+", latestTotalcases ="+LetestTotalcases+'}';
		
		
	}
	public int getDiff() {
		return diff;
	}
	public void setDiff(int diff) {
		this.diff = diff;
	}
	
}
