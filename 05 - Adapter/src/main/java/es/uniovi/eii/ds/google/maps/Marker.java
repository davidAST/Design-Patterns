package es.uniovi.eii.ds.google.maps;

public interface Marker {
	String getTitle();
	Coordinates getPosition();
	String getHTMLInfo();
	void open();
}
