/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_lab;

import java.util.*;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Louis
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Scanner for user input
       Scanner scan = new Scanner(System.in);
       
       // Int to store menu choices
       int x = 0;
       // New empty instance of the list class
       List sheet = new List();
       
       
      
       // Loop to print menu and retrieve input
       while (x != -1){
           System.out.println("Press 1 to load list from file");
           System.out.println("Press 2 to load list with individual item from user input");
           System.out.println("Press 3 to print list inorder");
           System.out.println("Press 4 to print list backwards");
           System.out.println("Press 5 to remove item");
           System.out.println("Press 6 to delete entire list");
           System.out.println("Press -1 to exit");
           x  = scan.nextInt();
           
           // Process to load from file
           if (x == 1){
               System.out.println("Please enter the name of the file you would like to read");
               String k = scan.next();
               int z = 0;
               String p[];
               int juliet = 0;
               
               try{
               Scanner file_input = new Scanner(new File(k));
               while (file_input.hasNext()){
                    String alpha = file_input.nextLine();
                    z = z+1;
                }
                }
               catch(FileNotFoundException e){
                    System.out.println("File not found.");
       }
               String[][] romeo = new String[z][3];
               
               try{
               Scanner file_input = new Scanner(new File(k));
               
               while (file_input.hasNext()){
                    String alpha = file_input.nextLine();
                    romeo[juliet] = alpha.split(", ");
                    
                    juliet = juliet + 1;        
                            
                }
                }
               catch(FileNotFoundException e){
                    System.out.println("File not found.");
       }
               System.out.println("Loading...");
               for (int india= 0; india < 10000000; india++){
                   for(int foxtrot = 0; foxtrot < z; foxtrot++){
                       if(Integer.parseInt((romeo[foxtrot][0])) == india){
                           
                           if (sheet.first==null){
                               sheet.first = new Node(Integer.parseInt(romeo[foxtrot][0]), romeo[foxtrot][1], romeo[foxtrot][2]);
                           }
                           else{
                           sheet.addback(new Node(Integer.parseInt(romeo[foxtrot][0]), romeo[foxtrot][1], romeo[foxtrot][2]));
                           }
                       }
                   }
               }
           }
           
           // Process to create new list from user input
           else if(x == 2){
               sheet = new List();
               int n = 1;
               while(n != 0){
               int alpha;
               String bravo;
               String charlie;
               System.out.println("Please input the ID for your new entry: ");
               alpha = scan.nextInt();
               System.out.println("Please input the last name for your new entry: ");
               charlie = scan.next();
               System.out.println("Please input the first name for your new entry: ");
               bravo = scan.next();
               
               if (sheet.first == null){
                   sheet.first = (new Node(alpha,bravo,charlie));
               }
               else if(sheet.first != null){
                   sheet.addback(new Node(alpha,bravo,charlie));
               }
               
               System.out.println("Enter 1 to add another entry, press 0 to go back to menu: ");
               n = scan.nextInt();
           }}
           
           // Process to print list 
           else if(x == 3){
               sheet.print();
           }
           // Process to print list in reverse
           else if (x == 4){
               sheet.print_back();
           }
           // Process to delete an item in a list
           else if (x==5){
               System.out.println("Please input the ID you would like to delete: ");
               int j = scan.nextInt();
               if (sheet.first.get_id() == j && sheet.first.get_next() == null){
               sheet = new List();
           }
               else{
               sheet.delete(j);
               }
           }
           // Process to erase entire list
           else if(x == 6){
               sheet = new List();
           }
    }
       
    
         
     }
    
     
    
}
