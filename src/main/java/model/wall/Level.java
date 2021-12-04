package main.java.model.wall;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import main.java.controller.BrickController;
import main.java.model.brick.BrickType;
import main.java.model.brick.CementBrick;
import main.java.model.brick.ClayBrick;
import main.java.model.brick.SpecialBrick;
import main.java.model.brick.SteelBrick;

public class Level {

	public Level() {

	}

	/**
	 * Method to create an array of a single type of bricks
	 * 
	 * @param drawArea       The area of the wall
	 * @param brickCnt       The amount of bricks
	 * @param lineCnt        The amount of line
	 * @param brickSizeRatio The ratio of the brick
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

			// 30% chance to create Special Brick
			if (r < 0.3) {
				tmp[i] = makeBrick(p, brickSize, BrickType.SPECIAL);
			}

			else {
				tmp[i] = makeBrick(p, brickSize, type);
			}

		}

		for (double y = brickHgt; i < tmp.length; i++, y += 2 * brickHgt) {
			double x = (brickOnLine * brickLen) - (brickLen / 2);
			p.setLocation(x, y);

			double r = rand.nextDouble();

			if (r < 0.3) {
				tmp[i] = makeBrick(p, brickSize, BrickType.SPECIAL);
			}

			else {
				tmp[i] = makeBrick(p, brickSize, type);
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
			tmp[i] = b ? makeBrick(p, brickSize, typeA) : makeBrick(p, brickSize, typeB);

//			double r = rand.nextDouble();
//
//			if (r < 0.2) {
//				tmp[i] = makeBrick(p, brickSize, BrickType.SPECIAL);
//			}
//
//			else {
//				tmp[i] = b ? makeBrick(p, brickSize, typeA) : makeBrick(p, brickSize, typeB);
//			}
		}

		for (double y = brickHgt; i < tmp.length; i++, y += 2 * brickHgt) {
			double x = (brickOnLine * brickLen) - (brickLen / 2);
			p.setLocation(x, y);
			tmp[i] = makeBrick(p, brickSize, typeA);
			
//			double r = rand.nextDouble();

//			if (r < 0.2) {
//				tmp[i] = makeBrick(p, brickSize, BrickType.SPECIAL);
//			}
//
//			else {
//				tmp[i] = makeBrick(p, brickSize, typeA);
//			}
		}
		return tmp;
	}

	/**
	 * Method to create brick objects
	 * 
	 * @param point The point of the brick object
	 * @param size  The size of the brick object
	 * @param type  The type of the brick object
	 * @return A brick object
	 */

	private BrickController makeBrick(Point point, Dimension size, BrickType type) {
		BrickController out;
		switch (type) {
		case CLAY:
			out = new ClayBrick(point, size);
			break;
		case STEEL:
			out = new SteelBrick(point, size);
			break;
		case CEMENT:
			out = new CementBrick(point, size);
			break;
		case SPECIAL:
			out = new SpecialBrick(point, size);
			break;
		default:
			throw new IllegalArgumentException(String.format("Unknown Type:%d\n", type));
		}
		return out;
	}

}
