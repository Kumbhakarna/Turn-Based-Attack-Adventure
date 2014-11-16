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

public class ChoosenOne {
        private String name;
        private String type;
        private BufferedImage photo;
        public ChoosenOne() {
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        public String getType() {
            return type;
        }
        
        public BufferedImage getPhoto() {
            return photo;
        }
        
        public void setType(String type) {
            this.type = type;
        }
        
        public void setPhoto(BufferedImage photo) {
            this.photo = photo;
        }
    }
    