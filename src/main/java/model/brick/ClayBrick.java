package main.java.model.brick;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;

import main.java.controller.BrickController;

/**
 * Objects of this class inherits from the brick class, creating clay brick objects
 * @author Emily
 *
 */

public class ClayBrick extends BrickController {

    private static final String NAME = "Clay Brick";
    private static final Color DEF_INNER = new Color(178, 34, 34).darker();
    private static final Color DEF_BORDER = Color.GRAY;
    private static final int CLAY_STRENGTH = 1;

    /**
     * Constructor to create a brick object of the type clay
     * @param point The coordinates of the point of the clay brick
     * @param size The size of the clay brick 
     */
    
    public ClayBrick(Point point, Dimension size){
        super(NAME,point,size,DEF_BORDER,DEF_INNER,CLAY_STRENGTH);
    }
    

    protected Shape makeBrickFace(Point pos, Dimension size) {
        return new Rectangle(pos,size);
    }

    public Shape getBrick() {
        return super.getBrickFace();
    }

}
