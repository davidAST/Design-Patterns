package es.uniovi.eii.ds.editor.core.tools;


import es.uniovi.eii.ds.editor.core.Editor;
import es.uniovi.eii.ds.editor.core.Tool;
import es.uniovi.eii.ds.editor.core.figures.Rectangle;

public class RectangleTool implements Tool{

    private Editor editor;
   
    private int x1;
    private int y1;

     public RectangleTool (Editor editor) {
        this.editor = editor;
    }


    @Override
    public void mousePressed(int x, int y) {
        x1 = x;
        y1 = y;
    }

    @Override
    public void mouseMoved(int x, int y) {
        // This method does nothing
    }

    @Override
    public void mouseReleased(int x, int y) {
        Rectangle rect = new Rectangle(x1, y1, x - x1, y - y1);
        editor.drawing().addFigure(rect);
        editor.toolButtonPressed("selection");
    }

}
