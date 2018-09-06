/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp;

/*
 *Hunter Lloyd
 * Copyrite.......I wrote, ask permission if you want to use it outside of class. 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.PixelGrabber;
import java.awt.image.MemoryImageSource;
import java.util.Arrays;
import java.util.Stack;

class IMP implements MouseListener{
   JFrame frame;
   JPanel mp;
   JButton start;
   JScrollPane scroll;
   JMenuItem openItem, exitItem, resetItem;
   Toolkit toolkit;
   File pic;
   ImageIcon img;
   int colorX, colorY;
   int [] pixels;
   int [] results;
   //Instance Fields you will be using below
   
   //This will be your height and width of your 2d array
   int height=0, width=0;
   
   //your 2D array of pixels
    int picture[][];

    /* 
     * In the Constructor I set up the GUI, the frame the menus. The open pulldown 
     * menu is how you will open an image to manipulate. 
     */
   IMP()
   {
      toolkit = Toolkit.getDefaultToolkit();
      frame = new JFrame("Image Processing Software by Hunter");
      JMenuBar bar = new JMenuBar();
      JMenu file = new JMenu("File");
      JMenu functions = getFunctions();
      frame.addWindowListener(new WindowAdapter(){
            @Override
              public void windowClosing(WindowEvent ev){quit();}
            });
      openItem = new JMenuItem("Open");
      openItem.addActionListener(new ActionListener(){
            @Override
          public void actionPerformed(ActionEvent evt){ handleOpen(); }
           });
      resetItem = new JMenuItem("Reset");
      resetItem.addActionListener(new ActionListener(){
            @Override
          public void actionPerformed(ActionEvent evt){ reset(); }
           });     
      exitItem = new JMenuItem("Exit");
      exitItem.addActionListener(new ActionListener(){
            @Override
          public void actionPerformed(ActionEvent evt){ quit(); }
           });
      file.add(openItem);
      file.add(resetItem);
      file.add(exitItem);
      bar.add(file);
      bar.add(functions);
      frame.setSize(600, 600);
      mp = new JPanel();
      mp.setBackground(new Color(0, 0, 0));
      scroll = new JScrollPane(mp);
      frame.getContentPane().add(scroll, BorderLayout.CENTER);
      JPanel butPanel = new JPanel();
      butPanel.setBackground(Color.black);
      start = new JButton("start");
      start.setEnabled(false);
      start.addActionListener(new ActionListener(){
            @Override
          public void actionPerformed(ActionEvent evt){ fun2(); }
           });
      butPanel.add(start);
      frame.getContentPane().add(butPanel, BorderLayout.SOUTH);
      frame.setJMenuBar(bar);
      frame.setVisible(true);      
   }
   
   /* 
    * This method creates the pulldown menu and sets up listeners to selection of the menu choices. If the listeners are activated they call the methods 
    * for handling the choice, fun1, fun2, fun3, fun4, etc. etc. 
    */
   
  private JMenu getFunctions()
  {
     JMenu fun = new JMenu("Functions");
     JMenuItem firstItem = new JMenuItem("MyExample - fun1 method");
    
     firstItem.addActionListener(new ActionListener(){
            @Override
          public void actionPerformed(ActionEvent evt){fun1();}
           });
        
      //fun.add(firstItem);
      
       
      
      fun.add(firstItem);
      
      return fun;   

  }
  
  /*
   * This method handles opening an image file, breaking down the picture to a one-dimensional array and then drawing the image on the frame. 
   * You don't need to worry about this method. 
   */
    private void handleOpen()
  {  
     img = new ImageIcon();
     JFileChooser chooser = new JFileChooser();
     int option = chooser.showOpenDialog(frame);
     if(option == JFileChooser.APPROVE_OPTION) {
       pic = chooser.getSelectedFile();
       img = new ImageIcon(pic.getPath());
      }
     width = img.getIconWidth();
     height = img.getIconHeight(); 
     
     JLabel label = new JLabel(img);
     label.addMouseListener(this);
     pixels = new int[width*height];
     
     results = new int[width*height];
  
          
     Image image = img.getImage();
        
     PixelGrabber pg = new PixelGrabber(image, 0, 0, width, height, pixels, 0, width );
     try{
         pg.grabPixels();
     }catch(InterruptedException e)
       {
          System.err.println("Interrupted waiting for pixels");
          return;
       }
     for(int i = 0; i<width*height; i++)
        results[i] = pixels[i];  
     turnTwoDimensional();
     mp.removeAll();
     mp.add(label);
     
     mp.revalidate();
  }
  
  /*
   * The libraries in Java give a one dimensional array of RGB values for an image, I thought a 2-Dimensional array would be more usefull to you
   * So this method changes the one dimensional array to a two-dimensional. 
   */
  private void turnTwoDimensional()
  {
     picture = new int[height][width];
     for(int i=0; i<height; i++)
       for(int j=0; j<width; j++)
          picture[i][j] = pixels[i*width+j];
      
     
  }
  /*
   *  This method takes the picture back to the original picture
   */
  private void reset()
  {
        for(int i = 0; i<width*height; i++)
             pixels[i] = results[i]; 
       Image img2 = toolkit.createImage(new MemoryImageSource(width, height, pixels, 0, width)); 

      JLabel label2 = new JLabel(new ImageIcon(img2));    
       mp.removeAll();
       mp.add(label2);
     
       mp.revalidate(); 
    }
  /*
   * This method is called to redraw the screen with the new image. 
   */
  private void resetPicture()
  {
       for(int i=0; i<height; i++)
       for(int j=0; j<width; j++)
          pixels[i*width+j] = picture[i][j];
      Image img2 = toolkit.createImage(new MemoryImageSource(width, height, pixels, 0, width)); 

      JLabel label2 = new JLabel(new ImageIcon(img2));    
       mp.removeAll();
       mp.add(label2);
     
       mp.revalidate(); 
   
    }
    /*
     * This method takes a single integer value and breaks it down doing bit manipulation to 4 individual int values for A, R, G, and B values
     */
  private int [] getPixelArray(int pixel)
  {
      int temp[] = new int[4];
      temp[0] = (pixel >> 24) & 0xff;
      temp[1]   = (pixel >> 16) & 0xff;
      temp[2] = (pixel >>  8) & 0xff;
      temp[3]  = (pixel      ) & 0xff;
      return temp;
      
    }
    /*
     * This method takes an array of size 4 and combines the first 8 bits of each to create one integer. 
     */
  private int getPixels(int rgb[])
  {
         int alpha = 0;
         int rgba = (rgb[0] << 24) | (rgb[1] <<16) | (rgb[2] << 8) | rgb[3];
        return rgba;
  }
  
  public void getValue()
  {
      int pix = picture[colorY][colorX];
      int temp[] = getPixelArray(pix);
      System.out.println("Color value " + temp[0] + " " + temp[1] + " "+ temp[2] + " " + temp[3]);
    }
  
  /**************************************************************************************************
   * This is where you will put your methods. Every method below is called when the corresponding pulldown menu is 
   * used. As long as you have a picture open first the when your fun1, fun2, fun....etc method is called you will 
   * have a 2D array called picture that is holding each pixel from your picture. 
   *************************************************************************************************/
   /*
    * Example function that just removes all red values from the picture. 
    * Each pixel value in picture[i][j] holds an integer value. You need to send that pixel to getPixelArray the method which will return a 4 element array 
    * that holds A,R,G,B values. Ignore [0], that's the Alpha channel which is transparency, we won't be using that, but you can on your own.
    * getPixelArray will breaks down your single int to 4 ints so you can manipulate the values for each level of R, G, B. 
    * After you make changes and do your calculations to your pixel values the getPixels method will put the 4 values in your ARGB array back into a single
    * integer value so you can give it back to the program and display the new picture. 
    */
  private void fun1()
  {
     
    for(int i=0; i<height; i++)
       for(int j=0; j<width; j++)
       {   
          int rgbArray[] = new int[4];
         
          //get three ints for R, G and B
          rgbArray = getPixelArray(picture[i][j]);
         
        
           rgbArray[1] = 0;
           //take three ints for R, G, B and put them back into a single int
           picture[i][j] = getPixels(rgbArray);
        } 
     resetPicture();
  }

  /*
   * fun2
   * This is where you will write your STACK
   * All the pixels are in picture[][]
   * Look at above fun1() to see how to get the RGB out of the int (getPixelArray)
   * and then put the RGB back to an int (getPixels)
   */  
  private void fun2()
  {
      //Stack creation
      Stack<Pixel> dude = new Stack<>();
      // Int to keep track of y coordinate
      int a = colorY;
      //Int to keep track of x coordinate
      int b = colorX;
      // Color array of selected pixel
      int[] cool = getPixelArray(picture[a][b]);
      // Stored as a template
      int[] template = Arrays.copyOfRange(cool, 0, cool.length);
      
     
      // Creation of the first pixel object
      Pixel first = new Pixel(a,b);
      // Definition of color to update to
      int[] black = {255,0,0,0};
      first.count = 0;
      picture[a][b] = getPixels(black);
      resetPicture();
      dude.push(first);
      // While loop to color the shape
 while(dude.empty() != true){
      //for(int i =0; i<10000; i++){
      // Check current y and x values
      a = dude.peek().y;
      b = dude.peek().x;
      // Color top left
      if ((getPixelArray(picture[a-1][b-1])[1] < template[1]+31 && getPixelArray(picture[a-1][b-1])[1] > template[1]-31 ) && (getPixelArray(picture[a-1][b-1])[2] < template[2]+31 && getPixelArray(picture[a-1][b-1])[2] > template[1]-31 ) && (getPixelArray(picture[a-1][b-1])[3] < template[3]+31 && getPixelArray(picture[a-1][b-1])[3] > template[3]-31 )){
              
                  Pixel top_left = new Pixel(a-1,b-1);
              a = a - 1;
              b = b - 1;
              picture[a][b] = getPixels(black);
              dude.push(top_left);}
 // Color top middle
              else if ((getPixelArray(picture[a-1][b])[1] < template[1]+31 && getPixelArray(picture[a-1][b])[1] > template[1]-31 ) && (getPixelArray(picture[a-1][b])[2] < template[2]+31&& getPixelArray(picture[a-1][b])[2] > template[1]-31) && (getPixelArray(picture[a-1][b])[3] < template[3]+31&& getPixelArray(picture[a-1][b])[3] > template[3]-31)){
              Pixel top_middle = new Pixel(a-1,b);
              a = a - 1;
              picture[a][b] = getPixels(black);

              dude.push(top_middle);
              }

 // Color top right
               else if ((getPixelArray(picture[a-1][b+1])[1] < template[1]+31&& getPixelArray(picture[a-1][b+1])[1] > template[1]-31) && (getPixelArray(picture[a-1][b+1])[2] < template[2]+31&& getPixelArray(picture[a-1][b+1])[2] > template[2]-31) && (getPixelArray(picture[a-1][b+1])[3] < template[3]+31&& getPixelArray(picture[a-1][b+1])[3] > template[3]-31)){
              Pixel top_right = new Pixel(a-1, b+1);
              a = a - 1;
              b = b + 1;
              picture[a][b] = getPixels(black);
              dude.push(top_right);
               }
                
       // Color middle left
               else if ((getPixelArray(picture[a][b-1])[1] < template[1]+31&& getPixelArray(picture[a][b-1])[1] > template[1]-31) && (getPixelArray(picture[a][b-1])[2] < template[2]+31&& getPixelArray(picture[a][b-1])[2] > template[2]-31) && (getPixelArray(picture[a][b-1])[3] < template[3]+31&& getPixelArray(picture[a][b-1])[3] > template[3]-31)){
              Pixel middle_left = new Pixel(a,b-1);
              b = b - 1;
              picture[a][b] = getPixels(black);

              dude.push(middle_left);
          }
      
          // Color middle right
               else if ((getPixelArray(picture[a][b+1])[1] < template[1]+31&& getPixelArray(picture[a][b+1])[1] > template[1]-31) && (getPixelArray(picture[a][b+1])[2] < template[2]+31&& getPixelArray(picture[a][b+1])[2] > template[2]-31) && (getPixelArray(picture[a][b+1])[3] < template[3]+31&& getPixelArray(picture[a][b+1])[3] > template[3]-31)){
              Pixel middle_right = new Pixel(a,b+1);
              b = b + 1;
              picture[a][b] = getPixels(black);
              dude.push(middle_right);
          }

        
              // Color bottom left
               else if ((getPixelArray(picture[a+1][b-1])[1] < template[1]+31&& getPixelArray(picture[a+1][b-1])[1] > template[1]-31) && (getPixelArray(picture[a+1][b-1])[2] < template[2]+31&& getPixelArray(picture[a+1][b-1])[2] > template[2]-31) && (getPixelArray(picture[a+1][b-1])[3] < template[3]+31&& getPixelArray(picture[a+1][b-1])[3] > template[3]-31)){
              Pixel bot_left = new Pixel(a+1,b-1);
              a = a + 1;
              b = b - 1;
              picture[a][b] = getPixels(black);

              dude.push(bot_left);
          }

          
       // Color bottom middle
               else if ((getPixelArray(picture[a+1][b])[1] < template[1]+31&& getPixelArray(picture[a+1][b])[1] > template[1]-31) && (getPixelArray(picture[a+1][b])[2] < template[2]+31&& getPixelArray(picture[a+1][b])[2] > template[2]-31) && (getPixelArray(picture[a+1][b])[3] < template[3]+31&& getPixelArray(picture[a+1][b])[3] > template[3]-31)){
              Pixel bot_middle = new Pixel (a+1, b);
              a = a + 1;
              picture[a][b] = getPixels(black);

              dude.push(bot_middle);
          }
// Color bottom right
               else if ((getPixelArray(picture[a+1][b+1])[1] < template[1]+31&& getPixelArray(picture[a+1][b+1])[1] > template[1]-31) && (getPixelArray(picture[a+1][b+1])[2] < template[2]+31&& getPixelArray(picture[a+1][b+1])[2] > template[2]-31) && (getPixelArray(picture[a+1][b+1])[3] < template[3]+31&& getPixelArray(picture[a+1][b+1])[3] > template[3]-31)){
              Pixel bot_right = new Pixel (a+1, b+1);
              a = a + 1;
              b = b + 1;
              picture[a][b] = getPixels(black);
              dude.push(bot_right);
          }
               // Color check fails, go back to the previous pixel and work from there
               else{
             dude.pop();
             
      }
      // Current pixel being painted
      System.out.println(a + "  ---  " + b);
      
      }
 // Reset the image
      resetPicture();


      
  }












  
 
  
 
  private void quit()
  {  
     System.exit(0);
  }

    @Override
   public void mouseEntered(MouseEvent m){}
    @Override
   public void mouseExited(MouseEvent m){}
    @Override
   public void mouseClicked(MouseEvent m){
        colorX = m.getX();
        colorY = m.getY();
        System.out.println(colorX + "  " + colorY);
        getValue();
        start.setEnabled(true);
    }
    @Override
   public void mousePressed(MouseEvent m){}
    @Override
   public void mouseReleased(MouseEvent m){}
   
   public static void main(String [] args)
   {
      IMP imp = new IMP();
   }
 
}
