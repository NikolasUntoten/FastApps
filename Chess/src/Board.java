import java.util.ArrayList;

public class Board {
	Piece[][] board = new Piece[8][8];

	public Board() {
		Pawn blackPawnOne = new Pawn(true);
		Pawn blackPawnTwo = new Pawn(true);
		Pawn blackPawnThree = new Pawn(true);
		Pawn blackPawnFour = new Pawn(true);
		Pawn blackPawnFive = new Pawn(true);
		Pawn blackPawnSix = new Pawn(true);
		Pawn blackPawnSeven = new Pawn(true);
		Pawn blackPawnEight = new Pawn(true);
		Rook blackRookOne = new Rook(true);
		Rook blackRookTwo = new Rook(true);
		Knight blackKnightOne = new Knight(true);
		Knight blackKnightTwo = new Knight(true);
		Bishop blackBishopOne = new Bishop(true);
		Bishop blackBishopTwo = new Bishop(true);
		Queen blackQueen = new Queen(true);
		King blackKing = new King(true);
		Pawn whitePawnOne = new Pawn(false);
		Pawn whitePawnTwo = new Pawn(false);
		Pawn whitePawnThree = new Pawn(false);
		Pawn whitePawnFour = new Pawn(false);
		Pawn whitePawnFive = new Pawn(false);
		Pawn whitePawnSix = new Pawn(false);
		Pawn whitePawnSeven = new Pawn(false);
		Pawn whitePawnEight = new Pawn(false);
		Rook whiteRookOne = new Rook(false);
		Rook whiteRookTwo = new Rook(false);
		Knight whiteKnightOne = new Knight(false);
		Knight whiteKnightTwo = new Knight(false);
		Bishop whiteBishopOne = new Bishop(false);
		Bishop whiteBishopTwo = new Bishop(false);
		Queen whiteQueen = new Queen(false);
		King whiteKing = new King(false);
		// Piece[8][8] board {
		board[0][0] = blackRookOne;
		board[1][0] = blackKnightOne;
		board[2][0] = blackBishopOne;
		board[3][0] = blackQueen;
		board[4][0] = blackKing;
		board[5][0] = blackBishopTwo;
		board[6][0] = blackKnightTwo;
		board[7][0] = blackRookTwo;
		board[0][1] = blackPawnOne;
		board[1][1] = blackPawnTwo;
		board[2][1] = blackPawnThree;
		board[3][1] = blackPawnFour;
		board[4][1] = blackPawnFive;
		board[5][1] = blackPawnSix;
		board[6][1] = blackPawnSeven;
		board[7][1] = blackPawnEight;
		board[0][7] = whiteRookOne;
		board[1][7] = whiteKnightOne;
		board[2][7] = whiteBishopOne;
		board[3][7] = whiteQueen;
		board[4][7] = whiteKing;
		board[5][7] = whiteBishopTwo;
		board[6][7] = whiteKnightTwo;
		board[7][7] = whiteRookTwo;
		board[0][6] = whitePawnOne;
		board[1][6] = whitePawnTwo;
		board[2][6] = whitePawnThree;
		board[3][6] = whitePawnFour;
		board[4][6] = whitePawnFive;
		board[5][6] = whitePawnSix;
		board[6][6] = whitePawnSeven;
		board[7][6] = whitePawnEight;
	}

	public Piece[][] boardReturn() {
		return board;
	}
}
