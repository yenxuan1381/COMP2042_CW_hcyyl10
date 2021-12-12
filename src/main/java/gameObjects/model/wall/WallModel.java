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
package main.java.gameObjects.model.wall;

import java.awt.*;
import main.java.gameObjects.controller.BallController;
import main.java.gameObjects.controller.BrickController;
import main.java.gameObjects.controller.PlayerController;

/**
 * This class contains the pure application data for WallController class
 * 
 * @author Emily
 *
 */

public class WallModel {

	private Rectangle area;

	private BrickController[] bricks;
	private BallController ball;

	private int level;
	private int stage = 0;
	private int score = 0;
	private Point startPoint;
	private int brickCount;
	private int ballCount;
	private boolean ballLost;

	/**
	 * Constructor to create the default value for the fields and parameters
	 * 
	 * @param drawArea the area of the wall
	 * @param ballPos  the coordinates of the point of the ball
	 */

	public WallModel(Rectangle drawArea, Point ballPos) {

		this.startPoint = new Point(ballPos);

		level = 0;

		ballCount = 3;
		ballLost = false;

		area = drawArea;
	}

	/**
	 * Getter to get the number of bricks
	 * 
	 * @return the number of bricks
	 */

	public int getBrickCount() {
		return brickCount;
	}

	/**
	 * Getter to get the number of balls 
	 * 
	 * @return the number of balls
	 */

	public int getBallCount() {
		return ballCount;
	}

	/**
	 * Method to determine is the ball lost (no impact made)
	 * 
	 * @return True if the ball is lost, False if the ball is not lost
	 */

	public boolean isBallLost() {
		return ballLost;
	}

	/**
	 * Setter to set the horizontal speed of the ball
	 * 
	 * @param s Horizontal speed of the ball
	 */

	public void setBallXSpeed(int s) {
		getBall().setXSpeed(s);
	}

	/**
	 * Setter to set the vertical speed of the ball
	 * 
	 * @param s Vertical speed of the ball
	 */

	public void setBallYSpeed(int s) {
		getBall().setYSpeed(s);
	}


	/**
	 * Getter to get the player object
	 * 
	 * @return The player obejct
	 */

	public PlayerController getPlayer() {
		return PlayerController.getUniquePlayer();
	}

	/**
	 * Setter to set the player
	 * 
	 * @param ballPoint The point of the ball position
	 * @param width The width of the player's paddle
	 * @param height The height of the player's paddle
	 * @param container The rectangle container of the player's paddle
	 */

	public void setPlayer(Point ballPoint, int width, int height, Rectangle container) {
		PlayerController.getUniquePlayer(ballPoint, width, height, container);
	}

	/**
	 * Getter to get the ball object
	 * 
	 * @return The ball object
	 */

	public BallController getBall() {
		return ball;
	}

	/**
	 * Setter to set the ball object
	 * 
	 * @param ball The ball object
	 */

	public void setBall(BallController ball) {
		this.ball = ball;
	}

	/**
	 * Getter to get the array of brick objects
	 * 
	 * @return An array of brick objects
	 */

	public BrickController[] getBricks() {
		return bricks;
	}

	/**
	 * Setter to set the array of brick objects
	 * 
	 * @param bricks An Array of brick objects
	 */

	public void setBricks(BrickController[] bricks) {
		this.bricks = bricks;
	}

	/**
	 * Getter to get the score of the player
	 * 
	 * @return Score integer
	 */

	public int getScore() {
		return score;
	}

	/**
	 * Setter to set the score
	 * 
	 * @param score The score of the player
	 */

	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Getter to get the current stage
	 * 
	 * @return Current stage integer
	 */

	public int getStage() {
		return stage;
	}

	/**
	 * Setter to set the stage number
	 * 
	 * @param stage Stage number
	 */

	public void setStage(int stage) {
		this.stage = stage;
	}

	/**
	 * Setter to set the number of bricks
	 * 
	 * @param brickCount Number of bricks
	 */

	public void setBrickCount(int brickCount) {
		this.brickCount = brickCount;
	}

	/**
	 * Setter to set the number of balls
	 * 
	 * @param ballCount Number of balls
	 */

	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}

	/**
	 * Getter to get the area
	 * 
	 * @return The area rectangle
	 */
	public Rectangle getArea() {
		return area;
	}

	/**
	 * Setter to set the area
	 * 
	 * @param area Rectangle area
	 */

	public void setArea(Rectangle area) {
		this.area = area;
	}

	/**
	 * Getter to get the starting point
	 * 
	 * @return Starting point
	 */

	public Point getStartPoint() {
		return startPoint;
	}

	/**
	 * Setter to set the starting point
	 * 
	 * @param startPoint Starting point
	 */

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * Setter to set the boolean value of is the ball lost
	 * 
	 * @param ballLost Boolean ballLost
	 */

	public void setBallLost(boolean ballLost) {
		this.ballLost = ballLost;
	}

	/**
	 * Getter to get the current level
	 * 
	 * @return The current level integer
	 */

	public int getLevel() {
		return level;
	}

	/**
	 * Setter to set the current level
	 * 
	 * @param level The level integer
	 */

	public void setLevel(int level) {
		this.level = level;
	}

}
