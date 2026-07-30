
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Devin
 */
public abstract class Piece {
    String color;
    int row;
    int col;
    
    abstract int[][] getValidMoves(JLabel[][] board);
}
