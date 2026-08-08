
import java.util.List;
import java.util.ArrayList;

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
    
    // Object variables
    String color;
    int row;
    int col;
    
    /**
     * Used to check if a piece can move to a potential square
     * @param board The current board, holding where every piece is currently
     * @param rowOffset The vertical direction the piece may go to
     * @param colOffset The horizontal direction the piece may go to
     * @return If there is a valid move, return the row and column that is valid
     */
    public int[] checkCandidateSquares(Piece[][] board, int rowOffset, int colOffset) {
        // Declair variables
        int[] validSquare = null;
        
        int candidateRow = this.row + rowOffset;
        int candidateCol = this.col + colOffset;
        
        // check if the movement is in bounds
        if (candidateRow >= MIN && candidateRow <= MAX && candidateCol >= MIN && candidateCol <= MAX){
            // check if the candidate location is empty
            if (board[candidateRow][candidateCol] == null) {
                validSquare = new int[] {candidateRow, candidateCol};
            } 
        }
        return validSquare;
    }
    
    public Jump checkForJump(Piece[][] board, int row, int col, int rowOffset, int colOffset, String color){
        // Declare Variables
        int candidateRow = row + rowOffset;
        int candidateCol = col + colOffset;
        
        int landingRow = row + (2 * rowOffset);
        int landingCol = col + (2 * colOffset);
        
        Jump canJump = null;
        // 

        // Check if the jump would go off the board
        if (candidateRow >= MIN && candidateRow <= MAX && candidateCol >= MIN && candidateCol <= MAX){
            // Check if the candidate square has a piece
            if (board[candidateRow][candidateCol] != null){
                // Check if the piece is the opposite color
                if (!board[candidateRow][candidateCol].color.equals(color)) {
                    // Check if the landing location would be off the board
                    if (landingRow >= MIN && landingRow <= MAX && landingCol >= MIN && landingCol <= MAX){
                        // Check if the space can be occupied
                        if (board[landingRow][landingCol] == null){
                            // Create Jump object to remember the potentially taken piece and new potential location
                            canJump = new Jump(new int[]{candidateRow, candidateCol}, new int[]{landingRow, landingCol});
                        }
                    }
                }
            }
        }
        
        
        return canJump;
    }
    
    /**
     * Constructs Jumps based on legal moves and handles the logic of multi-captures
     * @param board The Current state of the board
     * @param row The row the current piece is on
     * @param col The column the current piece is on
     * @param isKing check if the current piece is a king
     * @param color The color of the current piece
     * @return a compiled list of all possible paths a piece can go
     * tracking the path number, and the landing coordinate
     */
    public List<List<Jump>> findJumpSequences(Piece[][] board, int row, int col, boolean isKing, String color){
        // Create the list of lists
        List<List<Jump>> allPaths = new ArrayList<>();
        
        int[][] directions;
        
        // Determine which diretion offset needs to be used
        if (isKing) {
            // able to move all directions
            directions = new int[][] {{1,1},{-1,-1},{1,-1},{-1,1}};
        } else if (color.equals("black")){
            // black moves down, which is positive in the array
            directions = new int[][] {{1,-1},{1,1}};
        } else {
            // red moves up, which is negative values
            directions = new int[][] {{-1,1},{-1,-1}}; 
        }
        
        for (int[] direction : directions){
            // for each direction check if a jump is possible, then create a new jump
            Jump jump = checkForJump(board, row, col, direction[0], direction[1], color);
            
            // Check if there is a jump
            if (jump != null) {
                // If the piece reaches the back rank, make the piece a king
                boolean nowKing = false;
                
                if (jump.landsAt[0] == 0 || jump.landsAt[0] == MAX) {
                    nowKing = true;
                }
                
                // Make a list of lists to recursively search for new moves
                List<List<Jump>> furtherPaths = findJumpSequences(board, jump.landsAt[0], jump.landsAt[1], nowKing, color);
                
                // If there are no further paths then return a single jump sequence
                if (furtherPaths.isEmpty()){
                    List<Jump> singlePath = new ArrayList<>();
                    singlePath.add(jump);
                    allPaths.add(singlePath);
                } else {
                    // if there are more paths then note where the piece lands, the path it took, then return the combined list
                    for (List<Jump> path : furtherPaths) {
                        List<Jump> combined = new ArrayList<>();
                        combined.add(jump);
                        combined.addAll(path);
                        allPaths.add(combined);
                    }
                }
            }
        }
        
        return allPaths;
    }
    
    abstract int[][] getValidMoves(Piece[][] board);
}
