package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import main.java.gameObjects.controller.BallController;
import main.java.gameObjects.controller.PlayerController;
import main.java.gameObjects.model.ball.BallFactory;

class PlayerTest {
	
	BallFactory ballFac = new BallFactory();

	@Test
	void testSingleton() {
		
		// Only 1 instance of the class is created
		PlayerController p1 = PlayerController.getUniquePlayer(new Point(300,430),150,10, new Rectangle(10,10,20,20));
		PlayerController p2 = PlayerController.getUniquePlayer(new Point(200,330),150,10, new Rectangle(20,20,30,30));
		assertEquals(p1, p2);
		
		PlayerController p3 = PlayerController.getUniquePlayer(new Point(100,230),150,10, new Rectangle(20,30,50,40));
		assertEquals(p1, p3);
		assertEquals(p2, p3);
	}
	
	@Test
	void testMovePlayer() {
		PlayerController p1 = PlayerController.getUniquePlayer(new Point(300,430),150,10, new Rectangle(10,10,20,20));
		p1.moveLeft();
		p1.move();
		assertNotEquals(new Point(300,430), p1.getPlayerFace().getLocation());
	}
	
	@Test
	void testImpact() {
		PlayerController p1 = PlayerController.getUniquePlayer(new Point(300,430),150,10, new Rectangle(300,430,150,10));		
		BallController b1 = ballFac.makeBallType("RUBBER", new Point(300,430));
		BallController b2 = ballFac.makeBallType("RUBBER", new Point(200,330));

		assertTrue(p1.impact(b1));
		assertFalse(p1.impact(b2));
	}
	
	@Test
	void testMoveTo() {
		PlayerController p1 = PlayerController.getUniquePlayer(new Point(300,430),150,10, new Rectangle(500,500,500,500));
		p1.moveTo(new Point(400,530));
		assertEquals(new Point(325,530), p1.getPlayerFace().getLocation());
	}
	
	
	
	

}
