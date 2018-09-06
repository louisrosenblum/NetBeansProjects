/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Louis
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // String for store each line from file input
        String x;
        // Array to organize file input into multiples strings
        String[] a;
        // Array to hold strings as ints
        int[] w = {0,0,0};
        
       
        // File Input scan
        try{
        Scanner file_input = new Scanner(new File("input.txt"));
        PrintWriter printer = new PrintWriter(new File("output.txt"));
        while(file_input.hasNext()){
            x = file_input.nextLine();
            a = x.split(" ");
            w[0] = Integer.parseInt(a[0]);
            w[1] = Integer.parseInt(a[2]);
            w[2] = Integer.parseInt(a[1]);
            // Main method call
            go(w, printer);
            
        }
        printer.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        
        
        
        
        
    
} // Main method go, int array input and printwriter input
    public static void go(int[] a, PrintWriter w){
        // Number of nodes
        int z = a[0];
        //Creation of new linken list
        List party = new List(1,a[0]);
        // Clockwise iter node
        Node cw = party.dude[0];
        // Counter-clockwise iter node
        Node ccw = party.dude[a[0]-1];
        
        // While loop while not the politicians have been removed
        while(z!= 0){
        for(int i = 0; i < a[1]-1; i++){
            ccw = ccw.get_back();  
        }
        for(int i = 0; i < a[2]-1; i++){
            cw = cw.get_next(); 
        }
        // Scenario if iters point to different politicans
        if(cw.num != ccw.num && (z > 2)){
          w.println(cw.num + " " + ccw.num);
          cw = cw.get_next();
          ccw = ccw.get_back();
         
         // Specific scenario if iters end in adjacent spots and are the last two objects;
         if (cw.get_back() == ccw && z==4){
             cw = cw.get_next();
             ccw = ccw.get_back();
             
             cw.set_next(ccw);
             cw.set_back(ccw);
             
             ccw.set_next(cw);
             ccw.set_next(cw);
             
             
         }
         
         // Base case fix
         else{
        (cw.get_back()).get_back().set_next(cw);
         cw.set_back(cw.get_back().get_back());
          
         ccw.get_next().get_next().set_back(ccw);
         ccw.set_next(ccw.get_next().get_next());
         }
        
         z = z - 2;
        
          
        }
        // Scenario if pointers select the same politican, with specific odd case solutions
        else{
            if(z == 1){
                
                cw = cw.get_next();
                ccw = ccw.get_next();
                
                cw.set_next(cw);
                cw.set_back(cw);
                ccw.set_next(ccw);
                ccw.set_back(ccw);
                w.println(cw.num + " - Politician"); 
                
                z = z -1;
            }
            else if (z== 2){
               w.println(cw.num + " - Politician");
                ccw = ccw.get_next();
                cw.set_next(ccw);
                ccw.set_next(ccw);
                ccw.set_back(ccw);
                z = z-1;
            }
            else{
           w.println(cw.num+ " -K Politician"); 
           
           if(z> 2){
          (cw.get_back()).set_next(cw.get_next());
          cw.get_next().set_back(cw.get_back());
          
          ccw = cw;
         
           }
           z = z -1;
         
                    }
        }}
        
    }
}
