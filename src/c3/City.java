package c3;

/**
*   This class models a city
*   @author Ermins Dreimanis, David Sullivan, Moroof Shobowale
*   @version 1
*/


public class City {
    int x_coordinate;
    int y_coordinate;
    String city_name;

    /**
	*   A placed city is created randomly
	*/
    City(){
        x_coordinate = (int)(Math.random()*200);
        y_coordinate = (int)(Math.random()*200);
    }

    /**
	*   This city is created at a particular location according to its coordinates
	*/
    City(int 1_x_coordinate, int 1_y_coordinate, String name_coordinate){
        x_coordinate = 1_x_coordinate;
        y_coordinate = 1_y_coordinate;
        city_name = name_coordinate;
    }

    /**
	*   Find the city's X coordinate
	*	@return City's X coordinate
	*/
    int getX_coordinate(){
        return x_coordinate;
    }

    /**
	*   Find the city's Y coordinate
	*	@return City's Y coordinate
	*/
    int getY_coordinate(){
        return y_coordinate;
    }

    /**
	*   Find the city's name
	*	@return City's name
	*/
    String getCityname(){
    	return city_name;
    }

    /**
	*   Now find the distance to this particular city
	*	@return Calculates the distance to this city - name given
	*/
    double findDistance(City city){
        int findX_Distance = Math.abs(getX_coordinate() - city.getX_coordinate());
        int findY_Distance = Math.abs(getY_coordinate() - city.getY_coordinate());
        double result = Math.sqrt( (findX_Distance*findX_Distance) + (findY_Distance*findY_Distance) );

        return result;
    }

    public String toString(){
        return getX_coordinate()+", "+getY_coordinate()+" "+city_name;
    }
}
