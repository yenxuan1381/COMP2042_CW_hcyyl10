//package main.java.view;
//
//import java.awt.AlphaComposite;
//import java.awt.Color;
//import java.awt.Composite;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
//import java.awt.Toolkit;
//import java.awt.font.FontRenderContext;
//
//import javax.swing.JComponent;
//
//import main.java.controller.BrickController;
//import main.java.controller.WallController;
//import main.java.model.GameModel;
//
//public class GameView extends JComponent{
//	
//	private GameModel gameModel;
//	
//	public GameView(WallController wall, int width, int height) {
//		gameModel = new GameModel(wall, width, height);
//	}
//	
//	/**
//	 * Method to paint the graphics
//	 */
//
//	public void paint(Graphics g) {
//
//		Graphics2D g2d = (Graphics2D) g;
////		ballView = new BallView();
////		brickView = new BrickView();
////		playerView = new PlayerView();
//
//		clear(g2d);
//
//		g2d.setColor(Color.BLUE);
//		g2d.drawString(gameModel.getMessage(), 250, 225);
//		g2d.drawString("Current Score : " + gameModel.getScore(), 30, 110);
//		g2d.drawString("(" + gameModel.getName() + ")", 30, 140);
//		g2d.drawString("High Score : " + gameModel.getRecord(), 460, 110);
//		if (gameModel.getNameRecord() != null) {
//			g2d.drawString("(" + gameModel.getNameRecord() + ")", 460, 140);
//		}
//
//		gameModel.getBallView().drawBall(getWall().getBall(), g2d);
//
//		// for bricks in the wall,
//		for (BrickController b : getWall().getBricks())
//			// if brick is not broken, draw the brick
//			if (!b.isBroken())
//				gameModel.getBrickView().drawBrick(b, g2d);
//
//		gameModel.getPlayerView().drawPlayer(getWall().getPlayer(), g2d);
//
//		if (gameModel.isShowPauseMenu())
//			drawMenu(g2d);
//
//		Toolkit.getDefaultToolkit().sync();
//	}
//
//	/**
//	 * Method to clear the graphics
//	 * 
//	 * @param g2d graphics
//	 */
//
//	private void clear(Graphics2D g2d) {
//		Color tmp = g2d.getColor();
//		g2d.setColor(GameModel.BG_COLOR);
//		g2d.fillRect(0, 0, gameModel.getWidth(), gameModel.getHeight());
//		g2d.setColor(tmp);
//	}
//
//	/**
//	 * Method to draw the menu
//	 * 
//	 * @param g2d Graphics
//	 */
//
//	private void drawMenu(Graphics2D g2d) {
//		obscureGameBoard(g2d);
//		drawPauseMenu(g2d);
//	}
//
//	/**
//	 * Method to draw the game board
//	 * 
//	 * @param g2d Graphics
//	 */
//
//	private void obscureGameBoard(Graphics2D g2d) {
//
//		Composite tmp = g2d.getComposite();
//		Color tmpColor = g2d.getColor();
//
//		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.55f);
//		g2d.setComposite(ac);
//
//		g2d.setColor(Color.BLACK);
//		g2d.fillRect(0, 0, GameModel.DEF_WIDTH, GameModel.DEF_HEIGHT);
//
//		g2d.setComposite(tmp);
//		g2d.setColor(tmpColor);
//	}
//
//	/**
//	 * Method to draw the pause menu
//	 * 
//	 * @param g2d Graphics
//	 */
//
//	private void drawPauseMenu(Graphics2D g2d) {
//		Font tmpFont = g2d.getFont();
//		Color tmpColor = g2d.getColor();
//
//		g2d.setFont(gameModel.getMenuFont());
//		g2d.setColor(gameModel.MENU_COLOR);
//
//		if (gameModel.getStrLen() == 0) {
//			FontRenderContext frc = g2d.getFontRenderContext();
////			strLen = gameModel.getMenuFont().getStringBounds(GameModel.PAUSE, frc).getBounds().width;
//			gameModel.setStrLen(gameModel.getMenuFont().getStringBounds(GameModel.PAUSE, frc).getBounds().width);
//		}
//
//		int x = (gameModel.getWidth() - gameModel.getStrLen()) / 2;
//		int y = gameModel.getHeight() / 10;
//
//		g2d.drawString(GameModel.PAUSE, x, y);
//
//		x = gameModel.getWidth() / 8;
//		y = gameModel.getHeight() / 4;
//
//		if (gameModel.getContinueButtonRect() == null) {
//			FontRenderContext frc = g2d.getFontRenderContext();
////			continueButtonRect = menuFont.getStringBounds(GameModel.CONTINUE, frc).getBounds();
//			gameModel.setContinueButtonRect(gameModel.getMenuFont().getStringBounds(GameModel.CONTINUE, frc).getBounds());
//			gameModel.getContinueButtonRect().setLocation(x, y - gameModel.getContinueButtonRect().height);
//		}
//
//		g2d.drawString(GameModel.CONTINUE, x, y);
//
//		y *= 2;
//
//		if (gameModel.getRestartButtonRect() == null) {
////			restartButtonRect = (Rectangle) continueButtonRect.clone();
//			gameModel.setRestartButtonRect((Rectangle) gameModel.getContinueButtonRect().clone());
//			gameModel.getRestartButtonRect().setLocation(x, y - gameModel.getRestartButtonRect().height);
//		}
//
//		g2d.drawString(gameModel.RESTART, x, y);
//
//		y *= 3.0 / 2;
//
//		if (gameModel.getExitButtonRect() == null) {
////			exitButtonRect = (Rectangle) continueButtonRect.clone();
//			gameModel.setExitButtonRect((Rectangle) gameModel.getContinueButtonRect().clone());
//			gameModel.getExitButtonRect().setLocation(x, y - gameModel.getExitButtonRect().height);
//		}
//
//		g2d.drawString(gameModel.EXIT, x, y);
//
//		g2d.setFont(tmpFont);
//		g2d.setColor(tmpColor);
//	}
//	
//	public WallController getWall() {
//		return gameModel.getWall();
//	}
//
//}
