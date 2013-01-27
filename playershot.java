/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyself;

/**
 *
 * @author catfriedrice
 */
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
public class PlayerShot extends Sprite implements Common {
    private String shot = "shot.png";
    protected int h;
    protected int w;
    
    public PlayerShot() {
        
    }


    public PlayerShot(int x, int y, int w, int h) {

        ImageIcon r = new ImageIcon(this.getClass().getResource(shot));
        Image tempimage = r.getImage();
        setImage(Transparency.makeColorTransparent(tempimage, new Color(0).red));
        setX(x+(PLAYER_WIDTH/3)-20);
        setY(y+(PLAYER_HEIGHT/2)-65);
        this.w = w;
        this.h = h;
        setHeight(h);
        setWidth(w);

    }

}
