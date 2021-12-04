package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import main.java.controller.BallController;
import main.java.controller.PlayerController;
import main.java.controller.WallController;
import main.java.model.ball.RubberBall;


class WallTest {

	WallController w1 = new WallController(new Rectangle(0,0,600, 450),30,3,6/2,new Point(300,430));


//    @Test
//    public void testImpacts() {
//        w1.findImpacts();
//        assertEquals(0, b1.getSpeedY());
//        assertEquals(0, b1.getSpeedX());
//    }

    @Test
    public void testBrickCount() {
    	w1.nextLevel();
        assertEquals(31, w1.getBrickCount());
    }
    
    @Test
    public void testMove() {
    	w1.ballReset();
    	w1.move();
    	assertNotEquals(new Point(300,430), w1.getBall().getPosition());
    }
    
    @Test
    public void testStage() {
    	w1.nextLevel();
    	assertEquals(1, w1.getStage());
    	w1.nextLevel();
    	assertEquals(2, w1.getStage());
    	
    }

	
	@Test
    public void testLevel() {
		assertEquals(6,w1.getLevelsLength());
        assertTrue(w1.hasLevel());
        w1.nextLevel();
        assertEquals(1, w1.getLevel());
        w1.nextLevel();
        assertEquals(2, w1.getLevel());
        w1.nextLevel();
        assertEquals(3, w1.getLevel());
        w1.nextLevel();
        assertEquals(4, w1.getLevel());
        w1.nextLevel();
        assertEquals(5, w1.getLevel());
        w1.nextLevel();
        assertEquals(6, w1.getLevel());
        assertFalse(w1.hasLevel());
    }
	
	


}
