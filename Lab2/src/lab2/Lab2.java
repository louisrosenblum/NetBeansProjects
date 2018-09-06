/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Louis
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Engineering r = new Engineering(6,7);
        Engineering c = new Engineering(7);
        c.changeLength(4);
        int answer = c.circle();
        r.changeLength(-5);
        int secondAnswer = r.rect();
        int thirdAnswer = c.rect();
        
    }
    
}
