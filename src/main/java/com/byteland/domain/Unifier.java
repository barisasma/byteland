package com.byteland.domain;

import com.byteland.entity.City;

public abstract class Unifier {
	
	protected City city;
	
	public Unifier(City city) {
		this.city = city;
	}
	
	protected void makeCityArrangements(City cityHasLeastConnection) {
		city.getConnectedCities().remove(cityHasLeastConnection);//remove means unify.
		cityHasLeastConnection.setUnified(true);//flag it as unified for no more unify.
	}

}
