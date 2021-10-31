package model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 * This abstract class Ball allows other class to implement its method
 * @author filippo
 *
 */

abstract public class Ball {

    private Shape ballFace;

    private Point2D center;

    Point2D up;
    Point2D down;
    Point2D left;
    Point2D right;

    private Color border;
    private Color inner;

    private int speedX;
    private int speedY;
    
    /**
     * Constructor of Ball class
     * 
     * @param center The coordinates of the center of the ball
     * @param radius The radius of the ball
     * @param inner The color code for the inner color of the ball object
     * @param border The color code for the border color of the ball object
     */
    
    public Ball(Point2D center,int radius,Color inner,Color border){
        this.center = center;

        up = new Point2D.Double();
        down = new Point2D.Double();
        left = new Point2D.Double();
        right = new Point2D.Double();

        up.setLocation(center.getX(),center.getY()-(radius / 2));
        down.setLocation(center.getX(),center.getY()+(radius / 2));

        left.setLocation(center.getX()-(radius /2),center.getY());
        right.setLocation(center.getX()+(radius /2),center.getY());


        ballFace = makeBall(center,radius);
        this.border = border;
        this.inner  = inner;
        speedX = 0;
        speedY = 0;
    }
    
    /**
     * Abstract method to create the shape of the ball object
     * @param center The coordinates of the center of the ball
     * @param radius The radius of the ball
     * @return The shape of the ball object
     */

    protected abstract Shape makeBall(Point2D center,int radius);
    
    /**
     * Method to move the ball object 
     */

    public void move(){
        RectangularShape tmp = (RectangularShape) ballFace;
        center.setLocation((center.getX() + speedX),(center.getY() + speedY));
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        setPoints(w,h);


        ballFace = tmp;
    }
    
    /**
     * Setter to set the speed of the ball
     * @param x The horizontal speed of the ball
     * @param y The vertical speed of the ball
     */

    public void setSpeed(int x,int y){
        speedX = x;
        speedY = y;
    }
    
    /**
     * Setter to set horizontal speed of the ball
     * @param s The horizontal speed of the ball
     */

    public void setXSpeed(int s){
        speedX = s;
    }
    
    /**
     * Setter to set the vertical speed of the ball
     * @param s The vertical speed of the ball
     */
    
    public void setYSpeed(int s){
        speedY = s;
    }
    
    /**
     * Method to reverse the horizontal speed of the ball (Move the ball in opposite direction horizontally)
     */

    public void reverseX(){
        speedX *= -1;
    }
    
    /**
     * Method to reverse the vertical speed of the ball (Move the ball in opposite direction vertically)
     */

    public void reverseY(){
        speedY *= -1;
    }
    
    /**
     * Getter for the border color of the ball object
     * @return Color code of the border color of the ball object
     */

    public Color getBorderColor(){
        return border;
    }
    
    /**
     * Getter for the inner Color of the ball object
     * @return Color code of the inner color of the ball object 
     */

    public Color getInnerColor(){
        return inner;
    }
    
    /**
     * Getter for the position of the ball object
     * @return the coordinates of the ball's position
     */

    public Point2D getPosition(){
        return center;
    }
    
    /**
     * Getter for the shape of the ball object
     * @return the shape of the ball 
     */
    
    public Shape getBallFace(){
        return ballFace;
    }
    
    /**
     * Method to move the ball to point p
     * @param p coordinates of the point for the ball to move to
     */

    public void moveTo(Point p){
        center.setLocation(p);

        RectangularShape tmp = (RectangularShape) ballFace;
        double w = tmp.getWidth();
        double h = tmp.getHeight();

        tmp.setFrame((center.getX() -(w / 2)),(center.getY() - (h / 2)),w,h);
        ballFace = tmp;
    }
    
    /**
     * Setter to set set the points of the ball
     * @param width The width of the ball
     * @param height The height of the ball
     */

    private void setPoints(double width,double height){
        up.setLocation(center.getX(),center.getY()-(height / 2));
        down.setLocation(center.getX(),center.getY()+(height / 2));

        left.setLocation(center.getX()-(width / 2),center.getY());
        right.setLocation(center.getX()+(width / 2),center.getY());
    }
    
    /**
     * Getter for the horizontal speed of the ball 
     * @return the horizontal speed of the ball
     */

    public int getSpeedX(){
        return speedX;
    }
    
    /**
     * Getter for the vertical speed of the ball
     * @return the vertical speed of the ball
     */

    public int getSpeedY(){
        return speedY;
    }


}
