package c3;

public class TourBuilder extends TourGenerator {

	protected Tour makeTour(String tourType){
		Tour tour = null;
		
		if(tourType.equals("city")){
//			TourCreationData tourData = new CityTourFactory();
			tour = new CityTour(TSP_GA.cityTour.getDestinationsArray());
		}else{
			if(tourType.equals("town")){
//				TourCreationData tourData = new TownTourFactory();
				tour = new TownTour(TSP_GA.townTour.getDestinationsArray());
			}
		}
		
		return tour;
	}

}
