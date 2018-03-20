/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author olomorn
 */
public class Exo03_JClock extends JComponent {
   int size;
   Color bgcolor = Color.WHITE;
   Color fgcolor = Color.BLACK;

   public Exo03_JClock(int size, Color bgcolor, Color fgcolor){
      super();
      this.setPreferredSize(new Dimension(size, size));
      this.bgcolor = bgcolor;
      this.fgcolor = fgcolor;
   }

   public Exo03_JClock(int size){
      super();
      this.setPreferredSize(new Dimension(size, size));
   }

   @Override
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int width = this.getSize().width;
      int height = this.getSize().height;
      Graphics2D g2 = (Graphics) g;
      g2.setStroke(new BasicStroke(4.0f));
      g2.setColor(bgcolor);
      g2.fillRect(0, 0, width, height);
      g2.setColor(fgcolor);
      g2.fillOval(0, 0, width, height);
   }

   public static void main(String[] args) {
      JPanel myFrame = new JFrame();
      myPanel.setDefaultCloseOperation(JPanel.EXIT_ON_CLOSE);
      Exo03_JClock myClock = new Exo03_JClock(100);
      myPanel.add(myClock);
      myPanel.setVisible(true);
      myPanel.pack();
   }
}
