/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Abstract super class to define what a game piece is
 * @author Shawn Saunders
 */
public abstract class Piece {
    // Constants
    final static int MIN = 0;
    final static int MAX = 7;
    
    String color;
    int row;
    int col;
    
    /**
     * Used to check if a piece can move to a potential square
     * @param board The current board, holding where every piece is currently
     * @param candidateRow The potential row the piece may go to
     * @param candidateCol The potential column the piece may go to
     * @return If there is a valid move, return the row and column that is valid
     */
    public int[] isMoveValid(Piece[][] board, int candidateRow, int candidateCol) {
        int[] validSquare = null;
        
        // check if the movement is in bounds
        if (candidateRow >= MIN && candidateRow <= MAX && candidateCol >= MIN && candidateCol <= MAX){
            // check if the candidate location is empty
            if (board[candidateRow][candidateCol] == null) {
                validSquare = new int[] {candidateRow, candidateCol};
            }
        }
        
        return validSquare;
    }
    
    abstract int[][] getValidMoves(Piece[][] board);
}
