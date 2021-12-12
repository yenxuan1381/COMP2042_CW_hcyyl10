/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main.java.gameWindow;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.java.gameObjects.controller.BallController;
import main.java.gameObjects.controller.BrickController;
import main.java.gameObjects.controller.WallController;
import main.java.gameObjects.model.ball.BallFactory;
import main.java.gameObjects.model.brick.HealthBrick;
import main.java.gameObjects.model.brick.SpecialBrick;
import main.java.gameObjects.view.BallView;
import main.java.gameObjects.view.BrickView;
import main.java.gameObjects.view.PlayerView;

/**
 * Objects of this class extend JComponenet and implements KeyListener,
 * MouseListener and MouseMotionListener methods
 * 
 * @author Emily
 *
 */

public class GameBoard extends JComponent implements KeyListener, MouseListener, MouseMotionListener {

	private static final String CONTINUE = "Continue";
	private static final String RESTART = "Restart";
	private static final String EXIT = "Exit";
	private static final String PAUSE = "Pause Menu";
	private static final int TEXT_SIZE = 30;
	private static final Color MENU_COLOR = new Color(0, 255, 0);

	private static final int DEF_WIDTH = 600;
	private static final int DEF_HEIGHT = 450;

	private static final Color BG_COLOR = Color.BLACK;

	private javax.swing.Timer gameTimer;

	private WallController wall;

	private String message;

	private boolean showPauseMenu;

	private Font menuFont;

	private String name;
	private Rectangle continueButtonRect;
	private Rectangle exitButtonRect;
	private Rectangle restartButtonRect;
	private int strLen;
	private int score;
	private int record;
	private int flag = 1;
	private int stage = 1;
	private String nameRecord;
	private Double r;
	private java.util.List<BallController> balls;
	private java.util.List<BrickController> bricks;
	private BallFactory ballFac;
	private int speedBoost;

	private DebugConsole debugConsole;
	private HighScore highscore;

	
	/**
	 * Constructor to create the game board
	 * 
	 * @param owner JFrame owner
	 */

	public GameBoard(JFrame owner) {
		super();
		nameInput();

		strLen = 0;
		showPauseMenu = false;

		menuFont = new Font("Monospaced", Font.PLAIN, TEXT_SIZE);

		this.initialize();
		message = "";
		wall = new WallController(new Rectangle(0, 0, DEF_WIDTH, DEF_HEIGHT), 30, 3, 6 / 2, new Point(300, 430));

		debugConsole = new DebugConsole(owner, wall, this);

		// initialize the first level
		wall.nextLevel();
		this.stage = wall.getStage();

		bricks = new ArrayList<BrickController>();
		ballFac = new BallFactory();

		gameTimer = new javax.swing.Timer(10, e -> {

			if (flag == 1) {
				score = 0;
				wall.setScore(0);
				HighScore highscore = new HighScore(stage);
				this.highscore = highscore;
				highscore.readFile();
				record = Integer.parseInt(highscore.getHighscore());
				nameRecord = highscore.getUsername();
				flag = 0;

			}

			wall.move();
			wall.findImpacts();
			this.score = wall.getScore();
			message = String.format("Bricks: %d %nBalls %d", wall.getBrickCount(), wall.getBallCount());

			for (BrickController br : wall.getBricks()) {

				// If a new special brick is broken, unlock cheat mode
				if (br.getClass() == SpecialBrick.class && br.isBroken()) {
					if (!bricks.contains(br)) {
						bricks.add(br);
						Random rand = new Random();
						r = rand.nextDouble();

						if (r < 0.7)
							oddBounce();

						else
							superSpeedBall();

					}
				}
				
				// If a new health brick is broken, increase life
				if (br.getClass() == HealthBrick.class && br.isBroken()) {
					if (!bricks.contains(br)) {
						bricks.add(br);
						wall.setBallCount(wall.getBallCount() + 1);

					}
				}
			}

			if (wall.isBallLost()) {
				if (wall.ballEnd()) {
					wall.wallReset();
					message = "Game over";
				}
				wall.ballReset();
				gameTimer.stop();
			} else if (wall.isDone()) {
				this.score += wall.getBallCount() * 100;

				if (wall.hasLevel()) {
					message = "Go to Next Level";
					gameTimer.stop();

					wall.ballReset();
					wall.wallReset();
					wall.nextLevel();

				} else {
					message = "ALL WALLS DESTROYED";
					gameTimer.stop();
				}
			}

			if (score > record) {
				record = score;
				nameRecord = name;
				highscore.writeFile(Integer.toString(record) + nameRecord);
			}

			if (this.stage != wall.getStage()) {
				flag = 1;
				this.stage = wall.getStage();
			}
			repaint();
		});

	}

