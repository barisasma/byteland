package com.byteland;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.byteland.domain.ByteLandCreator;
import com.byteland.domain.StateCreator;
import com.byteland.entity.City;

public class ByteLandTest {

	@Test
	public void test1() {
		//4
		//0 1 2
		int numberOfCities = 4;
		String[] roadMap = { "0", "1", "2" };
		ByteLandCreator creator = new ByteLandCreator(numberOfCities, roadMap);
		List<City> createdCities = creator.createCities();
		StateCreator unifier = new StateCreator();
		Assert.assertEquals(2, unifier.calculateUnificationSteps(createdCities).intValue());
	}
	
	@Test
	public void test2() {
		//8
		//0 1 2 0 0 3 3
		int numberOfCities = 8;
		String[] roadMap  = { "0", "1", "2", "0", "0", "3", "3" };
		ByteLandCreator creator = new ByteLandCreator(numberOfCities, roadMap);
		List<City> createdCities = creator.createCities();
		StateCreator unifier = new StateCreator();
		Assert.assertEquals(4, unifier.calculateUnificationSteps(createdCities).intValue());
	}
	
	@Test
	public void test3() {
		// 9
		// 0 1 1 1 1 0 2 2
		int numberOfCities = 9;
		String[] roadMap  = { "0", "1", "1", "1", "1", "0", "2", "2" };
		ByteLandCreator creator = new ByteLandCreator(numberOfCities, roadMap);
		List<City> createdCities = creator.createCities();
		Assert.assertEquals(4, createdCities.get(1).getConnectedCities().size());
		Assert.assertEquals(2, createdCities.get(0).getConnectedCities().size());
		Assert.assertEquals(2, createdCities.get(2).getConnectedCities().size());
		StateCreator unifier = new StateCreator();
		Assert.assertEquals(5, unifier.calculateUnificationSteps(createdCities).intValue());
	}
	
	@Test
	public void test4() {
		//12
		//0 1 1 3 3 5 6 0 8 8 10
		int numberOfCities = 12;
		String[] roadMap = { "0", "1", "1", "3", "3", "5", "6", "0", "8", "8", "10" };
		ByteLandCreator creator = new ByteLandCreator(numberOfCities, roadMap);
		List<City> createdCities = creator.createCities();
		StateCreator unifier = new StateCreator();
		Assert.assertEquals(4, unifier.calculateUnificationSteps(createdCities).intValue());
	}
	
	
}
