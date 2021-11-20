package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class HighScore {
	
	/**
	 * Saves the scores into a txt file
	 * @param updatedScores The updated high score
	 */
	
	public static void saveScores(int[] updatedScores) {
		try {
			PrintWriter pw = new PrintWriter("/src/resources/highscore.txt", StandardCharsets.UTF_8);
			
			for (int score: updatedScores) {
				pw.println(score);
			}
			
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int[] loadScores() {
		int[] highestScores = new int[10];
		
		try {
			FileReader fr = new FileReader("/src/resources/highscore.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			for(int i = 0; i < highestScores.length; i++) {
				line = br.readLine();
				if(line != null)
					highestScores[i] = Integer.parseInt(line);
				else
					highestScores[i] = 0;
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return highestScores;
	}

}
