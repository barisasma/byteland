package com.byteland.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.byteland.entity.City;

public class StateUnification {

	private final AtomicInteger counter;

	public StateUnification() {
		counter = new AtomicInteger(0);
	}
	
	public Integer calculateUnificationSteps(List<City> cityList) {
		uniteCityStepByStep(cityList);
		return counter.get();
	}

	private void uniteCityStepByStep(List<City> cityList) {
		if (cityList.get(0).getConnectedCities().isEmpty())
			return;
		List<City> newMergeList = mergeCityAndGetNewCityList(cityList);
		counter.incrementAndGet();
		uniteCityStepByStep(newMergeList);
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
	
	private void mergeCity(City city) {
		Optional<City> findLowestElementOp = findCityHasLeastConnection(city);//always merge with city which has lowest connections.
		if(findLowestElementOp.isPresent()) {
			City cityHasLeastConnection = findLowestElementOp.get();
			Unifier unifier = new ConnectedUnifier(city);
			unifier.makeCityArrangements(cityHasLeastConnection);
		}
	}
	
	private Optional<City> findCityHasLeastConnection(City city) {
		return city.getConnectedCities().stream().min(Comparator.comparing(City::getConnectionsNum));
	}

}
