
import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bgouge01
 */
public class Exo02_Figure extends JComponent {

    public enum Shape {PLAY, PAUSE};
    private Shape shape;
    //private int size;
    
    /**
     *
     * @param shape : shape in the carré poto
     * @param size : size in pixel of the square
     */
    public Exo02_Figure(Shape shape, int size) {
        super();
        this.setPreferredSize(new Dimension(size, size));
        this.setBackground(Color.MAGENTA);
        this.setForeground(Color.MAGENTA);
        this.shape = shape;
    }
    
    public Exo02_Figure(Shape shape, int size, Color color) {
        super();
        this.setPreferredSize(new Dimension(size, size));
        this.setBackground(Color.MAGENTA);
        this.setForeground(color);
        this.shape = shape;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int sizeH = this.getSize().height;
        int sizeW = this.getSize().width;
        
        switch (this.shape) {
            case PLAY :
                int playX[] = {sizeW/5,sizeW/5,sizeW*4/5};
                int playY[] = {sizeH/5,sizeH*4/5,sizeH/2};
                Polygon play = new Polygon(playX, playY, 3);
                g.fillPolygon(play);
                break;
            case PAUSE :
                g.fillRect(sizeW/5, sizeH/5, sizeW/5, sizeH*3/5);
                g.fillRect(sizeW*3/5, sizeH/5, sizeW/5, sizeH*3/5);
                break;
            default :
                break;
        }
        
        //g.drawRect(WIDTH, WIDTH, WIDTH, HEIGHT);
    }
    
    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Exo02_Figure playComp = new Exo02_Figure(Shape.PLAY, 100, Color.GREEN);
        Exo02_Figure pauseComp = new Exo02_Figure(Shape.PAUSE, 100, Color.CYAN);
        
        Box myBox = Box.createHorizontalBox();
        myBox.add(playComp);
        myBox.add(pauseComp);
        myFrame.add(myBox);
        myFrame.setVisible(true);
        myFrame.pack();
    }
}