	/**
	 * Method to apply speed boost to the ball
	 */
	private void superSpeedBall() {

		speedBoost = 2;

		int speedX = wall.getBall().getSpeedX();
		int speedY = wall.getBall().getSpeedY();

		if (speedX > 0) {
			speedX += speedBoost;
		} else {
			speedX -= speedBoost;
		}

		speedY += speedBoost;

		wall.getBall().setSpeed(speedX, speedY);
		wall.getPlayer().move(speedBoost);
	}

	/**
	 * Method to prompt user to input his/her username
	 */

	public void nameInput() {
		String name = JOptionPane.showInputDialog(this, "ENTER YOUR USERNAME:");
		this.name = name;
	}

	/**
	 * Method to allow the ball to bounce oddly
	 */
	private void oddBounce() {

		balls = new ArrayList<>();

		Point2D p = wall.getBall().getPosition();

		balls.add(wall.getBall());

		Random rnd = new Random();

		BallController ballA = ballFac.makeBallType("RUBBER", p);
		BallController ballB = ballFac.makeBallType("RUBBER", p);

		balls.add(ballA);
		balls.add(ballB);

		for (BallController b : balls) {

			b.makeBall(p, 10);

			int speedX, speedY;
			do {
				speedX = rnd.nextInt(7) - 3;
			} while (speedX == 0);
			do {
				speedY = -rnd.nextInt(5);
			} while (speedY == 0);

			b.setSpeed(speedX, speedY);

			b.move();
			wall.findImpacts();
		}

	}

	/**
	 * Method to initialize the variables
	 */

	private void initialize() {
		this.setPreferredSize(new Dimension(DEF_WIDTH, DEF_HEIGHT));
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	/**
	 * Method to paint the graphics
	 */

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		clear(g2d);

		g2d.setColor(Color.WHITE);
		g2d.drawString(message, 250, 225);
		g2d.drawString("Current Score : " + score, 30, 110);
		g2d.drawString("(" + name + ")", 30, 140);
		g2d.drawString("High Score : " + record, 460, 110);
		if (nameRecord != null) {
			g2d.drawString("(" + nameRecord + ")", 460, 140);
		}

		wall.getBall().updateView(wall.getBall(), g2d);

		// for bricks in the wall,
		for (BrickController b : wall.getBricks())
			// if brick is not broken, draw the brick
			if (!b.isBroken())
				b.updateView(b, g2d);

		wall.getPlayer().updateView(wall.getPlayer(), g2d);

		if (showPauseMenu)
			drawMenu(g2d);

		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Method to clear the graphics
	 * 
	 * @param g2d graphics
	 */

	private void clear(Graphics2D g2d) {
		Color tmp = g2d.getColor();
		g2d.setColor(BG_COLOR);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(tmp);
	}

	/**
	 * Method to draw the menu
	 * 
	 * @param g2d Graphics
	 */

	private void drawMenu(Graphics2D g2d) {
		obscureGameBoard(g2d);
		drawPauseMenu(g2d);
	}

	/**
	 * Method to draw the game board
	 * 
	 * @param g2d Graphics
	 */

	private void obscureGameBoard(Graphics2D g2d) {

		Composite tmp = g2d.getComposite();
		Color tmpColor = g2d.getColor();

		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.55f);
		g2d.setComposite(ac);

		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, DEF_WIDTH, DEF_HEIGHT);

