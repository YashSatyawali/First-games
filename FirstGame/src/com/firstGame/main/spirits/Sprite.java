package com.firstGame.main.spirits;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Sprite {
    public int x;
    public int y;
    public int h;
    public int w;
    public ImageIcon image;
    public int speed;

    public void draw(Graphics pen){
        pen.drawImage(image.getImage(), x, y, w, h, null);
    }
}
