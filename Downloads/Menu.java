package tetrisGame;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author James Nebeker
 *@ Class: CS 1410
 */
public class Menu extends JPanel 
{
JLabel info = new JLabel("Press UP to rotate piece counter-clockwise.");
JLabel info2 = new JLabel("Press D or SPACEBAR to move fast.");

	public Menu()
	{
		setLayout(new GridLayout(2, 1));
		add(info);
		add(info2);
		setBackground(Color.GREEN);
	}
}
