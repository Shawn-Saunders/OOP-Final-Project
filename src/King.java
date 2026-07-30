
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Devin
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
    int[][] getValidMoves(JLabel[][] board){
        int validMoves[][];
        
        return validMoves;
    }
}
