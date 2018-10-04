package com.byteland.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.byteland.entity.City;

public class CityUnifier {

	Integer counter = Integer.valueOf(0);
	
	public Integer unifyCities(List<City> cityList) {
		merger(cityList, counter);
		return counter;
	}

	private void merger(List<City> cityList, Integer counter) {
		if (cityList.get(0).getConnectedCities().isEmpty())
			return;
		List<City> newMergeList = new ArrayList<>();
		for (City city : cityList) {
			if (!city.isUnified()) {
				mergeCity(city);
				newMergeList.add(city);
			}
		}
		this.counter++;
		merger(newMergeList, this.counter);
	}
	
	private static void mergeCity(City city) {
		Optional<City> findLowestElementOp = findLowestElement(city);
		if(findLowestElementOp.isPresent()) {
			City lowestElement = findLowestElementOp.get();
			if(lowestElement.getConnectedCities().isEmpty()) {
				city.getConnectedCities().remove(lowestElement);
				lowestElement.setUnified(true);
			}
			else {
				lowestElement.getConnectedCities().forEach(city::addConnectedCity);
				lowestElement.setUnified(true);
				city.getConnectedCities().remove(lowestElement);
			}
		}
	}
	
	private static Optional<City> findLowestElement(City city) {
		return city.getConnectedCities().stream().min(Comparator.comparing(City::getConnectionsNum));
	}

}
