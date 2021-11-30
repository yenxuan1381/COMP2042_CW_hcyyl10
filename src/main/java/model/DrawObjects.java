package main.java.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import main.java.controller.BrickController;
import main.java.model.ball.Ball;
import main.java.model.brick.Brick;
import main.java.model.player.Player;

public class DrawObjects {

	public DrawObjects() {

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

	/**
	 * Method to draw the ball
	 * 
	 * @param ball Ball object
	 * @param g2d  Graphics
	 */

	public void drawBall(Ball ball, Graphics2D g2d) {
		Color tmp = g2d.getColor();

		Shape s = ball.getBallFace();

		g2d.setColor(ball.getInnerColor());
		g2d.fill(s);

		g2d.setColor(ball.getBorderColor());
		g2d.draw(s);

		g2d.setColor(tmp);
	}

	/**
	 * Method to draw the player
	 * 
	 * @param p   Player object
	 * @param g2d Graphics
	 */

	public void drawPlayer(Player p, Graphics2D g2d) {
		Color tmp = g2d.getColor();

		Shape s = p.getPlayerFace();
		g2d.setColor(Player.INNER_COLOR);
		g2d.fill(s);

		g2d.setColor(Player.BORDER_COLOR);
		g2d.draw(s);

		g2d.setColor(tmp);
	}

}
