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
import java.awt.geom.Rectangle2D;

/**
 * Objects of this class represent the player
 * @author Emily
 *
 */

public class Player {

    public static final Color BORDER_COLOR = Color.GREEN.darker().darker();
    public static final Color INNER_COLOR = Color.GREEN;

    private static final int DEF_MOVE_AMOUNT = 5;
	private static Player player;

    private Rectangle playerFace;
    private Point ballPoint;
    private int moveAmount;
    private int min;
    private int max;

    /**
     * Default constructor
     */
    
    private Player() {
    	
    }
    
    /**
     * Constructor to create a player class 
     * @param ballPoint The coordinates of the point of the ball that touches the player's paddle
     * @param width The width of the player's paddle
     * @param height The height of the player's paddle
     * @param container The rectangle shape of the player's paddle
     */
    
    private Player(Point ballPoint,int width,int height,Rectangle container) {
        this.ballPoint = ballPoint;
        
        //initialise the moveAmount
        moveAmount = 0;
        playerFace = makeRectangle(width, height);
        
        //container.x is the X coordinate of the upper-left corner of the Rectangle container.
        min = container.x + (width / 2);
        max = min + container.width - width;

    }
    
    /**
     * Method to create a rectangle object 
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @return A rectangle object
     */

    private Rectangle makeRectangle(int width,int height){
        Point p = new Point((int)(ballPoint.getX() - (width / 2)),(int)ballPoint.getY());
        return  new Rectangle(p,new Dimension(width,height));
    }
    
    /**
     * Method that determines whether the ball touches the player's paddle
     * @param b The ball object
     * @return True if the ball touches the player's paddle, False if the ball did not touch the player's paddle
     */

    public boolean impact(Ball b){
        return playerFace.contains(b.getPosition()) && playerFace.contains(b.down) ;
    }
    
    /**
     * Method to move the player's paddle
     */

    public void move(){
        double x = ballPoint.getX() + moveAmount;
        if(x < min || x > max)
            return;
        ballPoint.setLocation(x,ballPoint.getY());
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }
    
    public void move(int m){
        double x = ballPoint.getX() + m;
        if(x < min || x > max)
            return;
        ballPoint.setLocation(x,ballPoint.getY());
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }
    
    /**
     * Method to move the player's paddle to the left
     */

    public void moveLeft(){
        moveAmount = -DEF_MOVE_AMOUNT;
    }
    
    /**
     * Method to move the player's paddle to the right
     */

    public void moveRight(){
        moveAmount = DEF_MOVE_AMOUNT;
    }
    
    /**
     * Method to stop the player's paddle from moving
     */

    public void stop(){
        moveAmount = 0;
    }
    
    /**
     * Method to get the Player instance, creates a new instance if no instance is created
     * @return player
     */
    
    public static Player getUniquePlayer() {
    	if(player == null) {
    		player = new Player();
    	}
		return player;
    }
    
    /**
     * Method to get the Player instance, creates a new instance if no instance is created
     * @param ballPoint point of the ball
     * @param width width of the paddle
     * @param height height of the paddle
     * @param container the rectangle shape of the player paddle
     * @return player 
     */
    
    public static Player getUniquePlayer(Point ballPoint,int width,int height,Rectangle container) {
    	if(player == null) {
    		player = new Player(ballPoint, width, height, container);
    	}
		return player;
    }
    
    /**
     * Getter to get the shape of the player's paddle
     * @return The shape of the player's paddle
     */

    public Rectangle getPlayerFace(){
        return  playerFace;
    }
    
    /**
     * Method to move the player's paddle to a specific point
     * @param p The coordinates of the point for the player's paddle to move to
     */

    public void moveTo(Point p){
        ballPoint.setLocation(p);
        playerFace.setLocation(ballPoint.x - (int)playerFace.getWidth()/2,ballPoint.y);
    }
}
