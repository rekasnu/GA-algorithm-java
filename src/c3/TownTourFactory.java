package c3;

import java.util.ArrayList;

public class TownTourFactory implements TourCreationData {

	private ArrayList<City> townDestinations = new ArrayList<City>();
	// Add town destination
	public void addDestination(City city) {
		townDestinations.add(city);
	}
	// Get town destination
	public City getDestination(int index) {
		return townDestinations.get(index);
	}
	// Get town arrea size
	public int getSize() {
		return townDestinations.size();
	}
	// Get town array
	public ArrayList<City> getDestinationsArray() {
		return townDestinations;
	}

}
