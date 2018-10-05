package com.byteland.domain;

import com.byteland.entity.City;

public class ConnectedUnifier extends Unifier{

	public ConnectedUnifier(City city) {
		super(city);
	}
	
	@Override
	protected void makeCityArrangements(City cityHasLeastConnection) {
		//takes connections from unified city, apply them to parent city
		cityHasLeastConnection.getConnectedCities().forEach(city::addConnectedCity);
		super.makeCityArrangements(cityHasLeastConnection);
	}

}
