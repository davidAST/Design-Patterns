package es.uniovi.eii.ds.places.model;

import es.uniovi.eii.ds.google.maps.Navigator;
import es.uniovi.eii.ds.places.Place;

public class Monument extends Place {
	private static Navigator nav = new Navigator();

	private String name;
	private String author;
	private String address;

	public Monument(String name, String author, String address) {
		super(name, nav.coordinatesOf(address), author);
	}

	public String name() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String address() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String author() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
