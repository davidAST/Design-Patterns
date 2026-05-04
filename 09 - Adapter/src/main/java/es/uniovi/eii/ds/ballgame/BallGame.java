package es.uniovi.eii.ds.ballgame;

import java.awt.Point;

import es.uniovi.eii.ds.API;

import es.uniovi.eii.ds.graphics.Image2D;

// This class, and all the code inside this package, is supposed to be the
// complete game code, and it is what we want to reuse in the different
// platforms.

public class BallGame {
	
	private API api;
	
	public BallGame(API api) {
		this.api = api;
	}

	public void play() {
		Image2D image = api.loadImage("ball.png");

		// This simulates the game loop
		for (int i = 0; i < 10; i++) {
			Point point = api.getPosition();
			// Check collision with walls
			// Update score
			// Other game logic
			// ...
			api.drawBall(point.x, point.y, image);
		}
	}

}
