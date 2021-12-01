package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import main.java.controller.BallController;
import main.java.model.ball.RubberBall;

class BallTest {

	@Test
	void moveBallPosition() {
		RubberBall b1 = new RubberBall(new Point(300,430));
		b1.moveTo(new Point(430,300));
		assertEquals(new Point(430,300), b1.getPosition());
	}
	
	@Test
	void moveBall() {
		RubberBall b1 = new RubberBall(new Point(300,430));
		b1.setSpeed(10, 5);
		b1.move();
		assertNotEquals(new Point(300,430), b1.getPosition());
	}
	
	@Test
	void reverseXSpeed() {
		BallController b1 = new RubberBall(new Point(300,430));
		b1.setSpeed(10, 5);
		b1.reverseX();
		assertEquals(-10, b1.getSpeedX());
	}
	
	
	@Test
	void reverseYSpeed() {
		BallController b1 = new RubberBall(new Point(300,430));
		b1.setSpeed(10, 5);
		b1.reverseY();
		assertEquals(-5, b1.getSpeedY());
	}
	
	@Test
	void speed0() {
		BallController b1 = new RubberBall(new Point(300,430));
		b1.setSpeed(0, 0);
		b1.reverseY();
		assertEquals(0, b1.getSpeedY());
	}
	
}
