package main.java.gameObjects.model.ball;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * This class stores the pure application data for BallController class
 * 
 * @author Emily
 *
 */

public class BallModel {

	private Point2D center;

	public Point2D up;
	public Point2D down;
	public Point2D left;
	public Point2D right;

	private int speedX;
	private int speedY;

	private Color border;
	private Color inner;

	/**
	 * Constructor of Ball class
	 * 
	 * @param center The coordinates of the center of the ball
	 * @param radius The radius of the ball
	 * @param inner  The color code for the inner color of the ball object
	 * @param border The color code for the border color of the ball object
	 */

	public BallModel(Point2D center, int radius, Color inner, Color border) {
		this.center = center;

		up = new Point2D.Double();
		down = new Point2D.Double();
		left = new Point2D.Double();
		right = new Point2D.Double();

		up.setLocation(center.getX(), center.getY() - (radius / 2));
		down.setLocation(center.getX(), center.getY() + (radius / 2));

		left.setLocation(center.getX() - (radius / 2), center.getY());
		right.setLocation(center.getX() + (radius / 2), center.getY());

		speedX = 0;
		speedY = 0;

		this.border = border;
		this.inner = inner;
	}

	/**
	 * Setter to set the speed of the ball
	 * 
	 * @param x The horizontal speed of the ball
	 * @param y The vertical speed of the ball
	 */

	public void setSpeed(int x, int y) {
		speedX = x;
		speedY = y;
	}

	/**
	 * Setter to set horizontal speed of the ball
	 * 
	 * @param s The horizontal speed of the ball
	 */

	public void setXSpeed(int s) {
		speedX = s;
	}

	/**
	 * Setter to set the vertical speed of the ball
	 * 
	 * @param s The vertical speed of the ball
	 */

	public void setYSpeed(int s) {
		speedY = s;
	}

	/**
	 * Getter for the position of the ball object
	 * 
	 * @return the points of the ball's position
	 */

	public Point2D getPosition() {
		return center;
	}

	/**
	 * Getter for the horizontal speed of the ball
	 * 
	 * @return the horizontal speed of the ball
	 */

	public int getSpeedX() {
		return speedX;
	}

	/**
	 * Getter for the vertical speed of the ball
	 * 
	 * @return the vertical speed of the ball
	 */

	public int getSpeedY() {
		return speedY;
	}

	/**
	 * Getter for the border color of the ball object
	 * 
	 * @return Color code of the border color of the ball object
	 */

	public Color getBorderColor() {
		return border;
	}

	/**
	 * Getter for the inner Color of the ball object
	 * 
	 * @return Color code of the inner color of the ball object
	 */

	public Color getInnerColor() {
		return inner;
	}

	/**
	 * Getter to get the up point
	 * 
	 * @return up point
	 */

	public Point2D getUp() {
		return up;
	}

	/**
	 * Setter to set the up point
	 * 
	 * @param up The up point
	 */

	public void setUp(Point2D up) {
		this.up = up;
	}

	/**
	 * Getter to get the down point
	 * 
	 * @return down point
	 */

	public Point2D getDown() {
		return down;
	}

	/**
	 * Setter to set the down point
	 * 
	 * @param down The down point
	 */

	public void setDown(Point2D down) {
		this.down = down;
	}

	/**
	 * Getter to get the left point
	 * 
	 * @return left point
	 */

	public Point2D getLeft() {
		return left;
	}

	/**
	 * Setter to set the left point
	 * 
	 * @param left The left point
	 */

	public void setLeft(Point2D left) {
		this.left = left;
	}

	/**
	 * Getter to get the right point
	 * 
	 * @return right point
	 */

	public Point2D getRight() {
		return right;
	}

	/**
	 * Setter to set the right point
	 * 
	 * @param right The right point
	 */

	public void setRight(Point2D right) {
		this.right = right;
	}

}
