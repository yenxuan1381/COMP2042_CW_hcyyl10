package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import model.*;

class BrickTest {

	@Test
	void testLeftImpact() {
		Brick clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		Ball b1 = new RubberBall(new Point(280,430));
		b1.setXSpeed(20);
		b1.move();
		
		// (ball) --> [brick] (left impact)	
		assertEquals(300, clayBrick.findImpact(b1));
	}
	
	@Test
	void testRepair() {
		Brick clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		// dir 40 = crack.DOWN
		clayBrick.setImpact(new Point(300,440),40);
		clayBrick.repair();
		
		assertFalse(clayBrick.isBroken());
	}
	
	@Test
	void clayBrickStrength() {
		Brick clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		// dir 40 = crack.DOWN
		clayBrick.setImpact(new Point(300,440),40);
		
		assertTrue(clayBrick.isBroken());
	}
	
	@Test
	void cementBrickStrength() {
		Brick cementBrick = new CementBrick(new Point(300,430), new Dimension(10,10));
		// dir 40 = crack.DOWN
		cementBrick.setImpact(new Point(300,440),40);
		
		assertFalse(cementBrick.isBroken());
	}

	@Test
	void steelBrickStrength() {
		Brick steelBrick = new SteelBrick(new Point(300,430), new Dimension(10,10));
		// dir 40 = crack.DOWN
		steelBrick.setImpact(new Point(300,440),40) ;
		
		assertFalse(steelBrick.isBroken());
	}
}
