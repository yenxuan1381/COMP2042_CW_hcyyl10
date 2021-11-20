package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import main.HighScore;

public class ScoreBoard extends JComponent implements MouseListener, MouseMotionListener{
	
	private static final String TITLE = "Leaderboard";
    private static final String RETURN_TEXT = "Return";
	
    private static final Color BG_COLOR = new Color(233, 196, 106);
    private static final Color BORDER_COLOR = new Color(231, 111, 81); 
    private static final Color DASH_BORDER_COLOR = new Color(231, 111, 81);
    private static final Color TEXT_COLOR = new Color(231, 111, 81);
    private static final Color CLICKED_BUTTON_COLOR = BG_COLOR.brighter();
    private static final Color CLICKED_TEXT = BG_COLOR.brighter();
    private static final int BORDER_SIZE = 5;
    private static final float[] DASHES = {12,6};

    private Rectangle boardFace;
    private Rectangle returnButton;

    private BasicStroke borderStoke;
    private BasicStroke borderStoke_noDashes;

    private Font titleFont;
    private Font scoreFont;
    private Font buttonFont;

    private GameFrame owner;

    private boolean returnClicked;
    private String name;


	public ScoreBoard(GameFrame owner,Dimension area){
		
		this.setFocusable(true);
        this.requestFocusInWindow();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.owner = owner;

        boardFace = new Rectangle(new Point(0,0),area);
        this.setPreferredSize(area);

        Dimension btnDim = new Dimension(area.width / 3, area.height / 12);
        returnButton = new Rectangle(btnDim);

        borderStoke = new BasicStroke(BORDER_SIZE,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,0,DASHES,0);
        borderStoke_noDashes = new BasicStroke(BORDER_SIZE,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);

        titleFont = new Font("Noto Mono",Font.BOLD,40);
        scoreFont = new Font("Noto Mono",Font.PLAIN,20);
        buttonFont = new Font("Monospaced",Font.PLAIN,returnButton.height-2);
		
	}
	
	/**
     * Method to paint the Menu
     */
	
	public void paint(Graphics g){
        drawMenu((Graphics2D)g);
    }

    /**
     * Method to draw the menu
     * @param g2d Graphics
     */

    public void drawMenu(Graphics2D g2d){

        drawContainer(g2d);

        /*
        all the following method calls need a relative
        painting directly into the HomeMenu rectangle,
        so the translation is made here so the other methods do not do that.
         */
        Color prevColor = g2d.getColor();
        Font prevFont = g2d.getFont();

        double x = boardFace.getX();
        double y = boardFace.getY();

        g2d.translate(x,y);

        //methods calls
        drawText(g2d);
        //drawButton(g2d);
        //end of methods calls

        g2d.translate(-x,-y);
        g2d.setFont(prevFont);
        g2d.setColor(prevColor);
    }
    
    /**
     * Method to draw the container
     * @param g2d Graphics
     */

    private void drawContainer(Graphics2D g2d){
        Color prev = g2d.getColor();

        g2d.setColor(BG_COLOR);
        g2d.fill(boardFace);

        Stroke tmp = g2d.getStroke();

        g2d.setStroke(borderStoke_noDashes);
        g2d.setColor(DASH_BORDER_COLOR);
        g2d.draw(boardFace);

        g2d.setStroke(borderStoke);
        g2d.setColor(BORDER_COLOR);
        g2d.draw(boardFace);

        g2d.setStroke(tmp);

        g2d.setColor(prev);
    }
    
    /**
     * Method to draw the text
     * @param g2d Graphics
     */
    
    private void drawText(Graphics2D g2d){

        g2d.setColor(TEXT_COLOR);

        FontRenderContext frc = g2d.getFontRenderContext();

        Rectangle2D titleRect = titleFont.getStringBounds(TITLE,frc);
        
        int sX,sY;

        sX = (int)(boardFace.getWidth() - titleRect.getWidth()) / 2;
        sY = (int) (titleRect.getHeight() * 1.1);//add 10% of String height between the two strings

        g2d.setFont(titleFont);
        g2d.drawString(TITLE,sX,sY);
        
        int[] highscores = HighScore.loadScores();
        String scores = "";
        
        int id = 0;
        
        
        for(int score:highscores) {
        	String strScore = Integer.toString(score);
        	String strName = name;
        	String strNum = Integer.toString(id);
        	
        	Rectangle2D numRect = scoreFont.getStringBounds(strNum, frc);
        	Rectangle2D nameRect = scoreFont.getStringBounds(strNum, frc);
        	Rectangle2D scoreRect = scoreFont.getStringBounds(strScore,frc);
        	
        	sX = (int)(boardFace.getWidth() - numRect.getWidth()) / 2;
            sY += (int) numRect.getHeight() * 1.5;
            
            g2d.setFont(scoreFont);
            g2d.drawString(strNum,sX,sY);
            
            sX = (int)(boardFace.getWidth() - nameRect.getWidth()) / 2;
            sY += (int) nameRect.getHeight() * 0.7;

            g2d.setFont(scoreFont);
            g2d.drawString(strName,sX,sY);
            
            sX = (int)(boardFace.getWidth() - scoreRect.getWidth()) / 2;
            sY += (int) scoreRect.getHeight() * 0.7;

            g2d.setFont(scoreFont);
            g2d.drawString(strScore,sX,sY);
        	
        	id++;
        	
        	
        }
        

    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
