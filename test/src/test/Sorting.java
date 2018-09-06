/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import static java.util.Arrays.copyOfRange;
import java.util.Random;

/**
 *
 * @author w88m956
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random rand = new Random();
        int[] twenty = new int[20];
        int[] honey = new int[100];
        int[] fiddy = new int[500];
        int[] timmy = new int[1000];
        int[] tommy = new int[10000];
        
        for(int i = 0; i<20;i++){
            twenty[i] = rand.nextInt(21);
        }
        for(int i = 0; i<100;i++){
            honey[i] = rand.nextInt(101);
        }
        for(int i = 0; i<500;i++){
            fiddy[i] = rand.nextInt(501);
        }
        for(int i = 0; i<1000;i++){
            timmy[i] = rand.nextInt(1001);
        }
        for(int i = 0; i<10000;i++){
            tommy[i] = rand.nextInt(10001);
        }
        
        
        long startTime2 = System.currentTimeMillis();
        selection(tommy);
        long finishTime2 = System.currentTimeMillis();
        System.out.println("The time in milliseconds to selection sort 10000" + 
            " items is " + (finishTime2 - startTime2));
        
    }
    
    public static void selection(int[] b){
        int n = b.length;
        int z = 99999;
        int y = -6;
        int a[] = new int[n];
        for(int k = 0; k<n; k++){
        z = 999999;
        for(int i=0; i<n; i++){
            if(z > b[i]){
                z = b[i];
                y = i;
        }               
        }
        
        if(y >= 0){
           b[y] = 99999; 
        }
        
        a[k] = z;
   
        }

        for(int i =0; i<n; i++){
           System.out.println(a[i]);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void bubble(int[] b){
        int n = b.length;
        int k = b.length;
      
        while(k > 0){
        for(int i =0; i<n-1; i++){
            if(b[i] > b[i+1]){
                int x = b[i];
                int y = b[i+1];
                b[i] = y;
                b[i+1] = x;
                k = k+1;
            }
            else{
                k = k -1;
            }
        }
        }
        
        
        for (int i =0; i<n; i++){
            System.out.println(b[i]);
        }
        
    }
}
