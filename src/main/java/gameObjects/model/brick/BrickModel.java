package main.java.gameObjects.model.brick;

import java.awt.*;
import java.util.Random;

/**
 * This class stores the application data for brickController class
 * 
 * @author Emily
 *
 */

public class BrickModel {

	private int fullStrength;
	private int strength;
	protected static Random rnd;

	private String name;
	private boolean broken;
	Shape brickFace;

	private Color border;
	private Color inner;

	/**
	 * Default constructor to initialse the default value for the fields and
	 * parameters
	 * 
	 * @param name     Name of the brick object
	 * @param strength Strength of the brick object
	 */

	public BrickModel(String name, int strength, Color border, Color inner) {

		setBroken(false);
		setRnd(new Random());
		this.setName(name);
		this.fullStrength = this.strength = strength;

		this.border = border;
		this.inner = inner;

	}

	/**
	 * Setter to set the random value
	 * 
	 * @param rnd random value
	 */

	public static void setRnd(Random rnd) {
		BrickModel.rnd = rnd;
	}

	/**
	 * Getter to get the random value
	 * 
	 * @return rnd random value
	 */

	public static Random getRnd() {
		return rnd;
	}

	/**
	 * Getter to get the name of the brick
	 * 
	 * @return String brick name
	 */

	public String getName() {
		return name;
	}

	/**
	 * Setter to set the name
	 * 
	 * @param name String name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter to get the brickFace
	 * 
	 * @return the shape of brickFace
	 */

	public Shape getBrickFace() {
		return brickFace;
	}

	/**
	 * Getter to get the full strength of the brick
	 * 
	 * @return The full strength integer of the brick
	 */

	public int getFullStrength() {
		return fullStrength;
	}

	/**
	 * Setter to set the full strength of the brick
	 * 
	 * @param fullStrength The integer full Strength
	 */

	public void setFullStrength(int fullStrength) {
		this.fullStrength = fullStrength;
	}

	/**
	 * Getter to get the strength of the brick
	 * 
	 * @return The strength integer of the brick
	 */

	public int getStrength() {
		return strength;
	}

	/**
	 * Setter to set the strength of the brick
	 * 
	 * @param strength The integer strength
	 */

	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * Getter to get the current condition of the brick
	 * 
	 * @return True if the brick is broken, False is the brick is not broken
	 */
	public boolean isBroken() {
		return broken;
	}

	/**
	 * Setter to set the current condition of the brick
	 * 
	 * @param broken The boolean value of whether the brick is broken or not
	 */

	public void setBroken(boolean broken) {
		this.broken = broken;
	}

	/**
	 * Getter for the border color of the brick object
	 * 
	 * @return the color of the border of the brick object
	 */

	public Color getBorderColor() {
		return border;
	}

	/**
	 * Getter for the inner color of the brick object
	 * 
	 * @return the inner color of the brick object
	 */

	public Color getInnerColor() {
		return inner;
	}

}
