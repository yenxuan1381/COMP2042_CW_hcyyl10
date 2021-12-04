package main.java.model.brick;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.Random;

import main.java.controller.BrickController;

public class VibraniumBrick extends BrickController{
	
	  private static final String NAME = "Steel Brick";
	    private static final Color DEF_INNER = new Color(203, 203, 201);
	    private static final Color DEF_BORDER = Color.BLUE.brighter();
	    private static final int STEEL_STRENGTH = 1;
	    private static final double VIB_PROBABILITY = 0.6;

	    private Random rnd;
	    private Shape brickFace;
	    
	    /**
	     * Constructor to create a brick object of the type vibranium
	     * @param point The coordinates of the point of the vibranium brick
	     * @param size The size of the vibarnium brick
	     */

	    public VibraniumBrick(Point point, Dimension size){
	        super(NAME,point,size,DEF_BORDER,DEF_INNER,STEEL_STRENGTH);
	        rnd = new Random();
	        brickFace = super.getBrickFace();
	    }

	    @Override
	    protected Shape makeBrickFace(Point pos, Dimension size) {
	        return new Rectangle(pos,size);
	    }

	    @Override
	    public Shape getBrick() {
	        return brickFace;
	    }
	    
	    @Override
	    public  boolean setImpact(Point2D point , int dir){
	        if(super.isBroken())
	            return false;
	        impact();
	        return  super.isBroken();
	    }

	    @Override
	    public void impact(){
	        if(rnd.nextDouble() < VIB_PROBABILITY){
	            super.impact();
	        }
	    }

}
