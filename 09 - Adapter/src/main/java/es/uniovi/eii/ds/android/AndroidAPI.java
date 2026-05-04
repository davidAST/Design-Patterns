package es.uniovi.eii.ds.android;

import java.awt.Point;

import es.uniovi.eii.ds.API;
import es.uniovi.eii.ds.graphics.Image2D;

public class AndroidAPI implements API  {
	
	private Point point = new Point(0, 0);

	// INTERFACE METHODS ---------------------------------------------------------------
	@Override
	public Image2D loadImage(String file) {
		return loadResource(file);
	}

	@Override
	public Point getPosition() {
		return getTouch();
	}

	@Override
	public void drawBall(int x, int y, Image2D image) {
		draw(x, y, image);
	}

	// PRIVATE METHODS -----------------------------------------------------------------
	private Image2D loadResource(String name) {
		System.out.println("(Android) Image '" + name + "' loaded from flash memory.");
		return new Image2D(name, 10, 10);
	}

	private void draw(int x, int y, Image2D image) {
		System.out.println("(Android) Drawing '" + image.getName() + "' at (" + x + ", " + y + ")");
	}

	// Returns the position where the user touches the screen
	private Point getTouch() {
		point.translate(10, 10);
		return new Point(point);
	}
}
