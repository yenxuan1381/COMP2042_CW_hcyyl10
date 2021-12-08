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

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * Objects of this class extend the JFrame class and implement
 * WindowFocusListener interface
 * 
 * @author Emily
 *
 */

public class GameFrame extends JFrame implements WindowFocusListener {

	private static final String DEF_TITLE = "Brick Destroy";

	private GameBoard gameController;
	private InfoPage infoPage;
	private HomeMenu homeMenu;
	private boolean gaming;
	
	/**
	 * Default constructor to create default value for the fields
	 */

	public GameFrame() {
		super();

		gaming = false;

		this.setLayout(new BorderLayout());

		gameController = new GameBoard(this);

		homeMenu = new HomeMenu(this, new Dimension(450, 300));

		infoPage = new InfoPage(this, new Dimension(450, 300));

		this.add(homeMenu, BorderLayout.CENTER);

		this.setUndecorated(true);
	}

	/**
	 * Method to initialize the variables
	 */

	public void initialize() {
		this.setTitle(DEF_TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.autoLocate();
		this.setVisible(true);
	}

	/**
	 * Method to enable the game board
	 */

	public void enableGameBoard() {
		this.dispose();
		this.remove(homeMenu);
		this.add(gameController, BorderLayout.CENTER);
		this.setUndecorated(false);
		initialize();
		this.addWindowFocusListener(this);

	}

	/**
	 * Method to return to the home menu from the info page
	 */

	public void enableHomeMenu() {
		this.dispose();
		this.remove(infoPage);
		this.add(homeMenu, BorderLayout.CENTER);
		this.setUndecorated(true);
		initialize();
		this.addWindowFocusListener(this);

	}

	/**
	 * Method to show the info page
	 */

	public void enableInfoPage() {
		this.dispose();
		this.remove(homeMenu);
		this.add(infoPage, BorderLayout.CENTER);
		this.setUndecorated(true);
		initialize();
		this.addWindowFocusListener(this);

	}

	/**
	 * Method to auto locate the screen
	 */

	private void autoLocate() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (size.width - this.getWidth()) / 2;
		int y = (size.height - this.getHeight()) / 2;
		this.setLocation(x, y);
	}

	@Override
	public void windowGainedFocus(WindowEvent windowEvent) {
		gaming = true;
	}

	@Override
	public void windowLostFocus(WindowEvent windowEvent) {
		if (gaming)
//			gameBoard.onLostFocus();
			gameController.onLostFocus();

	}

}
