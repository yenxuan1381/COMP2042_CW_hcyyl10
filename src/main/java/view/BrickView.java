package main.java.view;

import java.awt.Color;
import java.awt.Graphics2D;

import main.java.controller.BrickController;

public class BrickView {

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
