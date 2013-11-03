package jjw123.GameCraft.chess;

public class Tile {
	
	private int x, y;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y;
	}
}
