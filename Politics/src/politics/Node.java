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
public class Node {
    int num;
    Node next;
    Node back;
    
    Node(int a){
        num = a;
    }
    
    public void set_next(Node a){
        next = a;
    }
    
    public void set_back(Node a){
        back = a;
    }
    public Node get_next(){
        return next;
    }
    
    public Node get_back(){
        return back;
    }
    
    public int get_num(){
        return num;
    }
    
    public void print(){
        System.out.println(this.num);
    }
}
