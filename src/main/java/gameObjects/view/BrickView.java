package main.java.gameObjects.view;

import java.awt.Color;
import java.awt.Graphics2D;

import main.java.gameObjects.controller.BrickController;

/**
 * This class renders the view of the Brick object
 * 
 * @author Emily
 *
 */

public class BrickView {

	/**
	 * Default Constructor
	 */
	
	public BrickView() {

	}

	/**
	 * Method to draw the bricks
	 * 
	 * @param brick Brick object
	 * @param g2d   Graphics
	 */

	public void drawBrick(BrickController brick, Graphics2D g2d) {
		Color tmp = g2d.getColor();

		g2d.setColor(brick.getInner());
		g2d.fill(brick.getBrick());

		g2d.setColor(brick.getBorder());
		g2d.draw(brick.getBrick());

		g2d.setColor(tmp);
	}

}
