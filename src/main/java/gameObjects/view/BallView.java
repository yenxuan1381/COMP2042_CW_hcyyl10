package main.java.gameObjects.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import main.java.gameObjects.controller.BallController;


/**
 * This class renders the view of the ball object
 * @author Emily
 *
 */

public class BallView {

	/**
	 * Default constructor
	 */
	
	public BallView() {

	}

	/**
	 * Method to draw the ball
	 * 
	 * @param ball Ball object
	 * @param g2d  Graphics
	 */

	public void drawBall(BallController ball, Graphics2D g2d) {
		Color tmp = g2d.getColor();

		Shape s = ball.getBallFace();

		g2d.setColor(ball.getInnerColor());
		g2d.fill(s);

		g2d.setColor(ball.getBorderColor());
		g2d.draw(s);

		g2d.setColor(tmp);
	}

}
