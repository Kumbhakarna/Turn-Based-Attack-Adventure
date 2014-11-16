import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JApplet;
import java.awt.*; 
import java.net.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Graphics2D;
import java.awt.image.*;

public class TurnBased extends Applet
    implements MouseListener, MouseMotionListener {
    
    int width, height;
    ChoosenOne player = new ChoosenOne();
    boolean message1 = true;
    boolean message0 = true;
    boolean message2 = true;
    boolean mouseIn = false;
    boolean choosingClass = true;
    boolean mageDscpt;
    boolean warriorDscpt;
    boolean rangerDscpt;
    Image image;
    Graphics graphics;
    BufferedImage magePhoto = null;
    BufferedImage warriorPhoto = null;
    BufferedImage rangerPhoto = null;
    Scanner scan = new Scanner(System.in);
    int mouseX = -1000, mouseY = -1000;  // the mouse coordinates
    boolean isButtonPressed = false;
    int control = 0;
    
    Rectangle message1Box = new Rectangle(301,31,19,16);
    Rectangle message2Box;
    Rectangle warrior = new Rectangle(50,50,75,50);
    Rectangle ranger = new Rectangle(150,50,75,50);
    Rectangle mage = new Rectangle(250,50,75,50);
    
    public void init() {
        if (control == 0)
            setBackground(Color.BLACK);
        control++;
        addMouseListener( this );
        addMouseMotionListener( this );
    }
    
    public void mouseEntered( MouseEvent e ) {
        mouseIn = true;
    }
    public void mouseExited( MouseEvent e ) {
        mouseIn = false;
    }
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if (message1 && mouseIn && mage.contains(mouseX,mouseY)) {
            player.setType("mage");
            message1 = false;
        }
        if (message1 && mouseIn && mage.contains(mouseX,mouseY)) {
            player.setType("warrior");
            message1 = false;
        }
        if (message1 && mouseIn && mage.contains(mouseX,mouseY)) {
            player.setType("ranger");
            message1 = false;
        }
    }
    public void mousePressed( MouseEvent e ) {  // called after a button is pressed down
        repaint();
        e.consume();
    }
    public void mouseReleased( MouseEvent e ) {  
        repaint();
        e.consume();
    }
    public void mouseMoved( MouseEvent e ) {  
        mouseX = e.getX();
        mouseY = e.getY();
        if (mouseIn && mage.contains(mouseX,mouseY)) {
            mageDscpt = true;
        }
        if (mouseIn && warrior.contains(mouseX,mouseY)) {
            warriorDscpt = true;
        }
        if (mouseIn && ranger.contains(mouseX,mouseY)) {
            rangerDscpt = true;
        }
        
        repaint();
        e.consume();
    }
    public void mouseDragged( MouseEvent e ) {  // called during motion with buttons down
        mouseX = e.getX();
        mouseY = e.getY();
        System.out.println( "Mouse at (" + mouseX + "," + mouseY + ")" );
        repaint();
        e.consume();
    }
    
    public void delay(int time) {
        try {
            Thread.sleep(time);
        }
        catch (Exception e) {
        }
    }
    public void imageCreater(Graphics g) {
          try {
            URL u = new URL(getCodeBase(), "Mage.png");
            magePhoto = ImageIO.read(u);
        }   catch (IOException e) {
            g.drawString("Problem reading the file", 100, 100);
        }
        try {
            URL u = new URL(getCodeBase(), "Warrior.png");
            warriorPhoto = ImageIO.read(u);
        }   catch (IOException e) {
            g.drawString("Problem reading the file", 100, 100);
        }
        try {
            URL u = new URL(getCodeBase(), "Ranger.png");
            rangerPhoto = ImageIO.read(u);
        }   catch (IOException e) {
            g.drawString("Problem reading the file", 100, 100);
        }
    }
    
    public void clear() {
        setBackground(Color.BLACK);
    }
    public void paint(Graphics g) {
        imageCreater(g);
        if (message0) {
            g.setColor(Color.WHITE);
            g.drawString("Please enter your name", 25,25);
            try {
                player.setName(scan.nextLine());
            }
            catch (Exception e) {
                player.setName("Zero");
                repaint();
                return;
            }
            if (player.getName().length() > 0)
                message0 = false;
        } else {
            if (message1) {
                clear();
                g.setColor(Color.WHITE);
                g.drawString("Please choose your class:", 25,25);
                g.setColor(new Color(200,40,40));
                g.fillRect(50,50,75,50);
                g.setColor(Color.WHITE);
                g.drawString("WARRIOR",57,77);
                g.drawString("WARRIOR",57,78);
                g.setColor(Color.GREEN);
                g.fillRect(150,50,75,50);
                g.setColor(new Color(90,90,10));
                g.drawString("RANGER",159,77);
                g.drawString("RANGER",159,78);
                g.setColor(new Color(40,40,200));
                g.fillRect(250,50,75,50);

                g.setColor(new Color(200,200,20));
                g.drawString("MAGE",270,78);
                g.drawString("MAGE",270,79);
                if (mageDscpt) {
                    g.drawString("A Master of all things arcane, Intellect",25,210);
                    g.drawImage(magePhoto,25,100,100,100,null);
                    g.drawString("guides this sorcerer through the evil ahead.",25,220);
                    delay(400);
                    clear();
                    mageDscpt = false;
                }
                if (warriorDscpt) {
                    g.drawImage(warriorPhoto,25,100,100,100,null);
                    g.drawString("A Man broken down, with nothing to lose,",25,210);
                    g.drawString("is ready to use his brute strength to ",25,220);
                    g.drawString("destroy all evils ahead.",25,230);
                     delay(400);
                    clear();
                    warriorDscpt = false;
                }
                if (rangerDscpt) {
                    g.drawImage(rangerPhoto,25,100,100,100,null);
                    g.drawString("Once hailed as the greatest archerer of ",25,210);
                    g.drawString("all the land, he is forced in hiding from the world,",25,220);
                    g.drawString("faced now with the evils ahead as a falsely accused man.",25,230);
                     delay(400);
                    clear();
                    rangerDscpt = false;
                }
                        
                                     
                                     
            }
            
        else {
            if (message2) {
                g.setColor(Color.WHITE);
                g.drawString("It's Time..", 25,25);
                g.setColor(Color.RED);
                g.drawRect(300,30,20,17);
                g.setColor(Color.WHITE);
                g.fillRect(301,31,19,16);
                g.setColor(Color.BLUE);
                g.drawString("Ok",302,42);
                //if (player.
            }
            else {
                clear();
                g.setColor(Color.WHITE);
                g.drawString("You are the choosen one.",25,25);
            }
        }
        }
    }
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            graphics = image.getGraphics();
        }
        graphics.setColor(getBackground());
        graphics.fillRect(0,  0,  this.getWidth(),  this.getHeight());
        graphics.setColor(getForeground());
        paint(graphics);
        g.drawImage(image, 0, 0, this);
    }
    }
