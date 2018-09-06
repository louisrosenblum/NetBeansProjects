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

// Class for a game of Bowling
public class Bowling_game {
    
    Random rand = new Random();
    int pin_count = 10; // Number of pins that are currently up
    int w; // Tracks number of pins knocked over each throw
    int bowls[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // Array for all throw results
    int previous[] = {0,0}; // Array to store the results of last frame
    int current[] = {0,0}; // Array to store results of current frame
    int frames[] = {0,0,0,0,0,0,0,0,0,0}; // Array to store scores of all frames 
    int status = 0; // Array to track spares and strikes
    
    Bowling_game(String x){
        System.out.println("Bowling game: " + x);
        // Loop performing the first 9 frames of the game
        for (int i = 0; i<9; i++){
        first_turn(i);
        second_turn(i);
  
        }
        // 10th frame
        first_turn(9);
        second_turn(9);
        // Conditional statement to trigger bonus frame
        if (current[0] == 10 || (current[0] + current[1] == 10)){
            status = 1;
            first_turn(10);
            second_turn(10);
           
    }
      
        // Calculate scoring
        tally_frames(); 
        //Output results to user
        print_results();
    }
        // Method to perform the first throw of a frame
    public int first_turn(int a){
        pin_count = 10;
        previous = current.clone();
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
        
        current[0] = w;
        bowls[2*a] = w;
        
        return(0);
    }
    
        //Method to perform the second throw of a frame
    public int second_turn(int a){
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
           } while((pin_count - w )<0);
        pin_count = pin_count - w;
        if (a == 10){
            current[1] = current[1] + w;
        }
        current[1] = w;
        bowls[((2*a)+1)] = w;
        return(0);
        }
    }
   // Method to calculate the scores of each frame
    int tally_frames(){
        for(int i = 0; i<10; i++){
            if(i ==0){
                if(bowls[2*i] == 10){
                frames[i] = bowls[2*i] + bowls[2*(i+1)] + bowls[2*(i+1) + 1];
        }
            else if(bowls[(2*i)+1] + bowls[2*i] == 10){
                frames[i] = bowls[2*i] + bowls[(2*i)+1] + bowls[2*(i+1)];
            }
            else{
            frames[i] = bowls[2*i] + bowls[(2*i)+1];
            }}
            else{
            
            if(bowls[2*i] == 10){
                frames[i] = frames[i-1] + bowls[2*i] + bowls[2*(i+1)] + bowls[2*(i+1) + 1];
        }
            else if((bowls[(2*i)+1] + bowls[2*i] == 10) && i!=9){
                frames[i] = frames[i-1] + bowls[2*i] + bowls[(2*i)+1] + bowls[2*(i+1)];
            }
            else if((bowls[(2*i)+1] + bowls[2*i] == 10) && i==9){
                 frames[i] = frames[i-1] + bowls[2*i] + bowls[(2*i)+1] + bowls[2*(i+1)] + bowls[2*(i+1)+1];
            }
            else{
            frames[i] = frames[i-1] + bowls[2*i] + bowls[(2*i)+1];
        }
        }
        
    }
            
        return(0);
}
    // Method to print results out via the console
    public int print_results(){
        for(int i =0; i<9; i++){
        System.out.print("+----Frame " + (i+1) + "----");
         
    }
       System.out.print("+----Frame 10"+ "---"); 
       System.out.print("+---------------+");
        System.out.println("");
        for(int i =0; i<10; i++){
            if(bowls[2*i] == 10){
            System.out.print("+   " + "X" + "   |   " + "    ");    
            }
            else if(bowls[((2*i)+1)] == 10){
               System.out.print("+   " + bowls[2*i] + "   |   " + "S" + "   "); 
            }
            else if(bowls[2*i] + bowls[(2*i) + 1] == 10){
                 System.out.print("+   " + bowls[2*i] + "   |   " + "S" + "   ");
            }
            else{
        System.out.print("+   " + bowls[2*i] + "   |   " + bowls[(2*i)+ 1]+ "   ");
    }}
        if(status ==0){
          System.out.print("+               +");
        }
        else if(status ==1){
            System.out.print("+   " + bowls[20] + "   |   " + bowls[21]+ "   ");
        }
        
        System.out.println("");
        for(int i =0; i<11; i++){
            System.out.print("+---------------");
        }
        System.out.print("+");
        System.out.println("");
        for(int i =0; i<=9; i++){
            if(frames[i] >=10 && frames[i]<100){
                System.out.print("+      " + frames[i] + "       ");
            }
            else if (frames[i] >=100){
                System.out.print("+      " + frames[i] + "      ");
            }
            else{
            System.out.print("+       " + frames[i] + "       ");
        }}
        System.out.print("+               +");
        System.out.println("");
        
        for(int i =0; i<11; i++){
            System.out.print("+---------------");
        }
        System.out.print("+");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        return(0);
        
        
}
}