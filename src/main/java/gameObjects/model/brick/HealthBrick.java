package main.java.gameObjects.model.brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import main.java.gameObjects.controller.BrickController;
import main.java.gameObjects.controller.CrackController;
import main.java.gameObjects.model.crack.CrackDirection;

/**
 * Objects of this class inherits from the brickController class, creating
 * health brick objects
 * 
 * @author Emily
 *
 */

public class HealthBrick extends BrickController {

	private static final String NAME = "Health Brick";
	private static final Color DEF_INNER = Color.MAGENTA;
	private static final Color DEF_BORDER = new Color(147, 147, 147);
	private static final int HEALTH_STRENGTH = 2;

	private CrackController crack;
	private Shape brickFace;

	/**
	 * Constructor to create a brick object of the type health
	 * 
	 * @param point The coordinates of the point of the health brick
	 * @param size  The size of the cement brick
	 */

	public HealthBrick(Point point, Dimension size) {
		super(NAME, point, size, DEF_BORDER, DEF_INNER, HEALTH_STRENGTH);
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
	 * Method to update the condition of the health brick
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
