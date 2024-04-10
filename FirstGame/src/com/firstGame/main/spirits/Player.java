package com.firstGame.main.spirits;

import javax.swing.ImageIcon;

public class Player extends Sprite{
    

    public Player(){
        x=50;
        y=500;
        w=200;
        h=200;

        image = new ImageIcon(Player.class.getResource("RobotPlayer.gif"));// this is just to import image and above was to set the location of the image in the board.

    }
    public void move(){
        if(x<=0)x=10;
        x += speed;
        
    }
    public boolean outOfScreen(){
        return x>1350;
    }
}
