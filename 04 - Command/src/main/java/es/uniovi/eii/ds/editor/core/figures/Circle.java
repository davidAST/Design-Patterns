package es.uniovi.eii.ds.editor.core.figures;

import es.uniovi.eii.ds.editor.core.Figure;
import es.uniovi.eii.ds.editor.core.Point;

public class Circle implements Figure{

    private int x;
    private int y;
    private int radius;

    public Circle (int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Circle at (%d, %d) with radius %d", 
            x, y, radius));
    }

    @Override
    public boolean figureSelected(Point center) {
        double distance = Math.sqrt(Math.pow(x - center.x, 2) + Math.pow(y - center.y, 2));
        boolean clicked = distance < radius;
        return clicked;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
