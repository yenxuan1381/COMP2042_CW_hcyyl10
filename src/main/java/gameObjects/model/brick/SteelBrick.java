/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main.java.gameObjects.model.brick;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

import main.java.gameObjects.controller.BrickController;
import main.java.gameObjects.model.crack.CrackDirection;

/**
 * The objects of this class inherits from the BrickController class, creating
 * steel brick object
 * 
 * @author Emily
 *
 */

public class SteelBrick extends BrickController {

	private static final String NAME = "Steel Brick";
	private static final Color DEF_INNER = new Color(203, 203, 201);
	private static final Color DEF_BORDER = Color.BLACK;
	private static final int STEEL_STRENGTH = 1;
	private static final double STEEL_PROBABILITY = 0.4;

	private Random rnd;
	private Shape brickFace;

	/**
	 * Constructor to create a brick object of the type steel
	 * 
	 * @param point The coordinates of the point of the steel brick
	 * @param size  The size of the steel brick
	 */

	public SteelBrick(Point point, Dimension size) {
		super(NAME, point, size, DEF_BORDER, DEF_INNER, STEEL_STRENGTH);
		rnd = new Random();
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
		impact();
		return super.isBroken();
	}

	@Override
	public void impact() {
		if (rnd.nextDouble() < STEEL_PROBABILITY) {
			super.impact();
		}
	}

}
