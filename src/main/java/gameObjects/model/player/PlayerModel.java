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
package main.java.gameObjects.model.player;

import java.awt.*;

/**
 * This class stores the pure application data for playerController class
 * 
 * @author Emily
 *
 */

public class PlayerModel {

	public static final Color BORDER_COLOR = Color.GREEN.darker().darker();
	public static final Color INNER_COLOR = Color.GREEN;

	private Point ballPoint;
	private int min;
	private int max;

	/**
	 * Constructor to create a player class
	 * 
	 * @param ballPoint The coordinates of the point of the ball that touches the
	 *                  player's paddle
	 * @param width     The width of the player's paddle
	 * @param container The rectangle shape of the player's paddle
	 */

	public PlayerModel(Point ballPoint, int width, Rectangle container) {

		this.ballPoint = ballPoint;

		min = container.x + (width / 2);
		max = min + container.width - width;

	}

	/**
	 * Getter to get the point of the ball point
	 * 
	 * @return Point ball point
	 */

	public Point getBallPoint() {
		return ballPoint;
	}

	/**
	 * Setter to set the point of the ball point
	 * 
	 * @param ballPoint The point of the ball point
	 */

	public void setBallPoint(Point ballPoint) {
		this.ballPoint = ballPoint;
	}

	/**
	 * Getter to get the minimum
	 * 
	 * @return Integer minimum
	 */

	public int getMin() {
		return min;
	}

	/**
	 * Setter to set the minimum
	 * 
	 * @param min Integer minimum
	 */

	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * Getter to get the maximum
	 * 
	 * @return Integer maximum
	 */

	public int getMax() {
		return max;
	}

	/**
	 * Setter to set the maximum
	 * 
	 * @param max Integer maximum
	 */
	public void setMax(int max) {
		this.max = max;
	}

}
