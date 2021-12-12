package main.java.gameObjects.model.wall;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import main.java.gameObjects.controller.BrickController;
import main.java.gameObjects.model.brick.BrickFactory;
import main.java.gameObjects.model.brick.BrickType;

/**
 * Objects of this class creates levels for the game
 * 
 * @author Emily
 *
 */
public class Level {

	private BrickFactory brFactory;

	/**
	 * Default constructor to create initialise the value for field
	 */
	public Level() {

		brFactory = new BrickFactory();

	}

	/**
	 * Method to create an array of a single type of bricks
	 * 
	 * @param drawArea       The area of the wall
	 * @param brickCnt       The amount of bricks
	 * @param lineCnt        The amount of line
	 * @param brickSizeRatio The ratio of the brick size
	 * @param type           The type of the brick
	 * @return An array of brick objects
	 */

	public BrickController[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio,
			BrickType type) {
		/*
		 * if brickCount is not divisible by line count,brickCount is adjusted to the
		 * biggest multiple of lineCount smaller then brickCount
		 */
		brickCnt -= brickCnt % lineCnt;

		int brickOnLine = brickCnt / lineCnt;

		double brickLen = drawArea.getWidth() / brickOnLine;
		double brickHgt = brickLen / brickSizeRatio;

		brickCnt += lineCnt / 2;

		BrickController[] tmp = new BrickController[brickCnt];

		Dimension brickSize = new Dimension((int) brickLen, (int) brickHgt);
		Point p = new Point();

		Random rand = new Random();

		int i;
		for (i = 0; i < tmp.length; i++) {
			int line = i / brickOnLine;
			if (line == lineCnt)
				break;
			double x = (i % brickOnLine) * brickLen;
			x = (line % 2 == 0) ? x : (x - (brickLen / 2));
			double y = (line) * brickHgt;
			p.setLocation(x, y);

			double r = rand.nextDouble();
			double r2 = rand.nextDouble();

			// 30% chance to create Special Brick
			if (r < 0.3) {
				
				if (r2 < 0.3) {
					tmp[i] = brFactory.makeBrick(p, brickSize, BrickType.HEALTH);
				}
				
				else {
					tmp[i] = brFactory.makeBrick(p, brickSize, BrickType.SPECIAL);
				}
				
			}

			else {
				tmp[i] = brFactory.makeBrick(p, brickSize, type);
			}

		}

		for (double y = brickHgt; i < tmp.length; i++, y += 2 * brickHgt) {
			double x = (brickOnLine * brickLen) - (brickLen / 2);
			p.setLocation(x, y);

			double r = rand.nextDouble();

			if (r < 0.3) {
				tmp[i] = brFactory.makeBrick(p, brickSize, BrickType.SPECIAL);
			}

			else {
				tmp[i] = brFactory.makeBrick(p, brickSize, type);
			}
		}
		return tmp;

	}

	/**
	 * Method to create an array of a two type of bricks in a chessboard pattern
	 * 
	 * @param drawArea       The area of the wall
	 * @param brickCnt       The number of bricks
	 * @param lineCnt        The number of line
	 * @param brickSizeRatio The ratio of the brick
	 * @param typeA          The type of the brick
	 * @param typeB          The type of the brick
	 * @return An array of brick objects
	 */

	public BrickController[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio,
			BrickType typeA, BrickType typeB) {

		/*
		 * if brickCount is not divisible by line count,brickCount is adjusted to the
		 * biggest multiple of lineCount smaller then brickCount
		 */

		brickCnt -= brickCnt % lineCnt;

		int brickOnLine = brickCnt / lineCnt;

		int centerLeft = brickOnLine / 2 - 1;
		int centerRight = brickOnLine / 2 + 1;

		double brickLen = drawArea.getWidth() / brickOnLine;
		double brickHgt = brickLen / brickSizeRatio;

		brickCnt += lineCnt / 2;

		BrickController[] tmp = new BrickController[brickCnt];

		Dimension brickSize = new Dimension((int) brickLen, (int) brickHgt);
		Point p = new Point();
		
		Random rand = new Random();


		int i;
		for (i = 0; i < tmp.length; i++) {
			int line = i / brickOnLine;
			if (line == lineCnt)
				break;
			int posX = i % brickOnLine;
			double x = posX * brickLen;
			x = (line % 2 == 0) ? x : (x - (brickLen / 2));
			double y = (line) * brickHgt;
			p.setLocation(x, y);

			boolean b = ((line % 2 == 0 && i % 2 == 0) || (line % 2 != 0 && posX > centerLeft && posX <= centerRight));
//			tmp[i] = b ? brFactory.makeBrick(p, brickSize, typeA) : brFactory.makeBrick(p, brickSize, typeB);
			
			double r = rand.nextDouble();

			// 10% chance create health brick instead
			if (r < 0.1) {
				tmp[i] = brFactory.makeBrick(p, brickSize, BrickType.HEALTH);
			}

			else {
				tmp[i] = b ? brFactory.makeBrick(p, brickSize, typeA) : brFactory.makeBrick(p, brickSize, typeB);
			}

		}

		for (double y = brickHgt; i < tmp.length; i++, y += 2 * brickHgt) {
			double x = (brickOnLine * brickLen) - (brickLen / 2);
			p.setLocation(x, y);
//			tmp[i] = brFactory.makeBrick(p, brickSize, typeA);
			
			double r = rand.nextDouble();

			if (r < 0.1) {
				tmp[i] = brFactory.makeBrick(p, brickSize, BrickType.HEALTH);
			}

			else {
				tmp[i] = brFactory.makeBrick(p, brickSize, typeA);
			}

		}
		return tmp;
	}

}
