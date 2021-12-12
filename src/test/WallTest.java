package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import main.java.gameObjects.controller.WallController;

class WallTest {

	WallController w1 = new WallController(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, new Point(300, 430));

	@Test
	void testFindImpacts() {
		w1.getBall().setYSpeed(10);
		w1.getPlayer().impact(w1.getBall());
		w1.findImpacts();
		assertEquals(-10, w1.getBall().getSpeedY());
	}

	@Test
	public void testBrickCount() {
		w1.nextLevel();
		assertEquals(31, w1.getBrickCount());
	}

	@Test
	public void testMove() {
		w1.ballReset();
		w1.move();
		assertNotEquals(new Point(300, 430), w1.getBall().getPosition());
	}

	@Test
	public void testStage() {
		w1.nextLevel();
		assertEquals(1, w1.getStage());
		w1.nextLevel();
		assertEquals(2, w1.getStage());

	}

	@Test
	public void testResetLevel() {
		w1.nextLevel();
		w1.nextLevel();
		w1.resetLevel();
		w1.nextLevel();
		assertEquals(1, w1.getStage());
		w1.nextLevel();
		assertEquals(2, w1.getStage());
	}
	
	@Test
    void testBallReset() {
		w1.setBallLost(true);
		assertTrue(w1.isBallLost());
		w1.ballReset();
        assertFalse(w1.isBallLost());
    }

	@Test
	public void testLevel() {
		assertEquals(8, w1.getLevelsLength());
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
		w1.nextLevel();
		assertEquals(7, w1.getLevel());
		w1.nextLevel();
		assertEquals(8, w1.getLevel());
		assertFalse(w1.hasLevel());
	}

}