		g2d.setComposite(tmp);
		g2d.setColor(tmpColor);
	}

	/**
	 * Method to draw the pause menu
	 * 
	 * @param g2d Graphics
	 */

	private void drawPauseMenu(Graphics2D g2d) {
		Font tmpFont = g2d.getFont();
		Color tmpColor = g2d.getColor();

		g2d.setFont(menuFont);
		g2d.setColor(MENU_COLOR);

		if (strLen == 0) {
			FontRenderContext frc = g2d.getFontRenderContext();
			strLen = menuFont.getStringBounds(PAUSE, frc).getBounds().width;
		}

		int x = (this.getWidth() - strLen) / 2;
		int y = this.getHeight() / 10;

		g2d.drawString(PAUSE, x, y);

		x = this.getWidth() / 8;
		y = this.getHeight() / 4;

		if (continueButtonRect == null) {
			FontRenderContext frc = g2d.getFontRenderContext();
			continueButtonRect = menuFont.getStringBounds(CONTINUE, frc).getBounds();
			continueButtonRect.setLocation(x, y - continueButtonRect.height);
		}

		g2d.drawString(CONTINUE, x, y);

		y *= 2;

		if (restartButtonRect == null) {
			restartButtonRect = (Rectangle) continueButtonRect.clone();
			restartButtonRect.setLocation(x, y - restartButtonRect.height);
		}

		g2d.drawString(RESTART, x, y);

		y *= 3.0 / 2;

		if (exitButtonRect == null) {
			exitButtonRect = (Rectangle) continueButtonRect.clone();
			exitButtonRect.setLocation(x, y - exitButtonRect.height);
		}

		g2d.drawString(EXIT, x, y);

		g2d.setFont(tmpFont);
		g2d.setColor(tmpColor);
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
		case KeyEvent.VK_A:
			wall.getPlayer().moveLeft();
			break;
		case KeyEvent.VK_D:
			wall.getPlayer().moveRight();
			break;
		case KeyEvent.VK_ESCAPE:
			showPauseMenu = !showPauseMenu;
			repaint();
			gameTimer.stop();
			break;
		case KeyEvent.VK_SPACE:
			if (!showPauseMenu)
				if (gameTimer.isRunning())
					gameTimer.stop();
				else
					gameTimer.start();
			break;
		case KeyEvent.VK_F1:
			if (keyEvent.isAltDown() && keyEvent.isShiftDown())
				debugConsole.setVisible(true);
		default:
			wall.getPlayer().stop();
		}
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		wall.getPlayer().stop();
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		Point p = mouseEvent.getPoint();
		if (!showPauseMenu)
			return;
		if (continueButtonRect.contains(p)) {
			showPauseMenu = false;
			repaint();
		} else if (restartButtonRect.contains(p)) {
			message = "Restarting Game...";
			wall.ballReset();
			wall.wallReset();
			wall.setScore(0);
			score = 0;
			showPauseMenu = false;
			repaint();
		} else if (exitButtonRect.contains(p)) {
			System.exit(0);
		}

	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		Point p = mouseEvent.getPoint();
		if (exitButtonRect != null && showPauseMenu) {
			if (exitButtonRect.contains(p) || continueButtonRect.contains(p) || restartButtonRect.contains(p))
				this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			else
				this.setCursor(Cursor.getDefaultCursor());
		} else {
			this.setCursor(Cursor.getDefaultCursor());
		}
	}

	/**
	 * Method to pause the game when focus is lost
	 */

	public void onLostFocus() {
		gameTimer.stop();
		message = "Focus Lost";
		repaint();
	}

}