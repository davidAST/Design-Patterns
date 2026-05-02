package es.uniovi.eii.ds.editor.core;

public class MoveAction implements Action {

    private Figure figure;
    private int x;
    private int y;

    public MoveAction(Figure figure, int x, int y) {
        this.figure = figure;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(Editor editor) {
        figure.move(x,y);
    }

    @Override
    public void undo(Editor editor) {
        figure.move(-x, -y);
    }

}
