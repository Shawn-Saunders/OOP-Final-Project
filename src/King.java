
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Subclass of Piece, creates a king checker piece that can move all directions
 * @author Shawn
 */
public class King extends Piece {
    /**
     * Constructor - Create King piece objects
     */
    King(String color, int row, int col, int[][] directions) {
        this.color = color;
        this.row = row;
        this.col = col;
        this.directions = directions;
    }
    
    @Override
    public int[][] getValidMoves(Piece[][] board){
        // Create an empty list of validMoves using List and ArrayList
        // because we dont know how many moves there will be
        List<int[]> validMoves = new ArrayList<>();
        
        for (int[] direction : directions) {
            // check each direction to see if the piece can move there normally
            int[] result = checkCandidateSquares(board, direction[0], direction[1]);
            if (result != null) {
                // if the square is available then add it to the list of valid moves
                validMoves.add(result);
                System.out.println("Simple move valid: lands at (" + result[0] + "," + result[1] + ")");
            }
        }
        
        
        // If there is an opponent, calculate jump
        List<List<Jump>> jumpPaths = findJumpSequences(board, this.row, this.col, true, this.color, new ArrayList<>());
        
        if (!jumpPaths.isEmpty()){
            // a jump exists, extract the landing squares from jumpPaths
            for (List<Jump> path : jumpPaths) {
                Jump lastJump = path.get(path.size() -1);
                validMoves.add(lastJump.landsAt);
            }
        }
        
        System.out.println(debugMessage(jumpPaths));
        // After the number of moves is determined, we can send the moves back
        // as a new int[][] like origonally planned
        return validMoves.toArray(new int[0][]);
    }
}
