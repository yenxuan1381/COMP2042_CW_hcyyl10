package main.java.gameObjects.model.player;

import java.awt.*;

/**
 * This interface allows other class to implement its methods
 * @author Emily
 *
 */

public interface Playable {
	
	/**
	 * Method to move the player's paddle
	 */
	
	public void move();

	/**
	 * Method to move the player's paddle a specific amount
	 * 
	 * @param m Move amount integer
	 */
	
	public void move(int m);
	
	/**
	 * Method to move the player's paddle to the left
	 */

	public void moveLeft();
	
	/**
	 * Method to move the player's paddle to the right
	 */

	public void moveRight();
	
	/**
	 * Method to stop the player's paddle from moving
	 */

	public void stop();
	
	/**
	 * Method to move the player's paddle to a specific point
	 * 
	 * @param p The point of the player's paddle to move to
	 */

	public void moveTo(Point p);

}
