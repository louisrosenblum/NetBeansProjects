/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_lab;

/**
 *
 * @author Louis
 */
public class List {
    Node first;
    Node iter;
    
    List(){
        first = null;
    }
    
    List(Node w){
        first = w;
    }
    
    // Method to add new item to back of list
    public void addback(Node w){
        iter = first;
        while(iter.get_next() != null){
            iter = iter.get_next();
        }
        iter.set_next(w);
    }
    // Method to remove item from list by ID
    public void delete(int a){
        iter = first;
        Node back;
        
        
        
        if(iter.get_id() == a){
            first = first.get_next();
        }
        
        do{
        back = iter;
        iter = iter.get_next();
        if (iter.get_id() == a && (iter.get_next() != null)){
            back.set_next(iter.get_next());
        } 
        }while(iter.get_next() != null);
        
        if(iter.get_next() == null){
            if(iter.get_id() == a){
                back.set_next(null);
                
            }
        }
       
    }
    // Method to print a list
    public void print(){
        iter = first;
        if(first != null){
        while (iter.get_next() != null){
            iter.print();
            iter = iter.get_next();
        }
        iter.print();
        }
        
    }
    // Method to print a list in reverse
    public void print_back(){
        iter = first;
        
        while(iter.get_next() != null){
           iter.get_next().set_back(iter);
           iter = iter.get_next();
           
    }
        
        while(iter.get_back() != null){
            iter.print();
            iter = iter.get_back();
        }
        
        iter.print();
        
    }
}
