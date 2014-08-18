/*Justin Tyme Dejesus
CSC 301 - HW 2
05/07/2014*/


public class CityCoord {
	
	private String city;
	private String state;
	private double lat;
	private double lng;
	
	public CityCoord(String city, String state, double lat, double lng) {
		// constructor
		
		this.city = city;
		this.state = state;
		this.lat = lat;
		this.lng = lng;
	}
	
	// methods for returning individual variables
	
	public String City() {
		return city;
	}
	
	public String State() {
		return state;
	}
	
	public double Latitude() {
		return lat;
	}
	
	public double Longitude() {
		return lng;
	}
	
	// in case I need to print it out all at once
	@Override
	public String toString() {
		
		return String.format("City: %s, State: %s, Lat: %f , Long: %f \n", City(), State(), Latitude(), Longitude());
	}
	
}
