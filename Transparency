/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyself;
import java.awt.*;
import java.awt.image.*;
/**
 *
 * @author catfriedrice
 */

public class Transparency {
    public static Image makeColorTransparent (Image im, final Color color) {
        ImageFilter filter = new RGBImageFilter() {
            public int markerRGB = color.getRGB() | 0xFF000000;
            public final int filterRGB(int x, int y, int rgb) {
                if ( ( rgb | 0xFF000000 ) == markerRGB ) 
                {
                // Mark alpha bits as 0 == transparent
                return 0x00FFFFFF & rgb;
                }
                else {
                // nothing to do
                return rgb;
                }
            }
        };
         ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
}

 
