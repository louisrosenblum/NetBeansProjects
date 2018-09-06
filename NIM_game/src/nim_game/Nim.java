/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nim_game;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Louis
 */
public class Nim {
    int total_marbles;
    int starting_player;
    int difficulty;
    Scanner scanner = new Scanner(System.in); 
    
    Random ran = new Random();
    
    Nim(){
        total_marbles = ran.nextInt(91) + 10;
        starting_player = ran.nextInt(2);
        difficulty = ran.nextInt(2);
        int x = 0;
        game_intro();
        while(total_marbles > 1){
            if (difficulty == 0){
                if (starting_player == 0){
                    player_turn();
                    x = 0;
                    if(total_marbles != 1){
                    stupid_cpu_turn();
                    x = 1;
                    }
                    
                }
                else{
                    stupid_cpu_turn();
                    x = 1;
                    if(total_marbles != 1){
                    player_turn();
                    x = 0;
                    }
                }
            }
            else{
                if (starting_player == 0){
                    player_turn();
                    x = 0;
                    if(total_marbles != 1){
                    smart_cpu_turn();
                    x = 1;
                    }
                }
                else{
                    smart_cpu_turn();
                    x = 1;
                    if(total_marbles != 1){
                    player_turn();
                    x = 0;
                    }
                }
            }
        }
        if(total_marbles == 1){
            if (x == 0){
                System.out.println("Congratulations, you win!");
            }
            else{
                System.out.println("The computer has defeated you. It pities your petty existence.");
            }
        }
    
   
}
    
    public int player_turn(){
        System.out.println("It is your turn. How many marbles do you wish to take? "); 
        int choice = scanner.nextInt();
        total_marbles = total_marbles - choice;
        System.out.println("There are " + total_marbles + " marbles remaining");
        return(0);
    }
    
    public int game_intro(){
        System.out.println("There are " + total_marbles + " total marbles");
        if (difficulty == 0){
            System.out.println("The computer is playing in stupid mode");
        }
        else{
            System.out.println("The computer is playing in smart mode");
        }
        if (starting_player == 0){
            System.out.println("You will go first");
        }
        else{
            System.out.println("The computer will go first");
        }
        return(0);
    }
    
    public int stupid_cpu_turn(){
        int choice = ran.nextInt(total_marbles/2) + 1;
        total_marbles = total_marbles - choice;
        System.out.println("The computer took " + choice + " marbles. There are now " + total_marbles + " marbles remaining");
        return(0);
    }
    
    public int smart_cpu_turn(){

        int remaining[] = {1,3,7,15,31,63};
        int random = ran.nextInt(6);
        while((total_marbles - remaining[random]) > total_marbles/2 || (total_marbles - remaining[random]) < 0){
            random = ran.nextInt(6);
        }
        
        int choice = total_marbles - remaining[random];
        if (total_marbles == 3 || total_marbles == 7 || total_marbles == 15 || total_marbles == 31 || total_marbles == 63){
            choice = ran.nextInt(total_marbles/2) + 1;
        }
        total_marbles = total_marbles - choice;
        System.out.println("The computer took " + choice + " marbles. There are now " + total_marbles + " marbles remaining");
        
        
        return(0);
    }
}
