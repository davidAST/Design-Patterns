package es.uniovi.eii.ds.editor.core.figures;

import es.uniovi.eii.ds.editor.core.Figure;
import es.uniovi.eii.ds.editor.core.Point;

public class Rectangle implements Figure{

    private int x;
    private int y;
    private int height;
    private int width;

    public Rectangle (int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Rectangle at (%d, %d) with width %d and height %d", 
            x, y, width, height));
    }

    @Override
    public boolean figureSelected(Point corner) {
        boolean clicked = (corner.x <= x && x <= corner.x + width)
               && (corner.y <= y && y <= corner.y + height);
        return clicked;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
