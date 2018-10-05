package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;
import com.byteland.domain.ByteLandCreator;
import com.byteland.domain.StateCreator;
import com.byteland.entity.City;

public class MainByteLandApp {

	private static final Logger logger = Logger.getLogger(MainByteLandApp.class.getName());

	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Enter Number of Test Cases: ");
			String readLine = reader.readLine();
			startTestCases(readLine, reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void startTestCases(String readLine, BufferedReader reader) throws IOException {
		Integer numberOfTestCases = Integer.valueOf(readLine);
		if (numberOfTestCases >= 1000)
			throw new IllegalArgumentException("Number of test cases should be below 1000");
		for (int i = 0; i < numberOfTestCases; i++) {
			System.out.println("Enter City Number (2 <= k <= 600): ");
			String cityNumber = reader.readLine();
			Integer cityNumberInt = Integer.valueOf(cityNumber);
			if (cityNumberInt < 2 || cityNumberInt > 600)
				throw new IllegalArgumentException("City Number should be between 2 and 600");
			enterRoadsAndCalculateSteps(cityNumberInt,reader);
		}
	}

	private static void enterRoadsAndCalculateSteps(Integer cityNumberInt, BufferedReader reader) throws IOException {
		System.out.println("Enter roads: (k-1) ");
		String readLine = reader.readLine();
		String[] roads = readLine.split(" ");
		if (roads.length != cityNumberInt - 1) {
			throw new IllegalArgumentException("Roads should be exactly cityNumber - 1");
		}
		calculateSteps(cityNumberInt,roads);	
	}

	private static void calculateSteps(Integer cityNumberInt, String[] roads) {
		ByteLandCreator creator = new ByteLandCreator(cityNumberInt, roads);
		List<City> createdCities = creator.createCities();
		StateCreator unifier = new StateCreator();
		Integer steps = unifier.unifyCities(createdCities);
		System.out.println(steps);
	}

}
