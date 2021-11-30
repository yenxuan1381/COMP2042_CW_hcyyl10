package main.java.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Point2D;

import main.java.model.ball.Ball;
import main.java.model.brick.Brick;
import main.java.model.brick.ImpactDirection;
import main.java.view.BrickView;

public abstract class BrickController {
	
	public static final int MIN_CRACK = 1;
    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;
	
	private String name;
    private Shape brickFace;

	private Color border;
    private Color inner;

    private int fullStrength;
    private int strength;

    private boolean broken;
    Brick brickModel;
    BrickView brickView;
	
	public BrickController(String name, Point pos,Dimension size,Color border,Color inner,int strength) {
		broken = false;
	
		brickModel = new Brick(name);
		setBrickFace(makeBrickFace(pos,size));
//		this.setName(name);
//	    brickFace = makeBrickFace(pos,size);
		
	    brickView = new BrickView(border, inner);

//	    this.border = border;
//	    this.inner = inner;
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
     * Getter for the shape of the brick object
     * @return The shape of the brick object
     */
    
    public abstract Shape getBrick();
    
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
     * Method to find the impact point between the ball object and the brick object
     * @param b The ball object
     * @return The speed and direction of the ball after impact
     */

    public final ImpactDirection findImpact(Ball b){
        if(broken)
            return ImpactDirection.NO_IMPACT;
        ImpactDirection out  = ImpactDirection.NO_IMPACT;
        if(getBrickFace().contains(b.right))
            out = ImpactDirection.LEFT_IMPACT;
        else if(getBrickFace().contains(b.left))
            out = ImpactDirection.RIGHT_IMPACT;
        else if(getBrickFace().contains(b.up))
            out = ImpactDirection.DOWN_IMPACT;
        else if(getBrickFace().contains(b.down))
            out = ImpactDirection.UP_IMPACT;
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
    
//    public Shape getBrick() {
//		return brickModel.getBrickFace();
//    	
//    }
//    


	
	public Color getBorder() {
		return brickView.getBorderColor();
	}

	public Color getInner() {
		return brickView.getInnerColor();
	}


	public Shape getBrickFace() {
		return brickFace;
	}


	public void setBrickFace(Shape brickFace) {
		this.brickFace = brickFace;
	}

}
