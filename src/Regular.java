
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
    Regular(String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
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
        int forward = 0;
        int left = -1;
        int right = 1;
        
        //Determine forward direction based on piece color
        if (this.color.equals("black")){
            forward = 1;
        } else if (this.color.equals("red")){
            forward = -1;
        }
        
        
        // Check if the move is valid, if it is then add it to the array
        int[] leftResult = checkCandidateSquares(board, forward, left);
        if (leftResult != null){
            validMoves.add(leftResult);
            System.out.println("Left move is valid");
        }
        int[] rightResult = checkCandidateSquares(board, forward, right);
        if (rightResult != null){
            validMoves.add(rightResult);
            System.out.println("Right move is valid");
        }
        
        // If there is an opponent, calculate jump

        // After the number of moves is determined, we can send the moves back
        // as a new int[][] like origonally planned
        return validMoves.toArray(new int[0][]);
    }
}
