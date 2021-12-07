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
package main.java;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.gameWindow.MenuView;

/**
 * Main class to call the main method
 * 
 * @author Emily
 *
 */

public class GraphicsMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		try {
			MenuView menu = new MenuView(stage);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Main method to run the game
	 * 
	 * @param args argument
	 */

	public static void main(String[] args) {
		launch(args);
	}

}
