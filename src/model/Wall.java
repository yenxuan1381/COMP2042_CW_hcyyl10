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
package model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;


public class Wall {

    private static final int LEVELS_COUNT = 4;

    private static final int CLAY = 1;
    private static final int STEEL = 2;
    private static final int CEMENT = 3;

    private Random rnd;
    private Rectangle area;

    private Brick[] bricks;
    private Ball ball;
    private Player player;

    private Brick[][] levels;
    private int level;

    private Point startPoint;
    private int brickCount;
    private int ballCount;
    private boolean ballLost;
    
    /**
     * Constructor to create a wall class
     * @param drawArea the wall shape
     * @param brickCount the amount of bricks
     * @param lineCount the amount of lines
     * @param brickDimensionRatio the ratio of the brick shape
     * @param ballPos the coordinates of the point of the ball
     */

    public Wall(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point ballPos){

        this.startPoint = new Point(ballPos);

        levels = makeLevels(drawArea,brickCount,lineCount,brickDimensionRatio);
        level = 0;

        ballCount = 3;
        ballLost = false;

        rnd = new Random();

        makeBall(ballPos);
        int speedX,speedY;
        do{
            speedX = rnd.nextInt(5) - 2;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(3);
        }while(speedY == 0);

        getBall().setSpeed(speedX,speedY);

        setPlayer(new Player((Point) ballPos.clone(),150,10, drawArea));

        area = drawArea;

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

    private Brick[] makeSingleTypeLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int type){
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

        int i;
        for(i = 0; i < tmp.length; i++){
            int line = i / brickOnLine;
            if(line == lineCnt)
                break;
            double x = (i % brickOnLine) * brickLen;
            x =(line % 2 == 0) ? x : (x - (brickLen / 2));
            double y = (line) * brickHgt;
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,type);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = new ClayBrick(p,brickSize);
        }
        return tmp;

    }
    
    /**
     * Method to create an array of a two type of bricks in a chessboard pattern
     * @param drawArea The area of the wall
     * @param brickCnt The amount of bricks
     * @param lineCnt The amount of line
     * @param brickSizeRatio The ratio of the brick
     * @param typeA The type of the brick
     * @param typeB The type of the brick
     * @return An array of brick objects
     */

    private Brick[] makeChessboardLevel(Rectangle drawArea, int brickCnt, int lineCnt, double brickSizeRatio, int typeA, int typeB){
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
            tmp[i] = b ?  makeBrick(p,brickSize,typeA) : makeBrick(p,brickSize,typeB);
        }

        for(double y = brickHgt;i < tmp.length;i++, y += 2*brickHgt){
            double x = (brickOnLine * brickLen) - (brickLen / 2);
            p.setLocation(x,y);
            tmp[i] = makeBrick(p,brickSize,typeA);
        }
        return tmp;
    }
    
    /**
     * Method to create a ball at a specific position
     * @param ballPos The coordinates of the point of the ball
     */

    private void makeBall(Point2D ballPos){
        setBall(new RubberBall(ballPos));
    }
    
    /**
     * Method to create multiple game levels
     * @param drawArea The area of the wall
     * @param brickCount The amount of bricks
     * @param lineCount The amount of lines
     * @param brickDimensionRatio The ratio of the brick shape
     * @return An array of brick objects
     */

    private Brick[][] makeLevels(Rectangle drawArea,int brickCount,int lineCount,double brickDimensionRatio){
        Brick[][] tmp = new Brick[LEVELS_COUNT][];
        tmp[0] = makeSingleTypeLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY);
        tmp[1] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,CEMENT);
        tmp[2] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,CLAY,STEEL);
        tmp[3] = makeChessboardLevel(drawArea,brickCount,lineCount,brickDimensionRatio,STEEL,CEMENT);
        return tmp;
    }
    
    /**
     * Method to move the player and the ball object
     */

    public void move(){
        getPlayer().move();
        getBall().move();
    }

    /**
     * Method to find the impact made by the ball
     * <li> if impact made between ball and player, ball change direction
     * <li> if impact made between ball and wall, the amount of bricks decreases 
     */
    
    public void findImpacts(){
        if(getPlayer().impact(getBall())){
            getBall().reverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
            * because for every brick program checks for horizontal and vertical impacts
            */
            brickCount--;
        }
        else if(impactBorder()) {
            getBall().reverseX();
        }
        else if(getBall().getPosition().getY() < area.getY()){
            getBall().reverseY();
        }
        else if(getBall().getPosition().getY() > area.getY() + area.getHeight()){
            ballCount--;
            ballLost = true;
        }
    }
    
    /**
     * Method to determine and set the direction of the ball if impact made between the ball and the wall
     * @return True if impact is made, False if no impact is made
     */

    private boolean impactWall(){
        for(Brick b : getBricks()){
            switch(b.findImpact(getBall())) {
                //Vertical Impact
                case Brick.UP_IMPACT:
                    getBall().reverseY();
                    return b.setImpact(getBall().down, Brick.Crack.UP);
                case Brick.DOWN_IMPACT:
                    getBall().reverseY();
                    return b.setImpact(getBall().up,Brick.Crack.DOWN);

                //Horizontal Impact
                case Brick.LEFT_IMPACT:
                    getBall().reverseX();
                    return b.setImpact(getBall().right,Brick.Crack.RIGHT);
                case Brick.RIGHT_IMPACT:
                    getBall().reverseX();
                    return b.setImpact(getBall().left,Brick.Crack.LEFT);
            }
        }
        return false;
    }
    
    /**
     * Method to determine and set the direction of the ball if impact made between the ball and the border
     * @return True if impact is made, False if no impact is made
     */

    private boolean impactBorder(){
        Point2D p = getBall().getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    }

    public int getBrickCount(){
        return brickCount;
    }

    public int getBallCount(){
        return ballCount;
    }

    public boolean isBallLost(){
        return ballLost;
    }
    
    /**
     * Method to reset the coordinates of the points of the ball to the default starting position
     */

    public void ballReset(){
        getPlayer().moveTo(startPoint);
        getBall().moveTo(startPoint);
        int speedX,speedY;
        do{
            speedX = rnd.nextInt(5) - 2;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(3);
        }while(speedY == 0);

        getBall().setSpeed(speedX,speedY);
        ballLost = false;
    }
    
    /**
     * Method to reset the wall to the default amount of bricks
     */

    public void wallReset(){
        for(Brick b : getBricks())
            b.repair();
        brickCount = getBricks().length;
        ballCount = 3;
    }

    public boolean ballEnd(){
        return ballCount == 0;
    }

    public boolean isDone(){
        return brickCount == 0;
    }

    public void nextLevel(){
        setBricks(levels[level++]);
        this.brickCount = getBricks().length;
    }

    public boolean hasLevel(){
        return level < levels.length;
    }

    public void setBallXSpeed(int s){
        getBall().setXSpeed(s);
    }

    public void setBallYSpeed(int s){
        getBall().setYSpeed(s);
    }

    public void resetBallCount(){
        ballCount = 3;
    }

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
            default:
                throw  new IllegalArgumentException(String.format("Unknown Type:%d\n",type));
        }
        return  out;
    }

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Brick[] getBricks() {
		return bricks;
	}

	public void setBricks(Brick[] bricks) {
		this.bricks = bricks;
	}

}
