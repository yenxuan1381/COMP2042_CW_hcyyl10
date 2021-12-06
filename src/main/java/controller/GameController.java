//package main.java.controller;
//
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Point;
//import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import java.awt.geom.Point2D;
//import java.util.ArrayList;
//import java.util.Random;
//
//import javax.swing.JComponent;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//
//import main.java.gameWindow.DebugConsole;
//import main.java.gameWindow.HighScore;
//import main.java.model.GameModel;
//import main.java.model.ball.RubberBall;
//import main.java.model.brick.SpecialBrick;
//import main.java.view.GameView;
//
//public class GameController extends JComponent implements KeyListener, MouseListener, MouseMotionListener {
//
////	private static final String CONTINUE = "Continue";
////	private static final String RESTART = "Restart";
////	private static final String EXIT = "Exit";
////	private static final String PAUSE = "Pause Menu";
////	private static final int TEXT_SIZE = 30;
////	private static final Color MENU_COLOR = new Color(0, 255, 0);
////
////	private static final int DEF_WIDTH = 600;
////	private static final int DEF_HEIGHT = 450;
////
////	private static final Color BG_COLOR = Color.BLACK;
//
//	private javax.swing.Timer gameTimer;
//
////	private WallController wall;
//
////	private String message;
//
////	private boolean showPauseMenu;
//
////	private Font menuFont;
//
////	private String name;
////	private Rectangle continueButtonRect;
////	private Rectangle exitButtonRect;
////	private Rectangle restartButtonRect;
////	private int strLen;
////	private int score;
////	private int record;
////	private int flag = 1;
////	private int stage = 1;
////	private String nameRecord;
//	private Double r;
//	private java.util.List<BallController> balls;
//	private java.util.List<BrickController> bricks;
//	private int speedBoost;
//
//	private DebugConsole debugConsole;
//	private HighScore highscore;
//	
//	private GameView gameView;
//	private GameModel gameModel;
//	
//	public GameController(JFrame owner) {
//		super();
//		
////		gameView = new GameView();
////		gameModel = new GameModel();
//		
//		
////		nameInput();
//
////		strLen = 0;
////		showPauseMenu = false;
////
////		menuFont = new Font("Monospaced", Font.PLAIN, TEXT_SIZE);
//
//		this.initialize();
////		message = "";
//		WallController wall = new WallController(new Rectangle(0, 0, GameModel.DEF_WIDTH, GameModel.DEF_HEIGHT), 30, 3, 6 / 2, new Point(300, 430));
//		
//		gameModel = new GameModel(wall, getWidth(), getHeight());
//		gameView = new GameView(wall, getWidth(), getHeight());
//		
//		nameInput();
////		gameModel.setWall(wall);
//
//		debugConsole = new DebugConsole(owner, wall, this);
//
//		// initialize the first level
//		getWall().nextLevel();
////		gameModel = new GameModel();
////		this.stage = getWall().getStage(); ////////////////game model should be created here after next level
//
//		bricks = new ArrayList<BrickController>();
//
//		gameTimer = new javax.swing.Timer(10, e -> {
//
//			if (getFlag() == 1) {
////				score = 0;
//				gameModel.setScore(0);
//				getWall().setScore(0);
//				HighScore highscore = new HighScore(getStage());
////				this.highscore = highscore;
//				gameModel.setHighscore(highscore);
////				highscore.readFile();
//				gameModel.getHighscore().readFile();
////				record = Integer.parseInt(highscore.getHighscore());
//				gameModel.setRecord(Integer.parseInt(highscore.getHighscore()));
////				nameRecord = highscore.getUsername();
//				gameModel.setNameRecord(highscore.getUsername());
////				flag = 0;
//				gameModel.setFlag(0);
//
//			}
//
//			getWall().move();
//			getWall().findImpacts();
//			
//			gameModel.setScore(getWall().getScore());
////			this.score = getWall().getScore();
//			String msg = String.format("Bricks: %d %nBalls %d", getWall().getBrickCount(), getWall().getBallCount());
//			gameModel.setMessage(msg);
//
//			for (BrickController br : getWall().getBricks()) {
//
//				// If a new special brick is broken, unlock cheat mode
//				if (br.getClass() == SpecialBrick.class && br.isBroken()) {
//					if (!bricks.contains(br)) {
//						bricks.add(br);
//						Random rand = new Random();
//						r = rand.nextDouble();
//
//						if (r < 0.7)
//							oddBounce();
//
//						else
//							superSpeedBall();
//
//					}
//				}
//			}
//
//			if (getWall().isBallLost()) {
//				if (getWall().ballEnd()) {
//					getWall().wallReset();
////					message = "Game over";
//					gameModel.setMessage("Game over");
//				}
//				getWall().ballReset();
//				gameTimer.stop();
//			} else if (getWall().isDone()) {
////				this.score += getWall().getBallCount() * 100;
//				gameModel.setScore(gameModel.getScore() + getWall().getBallCount() * 100);
//
//				if (getWall().hasLevel()) {
////					message = "Go to Next Level";
//					gameModel.setMessage("Go to Next Level");
//							
//					gameTimer.stop();
//
//					getWall().ballReset();
//					getWall().wallReset();
//					getWall().nextLevel();
//
//				} else {
////					message = "ALL WALLS DESTROYED";
//					gameModel.setMessage("ALL WALLS DESTROYED");
//					gameTimer.stop();
//				}
//			}
//
//			if (gameModel.getScore() > gameModel.getRecord()) {
////				record = score;
//				gameModel.setRecord(gameModel.getScore());
////				nameRecord = name;
//				gameModel.setNameRecord(gameModel.getName());
//				highscore.writeFile(Integer.toString(gameModel.getRecord()) + gameModel.getNameRecord());
//			}
//
//			if (getStage() != getWall().getStage()) {
////				flag = 1;
//				gameModel.setFlag(1);
////				this.stage = getWall().getStage();
//				gameModel.setStage(getWall().getStage());
//			}
//			gameView.repaint();
//		});
//	}
//	
//	private WallController getWall() {
//		return gameModel.getWall();
//	}
//	
//	private int getStage() {
//		return gameModel.getStage();
//	}
//	
//	private int getFlag() {
//		return gameModel.getFlag();
//	}
//
//	/**
//	 * Method to initialize the variables
//	 */
//
//	private void initialize() {
//		this.setPreferredSize(new Dimension(GameModel.DEF_WIDTH, GameModel.DEF_HEIGHT));
//		this.setFocusable(true);
//		this.requestFocusInWindow();
//		this.addKeyListener(this);
//		this.addMouseListener(this);
//		this.addMouseMotionListener(this);
//	}
//	
//	/**
//	 * Method to apply speed boost to the ball
//	 */
//	private void superSpeedBall() {
//
//		speedBoost = 2;
//
//		int speedX = getWall().getBall().getSpeedX();
//		int speedY = getWall().getBall().getSpeedY();
//
//		if (speedX > 0) {
//			speedX += speedBoost;
//		} else {
//			speedX -= speedBoost;
//		}
//
//		speedY += speedBoost;
//
//		getWall().getBall().setSpeed(speedX, speedY);
//		getWall().getPlayer().move(speedBoost);
//	}
//
//	/**
//	 * Method to prompt user to input his/her username
//	 */
//
//	public void nameInput() {
//		String name = JOptionPane.showInputDialog(this, "ENTER YOUR USERNAME:");
////		this.name = name;
//		gameModel.setName(name);
//	}
//
//	/**
//	 * Method to allow the ball to bounce oddly
//	 */
//	private void oddBounce() {
//
//		balls = new ArrayList<>();
//
//		Point2D p = getWall().getBall().getPosition();
//
//		balls.add(getWall().getBall());
//
//		Random rnd = new Random();
//
//		BallController ballA = new RubberBall(p);
//		BallController ballB = new RubberBall(p);
//
//		balls.add(ballA);
//		balls.add(ballB);
//
//		for (BallController b : balls) {
//
//			b.makeBall(p, 10);
//
//			int speedX, speedY;
//			do {
//				speedX = rnd.nextInt(7) - 3;
//			} while (speedX == 0);
//			do {
//				speedY = -rnd.nextInt(5);
//			} while (speedY == 0);
//
//			b.setSpeed(speedX, speedY);
//
//			b.move();
//			getWall().findImpacts();
//		}
//
//	}
//	
//	@Override
//	public void keyTyped(KeyEvent keyEvent) {
//	}
//
//	@Override
//	public void keyPressed(KeyEvent keyEvent) {
//		switch (keyEvent.getKeyCode()) {
//		case KeyEvent.VK_A:
//			getWall().getPlayer().moveLeft();
//			break;
//		case KeyEvent.VK_D:
//			getWall().getPlayer().moveRight();
//			break;
//		case KeyEvent.VK_ESCAPE:
////			showPauseMenu = !showPauseMenu;
//			gameModel.setShowPauseMenu(!gameModel.isShowPauseMenu());
//			gameView.repaint();
//			gameTimer.stop();
//			break;
//		case KeyEvent.VK_SPACE:
//			if (!gameModel.isShowPauseMenu())
//				if (gameTimer.isRunning())
//					gameTimer.stop();
//				else
//					gameTimer.start();
//			break;
//		case KeyEvent.VK_F1:
//			if (keyEvent.isAltDown() && keyEvent.isShiftDown())
//				debugConsole.setVisible(true);
//		default:
//			getWall().getPlayer().stop();
//		}
//	}
//
//	@Override
//	public void keyReleased(KeyEvent keyEvent) {
//		getWall().getPlayer().stop();
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent mouseEvent) {
//		Point p = mouseEvent.getPoint();
//		if (!gameModel.isShowPauseMenu())
//			return;
//		if (gameModel.getContinueButtonRect().contains(p)) {
////			showPauseMenu = false;
//			gameModel.setShowPauseMenu(false);
//			gameView.repaint();
//		} else if (gameModel.getRestartButtonRect().contains(p)) {
////			message = "Restarting Game...";
//			gameModel.setMessage("Restarting Game...");
//			getWall().ballReset();
//			getWall().wallReset();
//			getWall().setScore(0);
////			score = 0;
//			gameModel.setScore(0);
////			showPauseMenu = false;
//			gameModel.setShowPauseMenu(false);
//			gameView.repaint();
//		} else if (gameModel.getExitButtonRect().contains(p)) {
//			System.exit(0);
//		}
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent mouseEvent) {
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent mouseEvent) {
//
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent mouseEvent) {
//
//	}
//
//	@Override
//	public void mouseExited(MouseEvent mouseEvent) {
//
//	}
//
//	@Override
//	public void mouseDragged(MouseEvent mouseEvent) {
//
//	}
//
//	@Override
//	public void mouseMoved(MouseEvent mouseEvent) {
//		Point p = mouseEvent.getPoint();
//		if (gameModel.getExitButtonRect() != null && gameModel.isShowPauseMenu()) {
//			if (gameModel.getExitButtonRect().contains(p) || gameModel.getContinueButtonRect().contains(p) || gameModel.getRestartButtonRect().contains(p))
//				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			else
//				setCursor(Cursor.getDefaultCursor());
//		} else {
//			setCursor(Cursor.getDefaultCursor());
//		}
//	}
//
//	/**
//	 * Method to pause the game when focus is lost
//	 */
//
//	public void onLostFocus() {
//		gameTimer.stop();
////		message = "Focus Lost";
//		gameModel.setMessage("Focus Lost");
//		repaint();
//	}
//}
