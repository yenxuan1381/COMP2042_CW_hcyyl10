package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Point;
import org.junit.jupiter.api.Test;

import main.java.controller.BallController;
import main.java.controller.BrickController;
import main.java.model.ball.RubberBall;
import main.java.model.brick.CementBrick;
import main.java.model.brick.ClayBrick;
import main.java.model.brick.ImpactDirection;
import main.java.model.crack.CrackDirection;

class BrickTest {

	@Test
	void testLeftImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		RubberBall b1 = new RubberBall(new Point(280,430));
		b1.setXSpeed(20);
		b1.move();
		
		// (ball) --> [brick] (left impact)	
		assertEquals(ImpactDirection.LEFT_IMPACT, clayBrick.findImpact(b1));
	}
	
	@Test
	void testRightImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		RubberBall b1 = new RubberBall(new Point(305,430));

		assertEquals(ImpactDirection.RIGHT_IMPACT, clayBrick.findImpact(b1));
	}
	
	@Test
	void testUpImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		BallController b1 = new RubberBall(new Point(300,425));
		
		assertEquals(ImpactDirection.UP_IMPACT, clayBrick.findImpact(b1));
	}
	
	@Test
	void testDownImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		BallController b1 = new RubberBall(new Point(300,440));

		assertEquals(ImpactDirection.DOWN_IMPACT, clayBrick.findImpact(b1));
	}
	
	
	@Test
	void testRepair() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		clayBrick.setImpact(new Point(300,440),CrackDirection.DOWN);
		clayBrick.repair();
		
		assertFalse(clayBrick.isBroken());
	}
	
	@Test
	void clayBrickStrength() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		clayBrick.setImpact(new Point(300,440),CrackDirection.DOWN);
		
		assertTrue(clayBrick.isBroken());
	}
	
	@Test
	void cementBrickStrength() {
		BrickController cementBrick = new CementBrick(new Point(300,430), new Dimension(10,10));
		cementBrick.setImpact(new Point(300,440),CrackDirection.DOWN);
		
		assertFalse(cementBrick.isBroken());
	}
	
	@Test
	void testImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		clayBrick.impact();
		assertTrue(clayBrick.isBroken());
	}
	
	@Test
	void testFindImpact() {
		BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
		BallController b1 = new RubberBall(new Point(300,440));
		ImpactDirection res = null;
		clayBrick.impact();
		res = clayBrick.findImpact(b1);
		
		assertEquals(ImpactDirection.NO_IMPACT, res);
	}

}
