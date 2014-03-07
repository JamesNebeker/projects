package tetrisGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;




public class tetrisPanel extends JPanel implements ActionListener {


    final int BoardWidth = 10;
    final int BoardHeight = 22;
    JOptionPane endGame = new JOptionPane();

   
    boolean isFallingFinished = false;
    boolean isStarted = false;
    boolean isPaused = false;
    int numLinesRemoved = 0;
    int currentX = 0;
    int currentY = 0;
    Timer timer;
    boolean[][] board = new boolean[BoardWidth][BoardHeight];
    int[][] boardcoord = new int[10][22];
    Color[][] boardColor = new Color[BoardWidth][BoardHeight];
    Shape currentPiece = new Shape(0);
    int score = 0;
    



    public tetrisPanel() {

       setFocusable(true);
       
       
       addKeyListener(new TAdapter());
       clearBoard();  
       start();
       setSize(200, 400);
      
    }

    public void actionPerformed(ActionEvent e) {
        if (isFallingFinished == true) {
            isFallingFinished = false;
            newPiece();
        } else {
            oneLineDown();
           
        }
    }


    int squareWidth() { return (int) getSize().getWidth() / BoardWidth; }
    int squareHeight() { return (int) getSize().getHeight() / BoardHeight; }
    


    public void start()
    {
    	 clearBoard();
        isStarted = true;
        isFallingFinished = false;
        numLinesRemoved = 0;
        timer = new Timer(400, this);
        timer.start();
        
        newPiece();
       
        
        
    }

   
    public int getScore()
    {
    	return score;
    }
    public void paint(Graphics g)
    { 
        super.paint(g);

        Dimension size = getSize();
        
        int boardTop = (int) size.getHeight() - BoardHeight * squareHeight();
        

        for (int i = 0; i < BoardHeight; ++i) {
            for (int j = 0; j < BoardWidth; ++j) {
                boolean isShape = board[j][i];
              
                if (isShape == true)
                {
                	 drawSquare(g, 0 + j * squareWidth(),
                             boardTop + i * squareHeight(), boardColor[j][i]);
                		
                	
                }
                    
            }
        }

        	
        	int y = 0;
            for (int i = 0; i < 4; ++i) {
                int x = currentX + currentPiece.getX(i);
                y = currentY + currentPiece.getY(i) - 2;
                
                drawSquare(g, 0 + x * squareWidth(),
                           boardTop + (BoardHeight - y - 1) * squareHeight(),
                           currentPiece.getColor());
            }
        
    }

    private void dropDown()
    {
        int newY = currentY;
        while (newY > 0) {
            if (!Move(currentPiece, currentX, newY - 1))
                break;
            --newY;
        }
        pieceDropped();
    }

    private void oneLineDown()
    {
        if (Move(currentPiece, currentX, currentY - 1) == false)
            pieceDropped();
       
        	
    }


    private void clearBoard()
    {
       for (int i = 0; i < BoardWidth - 1; i++)
       {
    	   for (int j = 0; j < BoardHeight; j++)
    	   {
    		   board[i][j] = false;
    	   }
       }
    }

    private void pieceDropped()
    {
        for (int i = 0; i < 4; ++i) {
            int x = currentX + currentPiece.getX(i);
            int y = currentY - currentPiece.getY(i);
            if (y == 0)
            {
            	 board[x][0] = true;
            	 boardColor[x][0] = currentPiece.getColor();
            	 boardcoord[x][0] = currentY;
            }
           
            if (y > 0)
            {
            	 board[x][y] = true;
            	 boardcoord[x][y] = currentX;
            	 boardColor[x][y] = currentPiece.getColor();
            }
        }

        removeFullLines();
        isFallingFinished = true;
        if (isFallingFinished == true)
        	newPiece();
            
    }

    private void newPiece()
    {
    	currentPiece = new Shape(0);
        int seed = currentPiece.setRandom();
        currentPiece = new Shape(seed);
        currentX = BoardWidth / 2 + 1;
        currentY = BoardHeight - 1 + currentPiece.minY();

        if (Move(currentPiece, currentX, currentY) == false) {
            
            
            isStarted = false;
            timer.stop();
            HighScores scoreList = new HighScores(score);
            String topFive = scoreList.getScores();
            String endMessage = "Game Over. Score was: " + score + "\n" + "Previous Scores: " + "\n" + topFive;
            endGame.showMessageDialog(null, endMessage);
            
            System.exit(0);
        }
    }

    private boolean Move(Shape newPiece, int newX, int newY)
    {
        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.getX(i);
            int y = newY;
            if (x < 0 || x >= BoardWidth || y < 0 || y >= BoardHeight)
                return false;
            if (board[x][y] != false)
                return false;
        }

        currentPiece = newPiece;
        currentX = newX;
        currentY = newY;
        
        repaint();
        return true;
    }

    private void removeFullLines()
    {
        int numFullLines = 0;

        for (int i = BoardHeight - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < BoardWidth; ++j) {
                if (board[j][i] == false) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                ++numFullLines;
                for (int k = i; k < BoardHeight - 2; ++k) {
                    for (int j = 0; j < BoardWidth - 1; ++j)
                    	if (j != BoardWidth  && i != BoardHeight - 1)
                         board[j][k] = board[j + 1][k + 1];
                    	else 
                    		board[j][k] = false;
                }
            }
        }

        if (numFullLines > 0) {
            numLinesRemoved += numFullLines;
            score++;
            isFallingFinished = true;
            
            repaint();
        }
     }

    private void drawSquare(Graphics g, int x, int y, Color sColor)
    {
        


        Color color = sColor;

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

       
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                         x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                         x + squareWidth() - 1, y + 1);

    }

    class TAdapter extends KeyAdapter {
         public void keyPressed(KeyEvent e) {

             if (!isStarted) {  
                 return;
             }

             int keycode = e.getKeyCode();

             

           
             switch (keycode) {
             case KeyEvent.VK_LEFT:
                 Move(currentPiece, currentX - 1, currentY);
                 break;
             case KeyEvent.VK_RIGHT:
                 Move(currentPiece, currentX + 1, currentY);
                 break;
             case KeyEvent.VK_UP:
                 Move(currentPiece.rotateLeft(currentPiece), currentX, currentY);
                 break;
             case KeyEvent.VK_SPACE:
                 dropDown();
                 break;
             case 'd':
                 oneLineDown();
                 break;
             case 'D':
                 oneLineDown();
                 break;
             }

         }
     }
}