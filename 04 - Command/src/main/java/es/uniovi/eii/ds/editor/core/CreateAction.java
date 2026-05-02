package es.uniovi.eii.ds.editor.core;

public class CreateAction implements Action {

    private Figure figure;

    public CreateAction(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void execute(Editor editor) {
        editor.drawing().addFigure(figure);
        editor.toolButtonPressed("selection");
    }

    @Override
    public void undo(Editor editor) {
        editor.drawing().deleteFigure(figure);
    }

}
