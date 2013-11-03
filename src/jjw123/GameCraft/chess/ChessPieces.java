package jjw123.GameCraft.chess;

import java.util.ArrayList;

public class ChessPieces {
	
	public enum ChessPiece {
		KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN;
	}
	
	public static Tile[] getPossibleMoves(ChessPiece piece, Tile currentTIle, boolean white, boolean first) {
		
		ArrayList<Tile> moves = new ArrayList<Tile>();
		
		
		int curX = currentTIle.getX();
		int curY = currentTIle.getY();
		
		switch(piece) {
		case KING :
			for(int  i = -1; i < 2; i++) {
				for(int  j = -1; j < 2; j++) {
					if(curX + i >= 0 && curX + i <= 7 && curY + j >= 0 && curY + j <= 7 && !(j == 0 && i == 0)) {
						moves.add(new Tile(curX + i, curY + j));
					}
				}
			}
			break;
		case QUEEN:
			for(int i = 0; i < 8; i++) {
				if(i != curY) {
					moves.add(new Tile(curX, i));
				}
				if(i != curX) {
					moves.add(new Tile(i, curY));
				}
			}
			
			for(int i = -7; i < 8; i++) {
				if(!(curX + i > 7 || curX  + i < 0 || curY + i > 7 || curY + i < 0 || i == 0)) {
					moves.add(new Tile(curX + i, curY + i));
				}
				if(!(curX + i > 7 || curX + i < 0 || curY - i > 7 || curY - i < 0 || i == 0)) {
					moves.add(new Tile(curX + i, curY - i));
				}
			}
			
			break;
		case ROOK:
			for(int i = 0; i < 8; i++) {
				if(i != curY) {
					moves.add(new Tile(curX, i));
				}
				if(i != curX) {
					moves.add(new Tile(i, curY));
				}
			}
			
			break;
		case BISHOP:
			for(int i = -7; i < 8; i++) {
				if(!(curX + i > 7 || curX  + i < 0 || curY + i > 7 || curY + i < 0 || i == 0)) {
					moves.add(new Tile(curX + i, curY + i));
				}
				if(!(curX + i > 7 || curX + i < 0 || curY - i > 7 || curY - i < 0 || i == 0)) {
					moves.add(new Tile(curX + i, curY - i));
				}
			}
			
			break;
		case KNIGHT:
			if(!(curX + 2 > 7 || curY + 1 > 7)) {
				moves.add(new Tile(curX + 2, curY + 1));
			}
			if(!(curX + 1 > 7 || curY + 2 > 7)) {
				moves.add(new Tile(curX + 1, curY + 2));
			}
			if(!(curX - 2 < 0 || curY + 1 > 7)) {
				moves.add(new Tile(curX - 2, curY + 1));
			}
			if(!(curX - 1 < 0 || curY + 2 > 7)) {
				moves.add(new Tile(curX- 1, curY + 2));
			}
			if(!(curX + 2 > 7 || curY - 1 < 0)) {
				moves.add(new Tile(curX + 2, curY - 1));
			}
			if(!(curX + 1 > 7 || curY - 2 < 0)) {
				moves.add(new Tile(curX + 1, curY - 2));
			}
			if(!(curX - 2 < 0 || curY - 1 < 0)) {
				moves.add(new Tile(curX - 2, curY - 1));
			}
			if(!(curX - 1 < 0 || curY - 2 < 0)) {
				moves.add(new Tile(curX - 1, curY - 2));
			}
			
			break;
		case PAWN:
			if(white) {
				if(first) {
					moves.add(new Tile(curX, curY +1));
					moves.add(new Tile(curX, curY +2));
				} else {
					if(curY != 7)
						moves.add(new Tile(curX, curY +1));
				}
			} else {
				if(first) {
					moves.add(new Tile(curX, curY -1));
					moves.add(new Tile(curX, curY - 2));
				} else {
					if(curY != 7)
						moves.add(new Tile(curX, curY -1));
				}
			}
			
			break;
		}
		
		return moves.toArray(new Tile[] {});
	}
	
	public static void main(String[] args) {
		for(Tile t:getPossibleMoves(ChessPiece.KING, new Tile(4, 4), true, true)) {
			System.out.println(t);
		}
	}
}
