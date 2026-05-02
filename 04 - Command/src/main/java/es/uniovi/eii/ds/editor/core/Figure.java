package es.uniovi.eii.ds.editor.core;

public interface Figure {
    public void draw();
    public boolean figureSelected(Point point);
    public void move(int x, int y);
}
