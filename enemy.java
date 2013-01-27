/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyself;

/**
 *
 * @author catfriedrice
 */

import javax.swing.ImageIcon;
import java.awt.*;


public class Enemy extends Sprite implements Common {
    protected int x;
    protected int y;
    protected int checky = 0;
    protected int dirx;
    protected int diry;

    protected int width;
    protected int height;
    protected boolean dir;
    private EAttack eattack;
    private final String bact = "bact.png";
    private final String virus = "virus.png";
    
    
    public Enemy (int x, int y, int dirx, int diry,  int height, int width, boolean img, boolean dir) {
        this.x = x;
        this.y = y;
        this.dirx = dirx;
        this.diry = diry;
        this.dir = dir;
        this.height = height;
        this.width = width;
        
        //eattack = new EAttack(x, y);
        
        if (img) {
        
        ImageIcon r = new ImageIcon(this.getClass().getResource(bact));
        Image tempimage = r.getImage();
        setImage(Transparency.makeColorTransparent(tempimage, new Color(0).red));
        }
        else {

        ImageIcon r = new ImageIcon(this.getClass().getResource(virus));
        Image tempimage = r.getImage();
        setImage(Transparency.makeColorTransparent(tempimage, new Color(0).red));
        }
            
        setX(x);
        setY(y);
        setHeight(height);
        setWidth(width);
    }
    
    public void act() {
        x -= dirx;
        if (dir) {
        y += diry;
        }
        else {
        y -= diry;
        }
        if (y >= BOTTOM_VEIN - height) {
            dir = !dir;

        }
        if (y <= TOP_VEIN + 10) {
            dir = !dir;

        }
        setX(x);
        setY(y);
        // System.out.println(x + " " + y + " " + changedir + " " + dir);
    }
  //  public EAttack getShot() {
  //      return eattack;
  //  }
    
    public class EAttack extends Sprite {
    /*    private final String shot = "enemyshot.png";
        private boolean die;
        public EAttack(int x, int y) {
            setDestroyed(true);
            this.x = x;
            this.y = y;
            ImageIcon r = new ImageIcon(this.getClass().getResource(shot));
            setImage(r.getImage());
        }
        public void setDestroyed(boolean die) {
            this.die = die;
        }
        public boolean isDestroyed() {
            return die;
        }
        */
    } 
}
