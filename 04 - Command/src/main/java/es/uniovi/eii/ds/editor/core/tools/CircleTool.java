package es.uniovi.eii.ds.editor.core.tools;

import es.uniovi.eii.ds.editor.core.CreateAction;
import es.uniovi.eii.ds.editor.core.Editor;
import es.uniovi.eii.ds.editor.core.Tool;
import es.uniovi.eii.ds.editor.core.figures.Circle;

public class CircleTool implements Tool{

    private Editor editor;
   
    private int x1;
    private int y1;

     public CircleTool (Editor editor) {
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
        int dx = x - x1;
        int dy = y - y1;
        int radius = (int) Math.sqrt(dx * dx + dy * dy);

        Circle circ = new Circle(x1,y1, radius);
        CreateAction action = new CreateAction(circ);
        editor.execute(action);
    }

}
