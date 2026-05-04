package es.uniovi.eii.ds;

import java.awt.Point;

import es.uniovi.eii.ds.graphics.Image2D;

public interface API {

    /**
     * Loads an image from a file
     * @param file File name
     * @return The image loaded
     */
    Image2D loadImage(String file);

    /**
     * Gets the position of the user (mouse, josytick...)
     * @return Position of the user input
     */
    Point getPosition();

    /**
     * Draws the ball given a position
     * @param x X coordinate of the ball
     * @param y Y coordinate of the ball
     * @param image Image of the ball to draw
     */
    void drawBall(int x, int y, Image2D image);


}
