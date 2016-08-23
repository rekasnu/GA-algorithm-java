package c3;

import java.util.ArrayList;

public class CityTour extends Tour {
	
	// Create city tour and populate tour array with cities 
	CityTour(ArrayList<City> destinationsArray) {
		tour = destinationsArray;
	}
	
	// create blank tour. City tour consteuctor is used for this.
	CityTour(int i) {
	//	tour = new ArrayList<City>(i);
		for (int x = 0; x < i; x++) {
			  tour.add(null);
			}
	}


}
