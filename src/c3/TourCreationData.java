package c3;

import java.util.ArrayList;
/**
* TourCreation.java
* Interface used in tour creation process
*/

public interface TourCreationData {

	void addDestination(City city);
	City getDestination(int index);
	int getSize();
	public ArrayList<City> getDestinationsArray();

}

