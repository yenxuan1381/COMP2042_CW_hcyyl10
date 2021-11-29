package main.java.model;

import java.awt.Rectangle;

public class LevelFactory {
	
	private static final int LEVELS_COUNT = 6;
	
//	private static final int CLAY = 1;
//    private static final int STEEL = 2;
//    private static final int CEMENT = 3;
	

    
    private Level level;
	
	public LevelFactory() {
		level = new Level();
			
		}
	
    /**
     * Method to create multiple game levels
     * @param drawArea The area of the wall
     * @param brickCount The number of bricks
     * @param lineCount The number of lines
     * @param brickDimensionRatio The ratio of the brick shape
     * @return An array of brick objects
     */

    public Brick[][] makeLevels(Rectangle drawArea,int brickCount,int lineCount,double brickDimensionRatio){
        Brick[][] tmp = new Brick[LEVELS_COUNT][];
        tmp[0] = level.makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,BrickType.CLAY);
        tmp[1] = level.makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,BrickType.CLAY,BrickType.CEMENT);
        tmp[2] = level.makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,BrickType.CEMENT);
        tmp[3] = level.makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,BrickType.CLAY,BrickType.STEEL);
        tmp[4] = level.makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,BrickType.STEEL,BrickType.CEMENT);
        tmp[5] = level.makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,BrickType.STEEL);
        return tmp;
    }
    
    
}
