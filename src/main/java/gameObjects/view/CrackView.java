package main.java.gameObjects.view;

import java.awt.geom.GeneralPath;

public class CrackView {

	private GeneralPath crack;

	public CrackView(int crackDepth, int steps) {
		crack = new GeneralPath();
	}

	/**
	 * Method to draw the crack
	 * 
	 * @return Crack
	 */

	public GeneralPath draw() {
		return crack;
	}

	/**
	 * Getter to get the crack
	 * 
	 * @return crack
	 */

	public GeneralPath getCrack() {
		return crack;
	}

}
