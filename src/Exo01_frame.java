
import java.awt.*;
import java.awt.event.*;
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
public class Exo01_frame extends JFrame implements ActionListener {
    private JButton buttExit = new JButton("Exit");
    private JButton buttWipe = new JButton("Wipe");
    private Exo01_panel drawingPanel = new Exo01_panel();
    private String title = "Adobe Photoshop CC";
    
    public Exo01_frame() {
        super("Adobe® Photoshop® CC");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        //==  creation bouttons north  =========================================
        Box box_north1 = Box.createHorizontalBox();
        JButton buttRouge = new JButton("Rouge");
        JButton buttBleu  = new JButton("Bleu ");
        JButton buttGris  = new JButton("Gris ");
        
        box_north1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box_north1.add(buttRouge);
        box_north1.add(Box.createRigidArea(new Dimension(5, 5)));
        box_north1.add(buttBleu);
        box_north1.add(Box.createRigidArea(new Dimension(5, 5)));
        box_north1.add(buttGris);
        box_north1.add(Box.createHorizontalGlue());
        
        Box box_north2 = Box.createHorizontalBox();
        JButton buttTrait = new JButton("Trait");
        JButton buttCarre = new JButton("Carre");
        JButton buttCarrP = new JButton("CarrP");
        
        box_north2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box_north2.add(buttTrait);
        box_north2.add(Box.createRigidArea(new Dimension(5, 5)));
        box_north2.add(buttCarre);
        box_north2.add(Box.createRigidArea(new Dimension(5, 5)));
        box_north2.add(buttCarrP);
        box_north2.add(Box.createHorizontalGlue());
        
        buttRouge.addActionListener(this);
        buttBleu.addActionListener(this);
        buttGris.addActionListener(this);
        buttCarre.addActionListener(this);
        buttCarrP.addActionListener(this);
        buttTrait.addActionListener(this);
        
        Box box_north = Box.createVerticalBox();
        box_north.add(box_north1);
        box_north.add(box_north2);
        //======================================================================

        
        //==  creation bouttons south  =========================================
        Box box_south = Box.createHorizontalBox();
        box_south.add(Box.createHorizontalGlue());
        box_south.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        //boutton wipe
        buttWipe.addActionListener(this);
        box_south.add(buttWipe);
        box_south.add(Box.createRigidArea(new Dimension(5, 5)));
        
        //boutton exit
        box_south.add(buttExit);
        buttExit.addActionListener(this);
        //======================================================================
        
        
        //==  creation panel  ==================================================
        this.add(drawingPanel, BorderLayout.CENTER);
        drawingPanel.setBackground(Color.LIGHT_GRAY);
        //======================================================================
        
        this.add(box_north, BorderLayout.NORTH);
        this.add(box_south, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setMinimumSize(new Dimension(500, 500));
        this.pack();
    }
    
    @Override
    public void actionPerformed (ActionEvent evt) {
        JButton myButt = (JButton) evt.getSource();
        String buttText = myButt.getText();
        
        if (buttText == "Wipe") {
            this.drawingPanel.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
            //this.drawingPanel.repaint();
        } else if (buttText.equals("Exit")) {
            this.dispose();
        } else if (buttText.equals("Rouge")) {
            this.drawingPanel.setBackground(Color.RED);
        } else if (buttText.equals("Bleu ")) {
            this.drawingPanel.setBackground(Color.BLUE);
        } else if (buttText.equals("Gris ")) {
            this.drawingPanel.setBackground(Color.LIGHT_GRAY);
        } else if (buttText.equals("Trait")) {
            this.drawingPanel.setShape(1);
        } else if (buttText.equals("Carre")) {
            this.drawingPanel.setShape(2);
        } else if (buttText.equals("CarrP")) {
            this.drawingPanel.setShape(3);
        }
    }
    
    public static void main(String[] args) {
        Exo01_frame myFrame = new Exo01_frame();
    }
}
