package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import main.java.gameObjects.controller.BrickController;
import main.java.gameObjects.model.brick.BrickType;
import main.java.gameObjects.model.brick.CementBrick;
import main.java.gameObjects.model.brick.ClayBrick;
import main.java.gameObjects.model.brick.HealthBrick;
import main.java.gameObjects.model.brick.SpecialBrick;
import main.java.gameObjects.model.brick.SteelBrick;
import main.java.gameObjects.model.brick.VibraniumBrick;
import main.java.gameObjects.model.wall.Level;
import main.java.gameObjects.model.wall.LevelFactory;

class LevelTest {
	
	
	Level level = new Level();
	BrickController cementBrick = new CementBrick(new Point(300,430), new Dimension(10,10));
	BrickController clayBrick = new ClayBrick(new Point(300,430), new Dimension(10,10));
	BrickController steelBrick = new SteelBrick(new Point(300,430), new Dimension(10,10));
	BrickController vibraniumBrick = new VibraniumBrick(new Point(300,430), new Dimension(10,10));
	BrickController specialBrick = new SpecialBrick(new Point(300,430), new Dimension(10,10));
	BrickController healthBrick = new HealthBrick(new Point(300,430), new Dimension(10,10));

	@Test
	void testFactory() {
		LevelFactory levelFac = new LevelFactory();
		BrickController [][] levels = levelFac.makeLevels(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2);
		assertNotNull(levels);
	}
	
	@Test
	void testSingleTypeLevel() {
		BrickController[] levelDemo = new BrickController[31];
		levelDemo = level.makeSingleTypeLevel(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, BrickType.CEMENT);
		assertNotNull(levelDemo);
	}
	
	@Test
	void testChessboardTypeLevel() {
		BrickController[] levelDemo = new BrickController[31];
		levelDemo = level.makeChessboardLevel(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, BrickType.CEMENT, BrickType.CLAY);
		assertNotNull(levelDemo);
	}
	
	@Test
	void testCementBrickType() {
		BrickController[] cementDemo = new BrickController[31];
		cementDemo = level.makeSingleTypeLevel(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, BrickType.CEMENT);
		
		int i = 0;
		// ignores health brick and special brick
		while(cementDemo[i].getClass().equals(specialBrick.getClass()) || cementDemo[i].getClass().equals(healthBrick.getClass()) ) {
			i++;
		}
		assertEquals(cementDemo[i].getClass(), cementBrick.getClass());	
	}
	
	@Test
	void testSteelBrickType() {

		BrickController[] steelDemo = new BrickController[31];
		steelDemo = level.makeSingleTypeLevel(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, BrickType.STEEL);
		
		int i = 0;
		while(steelDemo[i].getClass().equals(specialBrick.getClass()) || steelDemo[i].getClass().equals(healthBrick.getClass()) ) {
			i++;
		}
		assertEquals(steelDemo[i].getClass(), steelBrick.getClass());
	}
	
	@Test
	void testVibraniumBrickType() {
		BrickController[] vibraniumDemo = new BrickController[31];
		vibraniumDemo = level.makeSingleTypeLevel(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, BrickType.VIBRANIUM);
		
		int i = 0;
		while(vibraniumDemo[i].getClass().equals(specialBrick.getClass()) || vibraniumDemo[i].getClass().equals(healthBrick.getClass()) ) {
			i++;
		}
		assertEquals(vibraniumDemo[i].getClass(), vibraniumBrick.getClass());
	}
	
	@Test
	void testClayBrickType() {
		BrickController[] clayDemo = new BrickController[31];
		clayDemo = level.makeSingleTypeLevel(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, BrickType.CLAY);
		
		int i = 0;
		while(clayDemo[i].getClass().equals(specialBrick.getClass()) || clayDemo[i].getClass().equals(healthBrick.getClass()) ) {
			i++;
		}
		
		assertEquals(clayDemo[i].getClass(), clayBrick.getClass());
	}

}
