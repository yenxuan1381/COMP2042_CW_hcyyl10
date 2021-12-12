package main.java.gameObjects.model.crack;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

import main.java.gameObjects.model.brick.BrickModel;

/**
 * Objects of this class represent the cracks of the brick
 * 
 * @author Emily
 *
 */

public class CrackModel {

	public final int CRACK_SECTIONS = 3;
	public final double JUMP_PROBABILITY = 0.7;

	protected static Random rnd;

	private int crackDepth;
	private int steps;

	/**
	 * Constructer of crack class
	 * 
	 * @param crackDepth The depth of the crack
	 * @param steps      The steps of the crack
	 */

	public CrackModel(int crackDepth, int steps) {

		this.crackDepth = crackDepth;
		this.steps = steps;

	}
	
	/**
	 * Getter to get the crack depth
	 * 
	 * @return crack depth
	 */

	public int getCrackDepth() {
		return crackDepth;
	}

	/**
	 * Getter to get the steps
	 * 
	 * @return steps
	 */
	
	public int getSteps() {
		return steps;
	}



	
	

}
