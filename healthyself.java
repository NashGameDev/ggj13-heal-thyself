/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyself;

/**
 *
 * @author catfriedrice
 */
import javax.swing.JFrame;


public class HealThyself extends JFrame implements Common {

   public HealThyself () {
       add (new Work());
       setTitle("Heal Thyself");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(GAME_WIDTH, GAME_HEIGHT);
       setLocationRelativeTo(null);
       setVisible(true);
       setResizable(false);
   }

   
   
   
    public static void main(String[] args) {
        
        new HealThyself();
        // TODO code application logic here
    }
}
    
