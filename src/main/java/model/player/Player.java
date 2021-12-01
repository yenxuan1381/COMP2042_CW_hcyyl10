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
package main.java.model.player;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import main.java.controller.BallController;
import main.java.model.ball.Ball;

/**
 * Objects of this class represent the player
 * @author Emily
 *
 */

public class Player {

    public static final Color BORDER_COLOR = Color.GREEN.darker().darker();
    public static final Color INNER_COLOR = Color.GREEN;


//    private Rectangle playerFace;
    private Point ballPoint;
//    private int moveAmount;
    private int min;
    private int max;

    public Player() {
    	
    }
    
    /**
     * Constructor to create a player class 
     * @param ballPoint The coordinates of the point of the ball that touches the player's paddle
     * @param width The width of the player's paddle
     * @param height The height of the player's paddle
     * @param container The rectangle shape of the player's paddle
     */
    
    public Player(Point ballPoint, int width, Rectangle container) {
        this.ballPoint = ballPoint;
        
        //initialise the moveAmount
//        moveAmount = 0;
        
        //container.x is the X coordinate of the upper-left corner of the Rectangle container.
        min = container.x + (width / 2);
        max = min + container.width - width;

    }   
   
//    /**
//     * Getter to get the shape of the player's paddle
//     * @return The shape of the player's paddle
//     */
//
//    public Rectangle getPlayerFace(){
//        return  playerFace;
//    }

	public Point getBallPoint() {
		return ballPoint;
	}

	public void setBallPoint(Point ballPoint) {
		this.ballPoint = ballPoint;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
    
    

	
}
