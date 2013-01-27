/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyself;
import java.applet.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.util.Random;
/**
 *
 * @author catfriedrice
 */

public class Background extends Sprite implements Common {

    
    private final String bg1 = "Vein_LG_01.png";
    private final String bg2 = "Vein_LG_02.png";
    private final String bg3 = "Vein_MD_01.png";
    private final String bg4 = "Vein_MD_02.png";
    private final String bg5 = "Vein_SM_01.png";
    private final String bg6 = "Vein_SM_02.png";

    int p = 0;
    

    
    public Background () {
        ImageIcon r;
          r = new ImageIcon(this.getClass().getResource(bg1));
          
          setImage(r.getImage());
          setX(0);
          setY(0);
          r = new ImageIcon(this.getClass().getResource(bg6));
              
          setImage(r.getImage());
          setX(600);
          setY(0);
          p = 1;
 
    }
    public void act() {
        ImageIcon s;
            if (p >= 1200) {

                Random generator = new Random();
                int x = generator.nextInt(6);
                System.out.println(x);
                switch (x) {
                    case 0:
                       s = new ImageIcon(this.getClass().getResource(bg1));
                        break;
                    case 1:
                        s = new ImageIcon(this.getClass().getResource(bg2));
                        break;
                    case 2:
                        s = new ImageIcon(this.getClass().getResource(bg3));
                        break;
                    case 3:
                        s = new ImageIcon(this.getClass().getResource(bg4));
                        break;
                    case 4:
                        s = new ImageIcon(this.getClass().getResource(bg5));
                        break;
                    case 5:
                        s = new ImageIcon(this.getClass().getResource(bg6));
                        break;
                    default:
                        s = new ImageIcon(this.getClass().getResource(bg1));
                        break;
                }
                setImage(s.getImage());
                setX(600);
                setY(0);
                p = 1;
            
            }
        x -= 1;
        p++;
        setX(x);
        setY(y);

    }

}
