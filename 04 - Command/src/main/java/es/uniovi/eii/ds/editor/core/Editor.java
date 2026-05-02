package es.uniovi.eii.ds.editor.core;

import java.util.Stack;

import es.uniovi.eii.ds.editor.core.tools.*;

public class Editor {

	private Stack<Action> actions = new Stack<>();
	private Stack<Action> redoActions = new Stack<>();

	private Drawing drawing;
	private Tool tool;
	
	public Editor() {
		this(new Drawing());
	}
	
	public Editor(Drawing drawing) {
		setDrawing(drawing);
	}

	public void draw() {
		drawing.draw();
	}
	
	//-- Drawing methods
	
	public Drawing drawing() {
		return drawing;
	}
		
	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}
		
    //-- UI methods

	public void toolButtonPressed(String toolName) {
		switch (toolName) {
			case "selection":
				tool = new SelectTool(this);
				break;
			case "rectangle": 
				tool = new RectangleTool(this);
				break;
			case "circle":
				tool = new CircleTool(this);
				break;
			case "triangle":
				tool = new TriangleTool(this);
				break;
			default:
				throw new RuntimeException("There was an error");
		}
	}

	public void mousePressed(int x, int y) {
		tool.mousePressed(x, y);
	}

	public void mouseMoved(int x, int y) {
		tool.mouseMoved(x, y);
	}

	public void mouseReleased(int x, int y) {
		tool.mouseReleased(x, y);
	}

	public void execute(Action action) {
		action.execute(this);
		actions.add(action);
	}

	public void undo() {
		if (actions.size() == 0) {
			System.out.println("Nothing to undo");
		}
		else {
			Action action = actions.pop();
			redoActions.push(action);
			action.undo(this);
		}
	}

	public void redo() {
		if (redoActions.size() == 0) {
			System.out.println("Nothing to redo");
		}
		else {
			Action action = redoActions.pop();
			execute(action);
			actions.push(action);
		}

	}
}
