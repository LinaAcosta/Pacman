package model;

import java.io.Serializable;

public class Score implements Serializable{
	private Player player;
	private int value;
	public Score(Player p, int v) {
		player = p;
		value = v;
	}
	public Player getPlayer() {
		return player;
	}
	public int getValue() {
		return value;
	}
}
