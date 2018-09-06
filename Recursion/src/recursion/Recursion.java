/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.Random;

/**
 *
 * @author Louis
 */
public class Recursion {

    /**
     * @param args the command line arguments
     */
    static Random rand = new Random();
    public static void main(String[] args) {
       
        int k[] = {2,0};
        Maze puzzle;
        puzzle = new Maze(k);
        go(puzzle);
        
        
        
    }
    
    public static void go(Maze a){   
        while(a.matrix[a.position[0]][a.position[1]] != 'F'){
            System.out.println("Location: Row:" + a.position[0] + " Column:" + a.position[1]);
            // can't go up
            if(a.position[0] == 0){

                                // 2) can only move down
                if(a.y_down() == 1 && a.x_right() == 0 && a.x_left() == 0){
                    int b[] = {a.position[0]+1,a.position[1]};
                    Maze c = new Maze(b);
                    go(c);
            }
               // 3) can only move right
                else if(a.y_down() == 0 && a.x_right() == 1 && a.x_left() == 0){
                    int b[] = {a.position[0],a.position[1]+1};
                    Maze c = new Maze(b);
                    go(c);
            } 
                // 4) can only move left
                else if(a.y_down() == 0 && a.x_right() == 0 && a.x_left() == 1){
                    int b[] = {a.position[0],a.position[1]-1};
                    Maze c = new Maze(b);
                    go(c);
            } 
                 // 5) 2 possible moves, 1
                else if(a.y_down() == 0 && a.x_right() == 1 && a.x_left() == 1){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                                                               
                // 9) 2 possible moves, 5
                else if(a.y_down() == 1 && a.x_right() == 1 && a.x_left() == 0){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                // 10) 2 possible moves, 6
                else if(a.y_down() == 1 && a.x_right() == 0 && a.x_left() == 1){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                
                // 11) 3 possible moves, 1
                else if(a.y_down() == 1 && a.x_right() == 1 && a.x_left() == 1){
                    int w = rand.nextInt(3);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if(w==2){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c);
                    }
                    
                }
                                
              
                                
                              
            }


                
            
            //can't go down
            else if(a.position[0] == (11)){
                // 15 full scenarios
                // 1) can only move up
                if(a.y_up() == 1 && a.x_right() == 0 && a.x_left() == 0){
                    int b[] = {a.position[0]-1,a.position[1]};
                    Maze c = new Maze(b);
                    go(c);
            }

               // 3) can only move right
                else if(a.y_up() == 0 && a.x_right() == 1 && a.x_left() == 0){
                    int b[] = {a.position[0],a.position[1]+1};
                    Maze c = new Maze(b);
                    go(c);
            } 
                // 4) can only move left
                else if(a.y_up() == 0 && a.x_right() == 0 && a.x_left() == 1){
                    int b[] = {a.position[0],a.position[1]-1};
                    Maze c = new Maze(b);
                    go(c);
            } 
                 // 5) 2 possible moves, 1
                else if(a.y_up() == 0 && a.x_right() == 1 && a.x_left() == 1){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                               // 7) 2 possible moves, 3
                else if(a.y_up() == 1 && a.x_right() == 1 && a.x_left() == 0){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                // 8) 2 possible moves, 4
                else if(a.y_up() == 1 && a.x_right() == 0 && a.x_left() == 1){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
          
                
    
                    
                }
                             // 12) 3 possible moves, 2
                else if(a.y_up() == 1 && a.x_right() == 1 && a.x_left() == 1){
                    int w = rand.nextInt(3);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if(w==2){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c);
                    }
                    
                }
                
                           


                
            }
            // can't go left
            else if(a.position[1] == 0){
                // 15 full scenarios
                // 1) can only move up
                if(a.y_up() == 1 && a.y_down() == 0 && a.x_right() == 0){
                    int b[] = {a.position[0]-1,a.position[1]};
                    Maze c = new Maze(b);
                    go(c);
            }
                // 2) can only move down
                else if(a.y_up() == 0 && a.y_down() == 1 && a.x_right() == 0){
                    int b[] = {a.position[0]+1,a.position[1]};
                    Maze c = new Maze(b);
                    go(c);
            }
               // 3) can only move right
                else if(a.y_up() == 0 && a.y_down() == 0 && a.x_right() == 1){
                    int b[] = {a.position[0],a.position[1]+1};
                    Maze c = new Maze(b);
                    go(c);
            } 
                               // 6) 2 possible moves, 2
                else if(a.y_up() == 1 && a.y_down() == 1 && a.x_right() == 0){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                // 7) 2 possible moves, 3
                else if(a.y_up() == 1 && a.y_down() == 0 && a.x_right() == 1){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                               
                // 9) 2 possible moves, 5
                else if(a.y_up() == 0 && a.y_down() == 1 && a.x_right() == 1){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                               
              
                
                             // 14) 3 possible moves, 4
                else if(a.y_up() == 1 && a.y_down() == 1 && a.x_right() == 1){
                    int w = rand.nextInt(3);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if(w==2){
                        int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);
                    }
                    
                }
                
             


               
            }
            // can't go right
            else if(a.position[1] == (11)){
                 // 15 full scenarios
                // 1) can only move up
                if(a.y_up() == 1 && a.y_down() == 0 && a.x_left() == 0){
                    int b[] = {a.position[0]-1,a.position[1]};
                    Maze c = new Maze(b);
                    go(c);
            }
                // 2) can only move down
                else if(a.y_up() == 0 && a.y_down() == 1 && a.x_left() == 0){
                    int b[] = {a.position[0]+1,a.position[1]};
                    Maze c = new Maze(b);
                    go(c);
            }
                               // 4) can only move left
                else if(a.y_up() == 0 && a.y_down() == 0 && a.x_left() == 1){
                    int b[] = {a.position[0],a.position[1]-1};
                    Maze c = new Maze(b);
                    go(c);
            } 
                                 // 6) 2 possible moves, 2
                else if(a.y_up() == 1 && a.y_down() == 1 && a.x_left() == 0){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                               // 8) 2 possible moves, 4
                else if(a.y_up() == 1 && a.y_down() == 0 && a.x_left() == 1){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                
                              // 10) 2 possible moves, 6
                else if(a.y_up() == 0 && a.y_down() == 1 && a.x_left() == 1){
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                
                        
           
                // 13) 3 possible moves, 3
                else if(a.y_up() == 1 && a.y_down() == 1 && a.x_left() == 1){
                    int w = rand.nextInt(3);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if(w==2){
                        int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);
                    }
                    
                }
            }

                
            
            else if(a.position[0] != 0 && a.position[0] != 11 && a.position[1] != 0 && a.position[1] != 11){
                // 15 full scenarios
                // 1) can only move up
                if(a.y_up() == 1 && a.y_down() == 0 && a.x_right() == 0 && a.x_left() == 0){
                   
                    int b[] = {a.position[0]-1,a.position[1]};
                    Maze c = new Maze(b);
                    go(c);
            }
                // 2) can only move down
                else if(a.y_up() == 0 && a.y_down() == 1 && a.x_right() == 0 && a.x_left() == 0){
                   
                    int b[] = {a.position[0]+1,a.position[1]};
                    Maze c = new Maze(b);
                    go(c);
            }
               // 3) can only move right
                else if(a.y_up() == 0 && a.y_down() == 0 && a.x_right() == 1 && a.x_left() == 0){

                    int b[] = {a.position[0],a.position[1]+1};
                    Maze c = new Maze(b);
                    go(c);
            } 
                // 4) can only move left
                else if(a.y_up() == 0 && a.y_down() == 0 && a.x_right() == 0 && a.x_left() == 1){
                    
                    int b[] = {a.position[0],a.position[1]-1};
                    Maze c = new Maze(b);
                    go(c);
            } 
                 // 5) 2 possible moves, 1
                else if(a.y_up() == 0 && a.y_down() == 0 && a.x_right() == 1 && a.x_left() == 1){
                    
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                // 6) 2 possible moves, 2
                else if(a.y_up() == 1 && a.y_down() == 1 && a.x_right() == 0 && a.x_left() == 0){
                    ;
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if(w==1){
                        int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                // 7) 2 possible moves, 3
                else if(a.y_up() == 1 && a.y_down() == 0 && a.x_right() == 1 && a.x_left() == 0){
                   
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                // 8) 2 possible moves, 4
                else if(a.y_up() == 1 && a.y_down() == 0 && a.x_right() == 0 && a.x_left() == 1){
                  
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                
                // 9) 2 possible moves, 5
                else if(a.y_up() == 0 && a.y_down() == 1 && a.x_right() == 1 && a.x_left() == 0){
                  
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                // 10) 2 possible moves, 6
                else if(a.y_up() == 0 && a.y_down() == 1 && a.x_right() == 0 && a.x_left() == 1){
                   
                    int w = rand.nextInt(2);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
                }
                
                // 11) 3 possible moves, 1
                else if(a.y_up() == 0 && a.y_down() == 1 && a.x_right() == 1 && a.x_left() == 1){
                   
                    int w = rand.nextInt(3);
                    if(w == 0){
                       int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if(w==2){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c);
                    }
                    
                }
                // 12) 3 possible moves, 2
                else if(a.y_up() == 1 && a.y_down() == 0 && a.x_right() == 1 && a.x_left() == 1){
                   
                    int w = rand.nextInt(3);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if(w==2){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c);
                    }
                    
                }
                
                // 13) 3 possible moves, 3
                else if(a.y_up() == 1 && a.y_down() == 1 && a.x_right() == 0 && a.x_left() == 1){
                   
                    int w = rand.nextInt(3);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if(w==2){
                        int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);
                    }
                    
                }
                // 14) 3 possible moves, 4
                else if(a.y_up() == 1 && a.y_down() == 1 && a.x_right() == 1 && a.x_left() == 0){
                    
                    int w = rand.nextInt(3);
                    if(w == 0){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);  
                    }
                    else if (w==1){
                        int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if(w==2){
                        int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);
                    }
                    
                }
                
                // 15) 4 possible moves
                    else if(a.y_up() == 1 && a.y_down() == 1 && a.x_right() == 1 && a.x_left() == 1){
                      
                    int z = rand.nextInt(4);
                    if(z == 0){
                        int b[] = {a.position[0]+1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c);
                    }
                    else if (z== 1){
                       int b[] = {a.position[0]-1,a.position[1]};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if (z== 2){
                       int b[] = {a.position[0],a.position[1]+1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    else if (z== 3){
                       int b[] = {a.position[0],a.position[1]-1};
                        Maze c = new Maze(b);
                        go(c); 
                    }
                    
            } 
                
            }
            else{
                System.out.println(a.position[0] + " - " + a.position[1]);
            }
            
            
            
        }
        System.out.println("Finished");
        System.out.println("The finish is at location: Row:" + a.position[0] + " Column:" + a.position[1]);
        java.lang.System.exit(0);
    }

    }


