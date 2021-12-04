package main.java.model.brick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

public class Crack {

	private static final int CRACK_SECTIONS = 3;
	private static final double JUMP_PROBABILITY = 0.7;

//	public static final int LEFT = 10;
//	public static final int RIGHT = 20;
//	public static final int UP = 30;
//	public static final int DOWN = 40;
//	public static final int VERTICAL = 100;
//	public static final int HORIZONTAL = 200;

	protected static Random rnd;
	private GeneralPath crack;

	private int crackDepth;
	private int steps;

	/**
	 * Constructer of crack class
	 * 
	 * @param crackDepth The depth of the crack
	 * @param steps      The steps of the crack
	 */

	public Crack(int crackDepth, int steps) {

		crack = new GeneralPath();
		this.crackDepth = crackDepth;
		this.steps = steps;

	}

	/**
	 * Method to draw the crack
	 * 
	 * @return Crack
	 */

	public GeneralPath draw() {
		return crack;
	}

	/**
	 * Method to reset the crack
	 */

	public void reset() {
		crack.reset();
	}

	/**
	 * Method to create a crack on a brick
	 * 
	 * @param point     The coordinates of the point of impact made by the ball on
	 *                  the brick
	 * @param direction The direction of the impact
	 */

	protected void makeCrack(Shape brickFace, Point2D point, CrackDirection direction) {
		Rectangle bounds = brickFace.getBounds();

		Point impact = new Point((int) point.getX(), (int) point.getY());
		Point start = new Point();
		Point end = new Point();

		switch (direction) {
		case LEFT:
			start.setLocation(bounds.x + bounds.width, bounds.y);
			end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
			Point tmp = makeRandomPoint(start, end, CrackDirection.VERTICAL);
			makeCrack(impact, tmp);

			break;
		case RIGHT:
			start.setLocation(bounds.getLocation());
			end.setLocation(bounds.x, bounds.y + bounds.height);
			tmp = makeRandomPoint(start, end, CrackDirection.VERTICAL);
			makeCrack(impact, tmp);

			break;
		case UP:
			start.setLocation(bounds.x, bounds.y + bounds.height);
			end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
			tmp = makeRandomPoint(start, end, CrackDirection.HORIZONTAL);
			makeCrack(impact, tmp);
			break;
		case DOWN:
			start.setLocation(bounds.getLocation());
			end.setLocation(bounds.x + bounds.width, bounds.y);
			tmp = makeRandomPoint(start, end, CrackDirection.HORIZONTAL);
			makeCrack(impact, tmp);

			break;

		}
	}

	/**
	 * Method to create a crack on a brick
	 * 
	 * @param start The starting point of the crack
	 * @param end   The ending point of the crack
	 */

	protected void makeCrack(Point start, Point end) {

		GeneralPath path = new GeneralPath();

		path.moveTo(start.x, start.y);

		double w = (end.x - start.x) / (double) steps;
		double h = (end.y - start.y) / (double) steps;

		int bound = crackDepth;
		int jump = bound * 5;

		double x, y;

		for (int i = 1; i < steps; i++) {

			x = (i * w) + start.x;
			y = (i * h) + start.y + randomInBounds(bound);

			if (inMiddle(i, CRACK_SECTIONS, steps))
				y += jumps(jump, JUMP_PROBABILITY);

			path.lineTo(x, y);

		}

		path.lineTo(end.x, end.y);
		crack.append(path, true);
	}

	/**
	 * Method to get a random integer in bound
	 * 
	 * @param bound The bound
	 * @return Random integer in the range of the bound
	 */

	private int randomInBounds(int bound) {
		int n = (bound * 2) + 1;
		return Brick.getRnd().nextInt(n) - bound;
	}

	/**
	 * Method to determine if i is in between steps and divisions
	 * 
	 * @param i         integer i
	 * @param steps     number of steps
	 * @param divisions number of divisions
	 * @return
	 */

	private boolean inMiddle(int i, int steps, int divisions) {
		int low = (steps / divisions);
		int up = low * (divisions - 1);

		return (i > low) && (i < up);
	}

	/**
	 * Method to jump if in bound
	 * 
	 * @param bound       The bound
	 * @param probability The probability of jump
	 * @return A random integer in bound, Returns 0 if less than probability
	 */

	private int jumps(int bound, double probability) {

		if (Brick.getRnd().nextDouble() > probability)
			return randomInBounds(bound);
		return 0;

	}

	/**
	 * Method that return a random point in range between starting point and ending
	 * point
	 * 
	 * @param from      Starting point
	 * @param to        Ending point
	 * @param vertical The direction of impact
	 * @return A random point in range between from and to
	 */

	private Point makeRandomPoint(Point from, Point to, CrackDirection vertical) {

		Point out = new Point();
		int pos;

		switch (vertical) {
		case HORIZONTAL:
			pos = Brick.getRnd().nextInt(to.x - from.x) + from.x;
			out.setLocation(pos, to.y);
			break;
		case VERTICAL:
			pos = Brick.getRnd().nextInt(to.y - from.y) + from.y;
			out.setLocation(to.x, pos);
			break;
		}
		return out;
	}

}
