package es.uniovi.eii.ds.editor.core;

public interface Action {

    public void execute(Editor editor);
    public void undo(Editor editor);
}
