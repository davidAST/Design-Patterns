package es.uniovi.eii.ds.main;

import es.uniovi.eii.ds.google.maps.Map;
import es.uniovi.eii.ds.places.database.Database;
import es.uniovi.eii.ds.places.model.*;

public class Main {
	
	public static void main(String[] args) {
		Database database = new Database();
		Map map = new Map();
		
		// 1. Add markers to the map
		System.out.println("\n 1. Adding markers to the map...");
		
		
		for (Monument monument : database.selectMonuments()) {
			map.add(monument);
		}
		
		for (Photo photo : database.selectPhotos()) {
			map.add(photo);
		}

		for (Restaurant restaurant : database.selectRestaurants()) {
			map.add(restaurant);
		}

		// 2. Draw the map with all the markers
		System.out.println("\n 2. Show map:");
		
		map.draw();

		// 3. The user touches a marker to show information
		System.out.println("\n 3. Short touch: a tooltip is shown with a summary of the marker");
		map.userTouch(160, 160); // Summary of the Colosseum
		map.userTouch(22, 21);   // Summary of the photo
		map.userTouch(219, 221); // Summary of the restaurant

		// 4. The user performs a long touch on each marker
		System.out.println("\n 4. Long touch: an action is performed for the marker");
		map.userLongTouch(160, 158); // Navigate to the Colosseum
		map.userLongTouch(19, 22);   // Download the photo
		map.userLongTouch(222, 218); // Call the restaurant
	}
}
