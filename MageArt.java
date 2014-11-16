import javax.swing.JApplet;
import java.awt.*; 
import java.net.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Graphics2D;
import java.awt.image.*;
public class MageArt extends JApplet{
    public void paint(Graphics page) {
          BufferedImage photo = null;

        try {
            URL u = new URL(getCodeBase(), "Mage.png");
            photo = ImageIO.read(u);
        }   catch (IOException e) {
            page.drawString("Problem reading the file", 100, 100);
        }

        page.drawImage(photo, 30, 50, 150, 225, null);
    }
}