package com.firstGame.main;
import javax.swing.JFrame;

public class GameFrame extends JFrame{

   
    
    public GameFrame(){
            Board board = new Board();

            this.setSize(1500,820);                 
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*this is used so that the application is closed when clicked on the top right close button.*/
            this.setResizable(false);/*This is so that the application cannot be resized.(the center button on the top right will not work)*/
            this.setTitle("First game");
            this.setLocationRelativeTo(null);/*this is to that on start the application wil appear at the center of the screen.*/
            add(board);
            this.setVisible(true);
        }
    public static void main(String[] args) {
        new GameFrame();  


            // frame.setSize(1500,820);                 /*since this is the main class no need to write all this here , instead create a constructor and use 'this' keyword. */
            // frame.setVisible(true);
            // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*this is used so that the application is closed when clicked on the top right close button.*/
            // frame.setResizable(false);/*This is so that the application cannot be resized.(the center button on the top right will not work)*/
            // frame.setTitle("First game");
            // frame.setLocationRelativeTo(null);/*this is to that on start the application wil appear at the center of the screen.*/

    }
}
