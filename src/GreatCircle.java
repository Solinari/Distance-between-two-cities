/*Justin Tyme Dejesus
CSC 301 - HW 2
05/07/2014*/

public class GreatCircle {
	
	public static double distance(double lat1, double lng1, double lat2, double lng2) {
			
		// radius of the earth
		
		double R = 3950.02;
		
		// my four coordinates in radians
		
		double latone = Math.toRadians(lat1);
		double lngone = Math.toRadians(lng1);
		double lattwo = Math.toRadians(lat2);
		double lngtwo = Math.toRadians(lng2);
		
		// longest variable ever... ~_~
		
		double d = R * (Math.acos((Math.sin(latone) * Math.sin(lattwo)) + (Math.cos(latone) * Math.cos(lattwo) * Math.cos(lngone - lngtwo))));
		
		return d;
	}

}
