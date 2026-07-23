/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Create the squares that make up the board
 * @author Devin
 */
public class Square extends JLabel {
    private int row;
    private int col;
    
    /**
     * Square constructor
     * @param row the row of the square
     * @param col the column of the square
     */
    public Square(int row, int col){
        this.row = row;
        this.col = col;
        
        // make sure the label background is visible
        setOpaque(true);
        
       // if a square is on an even tile paint it red, otherwise
       // paint it dark gray
       if ((row+col) % 2 == 0){
           setBackground(Color.RED);
           //setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackKing.png")));
       } else {
           setBackground(Color.BLACK);
           //setIcon(new javax.swing.ImageIcon(getClass().getResource("/redKing.png")));
       }
    }
}
