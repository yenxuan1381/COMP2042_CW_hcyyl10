package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

public class SpecialBrick extends Brick {
	
	private static final String NAME = "Special Brick";
    private static final Color DEF_INNER = new Color(178, 34, 34).brighter();
    private static final Color DEF_BORDER = Color.GRAY;
    private static final int CLAY_STRENGTH = 1;

    /**
     * Constructor to create a brick object of the type clay
     * @param point The coordinates of the point of the clay brick
     * @param size The size of the clay brick 
     */
    
    public SpecialBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CLAY_STRENGTH);
        
    }

    @Override
    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    @Override
    public Shape getBrick() {
        return super.brickFace;
    }

}
