/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

/**
 *
 * @author Louis
 */
public class Baseball {

    private String name;
    public static int challenge = 3;
   
    public Baseball()
    {
        name = "Griffey Sr.";
        challenge++;
        
    }
    public Baseball(String input)
    {
        name = input;
        challenge--;
    }
/***********continued on next page********************/
    public void setName(String x)
    { 
        name = x;
    }
    public String getName()
    {
        return name;
    }

public Baseball changeName(Baseball player, Baseball catcher, int a)
  {
              a = 7;
              player = catcher;
              catcher.setName("Bemch");
              System.out.println(player.getName());    //1
              System.out.println(catcher.getName());    //2
              System.out.println(a);                    //3
              catcher = new Baseball();
              System.out.println(player.getName());    //4
              System.out.println(catcher.getName());//5
              player.setName("Rose");
              catcher = this;
              System.out.println(player.getName());    //6
              System.out.println(catcher.getName());    //7
              return player;
  }
    

    public static void main(String[] args) {
        Baseball bob = new Baseball("Louis");
        Baseball joe = new Baseball("joe");
        bob.changeName(bob,joe,5);
        System.out.println(bob.getName());
       
    }
    
}
