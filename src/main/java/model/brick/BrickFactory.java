package main.java.model.brick;

import java.awt.Dimension;
import java.awt.Point;

import main.java.controller.BrickController;

public class BrickFactory {
	
	public BrickFactory() {
		
	}
	
	/**
	 * Method to create brick objects
	 * 
	 * @param point The point of the brick object
	 * @param size  The size of the brick object
	 * @param type  The type of the brick object
	 * @return A brick object
	 */

	public BrickController makeBrick(Point point, Dimension size, BrickType type) {
		BrickController out;
		switch (type) {
		case CLAY:
			out = new ClayBrick(point, size);
			break;
		case STEEL:
			out = new SteelBrick(point, size);
			break;
		case CEMENT:
			out = new CementBrick(point, size);
			break;
		case SPECIAL:
			out = new SpecialBrick(point, size);
			break;
		case VIBRANIUM:
			out = new VibraniumBrick(point, size);
			break;
		default:
			throw new IllegalArgumentException(String.format("Unknown Type:%d\n", type));

		}
		return out;
	}

}
