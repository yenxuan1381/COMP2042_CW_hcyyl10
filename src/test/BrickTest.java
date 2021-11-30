package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import main.java.controller.BrickController;
import main.java.model.*;
import main.java.model.ball.Ball;
import main.java.model.ball.RubberBall;
import main.java.model.brick.Brick;
import main.java.model.brick.CementBrick;
import main.java.model.brick.ClayBrick;
import main.java.model.brick.ImpactDirection;

class BrickTest {

	@Test
	void testLeftImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		Ball b1 = new RubberBall(new Point(280,430));
		b1.setXSpeed(20);
		b1.move();
		
		// (ball) --> [brick] (left impact)	
		assertEquals(ImpactDirection.LEFT_IMPACT, clayBrick.findImpact(b1));
	}
	
	@Test
	void testRightImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		Ball b1 = new RubberBall(new Point(305,430));

		assertEquals(ImpactDirection.RIGHT_IMPACT, clayBrick.findImpact(b1));
	}
	
	@Test
	void testUpImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		Ball b1 = new RubberBall(new Point(300,425));
		
		assertEquals(ImpactDirection.UP_IMPACT, clayBrick.findImpact(b1));
	}
	
	@Test
	void testDownImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		Ball b1 = new RubberBall(new Point(300,440));

		assertEquals(ImpactDirection.DOWN_IMPACT, clayBrick.findImpact(b1));
	}
	
	
	@Test
	void testRepair() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		// dir 40 = crack.DOWN
		clayBrick.setImpact(new Point(300,440),40);
		clayBrick.repair();
		
		assertFalse(clayBrick.isBroken());
	}
	
	@Test
	void clayBrickStrength() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		// dir 40 = crack.DOWN
		clayBrick.setImpact(new Point(300,440),40);
		
		assertTrue(clayBrick.isBroken());
	}
	
	@Test
	void cementBrickStrength() {
		BrickController cementBrick = new CementBrick(new Point(300,430), new Dimension(10,10));
		// dir 40 = crack.DOWN
		cementBrick.setImpact(new Point(300,440),40);
		
		assertFalse(cementBrick.isBroken());
	}

//	// by probability
//	@Test
//	void steelBrickStrength() {
//		Brick steelBrick = new SteelBrick(new Point(300,430), new Dimension(10,10));
//		// dir 40 = crack.DOWN
//		steelBrick.setImpact(new Point(300,440),40) ;
//		
//		assertFalse(steelBrick.isBroken());
//	}
}
