package com.byteland.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.byteland.entity.City;

public class StateCreator {

	private Integer counter;

	public StateCreator() {
		counter = Integer.valueOf(0);
	}
	
	public Integer unifyCities(List<City> cityList) {
		unifyCityStepByStep(cityList, counter);
		return counter;
	}

	private void unifyCityStepByStep(List<City> cityList, Integer counter) {
		if (cityList.get(0).getConnectedCities().isEmpty())
			return;
		List<City> newMergeList = mergeCityAndGetNewCityList(cityList);
		incrementCounter();
		unifyCityStepByStep(newMergeList, this.counter);
	}

	private void incrementCounter() {
		this.counter++;
	}

	private List<City> mergeCityAndGetNewCityList(List<City> cityList) {
		List<City> newCityList = new ArrayList<>();
		for (City city : cityList) {
			ifNotUnifiedMergeAndAdd(newCityList, city);
		}
		return newCityList;
	}

	private void ifNotUnifiedMergeAndAdd(List<City> newCityList, City city) {
		if (!city.isUnified()) {
			mergeCity(city);
			newCityList.add(city);
		}
	}
	
	private static void mergeCity(City city) {
		Optional<City> findLowestElementOp = findCityHasLeastConnection(city);//always merge with city which has lowest connections.
		if(findLowestElementOp.isPresent()) {
			City cityHasLeastConnection = findLowestElementOp.get();
			Unifier unifier = new ConnectedUnifier(city);
			unifier.makeCityArrangements(cityHasLeastConnection);
		}
	}
	
	private static Optional<City> findCityHasLeastConnection(City city) {
		return city.getConnectedCities().stream().min(Comparator.comparing(City::getConnectionsNum));
	}

}
