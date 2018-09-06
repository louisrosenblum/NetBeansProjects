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
public class Engineering {
   int length;
   int width;
    
    Engineering(int x){
       length = x;
       
    }
    Engineering(int x, int y){
        length = x;
        width = y;
    }
    
    public int rect(){
        int a = (length * width);
        return(a);
    }
    
    public int circle(){
       int a;
       a = (int) (3.14 * (length * length));
       return(a);
    }
    
    public int changeLength(int x){
        length = x;
        return(0);
    }
}
