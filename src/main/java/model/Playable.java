package main.java.model;

import java.awt.Point;

public interface Playable {
	public void move();
	public void move(int m);
	public void moveLeft();
	public void moveRight();
	public void stop();
	public void moveTo(Point p);
}
