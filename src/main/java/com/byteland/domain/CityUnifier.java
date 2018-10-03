package com.byteland.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import com.byteland.entity.City;

public class CityUnifier {

	// methods finds city which has lowest possible connections!
	public static City findLeastConnectedCity(City city) {
		List<City> connectedCities = city.getConnectedCities();
		return connectedCities.stream()
				.filter(City::isNotUnified) //only for not unifieds
				.min(Comparator.comparing(City::neighboorsNumber)) //minimum
				.orElseThrow(NoSuchElementException::new); 
	}

}
