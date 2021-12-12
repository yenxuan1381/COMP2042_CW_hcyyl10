package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Point;
import org.junit.jupiter.api.Test;

import main.java.gameObjects.controller.BallController;
import main.java.gameObjects.controller.BrickController;
import main.java.gameObjects.model.ball.BallFactory;
import main.java.gameObjects.model.brick.BrickFactory;
import main.java.gameObjects.model.brick.BrickType;
import main.java.gameObjects.model.brick.CementBrick;
import main.java.gameObjects.model.brick.ClayBrick;
import main.java.gameObjects.model.brick.HealthBrick;
import main.java.gameObjects.model.brick.ImpactDirection;
import main.java.gameObjects.model.crack.CrackDirection;

class BrickTest {
	
	BallFactory ballFac = new BallFactory();
	BrickFactory brFactory = new BrickFactory();
	Point point = new Point(300,430);
	Dimension dimension = new Dimension(10,10);

	@Test
	void testLeftImpact() {
		BrickController clayBrick = new ClayBrick(point, dimension);
		BallController b1 = ballFac.makeBallType("RUBBER", new Point(280,430));
		b1.setXSpeed(20);
		b1.move();
		
		// (ball) --> [brick] (left impact)	
		assertEquals(ImpactDirection.LEFT_IMPACT, clayBrick.findImpact(b1));
	}
	
	@Test
	void testRightImpact() {
		BrickController clayBrick = new ClayBrick(point, dimension);
		BallController b1 = ballFac.makeBallType("RUBBER", new Point(305,430));

		assertEquals(ImpactDirection.RIGHT_IMPACT, clayBrick.findImpact(b1));
	}
	
	@Test
	void testUpImpact() {
		BrickController clayBrick = new ClayBrick(point, dimension);
		BallController b1 = ballFac.makeBallType("RUBBER", new Point(300,425));

		
		assertEquals(ImpactDirection.UP_IMPACT, clayBrick.findImpact(b1));
	}
	
	@Test
	void testDownImpact() {
		BrickController clayBrick = new ClayBrick(point, dimension);
		BallController b1 = ballFac.makeBallType("RUBBER", new Point(300,440));


		assertEquals(ImpactDirection.DOWN_IMPACT, clayBrick.findImpact(b1));
	}
	
	
	@Test
	void testRepair() {
		BrickController clayBrick = new ClayBrick(point, dimension);
		clayBrick.setImpact(new Point(300,440),CrackDirection.DOWN);
		assertTrue(clayBrick.isBroken());
		
		clayBrick.repair();
		assertFalse(clayBrick.isBroken());
	}
	
	@Test
	void clayBrickStrength() {
		BrickController clayBrick = new ClayBrick(point, dimension);
		clayBrick.setImpact(new Point(300,440),CrackDirection.DOWN);
		
		assertTrue(clayBrick.isBroken());
	}
	
	@Test
	void cementBrickStrength() {
		BrickController cementBrick = new CementBrick(point, dimension);
		cementBrick.setImpact(new Point(300,440),CrackDirection.DOWN);
		
		assertFalse(cementBrick.isBroken());
	}
	
	@Test
	void testImpact() {
		BrickController clayBrick = new ClayBrick(point, dimension);
		clayBrick.impact();
		assertTrue(clayBrick.isBroken());
	}
	
	@Test
	void testFindImpact() {
		BrickController clayBrick = new ClayBrick(point, dimension);
		BallController b1 = ballFac.makeBallType("RUBBER", new Point(300,440));

		ImpactDirection res = null;
		clayBrick.impact();
		res = clayBrick.findImpact(b1);
		
		assertEquals(ImpactDirection.NO_IMPACT, res);
	}
	
	@Test
	void testFactory() {
		BrickController tmp = brFactory.makeBrick(point, dimension, BrickType.HEALTH);
		BrickController healthBrick = new HealthBrick(point, dimension);
		assertNotNull(tmp);
		assertEquals(tmp.getClass(), healthBrick.getClass());
	}

}
