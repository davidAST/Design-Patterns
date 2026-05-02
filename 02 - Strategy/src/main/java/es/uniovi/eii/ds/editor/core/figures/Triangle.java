package es.uniovi.eii.ds.editor.core.figures;

import es.uniovi.eii.ds.editor.core.Figure;
import es.uniovi.eii.ds.editor.core.Point;

public class Triangle implements Figure{

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;


    public Triangle (int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.y1= y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Triangle: (%d, %d), (%d, %d), and (%d, %d)",
            x1, y1, x2, y2, x3, y3));
    }

    @Override
    public boolean figureSelected(Point position) {
        if ((position.x == x1 && position.y == y1) || 
            (position.x == x2 && position.y == y2) ||
            (position.x == x3 && position.y == y3))
            return true;
        return false; 
    }

    @Override
    public void move(int x, int y) {
        int dx = x - x1;
        int dy = y - y1;

        this.x1 += dx;
        this.y1 += dy;
        this.x2 += dx;
        this.y2 += dy;
        this.x3 += dx;
        this.y3 += dy;
    }

}
