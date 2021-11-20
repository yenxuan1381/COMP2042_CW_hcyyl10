package model;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * This abstract class Brick allows other class to implement its method
 * @author Emily
 *
 */

abstract public class Brick  {

    public static final int MIN_CRACK = 1;
    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;


    public static final int UP_IMPACT = 100;
    public static final int DOWN_IMPACT = 200;
    public static final int LEFT_IMPACT = 300;
    public static final int RIGHT_IMPACT = 400;

    /**
     * Objects of this class represent the cracks of the brick
     * @author Emily
     *
     */

    protected static Random rnd;

    private String name;
    Shape brickFace;

    private Color border;
    private Color inner;

    private int fullStrength;
    private int strength;

    private boolean broken;
    
   
    /**
     * Constructor for the brick object
     * @param name Name of the brick object
     * @param pos Position of the brick object
     * @param size Size of the brick object
     * @param border Color of the border of the brick object
     * @param inner Inner color of the brick object
     * @param strength Strength of the brick object
     */

    public Brick(String name, Point pos,Dimension size,Color border,Color inner,int strength){
        setRnd(new Random());
        broken = false;
        this.setName(name);
        brickFace = makeBrickFace(pos,size);
        this.border = border;
        this.inner = inner;
        this.fullStrength = this.strength = strength;
    }
    
    /**
     * Abstract method to create the shape of the brick object
     * @param pos Position of the brick object
     * @param size Size of the brick object
     * @return The shape of the brick object
     */

    protected abstract Shape makeBrickFace(Point pos,Dimension size);
    
    /**
     * Method to determine whether the brick is broken or not
     * @param point The coordinates of the point of the ball
     * @param dir The direction of the impact
     * @return True if brick is not broken, False if the brick is broken
     */

    public  boolean setImpact(Point2D point , int dir){
        if(broken)
            return false;
        impact();
        return  broken;
    }

    /**
     * Getter for the shape of the brick object
     * @return The shape of the brick object
     */
    
    public abstract Shape getBrick();
    
    /**
     * Getter for the border color of the brick object
     * @return the color of the border of the brick object
     */

    public Color getBorderColor(){
        return  border;
    }
    
    /**
     * Getter for the inner color of the brick object
     * @return the inner color of the brick object
     */

    public Color getInnerColor(){
        return inner;
    }
    
    /**
     * Method to find the impact point between the ball object and the brick object
     * @param b The ball object
     * @return The speed and direction of the ball after impact
     */

    public final int findImpact(Ball b){
        if(broken)
            return 0;
        int out  = 0;
        if(brickFace.contains(b.right))
            out = LEFT_IMPACT;
        else if(brickFace.contains(b.left))
            out = RIGHT_IMPACT;
        else if(brickFace.contains(b.up))
            out = DOWN_IMPACT;
        else if(brickFace.contains(b.down))
            out = UP_IMPACT;
        return out;
    }
    
    /**
     * Method to determine whether the brick object is broken
     * @return True if the brick object is broken, False if the brick object is not broken
     */

    public final boolean isBroken(){
        return broken;
    }
    

    /**
     * Method to reset the strength of the brick object to full strength
     */

    public void repair() {
        broken = false;
        strength = fullStrength;
    }
    
    /**
     * Method to decrease the strength of the brick object
     */

    public void impact(){
        strength--;
        broken = (strength == 0);
    }
    
    /**
     * Setter to set the random value
     * @param rnd random value
     */

	public static void setRnd(Random rnd) {
		Brick.rnd = rnd;
	}
	
	/**
	 * Getter to get the randome value
	 * @return rnd randome value
	 */

	public static Random getRnd() {
		return rnd;
	}

	/**
	 * Setter to set the name
	 * @param name name
	 */

	public void setName(String name) {
		this.name = name;
	}



}





