/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Devin
 */
public class Jump {
    int[] captures;
    int[] landsAt; 
    
    /**
     * Small class to create references to which pieces have been
     * captured and where the attacking piece landed
     * @param captures {row, col} of the piece being captured
     * @param landsAt {row, col} of the landing square
     */
    public Jump(int[] captures, int[] landsAt){
        this.captures = captures;
        this.landsAt = landsAt;
    }
}
