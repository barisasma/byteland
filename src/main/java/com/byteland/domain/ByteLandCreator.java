package com.byteland.domain;

import java.util.ArrayList;
import java.util.List;

import com.byteland.entity.City;

public class ByteLandCreator {

	private int cityNumber;
	private List<Integer> roadList;
	
	public ByteLandCreator(int cityNumber, int[] roads) {
		this.cityNumber = cityNumber;
		this.roadList = arrangeProperRoads(roads);
	}
	
	private List<Integer> arrangeProperRoads(int[] roads) {
		List<Integer> properRoads = new ArrayList<>();
		properRoads.add(Integer.valueOf(0));
		for (int i = 0; i < roads.length; i++) {
			properRoads.add(roads[i]);
		}
		return properRoads;
	}

	public List<City> createCities() {
		List<City> cities = new ArrayList<>();
		for (int i = 0; i < cityNumber; i++) {
			City city = new City(i,false);
			cities.add(city);
		}
		makeCityConnections(cities);
		return cities;
	}

	private void makeCityConnections(List<City> cities) {
		for (City city : cities) {
			Integer connectedCityIndex = roadList.get(city.getIndex());
			City connectedCity = cities.get(connectedCityIndex);
			if(!city.equals(connectedCity)) {//exceptional case for zero index city
				//linktTwoCity(city, connectedCity); //add city to its collections
				linktTwoCity(connectedCity,city); //make link to connected city
			}
		}
	}

	private void linktTwoCity(City city, City connectedCity) {
		city.addConnectedCity(connectedCity);
	}

}
