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
package main.java.gameObjects.controller;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

import main.java.gameObjects.model.ball.RubberBall;
import main.java.gameObjects.model.crack.CrackDirection;
import main.java.gameObjects.model.wall.LevelFactory;
import main.java.gameObjects.model.wall.WallModel;

/**
 * Objects of this class creates a wall of bricks
 * 
 * @author Emily
 *
 */

public class WallController {

	private Random rnd;

	private BrickController[][] levels;

	private LevelFactory levelFac;
	private WallModel wallModel;

	/**
	 * Constructor to create a wall class
	 * 
	 * @param drawArea            the area of the wall
	 * @param brickCount          the amount of bricks
	 * @param lineCount           the amount of lines
	 * @param brickDimensionRatio the ratio of the brick shape
	 * @param ballPos             the coordinates of the point of the ball
	 */

	public WallController(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio,
			Point ballPos) {

		levelFac = new LevelFactory();

		levels = levelFac.makeLevels(drawArea, brickCount, lineCount, brickDimensionRatio);

		rnd = new Random();
		wallModel = new WallModel(drawArea, ballPos);
		makeBall(ballPos);

		int speedX, speedY;
		do {
			speedX = rnd.nextInt(10) - 5;
		} while (speedX == 0);
		do {
			speedY = -rnd.nextInt(7);
		} while (speedY == 0);

		getBall().setSpeed(speedX, speedY);

		wallModel.setPlayer((Point) ballPos.clone(), 150, 10, drawArea);

	}

	/**
	 * Method to create a ball at a specific position
	 * 
	 * @param ballPos The coordinates of the point of the ball
	 */

	private void makeBall(Point2D ballPos) {
		wallModel.setBall(new RubberBall(ballPos));
	}

	/**
	 * Method to move the player and the ball object
	 */

	public void move() {
		getPlayer().move();
		getBall().move();
	}

	/**
	 * Method to find the impact made by the ball if impact made between ball and
	 * player, ball change direction if impact made between ball and wall, the
	 * amount of bricks decreases
	 */

	public void findImpacts() {
		if (getPlayer().impact(getBall())) {
			getBall().reverseY();
		} else if (impactWall()) {
			/*
			 * for efficiency reverse is done into method impactWall because for every brick
			 * program checks for horizontal and vertical impacts
			 */
			wallModel.setScore(getScore() + 50);
			wallModel.setBrickCount(getBrickCount() - 1);
		} else if (impactBorder()) {
			getBall().reverseX();
		} else if (getBall().getPosition().getY() < wallModel.getArea().getY()) {
			getBall().reverseY();
		} else if (getBall().getPosition().getY() > wallModel.getArea().getY() + wallModel.getArea().getHeight()) {
			wallModel.setBallCount(getBallCount() - 1);
			wallModel.setBallLost(true);
		}
	}

	/**
	 * Method to determine and set the direction of the ball if impact made between
	 * the ball and the wall
	 * 
	 * @return True if impact is made, False if no impact is made
	 */

	private boolean impactWall() {
		for (BrickController br : getBricks()) {
			switch (br.findImpact(getBall())) {

			case UP_IMPACT:
				getBall().reverseY();
				return br.setImpact(getBall().getDown(), CrackDirection.UP);
			case DOWN_IMPACT:
				getBall().reverseY();
				return br.setImpact(getBall().getUp(), CrackDirection.DOWN);
			case LEFT_IMPACT:
				getBall().reverseX();
				return br.setImpact(getBall().getRight(), CrackDirection.RIGHT);
			case RIGHT_IMPACT:
				getBall().reverseX();
				return br.setImpact(getBall().getLeft(), CrackDirection.LEFT);
			case NO_IMPACT:
				continue;

			}
		}
		return false;
	}

	/**
	 * Method to determine and set the direction of the ball if impact made between
	 * the ball and the border
	 * 
	 * @return True if impact is made, False if no impact is made
	 */

	private boolean impactBorder() {
		Point2D p = getBall().getPosition();
		return ((p.getX() < wallModel.getArea().getX())
				|| (p.getX() > (wallModel.getArea().getX() + wallModel.getArea().getWidth())));
	}

	/**
	 * Getter to get the number of bricks
	 * 
	 * @return the number of bricks
	 */

	public int getBrickCount() {
		return wallModel.getBrickCount();
	}

