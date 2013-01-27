/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyself;

/**
 *
 * @author catfriedrice
 */
import java.awt.*;

public class Sprite {
    protected boolean visible;
    protected boolean active;
    private Image i;
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    
    protected boolean die;
    protected int dx;
    protected int dy;
    
    public Sprite() {
        visible = true;
    }
    public void die() {
        visible = false;
    }

  
    public boolean isVisible() {
        return visible;
    }
    public void setVisible (boolean b) {
        visible = b;
    }
    public void setActive (boolean b) {
        active = b;
    }
    public void suspend () {
        setVisible(false);
        setActive(false);
    }
    public void restore () {
        setVisible(true);
        setActive(true);
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getWidth() {
        return w;
    }
    public int getHeight() {
        return h;
    }
    public void setHeight(int h) {
        this.h = h;
    }
    public void setWidth(int w) {
        this.w = w;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setImage(Image i) {
        this.i = i;
    }
    public Image getImage() {
        return i;
    }
    public void setDeath(boolean die) {
        this.die = die;
    }
    public boolean isDead() {
        return die;
    }
}
