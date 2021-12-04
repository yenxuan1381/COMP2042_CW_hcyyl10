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
package main.java.model.wall;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

import main.java.controller.BallController;
import main.java.controller.BrickController;
import main.java.controller.PlayerController;
import main.java.model.ball.Ball;
import main.java.model.ball.RubberBall;
import main.java.model.brick.Brick;
import main.java.model.brick.Crack;
import main.java.model.player.Player;

/**
 * Objects of this class creates a wall of bricks
 * 
 * @author Emily
 *
 */

public class Wall {

//	private Random rnd;
	private Rectangle area;

	private BrickController[] bricks;
	private BallController ball;

	private BrickController[][] levels;
	private int level;
	private int stage = 0;
	private int score = 0;
	private Point startPoint;
	private int brickCount;
	private int ballCount;
	private boolean ballLost;
//	private LevelFactory levelFac;
//	private BrickController brController;


	/**
	 * Constructor to create a wall class
	 * 
	 * @param drawArea            the area of the wall
	 * @param brickCount          the amount of bricks
	 * @param lineCount           the amount of lines
	 * @param brickDimensionRatio the ratio of the brick shape
	 * @param ballPos             the coordinates of the point of the ball
	 */

	public Wall(Rectangle drawArea, Point ballPos) {

		this.startPoint = new Point(ballPos);

		level = 0;

		ballCount = 10;
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
	 * Getter to get the number of balls left (lives)
	 * 
	 * @return the number of balls left
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
	 * Method to reset the amount of balls left to 3 balls
	 */

	public void resetBallCount() {
		ballCount = 3;
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
	 * Setter to set the player object
	 * 
	 * @param player The player object
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public void setBrickCount(int brickCount) {
		this.brickCount = brickCount;
	}

	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}

	public Rectangle getArea() {
		return area;
	}

	public void setArea(Rectangle area) {
		this.area = area;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public void setBallLost(boolean ballLost) {
		this.ballLost = ballLost;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	

}
