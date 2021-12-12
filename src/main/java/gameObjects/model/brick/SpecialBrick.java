package main.java.gameObjects.model.brick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

import main.java.gameObjects.controller.BrickController;

/**
 * The objects of this class inherits from the BrickController class, creating
 * special brick object
 * 
 * @author Emily
 *
 */

public class SpecialBrick extends BrickController {

	private static final String NAME = "Special Brick";
	private static final Color DEF_INNER = new Color(255, 215, 0);
	private static final Color DEF_BORDER = Color.GRAY;
	private static final int SPECIAL_STRENGTH = 1;

	/**
	 * Constructor to create a brick object of the type special
	 * 
	 * @param point The coordinates of the point of the special brick
	 * @param size  The size of the special brick
	 */

	public SpecialBrick(Point point, Dimension size) {
		super(NAME, point, size, DEF_BORDER, DEF_INNER, SPECIAL_STRENGTH);

	}

	@Override
	protected Shape makeBrickFace(Point pos, Dimension size) {
		return new Rectangle(pos, size);
	}

	@Override
	public Shape getBrick() {
		return super.getBrickFace();
	}
}
