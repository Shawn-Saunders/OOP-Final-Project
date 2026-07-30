
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
    King(String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }
    
    @Override
    public int[][] getValidMoves(Piece[][] board){
        // Create an empty list of validMoves using List and ArrayList
        // because we dont know how many moves there will be
        List<int[]> validMoves = new ArrayList<>();
        int forward = 0;
        
        //Determine forward direction based on piece color
        if (this.color.equals("black")){
            forward = 1;
        } else if (this.color.equals("red")){
            forward = -1;
        }
        
        // Define the forward diagonals
        int[] forwardLeft = {this.row + forward, this.col - 1};
        int[] forwardRight = {this.row + forward, this.col + 1};
        int[] backwardLeft = {this.row - forward, this.col - 1};
        int[] backwardRight = {this.row - forward, this.col + 1};
        
        // Check if the move is valid, if it is then add it to the array
        int[] forwardLeftResult = isMoveValid(board, forwardLeft[0], forwardLeft[1]);
        if (forwardLeftResult != null){
            validMoves.add(forwardLeftResult);
            System.out.println("Forward Left move is valid");
        }
        int[] forwardRightResult = isMoveValid(board, forwardRight[0], forwardRight[1]);
        if (forwardRightResult != null){
            validMoves.add(forwardRightResult);
            System.out.println("Forward Right move is valid");
        }
        int[] backwardLeftResult = isMoveValid(board, backwardLeft[0], backwardLeft[1]);
        if (backwardLeftResult != null){
            validMoves.add(backwardLeftResult);
            System.out.println("Backward Left move is valid");
        }
        int[] backwardRightResult = isMoveValid(board, backwardRight[0], backwardRight[1]);
        if (backwardRightResult != null){
            validMoves.add(backwardRightResult);
            System.out.println("Backward Right move is valid");
        }
        
        
        // If there is an opponent, calculate jump

        // After the number of moves is determined, we can send the moves back
        // as a new int[][] like origonally planned
        return validMoves.toArray(new int[0][]);
    }
}
