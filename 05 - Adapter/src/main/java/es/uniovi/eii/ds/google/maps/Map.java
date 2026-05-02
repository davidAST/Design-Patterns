package es.uniovi.eii.ds.google.maps;

import java.awt.Rectangle;
import java.util.*;

public class Map {

	private List<Marker> markers = new ArrayList<>();

	public void add(Marker marker) {
		markers.add(marker);
	}

	public void draw() {
		// Here the map is drawn
		// ...
		
		// and then the markers
		for (Marker marker : markers)
			System.out.println(marker.getTitle() + " at " + marker.getPosition());
	}

	public void userTouch(int x, int y) {
		Marker marker = getmarkerAt(x, y);
		if (marker != null)
			System.out.println("An emergent window is open: " + marker.getHTMLInfo());
	}

	public void userLongTouch(int x, int y) {
		Marker marker = getmarkerAt(x, y);
		if (marker != null)
			marker.open();
	}

	private Marker getmarkerAt(int x, int y) {
		for (Marker marker : markers) {
			Coordinates coordinates = marker.getPosition();
			Rectangle markerArea = new Rectangle(
				(int) coordinates.getLongitude() - 5, 
				(int) coordinates.getLatitude() - 5, 
				10, 10);
			if (markerArea.contains(x, y))
				return marker;
		}
		return null;
	}	
}
