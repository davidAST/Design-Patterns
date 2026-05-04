package es.uniovi.eii.ds.windows;

import java.awt.Point;

import es.uniovi.eii.ds.API;
import es.uniovi.eii.ds.graphics.Image2D;

public class WindowsAPI implements API {

	private Point point = new Point(0, 0);

	// INTERFACE METHODS ---------------------------------------------------------------
	@Override
	public Image2D loadImage(String file) {
		return loadFile(file);
	}

	@Override
	public Point getPosition() {
		return getMouseClick();
	}

	@Override
	public void drawBall(int x, int y, Image2D image) {
		paint(x, y, image);
	}

	// PRIVATE METHODS -----------------------------------------------------------------
	private Image2D loadFile(String name) {
		System.out.println("(Windows) Image '" + name + "' loaded from disk.");
		return new Image2D(name, 10, 10);
	}

	private void paint(int x, int y, Image2D image) {
		System.out.println("(Windows) Drawing '" + image.getName() + "' at (" + x + ", " + y + ")");
	}

	// Returns the position where the user has clicked the mouse button.
	private Point getMouseClick() {
		point.translate(10, 10);
		return new Point(point);
	}

	
}
