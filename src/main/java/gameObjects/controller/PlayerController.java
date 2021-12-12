package main.java.gameObjects.controller;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import main.java.gameObjects.model.player.Playable;
import main.java.gameObjects.model.player.PlayerModel;
import main.java.gameObjects.view.PlayerView;

/**
 * Objects of this class implements the Playable interface
 * 
 * @author Emily
 *
 */

public class PlayerController implements Playable {

	private static final int DEF_MOVE_AMOUNT = 5;
	private static PlayerController player;

	private Rectangle playerFace;
	private int moveAmount;

	private PlayerModel playerModel;
	private PlayerView playerView;

	/**
	 * Default constructor
	 */

	private PlayerController() {

		// Prints error message
		System.out.println("Singleton Violated Error: Second Player object should not be created!!");
	}

	/**
	 * Constructor to create a player class
	 * 
	 * @param ballPoint The coordinates of the point of the ball that touches the
	 *                  player's paddle
	 * @param width     The width of the player's paddle
	 * @param height    The height of the player's paddle
	 * @param container The rectangle shape of the player's paddle
	 */

	private PlayerController(Point ballPoint, int width, int height, Rectangle container) {

		moveAmount = 0;
		playerModel = new PlayerModel(ballPoint, width, container);
		playerFace = makeRectangle(width, height);
		playerView = new PlayerView();

	}

	/**
	 * Method to create a rectangle object
	 * 
	 * @param width  The width of the rectangle
	 * @param height The height of the rectangle
	 * @return A rectangle object
	 */

	private Rectangle makeRectangle(int width, int height) {
		Point p = new Point((int) (playerModel.getBallPoint().getX() - (width / 2)),
				(int) playerModel.getBallPoint().getY());
		return new Rectangle(p, new Dimension(width, height));
	}

	/**
	 * Method that determines whether the ball touches the player's paddle
	 * 
	 * @param ballController The ball object
	 * @return True if the ball touches the player's paddle, False if the ball did
	 *         not touch the player's paddle
	 */

	public boolean impact(BallController ballController) {
		return playerFace.contains(ballController.getPosition()) && playerFace.contains(ballController.getDown());
	}

	/**
	 * Method to move the player's paddle
	 */

	public void move() {
		double x = playerModel.getBallPoint().getX() + moveAmount;
		if (x < playerModel.getMin() || x > playerModel.getMax())
			return;
		playerModel.getBallPoint().setLocation(x, playerModel.getBallPoint().getY());
		playerFace.setLocation(playerModel.getBallPoint().x - (int) playerFace.getWidth() / 2,
				playerModel.getBallPoint().y);
	}

	/**
	 * Method to move the player's paddle a specific amount
	 * 
	 * @param m Move amount integer
	 */

	public void move(int m) {
		double x = playerModel.getBallPoint().getX() + m;
		if (x < playerModel.getMin() || x > playerModel.getMax())
			return;
		playerModel.getBallPoint().setLocation(x, playerModel.getBallPoint().getY());
		playerFace.setLocation(playerModel.getBallPoint().x - (int) playerFace.getWidth() / 2,
				playerModel.getBallPoint().y);
	}

	/**
	 * Method to move the player's paddle to the left
	 */

	public void moveLeft() {
		moveAmount = -DEF_MOVE_AMOUNT;
	}

	/**
	 * Method to move the player's paddle to the right
	 */

	public void moveRight() {
		moveAmount = DEF_MOVE_AMOUNT;
	}

	/**
	 * Method to stop the player's paddle from moving
	 */

	public void stop() {
		moveAmount = 0;
	}

	/**
	 * Method to move the player's paddle to a specific point
	 * 
	 * @param p The point of the player's paddle to move to
	 */

	public void moveTo(Point p) {
		playerModel.getBallPoint().setLocation(p);
		playerFace.setLocation(playerModel.getBallPoint().x - (int) playerFace.getWidth() / 2,
				playerModel.getBallPoint().y);
	}
	
	/**
	 * Method to draw the player
	 * 
	 * @param p   Player object
	 * @param g2d Graphics
	 */
	
	public void updateView(PlayerController p, Graphics2D g2d) {
		playerView.drawPlayer(p, g2d);
	}

	/**
	 * Method to get the Player instance, creates a new instance if no instance is
	 * created
	 * 
	 * @return player
	 */

	public static PlayerController getUniquePlayer() {
		if (player == null) {
			player = new PlayerController();
		}
		return player;
	}

	/**
	 * Method to get the Player instance, creates a new instance if no instance is
	 * created
	 * 
	 * @param ballPoint point of the ball
	 * @param width     width of the paddle
	 * @param height    height of the paddle
	 * @param container the rectangle shape of the player paddle
	 * @return player
	 */

	public static PlayerController getUniquePlayer(Point ballPoint, int width, int height, Rectangle container) {
		if (player == null) {
			player = new PlayerController(ballPoint, width, height, container);
		}
		return player;
	}

	/**
	 * Getter to get the shape of the player's paddle
	 * 
	 * @return The shape of the player's paddle
	 */

	public Rectangle getPlayerFace() {
		return playerFace;
	}

}
