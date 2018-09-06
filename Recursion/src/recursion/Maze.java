/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Louis
 */
public class Maze {
    int x;
    int y;
    int position[] = {y,x};
   
    
    
    char row_1[] = {'#','#','#','#','#','#','#','#','#','#','#','#'};
    char row_2[] = {'#','.','.','.','#','.','.','.','.','.','.','#'};
    char row_3[] = {'.','.','#','.','#','.','#','#','#','#','.','#'};
    char row_4[] = {'#','#','#','.','#','.','.','.','.','#','.','#'};
    char row_5[] = {'#','.','.','.','.','#','#','#','.','#','.','#'};
    char row_6[] = {'#','#','#','#','.','#','F','#','.','#','.','#'};
    char row_7[] = {'#','.','.','#','.','#','.','#','.','#','.','#'};
    char row_8[] = {'#','#','.','#','.','#','.','#','.','#','.','#'};
    char row_9[] = {'#','.','.','.','.','.','.','.','.','#','.','#'};
    char row_10[] = {'#','#','#','#','#','#','.','#','#','#','.','#'};
    char row_11[] = {'#','.','.','.','.','.','.','#','.','.','.','#'};
    char row_12[] = {'#','#','#','#','#','#','#','#','#','#','#','#'};
    public char[][] matrix = {row_1,row_2,row_3,row_4,row_5,row_6,row_7,row_8,row_9,row_10,row_11};

    
    Maze(int a[]){
        position[0] = a[0];
        position[1] = a[1];
       
        
    }
    
    public int x_right(){
         if(matrix[position[0]][position[1] + 1] == '.' || matrix[position[0]][position[1] + 1] == 'F'){
             return(1);
         }
         else{
             return(0);
         }
    }
     public int x_left(){
         if(matrix[position[0]][position[1] - 1] == '.' || matrix[position[0]][position[1] - 1] == 'F'){
             return(1);
         }
         else{
             return(0);
         }
    }
      public int y_down(){
         int alpha = position[0] +1;
         int bravo = position[1];
         if(matrix[alpha][bravo] == '.' || matrix[alpha][bravo] == 'F'){
             return(1);
         }
         else{
             return(0);
         }
    }
       public int y_up(){
         if(matrix[position[0]-1][position[1]] == '.' || matrix[position[0]-1][position[1]] == 'F'){
             return(1);
         }
         else{
             return(0);
         }
    }
    
}