	/**
	 * Getter to get the number of balls left (lives)
	 * 
	 * @return the number of balls left
	 */

	public int getBallCount() {
		return wallModel.getBallCount();
	}

	/**
	 * Setter to set the number of balls
	 * 
	 * @param ballCount Number of balls
	 */

	public void setBallCount(int ballCount) {
		wallModel.setBallCount(ballCount);
	}

	/**
	 * Method to determine is the ball lost (no impact made)
	 * 
	 * @return True if the ball is lost, False if the ball is not lost
	 */

	public boolean isBallLost() {
		return wallModel.isBallLost();
	}

	/**
	 * Method to reset the coordinates of the points of the ball to the default
	 * starting position
	 */

	public void ballReset() {
		getPlayer().moveTo(wallModel.getStartPoint());
		getBall().moveTo(wallModel.getStartPoint());
		int speedX, speedY;
		do {
			speedX = rnd.nextInt(10) - 5;
		} while (speedX == 0);
		do {
			speedY = -rnd.nextInt(7);
		} while (speedY == 0);

		getBall().setSpeed(speedX, speedY);
		wallModel.setBallLost(false);
	}

	/**
	 * Method to reset the wall to the default amount of bricks
	 */

	public void wallReset() {
		for (BrickController b : getBricks())
			b.repair();
		wallModel.setBrickCount(getBricks().length);
		setBallCount(3);
	}

	/**
	 * Method to determine if the balls left is 0
	 * 
	 * @return True if the number of balls left is 0, False if the number of balls
	 *         left is more than 0
	 */

	public boolean ballEnd() {
		return wallModel.getBallCount() == 0;
	}

	/**
	 * Method to determine if the game is done Game is done when the number of
	 * bricks left is 0
	 * 
	 * @return True if the number of bricks left is 0, False if the number of bricks
	 *         left is more than 0
	 */

	public boolean isDone() {
		return wallModel.getBrickCount() == 0;
	}

	/**
	 * Method to move to the next level
	 */

	public void nextLevel() {

		setBricks(levels[getLevel()]);
		wallModel.setLevel(getLevel() + 1);
		wallModel.setBrickCount(getBricks().length);
		wallModel.setStage(getStage() + 1);
	}

	/**
	 * Method to reset the level
	 */

	public void resetLevel() {

		wallModel.setLevel(0);
		wallModel.setStage(0);
	}

	/**
	 * Method to determine if the game has another level
	 * 
	 * @return True if the game has another level, False if the game is on the final
	 *         level
	 */

	public boolean hasLevel() {
		return getLevel() < levels.length;
	}

	/**
	 * Getter to get the total number of levels
	 * 
	 * @return Total number of levels
	 */

	public int getLevelsLength() {
		return levels.length;
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
		setBallCount(3);
	}

	/**
	 * Getter to get the player object
	 * 
	 * @return The player object
	 */

	public PlayerController getPlayer() {
		return PlayerController.getUniquePlayer();
	}

	/**
	 * Getter to get the ball object
	 * 
	 * @return The ball object
	 */

	public BallController getBall() {
		return wallModel.getBall();
	}

	/**
	 * Getter to get the array of brick objects
	 * 
	 * @return An array of brick objects
	 */

	public BrickController[] getBricks() {
		return wallModel.getBricks();
	}

	/**
	 * Setter to set the array of brick objects
	 * 
	 * @param bricks An Array of brick objects
	 */

	public void setBricks(BrickController[] bricks) {
		wallModel.setBricks(bricks);
	}

	/**
	 * Getter to get the current level
	 * 
	 * @return Current level integer
	 */

	public int getLevel() {
		return wallModel.getLevel();
	}

	/**
	 * Getter to get the current stage
	 * 
	 * @return Current stage integer
	 */

	public int getStage() {
		return wallModel.getStage();
	}

	/**
	 * Setter to set the score
	 * 
	 * @param i The score integer
	 */

	public void setScore(int i) {
		wallModel.setScore(i);

	}

	/**
	 * Getter to get the current score
	 * 
	 * @return The score integer
	 */

	public int getScore() {
		return wallModel.getScore();
	}

	/**
	 * Setter to set the ball lost
	 * 
	 * @param b true if ball is lost, false is ball is not lost
	 */

	public void setBallLost(boolean b) {
		wallModel.setBallLost(b);

	}

}
