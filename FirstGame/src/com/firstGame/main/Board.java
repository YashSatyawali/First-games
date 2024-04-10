package com.firstGame.main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.firstGame.main.spirits.Enemy;
import com.firstGame.main.spirits.Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Board extends JPanel{      /*JPanel is used so that we can paint on the board. (print all the character , background , etc) */
    
    BufferedImage BackgroundImage;  //this is used to store image.
    Player player;
    Enemy[] enemies = new Enemy[3];
    Timer timer;//used for multithreading 
    public Board(){
        setSize(1500,820);
        loadBackgroundImage();
        player = new Player();
        loadEnemies();
        gameLoop();
        setFocusable(true);//this is so that all the key focus is on the screen. So when the keys are pressed it auto focus on the screen and the player moves.
        bindEvents();
        
    }
    public void bindEvents(){
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if(e.getKeyCode()== KeyEvent.VK_RIGHT)
                player.speed = 20;
                else if(e.getKeyCode()== KeyEvent.VK_LEFT)
                player.speed = -20;
                throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                player.speed=0;
                throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }
            
        });
    }
    private void loadEnemies(){
        int x = 500;
        int gap = 400;
        int speed = 5;
        for(int i=0;i<enemies.length;i++){
            enemies[i] = new Enemy(x,speed);
            if(speed >12)speed = 3;
            x += gap;
            speed += 3;
        }
    }
    private void printEnemies(Graphics pen){// this funcion is created so that multiple enemies can be drawn on the board.
        for(Enemy enemy: enemies){
            enemy.draw(pen);
            enemy.move();
        }
    }
    private void gameOver(Graphics pen){
            if(player.outOfScreen() == true){
                pen.setFont(new Font("times", Font.BOLD, 40));
                    pen.setColor(Color.RED);
                    pen.drawString("Game win", 1500/2, 820/2);
                    timer.stop();   
            }
            for(Enemy enemy: enemies){
                if(isCollide(enemy)){
                    pen.setFont(new Font("times", Font.BOLD, 40));
                    pen.setColor(Color.RED);
                    pen.drawString("Game Over", 1500/2, 820/2);
                    timer.stop();
                }
            }
   }
    private boolean isCollide(Enemy enemy){
        int xDis = Math.abs(player.x - enemy.x);
        int yDis = Math.abs(player.y - enemy.y);
        int maxH = Math.max(player.h, enemy.h);
        int maxW = Math.max(player.w , enemy.w);

        return xDis <= maxW-100 && yDis <= maxH-120;
    }

    private void gameLoop(){/*this is created so that we can achive multithreading and while the main thread is running simultaneously all the pictures in a gif will keep on changing */
        timer = new Timer(50, (e)->repaint()); /*here 50 is of the delay that is in milisecond. next is specified so that again again it can print the next pictur */
        timer.start();

    }
    private void loadBackgroundImage(){
        try {
            BackgroundImage = ImageIO.read(Board.class.getResource("gameBG.jpeg"));// this will be used to import the background image .
        } catch (IOException e) {       //try catch is used cause .read will thorw exception.
            System.out.println("Background image not found.");
            System.exit(1);// this will simply exit the game since the background image is notloading. status is 1 cause there is some error. if 0 that means no error.
            // TODO: handle exception
            e.printStackTrace();//this will tell where the problem occured.
        }
        
    }

    
    public void paintComponent(Graphics pen){        /*Graphics pen is a awt tool that will be used to draw all the paintings. */
        
        super.paintComponent(pen);  // since paintComponent is part of JComponent and JComponent is a parent class of JPanel i.e 'super' keyword is used cause JPanel extends JComponent.
        //above line is only used for cleanup of the board. from below we will start to paint on the board.
        pen.drawImage(BackgroundImage, 0, 0, 1500, 800, null);//this will be used to draw the image . (to print the background image)
        player.draw(pen);
        player.move();
        printEnemies(pen); // insead of calling a single enemy we created a funtion and the passed the pen in it .
        gameOver(pen);
    }
}
