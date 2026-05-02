package es.uniovi.eii.ds.places.model;

import es.uniovi.eii.ds.google.maps.Navigator;
import es.uniovi.eii.ds.places.Place;

public class Restaurant extends Place {
	private static Navigator nav = new Navigator();

	private String name;
	private String address;
	private String phone;

	public Restaurant(String name, String address, String phone) {
		super(name, nav.coordinatesOf(address), phone);
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String name() {
		return name;
	}

	public String address() {
		return address;
	}

	public String phone() {
		return phone;
	}

	// Call the restaurant
	public void call() {
		System.out.printf("Calling %s...%n", phone);
	}
}
