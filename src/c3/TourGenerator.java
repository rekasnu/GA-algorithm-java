package c3;

public abstract class TourGenerator {
	
	protected abstract Tour makeTour(String tourType);
	
	public Tour orderTour(String tourType){
		Tour tour = makeTour(tourType);
		tour.getFitness();
		tour.getDistance();
		tour.tourSize();
		
		return tour;
	}
}
