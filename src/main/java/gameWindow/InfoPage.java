package main.java.gameWindow;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
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

/**
 * Object of this class creates the info page gui using java swing
 * 
 * @author Emily
 *
 */

public class InfoPage extends JComponent implements MouseListener, MouseMotionListener {

	private static final String TITLE = "Brick Breaker";
	private static final String RETURN_TEXT = "Return";
	private static final String DESCRIPTION = "A simple ball shooter game";
	private static final String PARAGRAPH1 = "Press A to move the paddle to the left";
	private static final String PARAGRAPH2 = "Press D to move the paddle to the right";
	private static final String PARAGRAPH3 = "Press Esc to pause the game";
	private static final String PARAGRAPH4 = "Press Spacebar to start the game!";

	private static final Color BG_COLOR = new Color(233, 196, 106);
	private static final Color BORDER_COLOR = new Color(231, 111, 81);
	private static final Color DASH_BORDER_COLOR = new Color(231, 111, 81);
	private static final Color TEXT_COLOR = new Color(231, 111, 81);
	private static final Color CLICKED_BUTTON_COLOR = BG_COLOR.brighter();
	private static final Color CLICKED_TEXT = BG_COLOR.brighter();
	private static final int BORDER_SIZE = 5;
	private static final float[] DASHES = { 12, 6 };

	private Rectangle menuFace;
	private Rectangle returnButton;

	private BasicStroke borderStoke;
	private BasicStroke borderStoke_noDashes;

	private Font titleFont;
	private Font paragraphFont;
	private Font descriptionFont;
	private Font buttonFont;

	private GameFrame owner;

	private boolean returnClicked;

	/**
	 * Constructor to create the info page
	 * 
	 * @param owner The GameFrame owner
	 * @param area  The area of the info page
	 */
	
