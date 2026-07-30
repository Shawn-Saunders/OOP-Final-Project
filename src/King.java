
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
        List<int[]> validMoves = new ArrayList<>();
        
        return validMoves.toArray(new int[0][])
    }
}
