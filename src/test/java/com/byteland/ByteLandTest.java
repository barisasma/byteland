package com.byteland;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.byteland.domain.ByteLandCreator;
import com.byteland.domain.CityUnifier;
import com.byteland.entity.City;

public class ByteLandTest {

	@Test
	public void test1() {
		//4
		//0 1 2
		int numberOfCities = 4;
		int[] roadMap = { 0, 1, 2 };
		ByteLandCreator creator = new ByteLandCreator(numberOfCities, roadMap);
		List<City> createdCities = creator.createCities();
		CityUnifier unifier = new CityUnifier();
		Assert.assertEquals(2, unifier.unifyCities(createdCities).intValue());
	}
	
	@Test
	public void test2() {
		// 9
		// 0 1 1 1 1 0 2 2
		int numberOfCities = 9;
		int[] roadMap = { 0, 1, 1, 1, 1, 0, 2, 2 };
		ByteLandCreator creator = new ByteLandCreator(numberOfCities, roadMap);
		List<City> createdCities = creator.createCities();
		Assert.assertEquals(4, createdCities.get(1).getConnectedCities().size());
		Assert.assertEquals(2, createdCities.get(0).getConnectedCities().size());
		Assert.assertEquals(2, createdCities.get(2).getConnectedCities().size());
//		findLowestPossibleCity(createdCities);
		CityUnifier unifier = new CityUnifier();
		Assert.assertEquals(5, unifier.unifyCities(createdCities).intValue());
	}
	
	
	@Test
	public void test3() {
		//8
		//0 1 2 0 0 3 3
		int numberOfCities = 8;
		int[] roadMap = { 0, 1, 2, 0, 0, 3, 3 };
		ByteLandCreator creator = new ByteLandCreator(numberOfCities, roadMap);
		List<City> createdCities = creator.createCities();
		CityUnifier unifier = new CityUnifier();
		Assert.assertEquals(4, unifier.unifyCities(createdCities).intValue());
	}
	
//	public void findLowestPossibleCity(List<City> createdCities){
//		//should find city which has lowest connections
//		Assert.assertEquals(6, CityUnifier.findLeastConnectedCity(createdCities.get(0)).getIndex());
//		Assert.assertEquals(3, CityUnifier.findLeastConnectedCity(createdCities.get(1)).getIndex());
//		Assert.assertEquals(7, CityUnifier.findLeastConnectedCity(createdCities.get(2)).getIndex());
//	}
//	
}
