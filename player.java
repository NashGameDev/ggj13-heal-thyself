/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyself;
import java.applet.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

/**
 *
 * @author catfriedrice
 */

public class Player extends Sprite implements Common {
    
    private final int S_X = 30;
    private final int S_Y = 200;
    
    private final String playerimg = "shipdefault.png";
    private final String playerup = "shipup.png";
    private final String playerdown = "shipdown.png";
    private int width; 
    private int height;
    

    
    public Player () {
        ImageIcon r = new ImageIcon(this.getClass().getResource(playerimg));
        Image tempimage = r.getImage();
        
        width = (r.getImage().getWidth(null))/2;
        height = (r.getImage().getHeight(null))/2;
        
        setImage(Transparency.makeColorTransparent(tempimage, new Color(0).red));
        setX(S_X);
        setY(S_Y);
        setWidth(width);
        setHeight(height);
    }
    public void act() {
        x += dx;
        y += dy;
        if (x <= LEFT_BORDER) { x = LEFT_BORDER; }
        if (x >= RIGHT_BORDER) { x = RIGHT_BORDER; }
        if (y <= TOP_VEIN) { y = TOP_VEIN; }
        if (y >= BOTTOM_VEIN) { y = BOTTOM_VEIN; }
    }
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        // key events: A = left, W = up, D = right, S = down
        if (k == KeyEvent.VK_A) {
            dx = 0 - LEFT_MOVE;
        }
        if (k == KeyEvent.VK_D) {
            dx = RIGHT_MOVE;
        }
        if (k == KeyEvent.VK_W) {
            dy = 0 - UP_MOVE;
            ImageIcon r = new ImageIcon(this.getClass().getResource(playerup));
            Image tempimage = r.getImage();
            setImage(Transparency.makeColorTransparent(tempimage, new Color(0).red));
        }
        if (k == KeyEvent.VK_S) {
            dy = DOWN_MOVE;
            ImageIcon r = new ImageIcon(this.getClass().getResource(playerdown));
        Image tempimage = r.getImage();
        setImage(Transparency.makeColorTransparent(tempimage, new Color(0).red));
        }
        
    }
    public void keyReleased (KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_A) {
            dx = 0;
        }
        if (k == KeyEvent.VK_D) {
            dx = 0;
        }
        if (k == KeyEvent.VK_W) {
            dy = 0;
            ImageIcon r = new ImageIcon(this.getClass().getResource(playerimg));
        Image tempimage = r.getImage();
        setImage(Transparency.makeColorTransparent(tempimage, new Color(0).red));
        }
        if (k == KeyEvent.VK_S) {
            dy = 0;
            ImageIcon r = new ImageIcon(this.getClass().getResource(playerimg));
        Image tempimage = r.getImage();
        setImage(Transparency.makeColorTransparent(tempimage, new Color(0).red));
        }
    }
}
