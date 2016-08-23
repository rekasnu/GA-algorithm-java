package c3;

//	Now we can create our main method, add our cities and evolve a route 
//	for our travelling salesman problem.

/*
* TSP_GA.java
* Create a tour and evolve a solution
*/

public class TSP_GA {

   public static TourCreationData cityTour;
   public static TourCreationData townTour;

	public static void main(String[] args) {
		
		cityTour = new CityTourFactory();
		townTour = new TownTourFactory();
        // Create and add our cities
        City city = new City(60, 200, "Dublin");
        cityTour.addDestination(city);
        City city2 = new City(180, 200, "Carlow");
        townTour.addDestination(city2);
        City city3 = new City(80, 180, "Howt");
        townTour.addDestination(city3);
        City city4 = new City(140, 180, "Paris");
        cityTour.addDestination(city4);
        City city5 = new City(20, 160, "Berlin");
        cityTour.addDestination(city5);
        City city6 = new City(100, 160, "Dundalk");
        townTour.addDestination(city6);
        City city7 = new City(200, 160, "Cork");
        cityTour.addDestination(city7);
        City city8 = new City(140, 140, "Limerick");
        cityTour.addDestination(city8);
        City city9 = new City(40, 120, "Waterford");
        townTour.addDestination(city9);
        City city10 = new City(100, 120, "Navan");
        townTour.addDestination(city10);
        City city11 = new City(180, 100, "Arclov");
        townTour.addDestination(city11);
        City city12 = new City(60, 80, "London");
        cityTour.addDestination(city12);
        City city13 = new City(120, 80, "Birmingam");
        cityTour.addDestination(city13);
        City city14 = new City(180, 60, "Belfast");
        cityTour.addDestination(city14);
        City city15 = new City(20, 40, "Newtown");
        townTour.addDestination(city15);
        City city16 = new City(100, 40, "Sligo");
        townTour.addDestination(city16);
        City city17 = new City(200, 40, "Barselon");
        cityTour.addDestination(city17);
        City city18 = new City(20, 20, "Ballsbriggan");
        townTour.addDestination(city18);
        City city19 = new City(60, 20, "Mulingar");
        townTour.addDestination(city19);
        City city20 = new City(10, 202, "Roma");
        cityTour.addDestination(city20);
        City city21 = new City(10, 400, "Rostova");
        cityTour.addDestination(city21);
        City city22 = new City(10, 2, "Praga");
        cityTour.addDestination(city22);
        City city23 = new City(100, 100, "Malta");
        cityTour.addDestination(city23);
        City city24 = new City(12, 40, "Visbija");
        cityTour.addDestination(city24);
        City city25 = new City(100, 280, "Madrid");
        cityTour.addDestination(city25);
        City city26 = new City(20, 20, "Dog Town");
        townTour.addDestination(city26);
        City city27 = new City(200, 200, "Cat Town");
        townTour.addDestination(city27);
        City city28 = new City(24, 90, "Mouse Town");
        townTour.addDestination(city28);
        City city29 = new City(2, 129, "Snow Town");
        townTour.addDestination(city29);
        City city30 = new City(75, 230, "Boa Town");
        townTour.addDestination(city30);
        
     //   System.out.println(cityTour.getDestinationsArray());
    //    System.out.println(townTour.getDestinationsArray());
        
        TourBuilder build = new TourBuilder();
        Tour cc = build.orderTour("city");
        Tour tt = build.orderTour("town");
        
       // CityTour cc = new CityTour(cityTour);
       // TownTour tt = new TownTour(townTour);
        
      //  System.out.println(cc.getMyTour());
     //   System.out.println(tt.getMyTour());
     //   System.out.println("\n Mix \n");
     //   tt.makeTour(tt.tour);
      //  System.out.println(tt.getMyTour());
      // Initialize population
        Population pop = new Population(50, cc);
    //    pop.display();
        GA ga = new GA();
        System.out.println("City Tours - One pointe crosover method : (100 generations)");
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations with one crossover point
        pop = ga.evolvePopulationOne(pop);
        for (int i = 0; i < 100; i++) {
   //     	System.out.println("Generation "+i+" Initial distance: " + pop.getFittest().getDistance()+"\n");
            pop = ga.evolvePopulationOne(pop);
    //        System.out.println("Generation "+i+" Final distance: " + pop.getFittest().getDistance());
        
        }
        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
      //System.out.println(pop.getFittest());
        pop.calcDistance(pop.getFittest());
        
        Population pop1 = new Population(50,cc);
        System.out.println("\n\nCity Tours - Two pointe crosover method : (Subset between two points) - 100 generations");
        System.out.println("Initial distance: " + pop1.getFittest().getDistance());
        // Evolve population for 100 generations with two crossover points
        pop1 = ga.evolvePopulationTwo(pop1);
        for (int i = 0; i < 100; i++) {
 //       	System.out.println("Generation "+i+" Initial distance: " + pop1.getFittest().getDistance()+"\n");
            pop1 = ga.evolvePopulationTwo(pop1);
 //           System.out.println("Generation "+i+" Final distance: " + pop1.getFittest().getDistance());
        
        }
        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop1.getFittest().getDistance());
        System.out.println("Solution:");
      //  System.out.println(pop1.getFittest());
        pop1.calcDistance(pop1.getFittest());
        
        System.out.println("\n\n\n");
        
        Population pop2 = new Population(50, tt);
    //    pop.display();
        GA ga2 = new GA();
        System.out.println("Town Tours - One pointe crosover method : (100 generations)");
        System.out.println("Initial distance: " + pop2.getFittest().getDistance());

        // Evolve population for 100 generations with one crossover point
        pop2 = ga2.evolvePopulationOne(pop2);
        for (int i = 0; i < 100; i++) {
   //     	System.out.println("Generation "+i+" Initial distance: " + pop2.getFittest().getDistance()+"\n");
            pop2 = ga.evolvePopulationOne(pop2);
    //        System.out.println("Generation "+i+" Final distance: " + pop2.getFittest().getDistance());
        
        }
        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop2.getFittest().getDistance());
        System.out.println("Solution:");
       // System.out.println(pop2.getFittest());
        pop2.calcDistance(pop2.getFittest());
        
        
        Population pop3 = new Population(50,tt);
        System.out.println("\n\nTown Tours - Two pointe crosover method : (Subset between two points) - 100 generations");
        System.out.println("Initial distance: " + pop3.getFittest().getDistance());
        // Evolve population for 100 generations with two crossover points
        pop3 = ga2.evolvePopulationTwo(pop3);
        for (int i = 0; i < 100; i++) {
 //       	System.out.println("Generation "+i+" Initial distance: " + pop3.getFittest().getDistance()+"\n");
            pop3 = ga.evolvePopulationTwo(pop3);
 //           System.out.println("Generation "+i+" Final distance: " + pop3.getFittest().getDistance());
        
        }
        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop3.getFittest().getDistance());
        System.out.println("Solution:");
       // System.out.println(pop3.getFittest());
        pop3.calcDistance(pop3.getFittest());
      
    } 
}