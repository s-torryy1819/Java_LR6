package lr6;

import java.awt.*;
import java.awt.event.*;
 
class SimpleFrame extends Frame{
 SimpleFrame(String s){
  super(s);
  setSize(300,300);
  setVisible(true);
  addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) {
    System.exit(0);
   }
  });
 }
}
 
public class Task6 {
 
    public static void main(String[] args) {
        new SimpleFrame("Simple Frame");
    }
}
