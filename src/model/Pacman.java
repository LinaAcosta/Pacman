package model;


public class Pacman{
	public final static int INCREMENT = 10;
	private double radio;
	private double posX;
	private double posY;
	private double wait;
	public final static int UP = 1;
	public final static int DOWN = 2;
	public final static int LEFT = 3;
	public final static int RIGHT = 4;
	private int direction;
	private int rebounds;
	private boolean state;
	public final static boolean STOPPED = false;
	public final static boolean MOVING = true;
	public Pacman(double r, double x, double y, double w, int d, int re, boolean s) {
		radio = r;
		posX = x;
		posY = y;
		wait = w;
		direction = d;
		rebounds = re;
		state = s;
	}
	public double getRadio() {
		return radio;
	}
	public double getPosX() {
		return posX;
	}
	public double getPosY() {
		return posY;
	}
	public double getWait() {
		return wait;
	}
	public int getDirection() {
		return direction;
	}
	public boolean getState() {
		return state;
	}
	public void setState(boolean s) {
		if(s == true) {
			state = true;
		}
		else
			state = false;
	}
	public void setRebounds() {
		rebounds = rebounds++;
	}
	public void move(double width) {
		if(state == MOVING) {
			switch(direction) {
			case RIGHT:
				posX = posX + INCREMENT;
				if(posX >= width) {
					direction = LEFT;
					setRebounds();
				}
					
				break;
			case LEFT:
				posX = posX - INCREMENT;
				if(posX <= 0) {
					direction = RIGHT;
					setRebounds();
				}
				break;
			case UP:
				posY = posY -INCREMENT;
				if(posY <= 0) {
					direction = DOWN;
					setRebounds();
				}
				break;
			case DOWN:
				posY = posY + INCREMENT;
				if(posY>= width) {
					direction = UP;
					setRebounds();
				}
				break;
			}
		}
	}
	public void stopPacman(double x, double y) {
		if(posX - (radio) <= x && (posX >= x) && (posY + (radio) <= y && posY - radio >= y)) {
			setState(false);
		}
	}
	public int getRebounds() {
		return rebounds;
	}
}

