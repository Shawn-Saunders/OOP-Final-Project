
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Devin
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
    
    @Override
    int[][] getValidMoves(JLabel[][] board){
        // Create an empty list of validMoves
        int validMoves[][];
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
        
        // Calculate the two diections
        
        // check bounds
        
        // Check if square is empty
        
        // If there is an opponent, calculate jump
        
        // 
        
        return validMoves;
    }
}
