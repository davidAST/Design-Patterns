package es.uniovi.eii.ds.editor.core.tools;

import java.util.Optional;

import es.uniovi.eii.ds.editor.core.Editor;
import es.uniovi.eii.ds.editor.core.Figure;
import es.uniovi.eii.ds.editor.core.MoveAction;
import es.uniovi.eii.ds.editor.core.Tool;

public class SelectTool implements Tool{

    private Editor editor;
    private Optional<Figure> figure;

    public SelectTool (Editor editor) {
        this.editor = editor;
        figure = Optional.empty();
    }

    @Override
    public void mousePressed(int x, int y) {
       figure = editor.drawing().getFigure(x,y);
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (figure.isPresent()) {
            figure.get().move(x,y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        if (figure.isPresent()) {
            MoveAction action = new MoveAction(figure.get(),x,y);
            editor.execute(action);
        }
        figure = Optional.empty();
        editor.toolButtonPressed("selection");
    }
}
