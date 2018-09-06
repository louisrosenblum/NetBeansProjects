/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package politics;

/**
 *
 * @author Louis
 */
public class List {
    int count;
    Node[] dude;
    
    // Constructer method to make and link list
    List(int a, int b){
        count = b;
       dude = new Node[b];
        
        for(int i = 1; i<=b; i++){
            dude[i-1] = new Node(i);
        }
        for(int i = 1; i<=b; i++){
            if(i==1){
            dude[i-1].set_next(dude[i]);
            dude[i-1].set_back(dude[b-1]);
            }
            else if (i==b){
            dude[i-1].set_next(dude[0]);
            dude[i-1].set_back(dude[i-2]);    
            }
            else{
                dude[i-1].set_next(dude[i]);
                dude[i-1].set_back(dude[i-2]);
            }
        }
    }
    
    public void print(){
        for(int i=0; i<count; i++){
            
        }
    }
}
