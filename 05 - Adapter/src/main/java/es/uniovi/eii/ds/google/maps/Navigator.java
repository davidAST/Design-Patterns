package es.uniovi.eii.ds.google.maps;

public class Navigator {
	
	// Simulates Google Maps navigation: given an address it gives us the
	// directions to reach it.
	public void getDirectionsTo(String address) {
		System.out.println("GPS: Turn right [...] You have reached your destination: " + address);
	}

	// Gets the coordinates of an address.
	public Coordinates coordinatesOf(String address) {
        // Generates fake coordinates based on the first letter of the address
		double number = (address.toLowerCase().charAt(0) - 'a') * 10 + 10;
		return new Coordinates(number, number);
	}

	// Gets the address for a pair of coordinates.
	public String addressFor(Coordinates coordinates) {
		return coordinates.toString();
	}
}
