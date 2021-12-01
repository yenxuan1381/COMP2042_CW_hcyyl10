package main.java.view;

import java.awt.Color;

public class BallView {
	
    private Color border;
    private Color inner;
	
	public BallView(Color inner,Color border) {       
		this.border = border;
        this.inner  = inner;		
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

}
