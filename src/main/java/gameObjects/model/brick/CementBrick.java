package main.java.gameObjects.model.brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import main.java.gameObjects.controller.BrickController;
import main.java.gameObjects.controller.CrackController;
import main.java.gameObjects.model.crack.CrackDirection;

/**
 * Objects of this class inherits from the brickController class, creating
 * cement brick objects
 * 
 * @author Emily
 *
 */

public class CementBrick extends BrickController {

	private static final String NAME = "Cement Brick";
	private static final Color DEF_INNER = new Color(147, 147, 147);
	private static final Color DEF_BORDER = new Color(217, 199, 175);
	private static final int CEMENT_STRENGTH = 2;

	private CrackController crack;
	private Shape brickFace;

	/**
	 * Constructor to create a brick object of the type cement
	 * 
	 * @param point The coordinates of the point of the cement brick
	 * @param size  The size of the cement brick
	 */

	public CementBrick(Point point, Dimension size) {
		super(NAME, point, size, DEF_BORDER, DEF_INNER, CEMENT_STRENGTH);
		crack = new CrackController(DEF_CRACK_DEPTH, DEF_STEPS);
		brickFace = super.getBrickFace();
	}

	@Override
	protected Shape makeBrickFace(Point pos, Dimension size) {
		return new Rectangle(pos, size);
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
		return true;
	}

	@Override
	public Shape getBrick() {
		return brickFace;
	}

	/**
	 * Method to update the condition of the cement brick
	 */

	private void updateBrick() {
		if (!super.isBroken()) {
			GeneralPath gp = crack.updateView();
			gp.append(super.getBrickFace(), false);
			brickFace = gp;
		}
	}

	@Override
	public void repair() {
		super.repair();
		crack.reset();
		brickFace = super.getBrickFace();
	}
}
