package tetrisGame;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Tetris extends JFrame {


	Menu scorebar = new Menu();

    public Tetris() {

        
       add(scorebar, BorderLayout.EAST);
        
        tetrisPanel board = new tetrisPanel();
        
        add(board);
        board.start();
        
        setSize(600, 600);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

  

    public static void main(String[] args) {

        Tetris game = new Tetris();
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    } 
}


