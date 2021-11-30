package main.java.view;

import java.awt.Color;

public class BrickView {
	
	private Color border;
    private Color inner;
	
	public BrickView(Color border,Color inner){
		
		this.border = border;
        this.inner = inner;
		
	}
	
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

}
