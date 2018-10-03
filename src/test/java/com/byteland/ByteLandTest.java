package com.byteland;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.byteland.domain.ByteLandCreator;
import com.byteland.domain.CityUnifier;
import com.byteland.entity.City;

public class ByteLandTest {

	@Test
	public void test() {
		// 9
		// 0 1 1 1 1 0 2 2
		int numberOfCities = 9;
		int[] roadMap = { 0, 1, 1, 1, 1, 0, 2, 2 };
		ByteLandCreator creator = new ByteLandCreator(numberOfCities, roadMap);
		List<City> createdCities = creator.createCities();
		Assert.assertEquals(5, createdCities.get(1).getConnectedCities().size());
		findLowestPossibleCity(createdCities);
	}
	
	public void findLowestPossibleCity(List<City> createdCities){
		//should find city which has lowest connections
		Assert.assertEquals(6, CityUnifier.findLeastConnectedCity(createdCities.get(0)).getIndex());
		Assert.assertEquals(3, CityUnifier.findLeastConnectedCity(createdCities.get(1)).getIndex());
		Assert.assertEquals(7, CityUnifier.findLeastConnectedCity(createdCities.get(2)).getIndex());
	}
	
}
