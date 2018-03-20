/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author bgouge01
 */
public class Exo01_panel extends JPanel implements MouseListener {

    private int c1X, c1Y, c2X, c2Y;
    private boolean clic = false;
    private boolean draw = false;
    private int shape = 1;
    private Color penColor = Color.PINK;
    
    public Exo01_panel() {
        super();
        this.addMouseListener(this);
    }
    
    public void setShape(int i) {
        this.shape = i;
    }
    
    public void setPenColor(Color c){
        this.penColor = c;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (draw){
            g.setColor(this.penColor);
            switch (this.shape) {
                case 1:
                    g.drawLine(c1X, c1Y, c2X, c2Y);
                    break;
                case 2:
                    g.drawRect(c1X, c1Y, c2X-c1X, c2Y-c1Y);
                    break;
                case 3:
                    g.fillRect(c1X, c1Y, c2X-c1X, c2Y-c1Y);
                    break;
                default:
                    break;
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int cX = e.getX();
        int cY = e.getY();
        if (clic) {
            c2X = cX;
            c2Y = cY;
            clic = false;
            draw = true;
        } else {
            c1X = cX;
            c1Y = cY;
            clic = true;
            draw = false;
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
