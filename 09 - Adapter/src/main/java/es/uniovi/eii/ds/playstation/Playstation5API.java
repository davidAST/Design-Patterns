package es.uniovi.eii.ds.playstation;

import java.awt.Point;

import es.uniovi.eii.ds.API;
import es.uniovi.eii.ds.graphics.Image2D;

public class Playstation5API implements API {
	
	private Point point = new Point(0, 0);

	// INTERFACE METHODS ---------------------------------------------------------------
	@Override
	public Image2D loadImage(String file) {
		return loadGraphics(file);
	}

	@Override
	public Point getPosition() {
		return getJoystick();
	}

	@Override
	public void drawBall(int x, int y, Image2D image) {
		render(x, y, image);
	}

	// PRIVATE METHODS -----------------------------------------------------------------
	private Image2D loadGraphics(String name) {
		System.out.println("(PS5) Image loaded '" + name + "' from DVD.");
		return new Image2D(name, 10, 10);
	}

	private void render(int x, int y, Image2D image) {
		System.out.println("(PS5) Drawing '" + image.getName() + "' at (" + x + ", " + y + ")");
	}

	// Returns the position where the user presses the "X" button of the controller
	private Point getJoystick() {
		point.translate(10, 10);
		return new Point(point);
	}

	


}
