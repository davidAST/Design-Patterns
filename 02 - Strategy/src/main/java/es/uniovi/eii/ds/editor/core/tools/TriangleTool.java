package es.uniovi.eii.ds.editor.core.tools;

import es.uniovi.eii.ds.editor.core.Editor;
import es.uniovi.eii.ds.editor.core.Tool;
import es.uniovi.eii.ds.editor.core.figures.Triangle;

public class TriangleTool implements Tool{

    private Editor editor;
   
    private int x1 = -1;
    private int y1 = -1;
    private int x2 = -1;
    private int y2 = -1;
    private int x3 = -1;
    private int y3 = -1;

     public TriangleTool (Editor editor) {
        this.editor = editor;
    }
    
    @Override
    public void mousePressed(int x, int y) {
        if (x1 == -1 && y1 == -1) {
            x1 = x;
            y1 = y;
        }
        else if (x2 == -1 && y2 == -1) {
            x2 = x;
            y2 = y;
        }
        else {
            x3 = x;
            y3 = y;
            Triangle tr = new Triangle(x1,y1,x2,y2,x3,y3);
            editor.drawing().addFigure(tr);
            editor.toolButtonPressed("selection");
        }

    }

    @Override
    public void mouseMoved(int x, int y) {
        // This method does nothing
    }

    @Override
    public void mouseReleased(int x, int y) {
        // This method does nothing
    }

}
