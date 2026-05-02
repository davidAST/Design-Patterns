package es.uniovi.eii.ds.places.model;

import es.uniovi.eii.ds.google.maps.Coordinates;
import es.uniovi.eii.ds.places.Place;

public class Photo extends Place {
	
	private String description;
	
	// Information about the user who took the photo
	private String user;
	
	// Coordinates where the photo was taken
	private Coordinates coordinates;

	public Photo(String description, String user, Coordinates coordinates) {
		super(description, coordinates, user);
		this.description = description;
		this.coordinates = coordinates;
		this.user = user;
	}

	public String description() {
		return description;
	}

	public String user() {
		return user;
	}

	public Coordinates coordinates() {
		return coordinates;
	}

	public void show() {
		System.out.printf("Opening photo %s...%n", description);
	}
}
