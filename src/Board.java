/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * 
 * @author Shawn Saunders
 */
public class Board extends JPanel {
    // Create an 8x8 grid of square objects to generate
    // the board 
    public Board() {
        // Create the 8x8 grid
        setLayout(new GridLayout(8,8));
        
        // Populate grid with Square labels
        for (int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                Square square = new Square(row,col);
                add(square);
            }
        }
    }
    
}
