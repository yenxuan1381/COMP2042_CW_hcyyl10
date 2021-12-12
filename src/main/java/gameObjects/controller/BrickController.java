package main.java.gameObjects.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Point2D;

import main.java.gameObjects.model.brick.BrickModel;
import main.java.gameObjects.model.brick.ImpactDirection;
import main.java.gameObjects.model.crack.CrackDirection;
import main.java.gameObjects.view.BrickView;

/**
 * This abstract BrickController class allows other class to inherit
 * 
 * @author Emily
 *
 */

public abstract class BrickController {

	public static final int MIN_CRACK = 1;
	public static final int DEF_CRACK_DEPTH = 1;
	public static final int DEF_STEPS = 35;

	private Shape brickFace;

	private BrickModel brickModel;
	private BrickView brickView;
	
	/**
	 * Constructor to create the brick controller
	 * 
	 * @param name     name of brick
	 * @param pos      position of brick
	 * @param size     size of brick
	 * @param border   border color of the brick
	 * @param inner    inner color of the brick
	 * @param strength the strength of the brick
	 */

	public BrickController(String name, Point pos, Dimension size, Color border, Color inner, int strength) {

		brickModel = new BrickModel(name, strength, border, inner);
		setBrickFace(makeBrickFace(pos, size));
		brickView = new BrickView();
		
	}

	/**
	 * Abstract method to create the shape of the brick object
	 * 
	 * @param pos  Position of the brick object
	 * @param size Size of the brick object
	 * @return The shape of the brick object
	 */

	protected abstract Shape makeBrickFace(Point pos, Dimension size);

	/**
	 * Getter for the shape of the brick object
	 * 
	 * @return The shape of the brick object
	 */

	public abstract Shape getBrick();

	/**
	 * Method to determine whether the brick is broken or not
	 * 
	 * @param point The coordinates of the point of the ball
	 * @param dir   The direction of the impact
	 * @return True if brick is not broken, False if the brick is broken
	 */

	public boolean setImpact(Point2D point, CrackDirection dir) {
		if (isBroken())
			return false;
		impact();
		return isBroken();
	}

	/**
	 * Method to find the impact point between the ball object and the brick object
	 * 
	 * @param ballController The ball object
	 * @return The speed and direction of the ball after impact
	 */

	public final ImpactDirection findImpact(BallController ballController) {
		if (isBroken())
			return ImpactDirection.NO_IMPACT;
		ImpactDirection out = ImpactDirection.NO_IMPACT;
		if (getBrickFace().contains(ballController.getRight()))
			out = ImpactDirection.LEFT_IMPACT;
		else if (getBrickFace().contains(ballController.getLeft()))
			out = ImpactDirection.RIGHT_IMPACT;
		else if (getBrickFace().contains(ballController.getUp()))
			out = ImpactDirection.DOWN_IMPACT;
		else if (getBrickFace().contains(ballController.getDown()))
			out = ImpactDirection.UP_IMPACT;
		return out;
	}

	/**
	 * Method to determine whether the brick object is broken
	 * 
	 * @return True if the brick object is broken, False if the brick object is not
	 *         broken
	 */

	public final boolean isBroken() {
		return brickModel.isBroken();
	}

	/**
	 * Method to reset the strength of the brick object to full strength
	 */

	public void repair() {
		brickModel.setBroken(false);
		brickModel.setStrength(brickModel.getFullStrength());
	}

	/**
	 * Method to decrease the strength of the brick object
	 */

	public void impact() {
		brickModel.setStrength(brickModel.getStrength() - 1);
		brickModel.setBroken((brickModel.getStrength() == 0));
	}
	
	/**
	 * Method to update the view of the bricks
	 * 
	 * @param brick Brick object
	 * @param g2d   Graphics
	 */
	
	public void updateView(BrickController brick, Graphics2D g2d) {
		brickView.drawBrick(brick, g2d);
	}

	/**
	 * Getter to get the Border colour
	 * 
	 * @return Border colour
	 */

	public Color getBorder() {
		return brickModel.getBorderColor();
	}

	/**
	 * Getter to get the Inner colour
	 * 
	 * @return Inner colour
	 */

	public Color getInner() {
		return brickModel.getInnerColor();
	}

	/**
	 * Method to get the brick face
	 * 
	 * @return brick face
	 */
	public Shape getBrickFace() {
		return brickFace;
	}

	/**
	 * Method to set the brick Face
	 * 
	 * @param brickFace
	 */

	public void setBrickFace(Shape brickFace) {
		this.brickFace = brickFace;
	}

	/**
	 * Getter to get the brick's name
	 * 
	 * @return String brick name
	 */

	public String getName() {
		return brickModel.getName();
	}

	/**
	 * Setter to set the name of the brick
	 * 
	 * @param name String name of the brick
	 */

	public void setName(String name) {
		brickModel.setName(name);
	}

}
