package com.firstGame.main.spirits;

import javax.swing.ImageIcon;

public class Enemy extends Sprite{
    
    public Enemy(int x, int speed){
        this.x = x;
        y = 50;
        w = 200;
        h = 200;
        this.speed = speed;
        image = new ImageIcon(Enemy.class.getResource("BugImage2.gif"));
    }

    public void move(){
        if(y==820)y=10;
        
        y += speed;
    }
}
