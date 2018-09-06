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
public class Node {
    private int id;
    private String first;
    private String last;
    Node next = null;
    Node back = null;
    
    Node(){
        id = 1;
        first = "Huey";
        last = "Louie";
    }
    // Main node constructor
    Node(int a, String b, String c){
        id = a;
        first = b;
        last = c;
    }
    // Method to get next node 
    public Node get_next(){
        return(next);
    }
    // Method to get previous node
    public Node get_back(){
        return(back);
    }
    // Method to set next node
    public void set_next(Node w){
        next = w;
    }
    // Method to set previous node
    public void set_back(Node w){
        back = w;
    }
    // Method to print node info
    public void print(){
       
        System.out.println(id + " " + first + " " + last);
        
    }
    // Method to retrieve node id
    public int get_id(){
        return(id);
    }
    // Method to retrieve name
    public String get_first(){
        return(first);
    }
    // Method to retrieve name
    public String get_last(){
        return(last);
    }
    
}
