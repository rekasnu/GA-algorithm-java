package c3;

import java.text.DecimalFormat;

//	We also need to create a class that can hold a 
//	population of candidate tours

/*
* Population.java
* Manages a population of candidate tours
*/


public class Population {

    // Holds population of tours
    Tour[] tours;

    // Construct a population
    Population(int populationSize) {
        tours = new Tour[populationSize];       
            // Loop and create individuals
            for (int i = 0; i < populationSize(); i++){
                Tour newTour = new CityTour(TSP_GA.cityTour.getDestinationsArray());
                newTour.makeTour(newTour.tour);
                saveTour(i, newTour);
            }
    }

	public Population(int populationSize, Tour cc) {
        tours = new Tour[populationSize];       
        // Loop and create individuals
        for (int i = 0; i < populationSize(); i++){
            Tour newTour = new CityTour(cc.tour);
            newTour.makeTour(newTour.tour);
            saveTour(i, newTour);
        }
	}

	void display(){
		int x=0;
		for(Tour t: tours){
	    	
	    		System.out.println(x+" "+t);
	    		x++;
		}
    }
    
    // Saves a tour
    void saveTour(int index, Tour newTour) {
       tours[index] = newTour;
    }
    
    // Gets a tour from population
    Tour getTour(int index) {
        return tours[index];
    }

    // Gets the best tour in the population
    Tour getFittest() {
        Tour fittest = tours [0];
        // Loop through individuals to find fittest
  //      System.out.println("xxxxxxxxxxxx"+fittest.myTour);
  //      fittest.setTour(tours[0]);
    //    fittest.getDistance();
        for (int i = 1; i < populationSize(); i++) {
    //    	System.out.println("fitnes  "+getTour(i).getDistance());
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }
    // calculate distance between two cities in tour
    void calcDistance(Tour t){
    	double dist = 0;
    	DecimalFormat df = new DecimalFormat("#.##");
    	for (int i=0; i<t.tourSize(); i++){
    		if(i==0) dist = 0;
    		else {
    			if(i==t.tourSize()-1){
    				dist = t.distanceBetween(t.getCity(i-1),t.getCity(i)); 
	    			System.out.print(t.getCity(i-1).getName()+" ");
	    			System.out.print("-> "+df.format(dist)+" km  -> ");
	
	    			System.out.print(t.getCity(i).getName()+" | ");
    				dist = t.distanceBetween(t.getCity(i),t.getCity(0));
        			System.out.print(t.getCity(i).getName()+" ");
        			System.out.print("-> "+df.format(dist)+" km  -> ");

        			System.out.print(t.getCity(0).getName()+" | ");
    			}else{    				
	    			dist = t.distanceBetween(t.getCity(i-1),t.getCity(i)); 
	    			System.out.print(t.getCity(i-1).getName()+" ");
	    			System.out.print("-> "+df.format(dist)+" km  -> ");
	
	    			System.out.print(t.getCity(i).getName()+" | ");
    			}
    		}
    	}

    }


	// Gets population size
    int populationSize() {
        return tours.length;
    }
}
