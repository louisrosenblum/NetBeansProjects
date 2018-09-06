/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import java.util.Random;

/**
 *
 * @author Louis
 */
public class Bowling_game {
    int pins[] = {0,0,0,0,0,0,0,0,0,0};
    int pin_count = 10;
    int w;
    int score;
    int points;
    
    Random rand = new Random();
    
    Bowling_game(){
        
        System.out.println(first_turn());
    }
    
    public int first_turn(){
        int x = rand.nextInt(22);
        
        if (0 <= x && x <= 5){
            w = rand.nextInt(6);
        }
        else if (x == 6 || x==7){
            w = 6;
        }
        else if (x == 8 || x == 9 || x == 10){
            w = 7;
        }
        else if (x == 11 || x == 12 || x == 13){
            w = 10;
        }
        else if (14 <= x && x <= 17){
            w = 9;
        }
        else if (18 <= x && x <= 21){
            w = 8;
        }
        pin_count = pin_count - w;
        System.out.println(pin_count);
        return(pin_count);
    }
    
    public int second_turn(){
        if (pin_count == 0){
            return(0);
        }
        else {
        do {
              
        int x = rand.nextInt(22);
        
        if (0 <= x && x <= 5){
            w = rand.nextInt(6);
        }
        else if (x == 6 || x==7){
            w = 6;
        }
        else if (x == 8 || x == 9 || x == 10){
            w = 7;
        }
        else if (x == 11 || x == 12 || x == 13){
            w = 10;
        }
        else if (14 <= x && x <= 17){
            w = 9;
        }
        else if (18 <= x && x <= 21){
            w = 8;
        } 
           } while(pin_count - w <0);
        pin_count = pin_count - w;
        System.out.println(pin_count);
        return(0);
        }
    }
    }

