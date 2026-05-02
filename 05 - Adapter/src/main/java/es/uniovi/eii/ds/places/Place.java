package es.uniovi.eii.ds.places;

import es.uniovi.eii.ds.google.maps.Coordinates;
import es.uniovi.eii.ds.google.maps.Marker;

public abstract class Place implements Marker {

    private String title;
    private Coordinates coordinates;
    private String htmlInfo;

    public Place(String title, Coordinates coordinates, String htmlInfo) {
        this.title = title;
        this.coordinates = coordinates;
        this.htmlInfo = htmlInfo;
    }

    @Override
    public String getTitle() {
        return title;
    }


    @Override
    public Coordinates getPosition() {
        return coordinates;
    }

    @Override
    public String getHTMLInfo() {
        return htmlInfo;
    }

    @Override
    public void open() {
        //TODO
    }

}
