package tetrisGame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HighScores 
{
private List<String> scores = new ArrayList<String>();
File scoreFile = new File("src/scores.txt");



	public HighScores(int s)
	{
		addScore(s );
	}
	public void addScore(int s)
	{
		int counter = 0;
		Integer x = s;
		String addScore = x.toString();
	
			try {
		
		
				BufferedWriter bw = new BufferedWriter(new FileWriter(scoreFile.getAbsoluteFile(), true));
				bw.newLine();
				bw.write(addScore);
		  
				bw.close();

		
		
		
		
			} catch (IOException e) {
		
				e.printStackTrace();
			}
	}

	public String getScores()
		{
			int counter = 0;
				try {
					Scanner read = new Scanner(scoreFile);
						while (read.hasNextLine() == true && counter < 5)
						{
			
							scores.add(read.nextLine());
						}
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			return scores.toString();
			
		}
}
