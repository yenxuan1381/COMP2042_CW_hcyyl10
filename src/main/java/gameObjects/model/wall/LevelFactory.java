package main.java.gameObjects.model.wall;

import java.awt.Rectangle;

import main.java.gameObjects.controller.BrickController;
import main.java.gameObjects.model.brick.BrickType;

/**
 * This class implements the Factory design pattern to create multiple levels
 * 
 * @author Emily
 *
 */
public class LevelFactory {

	private static final int LEVELS_COUNT = 8;

	private Level level;

	public LevelFactory() {
		level = new Level();
	}

	/**
	 * Method to create multiple game levels
	 * 
	 * @param drawArea            The area of the wall
	 * @param brickCount          The number of bricks
	 * @param lineCount           The number of lines
	 * @param brickDimensionRatio The ratio of the brick shape
	 * @return An array of brick objects
	 */

	public BrickController[][] makeLevels(Rectangle drawArea, int brickCount, int lineCount,
			double brickDimensionRatio) {
		BrickController[][] tmp = new BrickController[LEVELS_COUNT][];
		tmp[0] = level.makeSingleTypeLevel(drawArea, brickCount, lineCount, brickDimensionRatio, BrickType.CLAY);
		tmp[1] = level.makeChessboardLevel(drawArea, brickCount, lineCount, brickDimensionRatio, BrickType.CLAY,
				BrickType.CEMENT);
		tmp[2] = level.makeSingleTypeLevel(drawArea, brickCount, lineCount, brickDimensionRatio, BrickType.CEMENT);
		tmp[3] = level.makeChessboardLevel(drawArea, brickCount, lineCount, brickDimensionRatio, BrickType.CLAY,
				BrickType.STEEL);
		tmp[4] = level.makeChessboardLevel(drawArea, brickCount, lineCount, brickDimensionRatio, BrickType.VIBRANIUM,
				BrickType.CEMENT);
		tmp[5] = level.makeSingleTypeLevel(drawArea, brickCount, lineCount, brickDimensionRatio, BrickType.STEEL);
		tmp[6] = level.makeChessboardLevel(drawArea, brickCount, lineCount, brickDimensionRatio, BrickType.VIBRANIUM,
				BrickType.STEEL);
		tmp[7] = level.makeSingleTypeLevel(drawArea, brickCount, lineCount, brickDimensionRatio, BrickType.VIBRANIUM);
		return tmp;
	}
}
