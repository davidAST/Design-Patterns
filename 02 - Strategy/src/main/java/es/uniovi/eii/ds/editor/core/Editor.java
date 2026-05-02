package es.uniovi.eii.ds.editor.core;

import es.uniovi.eii.ds.editor.core.tools.*;

public class Editor {

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
			case "tirangle":
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
}
