package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import main.java.gameObjects.controller.BallController;
import main.java.gameObjects.model.ball.BallFactory;

class BallTest {
	
	Point p = new Point(300, 430);
	BallFactory ballFac = new BallFactory();

	@Test
	void moveBallPosition() {
		BallController b1 = ballFac.makeBallType("RUBBER", p);
		b1.moveTo(new Point(430,300));
		assertEquals(new Point(430,300), b1.getPosition());
	}
	
	@Test
	void moveBall() {
		BallController b1 = ballFac.makeBallType("RUBBER", p);
		b1.setSpeed(10, 5);
		b1.move();
		assertNotEquals(new Point(300,430), b1.getPosition());
	}
	
	@Test
	void reverseXSpeed() {
		BallController b1 = ballFac.makeBallType("RUBBER", p);
		b1.setSpeed(10, 5);
		b1.reverseX();
		assertEquals(-10, b1.getSpeedX());
	}
	
	
	@Test
	void reverseYSpeed() {
		BallController b1 = ballFac.makeBallType("RUBBER", p);
		b1.setSpeed(10, 5);
		b1.reverseY();
		assertEquals(-5, b1.getSpeedY());
	}
	
	@Test
	void speed0() {
		BallController b1 = ballFac.makeBallType("RUBBER", p);
		b1.setSpeed(0, 0);
		b1.reverseY();
		assertEquals(0, b1.getSpeedY());
	}
	
}
