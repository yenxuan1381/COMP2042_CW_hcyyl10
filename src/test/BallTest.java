package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import model.Ball;
import model.RubberBall;

class BallTest {

	@Test
	void moveBallPosition() {
		Ball b1 = new RubberBall(new Point(300,430));
		b1.moveTo(new Point(430,300));
		assertEquals(new Point(430,300), b1.getPosition());
	}
	
	@Test
	void moveBall() {
		Ball b1 = new RubberBall(new Point(300,430));
		b1.setSpeed(10, 5);
		b1.move();
		assertNotEquals(new Point(300,430), b1.getPosition());
	}
	
	@Test
	void reverseXSpeed() {
		Ball b1 = new RubberBall(new Point(300,430));
		b1.setSpeed(10, 5);
		b1.reverseX();
		assertEquals(-10, b1.getSpeedX());
	}
	
	
	@Test
	void reverseYSpeed() {
		Ball b1 = new RubberBall(new Point(300,430));
		b1.setSpeed(10, 5);
		b1.reverseY();
		assertEquals(-5, b1.getSpeedY());
	}
	
	@Test
	void speed0() {
		Ball b1 = new RubberBall(new Point(300,430));
		b1.setSpeed(0, 0);
		b1.reverseY();
		assertEquals(0, b1.getSpeedY());
	}
	
	
//	@Test
//	void test() {
//		Ball b1 = new RubberBall(new Point(300,430));
//		b1.makeBall(new Point(300,430), 5);
//		assertEquals(b1, b1.getBallFace());
//	}
	
	
	

}
