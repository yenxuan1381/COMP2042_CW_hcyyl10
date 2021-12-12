package main.java.gameObjects.model.ball;

import java.awt.geom.Point2D;
import main.java.gameObjects.controller.BallController;

public class BallFactory {

	/**
	 * Default constructor
	 */
	public BallFactory() {

	}

	/**
	 * Factory method to create ball objects
	 * 
	 * @param ballType The type of ball
	 * @param center   The point of the center of the ball
	 * @return A ball
	 */

	public BallController makeBallType(String ballType, Point2D center) {
		BallController out = null;

		switch (ballType) {

		case "RUBBER":
			out = new RubberBall(center);
			break;

		}

		return out;

	}

}
