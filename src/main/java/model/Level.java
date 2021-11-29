package main.java.model;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Level {
	
	private static final int CLAY = 1;
    private static final int STEEL = 2;
    private static final int CEMENT = 3;
    private static final int SPECIAL = 4;
	
	public Level () {
		
	}
	
	/**
     * Method to create an array of a single type of bricks
     * @param drawArea The area of the wall
     * @param brickCnt The amount of bricks
     * @param lineCnt The amount of line
     * @param brickSizeRatio The ratio of the brick
     * @param type The type of the brick
     * @return An array of brick objects
     */

    public Brick[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int type){
        /*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        Brick[] tmp  = new Brick[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();
        
        Random rand = new Random();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            double x = (i % brickOnLine) * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);
            
            double r = rand.nextDouble();
    
            // 30% chance to create Special Brick
            if(r < 0.3) {
            	tmp[i] = makeBrick(p,brickSize,SPECIAL);
            }
            
            else {
            	tmp[i] = makeBrick(p,brickSize,type);
            }

        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            
            double r = rand.nextDouble();
            
            if(r < 0.3) {
            	tmp[i] = makeBrick(p,brickSize,SPECIAL);
            }
            
            else {
            	tmp[i] = makeBrick(p,brickSize,type);
            }
        }
        return tmp;

    }
    
    /**
     * Method to create an array of a two type of bricks in a chessboard pattern
     * @param drawArea The area of the wall
     * @param brickCnt The number of bricks
     * @param lineCnt The number of line
     * @param brickSizeRatio The ratio of the brick
     * @param typeA The type of the brick
     * @param typeB The type of the brick
     * @return An array of brick objects
     */

    public Brick[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int typeA, int typeB){
        
    	/*
          if brickCount is not divisible by line count,brickCount is adjusted to the biggest
          multiple of lineCount smaller then brickCount
         */
    	
        brickCnt -= brickCnt % lineCnt;

        int brickOnLine = brickCnt / lineCnt;

        int centerLeft = brickOnLine / 2 - 1;
        int centerRight = brickOnLine / 2 + 1;

        double brickLen = drawArea.getWidth() / brickOnLine;
        double brickHgt = brickLen / brickSizeRatio;

        brickCnt += lineCnt / 2;

        Brick[] tmp  = new Brick[brickCnt];

        Dimension brickSize = new Dimension((int) brickLen,(int) brickHgt);
        Point p = new Point();
        
        Random rand = new Random();

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            int posX = i % brickOnLine;
            double x = posX * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);

            boolean b = ((line % 2 == 0 && i % 2 == 0) || (line % 2 != 0 && posX > centerLeft && posX <= centerRight));
            
            double r = rand.nextDouble();
            
            if(r < 0.2) {
            	tmp[i] = makeBrick(p,brickSize,SPECIAL);
            }
            
            else {
            	tmp[i] = b ?  makeBrick(p,brickSize,typeA) : makeBrick(p,brickSize,typeB);
            }
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            double r = rand.nextDouble();
            
            if(r < 0.2) {
            	tmp[i] = makeBrick(p,brickSize,SPECIAL);
            }
            
            else {
            	tmp[i] = makeBrick(p,brickSize,typeA);
            }       
        }
        return tmp;
    }
    
//    /**
//     * Method to create multiple game levels
//     * @param drawArea The area of the wall
//     * @param brickCount The number of bricks
//     * @param lineCount The number of lines
//     * @param brickDimensionRatio The ratio of the brick shape
//     * @return An array of brick objects
//     */
//
//    public Brick[][] makeLevels(Rectangle drawArea,int brickCount,int lineCount,double brickDimensionRatio){
//        Brick[][] tmp = new Brick[LEVELS_COUNT][];
//        tmp[0] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY);
//        tmp[1] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,CEMENT);
//        tmp[2] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CEMENT);
//        tmp[3] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,STEEL);
//        tmp[4] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL,CEMENT);
//        tmp[5] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL);
//        return tmp;
//    }
//    
    /**
     * Method to create brick objects
     * @param point The point of the brick object
     * @param size The size of the brick object
     * @param type The type of the brick object
     * @return A brick object
     */
    
    private Brick makeBrick(Point point, Dimension size, int type){
        Brick out;
        switch(type){
            case CLAY:
                out = new ClayBrick(point,size);
                break;
            case STEEL:
                out = new SteelBrick(point,size);
                break;
            case CEMENT:
                out = new CementBrick(point, size);
                break;
            case SPECIAL:
                out = new SpecialBrick(point, size);
                break;
            default:
                throw  new IllegalArgumentException(String.format("Unknown Type:%d\n",type));
        }
        return  out;
    }


    
    

}
