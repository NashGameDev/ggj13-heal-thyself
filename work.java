/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyself;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Object;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.applet.Applet;
import java.net.*;
import java.applet.AudioClip;
import java.awt.Image;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;




/**
 *
 * @author catfriedrice
 */
public class Work extends JPanel implements Runnable, Common  {
    // Default Values that can be changed over time are in Common
    

    int i;
    private String gameover = "Game Over";
    private Dimension d;
    private ArrayList enemies;
    private ArrayList shotsfired;
    private Player player;

    private int HP = INIT_HP;
    private long score = 0;
    private int lives = INIT_LIVES;
    private int deaths = 0;
    
    private boolean ngame = true;
    private final String edestroy = "destroy.png";
    private final String expl = "expl.png";

    private Background background;
    
    

    int p;
    Random generator;
    
    
    private Thread a;
    
    private String S_Score = "Score";
    private String S_HP = "Health";
    

    
   
    public Work() {
        addKeyListener(new Work.TAdapter());
        setFocusable(true);
        d = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setBackground(Color.red);
        
        Init();
        setDoubleBuffered(true);
    }
    
    
    public void addNotify() {
        super.addNotify();
        Init();
    }
    
    public void music() {

            AudioStream backgroundMusic;
            AudioData musicData;
            AudioPlayer musicPlayer = AudioPlayer.player;
            ContinuousAudioDataStream loop = null;
            try {
                backgroundMusic = new AudioStream(new FileInputStream("h.wav"));
                musicData = backgroundMusic.getData();
                loop = new ContinuousAudioDataStream(musicData);
                musicPlayer.start(loop);
            } catch (IOException error) { System.out.println(error);
            }
        }
    
    public void Init() {
       
            music();
            background = new Background();
            enemies = new ArrayList();
            player = new Player();
            shotsfired = new ArrayList();
            
            if (a == null || !ngame) {
                a = new Thread(this);
                a.start();
            }
    }
        public void drawBackground (Graphics g) {
                    System.out.println(background.getX());
            g.drawImage(background.getImage(), background.getX(), background.getY(), this);
 

        }

       public void drawEnemies (Graphics g) {
            Iterator it = enemies.iterator();
            while (it.hasNext()) {
                Enemy enemy = (Enemy) it.next();
                if (enemy.isVisible()) {
                    g.drawImage (enemy.getImage(), enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight(), this);
                    
                }
                if (enemy.isDead()) {
                    enemy.die();
                }
            } 
            
        } 
        public void drawPlayer (Graphics g) {
            if (player.isVisible()) {
                g.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
            }
            if (player.isDead()){
                player.die();
                ngame = false;
            }
        }
        public void drawShot (Graphics g) {
            Iterator it = shotsfired.iterator();
            while (it.hasNext()) {
                PlayerShot shot = (PlayerShot) it.next();
                if (shot.getX() > RIGHT_BORDER - 40) {
                    shot.setDeath(true);
                }
                if (shot.isVisible()) {
                    
                    shot.setX(shot.getX() + SHOT_SPEED);
                    
                    g.drawImage (shot.getImage(), shot.getX(), shot.getY(), this);
                }
                if (shot.isDead()) {
                    shot.die();
                }
            } 
        }
        
        public void paint(Graphics g) {
            super.paint(g);
            
           // g.setColor(Color.red);
            //g.fillRect(0,0,d.width, d.height);
            
            
            if (ngame) {
                drawBackground(g);
                drawPlayer(g);
                drawEnemies(g);
                drawShot(g);
                g.setColor(Color.black);
                g.fillRect(0,0,d.width,10);
                g.fillRect(0,d.height-10,d.width,d.height);
            }
            
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        }
        public void gameOver() {
            Graphics g = this.getGraphics();
            g.setColor(Color.black);
            g.fillRect(0,0,GAME_WIDTH, GAME_HEIGHT);
            g.setColor(Color.white);
            Font f = new Font("Arial", Font.BOLD, 14);
            FontMetrics m = this.getFontMetrics(f);
            
            g.setFont(f);
            g.drawString(gameover, (GAME_WIDTH - m.stringWidth(gameover)/2), GAME_WIDTH/2);
        }
        public void animationCycle() {
            background.act();
            player.act();
            
            
            Iterator eit = enemies.iterator();
            Iterator sit = shotsfired.iterator();
            while (eit.hasNext()) {
                Enemy enemy = (Enemy) eit.next();
                int ex = enemy.getX();
                int ey = enemy.getY();
                int ew = enemy.getWidth();
                int eh = enemy.getHeight();
                while (sit.hasNext()) {
                    PlayerShot shot = (PlayerShot) sit.next();
                        int sx = shot.getX();
                        int sy = shot.getY();
                        System.out.println("sit");
                        if (enemy.isVisible() && shot.isVisible()) {
                            if ( (sx >= ex) && (sx <= ex + ew) && (sy >= ey) && (sy <= ey + eh) ) {
                                ImageIcon r = new ImageIcon(getClass().getResource(expl));
                                enemy.setImage(r.getImage());
                                enemy.setDeath(true);
                                score += 100;
                                shot.die();
                            }
                        }
                }
        
                enemy.act();
                
            }

       
            
            
        }
        
        public void run() {
            long bt, time, sleep;
            bt = System.currentTimeMillis(); 
            
            while (ngame) {
                repaint();
                animationCycle();
                
   
                generator = new Random();
                if (generator.nextInt(100) == 99) {
                    generator = new Random();
                    int tempy;
                    do {tempy= generator.nextInt(350) + 10;
                    } while (tempy > 350);
                    generator = new Random();
                    int dirx = generator.nextInt(10);
                    generator = new Random();
                    int diry = generator.nextInt(10);
                    generator = new Random();
                    Random bob = new Random();
                    int robert = bob.nextInt(2);

                    if (robert == 1) {
                        int width = (50/(generator.nextInt(10)+1)) + 30;
                        int height = width * 2;
                        Enemy enemy = new Enemy(ENEMY_X_START, tempy, dirx, diry, width, height, true, true);
                    enemies.add(enemy);
                    }
                    else {
                        int width = (50/(generator.nextInt(10)+1)) + 40;
                        int height = width * 2;
                        Enemy enemy = new Enemy(ENEMY_X_START, tempy, dirx, diry, width, height, false, true);
                    enemies.add(enemy);
                    }
                    
                    
                    
                }
                
                
                time = System.currentTimeMillis() - bt;
                sleep = INIT_DELAY - time;
                
                if (sleep < 0)  sleep = 2;
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.out.println("UhOh");
                }
                bt = System.currentTimeMillis();
            }
            gameOver();
        }
        private class TAdapter extends KeyAdapter {
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
                int x = player.getX();
                int y = player.getY();
                
                if (ngame)
                {
                    if (e.isShiftDown()) {
         
                        PlayerShot shot = new PlayerShot(player.getX(), player.getY(), 10, 10);
                        shotsfired.add(shot);
                    }
                }
            }
        }

}
