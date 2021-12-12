package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import org.junit.jupiter.api.Test;

import main.java.controller.BrickController;
import main.java.model.brick.CementBrick;
import main.java.model.crack.Crack;

class CrackTest {
	
	BrickController cementBrick = new CementBrick(new Point(300,430), new Dimension(10,10));
	Crack crack = new Crack(305,445);
	GeneralPath path = new GeneralPath();

	@Test
	void testMakeCrack() {
		crack.makeCrack(new Point(30,20), new Point(30,0));
        assertNotNull(crack);
	}
	
	@Test
	void testDraw() {
		crack.makeCrack(new Point(30,20), new Point(30,0));
		path = crack.draw();
        assertNotNull(path);
	}

}