	public InfoPage(GameFrame owner, Dimension area) {

		this.setFocusable(true);
		this.requestFocusInWindow();

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.owner = owner;

		menuFace = new Rectangle(new Point(0, 0), area);
		this.setPreferredSize(area);

		Dimension btnDim = new Dimension(area.width / 3, area.height / 12);
		returnButton = new Rectangle(btnDim);

		borderStoke = new BasicStroke(BORDER_SIZE, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, DASHES, 0);
		borderStoke_noDashes = new BasicStroke(BORDER_SIZE, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		titleFont = new Font("Noto Mono", Font.BOLD, 40);
		descriptionFont = new Font("Monospaced", Font.PLAIN, 10);
		paragraphFont = new Font("Noto Mono", Font.PLAIN, 20);
		buttonFont = new Font("Monospaced", Font.PLAIN, returnButton.height - 2);
	}

	/**
	 * Method to paint the info page
	 */

	public void paint(Graphics g) {
		drawMenu((Graphics2D) g);
	}

	/**
	 * Method to draw the info page
	 * 
	 * @param g2d Graphics2D
	 */

	public void drawMenu(Graphics2D g2d) {

		drawContainer(g2d);

		Color prevColor = g2d.getColor();
		Font prevFont = g2d.getFont();

		double x = menuFace.getX();
		double y = menuFace.getY();

		g2d.translate(x, y);

		drawText(g2d);
		drawButton(g2d);

		g2d.translate(-x, -y);
		g2d.setFont(prevFont);
		g2d.setColor(prevColor);
	}

	/**
	 * Method to draw a container
	 * 
	 * @param g2d Graphics2D
	 */

	private void drawContainer(Graphics2D g2d) {
		Color prev = g2d.getColor();

		g2d.setColor(BG_COLOR);
		g2d.fill(menuFace);

		Stroke tmp = g2d.getStroke();

		g2d.setStroke(borderStoke_noDashes);
		g2d.setColor(DASH_BORDER_COLOR);
		g2d.draw(menuFace);

		g2d.setStroke(borderStoke);
		g2d.setColor(BORDER_COLOR);
		g2d.draw(menuFace);

		g2d.setStroke(tmp);

		g2d.setColor(prev);
	}

	/**
	 * Method to draw the text
	 * 
	 * @param g2d Graphics2D
	 */

	private void drawText(Graphics2D g2d) {

		g2d.setColor(TEXT_COLOR);

		FontRenderContext frc = g2d.getFontRenderContext();

		Rectangle2D titleRect = titleFont.getStringBounds(TITLE, frc);
		Rectangle2D descriptionRect = descriptionFont.getStringBounds(DESCRIPTION, frc);
		Rectangle2D paragraphRect1 = paragraphFont.getStringBounds(PARAGRAPH1, frc);
		Rectangle2D paragraphRect2 = paragraphFont.getStringBounds(PARAGRAPH2, frc);
		Rectangle2D paragraphRect3 = paragraphFont.getStringBounds(PARAGRAPH3, frc);
		Rectangle2D paragraphRect4 = paragraphFont.getStringBounds(PARAGRAPH4, frc);

		int sX, sY;

		sX = (int) (menuFace.getWidth() - titleRect.getWidth()) / 2;
		sY = (int) (titleRect.getHeight() * 1.1);// add 10% of String height between the two strings

		g2d.setFont(titleFont);
		g2d.drawString(TITLE, sX, sY);

		sX = (int) (menuFace.getWidth() - descriptionRect.getWidth()) / 2;
		sY += (int) descriptionRect.getHeight() * 1.1;// add 10% of String height between the two strings

		g2d.setFont(descriptionFont);
		g2d.drawString(DESCRIPTION, sX, sY);

		sX = (int) (menuFace.getWidth() - paragraphRect1.getWidth()) / 2;
		sY += (int) paragraphRect1.getHeight() * 1.6;

		g2d.setFont(paragraphFont);
		g2d.drawString(PARAGRAPH1, sX, sY);

		sX = (int) (menuFace.getWidth() - paragraphRect2.getWidth()) / 2;
		sY += (int) paragraphRect2.getHeight() * 1.1;

		g2d.drawString(PARAGRAPH2, sX, sY);

		sX = (int) (menuFace.getWidth() - paragraphRect3.getWidth()) / 2;
		sY += (int) paragraphRect3.getHeight() * 1.1;

		g2d.drawString(PARAGRAPH3, sX, sY);

		sX = (int) (menuFace.getWidth() - paragraphRect4.getWidth()) / 2;
		sY += (int) paragraphRect4.getHeight() * 1.1;

		g2d.drawString(PARAGRAPH4, sX, sY);

	}

	/**
	 * Method to draw a button
	 * 
	 * @param g2d Graphics2D
	 */

	private void drawButton(Graphics2D g2d) {

		FontRenderContext frc = g2d.getFontRenderContext();

		Rectangle2D txtRect = buttonFont.getStringBounds(RETURN_TEXT, frc);

		g2d.setFont(buttonFont);

		int x = (menuFace.width - returnButton.width) / 2;
		int y = (int) ((menuFace.height - returnButton.height) * 0.85);

		returnButton.setLocation(x, y);

		x = (int) (returnButton.getWidth() - txtRect.getWidth()) / 2;
		y = (int) (returnButton.getHeight() - txtRect.getHeight()) / 2;

		x += returnButton.x;
		y += returnButton.y + (returnButton.height * 0.9);

		if (returnClicked) {
			Color tmp = g2d.getColor();
			g2d.setColor(CLICKED_BUTTON_COLOR);
			g2d.draw(returnButton);
			g2d.setColor(CLICKED_TEXT);
			g2d.drawString(RETURN_TEXT, x, y);
			g2d.setColor(tmp);
		} else {
			g2d.draw(returnButton);
			g2d.drawString(RETURN_TEXT, x, y);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		Point p = mouseEvent.getPoint();
		if (returnButton.contains(p))
			this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		else
			this.setCursor(Cursor.getDefaultCursor());
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		Point p = mouseEvent.getPoint();
		if (returnButton.contains(p)) {
			owner.enableHomeMenu();
		}
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		Point p = mouseEvent.getPoint();
		if (returnButton.contains(p)) {
			returnClicked = true;
			repaint(returnButton.x, returnButton.y, returnButton.width + 1, returnButton.height + 1);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (returnClicked) {
			returnClicked = false;
			repaint(returnButton.x, returnButton.y, returnButton.width + 1, returnButton.height + 1);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
