package main.java.model.brick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

import main.java.controller.BrickController;
import main.java.model.crack.Crack;
import main.java.model.crack.CrackDirection;

/**
 * The objects of this class inherits from the BrickController class, creating
 * vibranium brick object
 * 
 * @author Emily
 *
 */

public class VibraniumBrick extends BrickController {

	private static final String NAME = "Vibranium Brick";
	private static final Color DEF_INNER = Color.BLUE.brighter().brighter();
	private static final Color DEF_BORDER = Color.WHITE;
	private static final int VIB_STRENGTH = 3;
	private static final double VIB_PROBABILITY = 0.6;

	private Crack crack;
	private Random rnd;
	private Shape brickFace;

	/**
	 * Constructor to create a brick object of the type vibranium
	 * 
	 * @param point The coordinates of the point of the vibranium brick
	 * @param size  The size of the vibarnium brick
	 */

	public VibraniumBrick(Point point, Dimension size) {
		super(NAME, point, size, DEF_BORDER, DEF_INNER, VIB_STRENGTH);
		rnd = new Random();
		crack = new Crack(DEF_CRACK_DEPTH, DEF_STEPS);
		brickFace = super.getBrickFace();
	}

	@Override
	protected Shape makeBrickFace(Point pos, Dimension size) {
		return new Rectangle(pos, size);
	}

	@Override
	public Shape getBrick() {
		return brickFace;
	}

	@Override
	public boolean setImpact(Point2D point, CrackDirection dir) {
		if (super.isBroken())
			return false;
		super.impact();
		if (!super.isBroken()) {
			crack.makeCrack(getBrick(), point, dir);
			updateBrick();
			return false;
		}
		return super.isBroken();
	}

	/**
	 * Method to update the condition of the vibranium brick
	 */

	private void updateBrick() {
		if (!super.isBroken()) {
			GeneralPath gp = crack.draw();
			gp.append(super.getBrickFace(), false);
			brickFace = gp;
		}
	}

	@Override
	public void impact() {
		if (rnd.nextDouble() < VIB_PROBABILITY) {
			super.impact();
		}
	}

}
