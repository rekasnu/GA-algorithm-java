package c3;

import java.util.ArrayList;

public class CityTourFactory implements TourCreationData {

	private ArrayList<City> cityDestinations;
	CityTourFactory(){
		cityDestinations= new ArrayList<City>();
	}
	// Add city destination
	public void addDestination(City city) {
		cityDestinations.add(city);	
	}
	// Get city destination
	public City getDestination(int index) {
		return cityDestinations.get(index);
	}
	// Get citie array size
	public int getSize() {
		return cityDestinations.size();
	}
	// Get citie array
	public ArrayList<City> getDestinationsArray() {
		return cityDestinations;
	}

}
