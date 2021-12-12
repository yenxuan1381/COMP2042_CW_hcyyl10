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
package main.java.gameWindow;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import main.java.gameObjects.controller.WallController;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Object of this class extend JPanel
 * 
 * @author Emily
 *
 */

public class DebugPanel extends JPanel {

	private static final Color DEF_BKG = Color.WHITE;

	private JButton skipLevel;
	private JButton resetBalls;
	private JButton level1;
	private JButton level2;
	private JButton level3;
	private JButton level4;
	private JButton level5;
	private JButton level6;
	private JButton level7;
	private JButton level8;

	private JSlider ballXSpeed;
	private JSlider ballYSpeed;

	/**
	 * Constructor to create the debug panel gui
	 * 
	 * @param wall The wall
	 */

	public DebugPanel(WallController wall) {

		initialize();

		level1 = makeButton("Level 1", e -> setLevel(wall, 1));

		level2 = makeButton("Level 2", e -> setLevel(wall, 2));

		level3 = makeButton("Level 3", e -> setLevel(wall, 3));

		level4 = makeButton("Level 4", e -> setLevel(wall, 4));

		level5 = makeButton("Level 5", e -> setLevel(wall, 5));

		level6 = makeButton("Level 6", e -> setLevel(wall, 6));

		level7 = makeButton("Level 7", e -> setLevel(wall, 7));

		level8 = makeButton("Level 8", e -> setLevel(wall, 8));

		skipLevel = makeButton("Skip Level", e -> {
			if (wall.hasLevel())
				wall.nextLevel();
			else
				System.out.println("Last Level, no more levels left");
		});
		resetBalls = makeButton("Reset Balls", e ->
		{wall.resetBallCount();
		wall.ballReset();});

		ballXSpeed = makeSlider(-4, 4, e -> wall.setBallXSpeed(ballXSpeed.getValue()));
		ballYSpeed = makeSlider(-4, 4, e -> wall.setBallYSpeed(ballYSpeed.getValue()));

		this.add(skipLevel);
		this.add(resetBalls);

		this.add(level1);
		this.add(level2);
		this.add(level3);
		this.add(level4);
		this.add(level5);
		this.add(level6);
		this.add(level7);
		this.add(level8);

		this.add(ballXSpeed);
		this.add(ballYSpeed);

	}

	/**
	 * Method to initialise the default value of the fields
	 */

	private void initialize() {
		this.setBackground(DEF_BKG);
		this.setLayout(new GridLayout(3, 2));
	}

	/**
	 * Method to create a button
	 * 
	 * @param title Title of the button
	 * @param e     event
	 * @return the button
	 */

	private JButton makeButton(String title, ActionListener e) {
		JButton out = new JButton(title);
		out.addActionListener(e);
		return out;
	}

	/**
	 * Method to create a slider
	 * 
	 * @param min the minimum
	 * @param max the maximum
	 * @param e   the event
	 * @return the slider
	 */

	private JSlider makeSlider(int min, int max, ChangeListener e) {
		JSlider out = new JSlider(min, max);
		out.setMajorTickSpacing(1);
		out.setSnapToTicks(true);
		out.setPaintTicks(true);
		out.addChangeListener(e);
		return out;
	}

	/**
	 * Method to set the speed value of the ball
	 * 
	 * @param x The horizontal speed of the ball
	 * @param y The vertical speed of the ball
	 */

	public void setValues(int x, int y) {
		ballXSpeed.setValue(x);
		ballYSpeed.setValue(y);
	}

	/**
	 * Method to set the level
	 * 
	 * @param wall The wall
	 * @param lvl  The level
	 */

	private void setLevel(WallController wall, int lvl) {
		wall.resetLevel();
		for (int i = 0; i < lvl; i++) {
			wall.nextLevel();
		}
	}

}
