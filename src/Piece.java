
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
    boolean isKing;
    
    
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
     * @param pathSoFar The path the current piece may have traveled so far
     * @return a compiled list of all possible paths a piece can go
     * tracking the path number, and the landing coordinate
     */
    public List<List<Jump>> findJumpSequences(Piece[][] board, int row, int col, boolean isKing, String color, List<Jump> pathSoFar){
        
        // Create the list of lists
        List<List<Jump>> allPaths = new ArrayList<>();
        
        // Determine which diretion offset needs to be used
        int[][] directions = getDirections(isKing, color);
        
        boolean nowKing = isKing;
        
        // loop limited by isKing before iteration, nowKing will not affect it
        for (int[] direction : directions){
            // for each direction check if a jump is possible, then create a new jump
            Jump jump = checkForJump(board, row, col, direction[0], direction[1], color);
            
            // Check if there is a possible jump and that the piece has not already been captured
            if (jump != null && !alreadyCaptured(pathSoFar, jump)) {
                // If the piece reaches the back rank, make the piece a king
                if (jump.landsAt[0] == 0 || jump.landsAt[0] == MAX) {
                    nowKing = true;
                }
                // System.out.println("At (" + row + "," + col + ") -> landing (" + jump.landsAt[0] + "," + jump.landsAt[1] + "), isKing was " + isKing + ", nowKing = " + nowKing);
                
                List<Jump> newPath = new ArrayList<>(pathSoFar);
                newPath.add(jump);
                // Make a list of lists to recursively search for new moves
                List<List<Jump>> furtherPaths = findJumpSequences(board, jump.landsAt[0], jump.landsAt[1], nowKing, color, newPath);
                
                // If there are no further paths then return the current Jump
                if (furtherPaths.isEmpty()){
                    allPaths.add(newPath);
                } else {
                    // if there are more paths then note where the piece lands, the path it took, then return the combined list of Jumps
                    for (List<Jump> path : furtherPaths) {
                        List<Jump> combined = new ArrayList<>();
                        // combine the paths then add the combined paths to return all possible paths
                        combined.addAll(path);
                        allPaths.add(combined);
                    }
                }
            }
        }
        
        
        return allPaths;
    }
    
    /**
     * Check if the square has already been "captured"
     * @param path The last Jump performed by the piece
     * @param candidate The next possible Jump for the piece
     * @return 
     */
    private boolean alreadyCaptured(List<Jump> path, Jump candidate) {
        for (Jump takenJump : path) {
            if (takenJump.captures[0] == candidate.captures[0] && takenJump.captures[1] == candidate.captures[1]) {
                return true;
            }
        }
        return false;
    }
    
    public int[][] getDirections(boolean isKing, String color) {
        if (isKing) {
            // able to move all directions
            return new int[][] {{1,1},{-1,-1},{1,-1},{-1,1}};
        } else if (color.equals("black")){
            // black moves down, which is positive in the array
            return new int[][] {{1,-1},{1,1}};
        } else {
            // red moves up, which is negative values
            return new int[][] {{-1,1},{-1,-1}}; 
        }
    }
    
    public int[][] getCapturesFor(Piece[][] board, int destRow, int destCol) {
        List<int[]> captured = new ArrayList<>();
        List<List<Jump>> paths = findJumpSequences(board, this.row, this.col, this.isKing, this.color, new ArrayList<>());
        List<Jump> best = null;
        
        // Find the jump path that finishes on the square we were asked about
        for (List<Jump> path : paths) {
            int[] end = path.get(path.size() - 1).landsAt;
            if (end[0] == destRow && end[1] == destCol) {
                // If two paths finish on the same square, take the one that captures more
                if (best == null || path.size() > best.size()) {
                    best = path;
                }
            }
        }
        
        // Collect every square that path captured on the way
        if (best != null) {
            for (Jump jump : best) {
                captured.add(jump.captures);
            }
        }
        
        return captured.toArray(new int[0][]);
    }

    
    /**
     * Simple debugging message to check how many jumps are possible for a selected piece
     * @param jumpPaths The path the piece had gone down, holding both the location of
     * the captured piece and where the current piece is traveling
     * @return the debug message populated with the information
     */
    public String debugMessage (List<List<Jump>> jumpPaths) {
        String message = "";
        for (List<Jump> path : jumpPaths) {
            message += "Jump path found, length " + path.size() + ":\n";
            for (Jump j : path) {
                message += "captures (" + j.captures[0] + "," + j.captures[1] +
                        ") lands at (" + j.landsAt[0] + "," + j.landsAt[1] + ")\n";
            }
        }
        return message;
    }
    
    abstract int[][] getValidMoves(Piece[][] board);
}
