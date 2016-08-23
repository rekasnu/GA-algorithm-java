package c3;
/**
 * this clas holds all operations which can be executed on any City tour or Town Tour
 * 
 */
import java.util.ArrayList;
import java.util.Collections;

public abstract class Tour {
	//define variables
	protected ArrayList<City> myTour;
	protected ArrayList<City> tour;
    private double fitness = 0;
    private int distance = 0;
    Tour(){
    	tour = new ArrayList<City>();
  //  	for(City c : tour){
  //  		tour.add(null);
  //  	}
    }

	void makeTour(ArrayList<City> a1) {
		tour = new ArrayList<City>();
		for(City c1 : a1){
	//		System.out.println(c1);
			tour.add(c1);
	}
		Collections.shuffle(tour);		
	}
	//Getter to get new tour
	public ArrayList<City> getMyTour() {
		return tour;
	}
	

    // Gets the tours fitness
    double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }

    // Gets the total distance of the tour
    int getDistance(){
        if (distance == 0) {
            double tourDistance = 0;
            // Loop through our tour's cities
      //      System.out.println("aaaaaaaaaaa sixe"+tourSize());
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                // Get city we're travelling from
                City fromCity = getCity(cityIndex);
      //          System.out.println(fromCity);
                // City we're travelling to
                City destinationCity;
                // Check we're not on our tour's last city, if we are set our
                // tour's final destination city to our starting city
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                // Get the distance between the two cities
              //  System.out.print(" add "+fromCity.distanceTo(destinationCity));
                tourDistance += fromCity.distanceTo(destinationCity);
              //  System.out.println("tour distance  "+tourDistance);
            }
            distance = (int)tourDistance;
        }
        return distance;
    }
    
    // Gets a city from the tour
    City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }
    
    // Sets a city in a certain position within a tour
    void setCity(int tourPosition, City city) {
    	tour.set(tourPosition, city);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }

	double distanceBetween(City a, City b){
    	   
    	int xd = Math.abs(a.getX()-b.getX());
    	int yd = Math.abs(a.getY()-b.getY());
    	double dist = Math.sqrt( (xd*xd) + (yd*yd) );
    	
    	return dist;
    	
    }
    // Get number of cities on our tour
    int tourSize() {
        return tour.size();
    }
    // Check if the tour contains a city
    boolean containsCity(City city){
        return tour.contains(city);
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        geneString += " | fitness = "+fitness+" | distance = "+distance+" | ";
        return geneString;
    }   
    
}
