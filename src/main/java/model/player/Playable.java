package main.java.model.player;

import java.awt.*;

public interface Playable {
	public void move();

	public void move(int m);

	public void moveLeft();

	public void moveRight();

	public void stop();

	public void moveTo(Point p);

}
