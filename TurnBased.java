import java.applet.Applet;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class TurnBased extends Applet implements MouseListener{
    Rectangle okBox;
    Boolean okBoxChecker = false;
    public void paint(Graphics g) {
        play(g);
    }
    public void update(Graphics g, int delay) {
        try { 
            Thread.sleep(delay);
        } 
        catch (Exception e) {
        }
        clearScreen(g);
    }
    
    public void clearScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,2000,1000);
    }
    
    public void play(Graphics g) {
        beginningDialog(g);
    }
    
    public void beginningDialog(Graphics g) {
        update(g,0);
        while (!okBoxChecker) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Large",0,14));
        g.drawString("It's Time.",25,25);
        g.setColor(Color.RED);
        g.drawRect(355,50,25,25);
        okBox= new Rectangle(355,50,25,25);
        g.setColor(Color.WHITE);
        g.fillRect(356,51,23,23);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Small",0,10));
        g.drawString("OK",360,65);
        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
        }
        }
        update(g,250);
    }
    
    public void mouseClicked(MouseEvent e) {
        if (okBox.contains(e.getX(),e.getY())) {
            okBoxChecker = true;
        }
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
    
    public void mousePressed(MouseEvent e) {
    }
    
    public void mouseReleased(MouseEvent e) {
    }
        
        
}