package main.java.gameObjects.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import main.java.gameObjects.controller.PlayerController;
import main.java.gameObjects.model.player.PlayerModel;

/**
 * This class renders the view of the Player object
 * 
 * @author Emily
 *
 */

public class PlayerView {

	/**
	 * Default constructor
	 */
	
	public PlayerView() {

	}

	/**
	 * Method to draw the player
	 * 
	 * @param p   Player object
	 * @param g2d Graphics
	 */

	public void drawPlayer(PlayerController p, Graphics2D g2d) {
		Color tmp = g2d.getColor();

		Shape s = p.getPlayerFace();
		g2d.setColor(PlayerModel.INNER_COLOR);
		g2d.fill(s);

		g2d.setColor(PlayerModel.BORDER_COLOR);
		g2d.draw(s);

		g2d.setColor(tmp);
	}

}
