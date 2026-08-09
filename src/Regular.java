
import java.util.List;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Subclass of Piece, creates a regular checker piece that can only move forwards
 * @author Shawn
 */
public class Regular extends Piece {
    /**
     * Constructor - Create Regular piece objects
     */
    Regular(String color, int row, int col, boolean isKing) {
        this.color = color;
        this.row = row;
        this.col = col;
        this.isKing = isKing;
    }
    
    /**
     * Gets every valid move a selected piece can make
     * @param board The entire board, holding the location of each piece
     * @return Every valid position the piece can move to
     */
    @Override
    public int[][] getValidMoves(Piece[][] board){
        // Create an empty list of validMoves using List and ArrayList
        // because we dont know how many moves there will be
        List<int[]> validMoves = new ArrayList<>();
//        
        int[][] directions = getDirections(this.isKing, this.color);
        for (int[] direction : directions) {
            int[] result = checkCandidateSquares(board, direction[0], direction[1]);
            if (result != null) {
                validMoves.add(result);
                // System.out.println("Simple move valid: lands at (" + result[0] + "," + result[1] + ")");
            }
        }
        
        // If there is an opponent, calculate jump
        List<List<Jump>> jumpPaths = findJumpSequences(board, this.row, this.col, this.isKing, this.color, new ArrayList<>());
                
        if (!jumpPaths.isEmpty()){
            // a jump exists, extract the landing squares from jumpPaths
            for (List<Jump> path : jumpPaths) {
                Jump lastJump = path.get(path.size() -1);
                validMoves.add(lastJump.landsAt);
            }
        }
        
        // System.out.println(debugMessage(jumpPaths));
        // After the number of moves is determined, we can send the moves back
        // as a new int[][] like origonally planned
        return validMoves.toArray(new int[0][]);
    }
}
