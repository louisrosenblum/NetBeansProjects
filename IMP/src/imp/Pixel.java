/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp;

/**
 *
 * @author Louis
 */
public class Pixel {
    public int y;
    public int x;
    public int count = 0;
    
    Pixel(int a, int b){
        y = a;
        x = b;
    }
    
    public int get_count(){
        return(count);
    }
    
    public void set_count(int a){
        count = a;
    }
}
