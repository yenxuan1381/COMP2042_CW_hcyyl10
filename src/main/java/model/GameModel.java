//package main.java.model;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Point;
//import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import java.util.ArrayList;
//
//import javax.swing.JComponent;
//
//import main.java.controller.BallController;
//import main.java.controller.BrickController;
//import main.java.controller.WallController;
//import main.java.gameWindow.DebugConsole;
//import main.java.gameWindow.HighScore;
//import main.java.view.BallView;
//import main.java.view.BrickView;
//import main.java.view.PlayerView;
//
//public class GameModel{
//	
//	public final static String CONTINUE = "Continue";
//	public final String RESTART = "Restart";
//	public final String EXIT = "Exit";
//	public final static String PAUSE = "Pause Menu";
//	public final int TEXT_SIZE = 30;
//	public final Color MENU_COLOR = new Color(0, 255, 0);
//
//	public static final int DEF_WIDTH = 600;
//	public static final int DEF_HEIGHT = 450;
//
//	public final static Color BG_COLOR = Color.BLACK;
//
//	private WallController wall;
//
//	private String message;
//
//	private boolean showPauseMenu;
//
//	private Font menuFont;
//
//	private String name;
//	private Rectangle continueButtonRect;
//	private Rectangle exitButtonRect;
//	private Rectangle restartButtonRect;
//	
//	private int strLen;
//	private int score;
//	private int record;
//	private int flag = 1;
//	private int stage = 1;
//	private String nameRecord;
////	private Double r;
////	private java.util.List<BallController> balls;
////	private java.util.List<BrickController> bricks;
////	private int speedBoost;
//
////	private DebugConsole debugConsole;
//	private HighScore highscore;
//
//	private BallView ballView;
//	private BrickView brickView;
//	private PlayerView playerView;
//	
//	private int width;
//	private int height;
//
//	
//	public GameModel(WallController wall, int width, int height) {
//		strLen = 0;
//		showPauseMenu = false;
//
//		menuFont = new Font("Monospaced", Font.PLAIN, TEXT_SIZE);
//		
//		message = "";
//		
//		this.wall = wall;
//		this.stage = getWall().getStage();
//		
//		this.width = width;
//		this.height = height;
////		bricks = new ArrayList<BrickController>();
//		
//	}
//	
//	
//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int score) {
//		this.score = score;
//	}
//
//	public BallView getBallView() {
//		return ballView;
//	}
//
//	public BrickView getBrickView() {
//		return brickView;
//	}
//
//	public PlayerView getPlayerView() {
//		return playerView;
//	}
//	
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public boolean isShowPauseMenu() {
//		return showPauseMenu;
//	}
//
//	public void setShowPauseMenu(boolean showPauseMenu) {
//		this.showPauseMenu = showPauseMenu;
//	}
//
//	public WallController getWall() {
//		return wall;
//	}
//
//	public void setWall(WallController wall) {
//		this.wall = wall;
//	}
//
//	public int getFlag() {
//		return flag;
//	}
//
//	public void setFlag(int flag) {
//		this.flag = flag;
//	}
//
//	public int getStage() {
//		return stage;
//	}
//
//	public void setStage(int stage) {
//		this.stage = stage;
//	}
//
//	public HighScore getHighscore() {
//		return highscore;
//	}
//
//	public void setHighscore(HighScore highscore) {
//		this.highscore = highscore;
//	}
//	
//	public int getWidth() {
//		return width;
//	}
//	
//	public int getHeight() {
//		return height;
//	}
//
//	public Rectangle getContinueButtonRect() {
//		return continueButtonRect;
//	}
//
//	public void setContinueButtonRect(Rectangle continueButtonRect) {
//		this.continueButtonRect = continueButtonRect;
//	}
//
//	public Rectangle getExitButtonRect() {
//		return exitButtonRect;
//	}
//
//	public void setExitButtonRect(Rectangle exitButtonRect) {
//		this.exitButtonRect = exitButtonRect;
//	}
//
//	public Rectangle getRestartButtonRect() {
//		return restartButtonRect;
//	}
//
//	public void setRestartButtonRect(Rectangle restartButtonRect) {
//		this.restartButtonRect = restartButtonRect;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getStrLen() {
//		return strLen;
//	}
//
//	public void setStrLen(int strLen) {
//		this.strLen = strLen;
//	}
//
//	public int getRecord() {
//		return record;
//	}
//
//	public void setRecord(int record) {
//		this.record = record;
//	}
//
//	public String getNameRecord() {
//		return nameRecord;
//	}
//
//	public void setNameRecord(String nameRecord) {
//		this.nameRecord = nameRecord;
//	}
//
//	public Font getMenuFont() {
//		return menuFont;
//	}
//
//	public void setMenuFont(Font menuFont) {
//		this.menuFont = menuFont;
//	}
//
//	
//	
//	
//
//}
