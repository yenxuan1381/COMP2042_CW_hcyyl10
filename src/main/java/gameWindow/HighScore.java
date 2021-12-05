package main.java.gameWindow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

/**
 * The class allows the game to save and load highscores
 * 
 * @author Windows10
 *
 */

public class HighScore {
	File file;
	String data;
	private String highscore = "0";
	private String username;

	/**
	 * Default constructor
	 * 
	 * @param stage The stage number
	 */

	public HighScore(int stage) {

		try {
			if (stage == 1) {
				File file1 = new File("src\\main\\java\\resources\\highscore1.txt");
				this.file = file1;
			} else if (stage == 2) {
				File file2 = new File("src\\main\\java\\resources\\highscore2.txt");
				this.file = file2;
			} else if (stage == 3) {
				File file3 = new File("src\\main\\java\\resources\\highscore3.txt");
				this.file = file3;
			} else if (stage == 4) {
				File file4 = new File("src\\main\\java\\resources\\highscore4.txt");
				this.file = file4;
			} else if (stage == 5) {
				File file5 = new File("src\\main\\java\\resources\\highscore5.txt");
				this.file = file5;
			} else if (stage == 6) {
				File file6 = new File("src\\main\\java\\resources\\highscore6.txt");
				this.file = file6;
			} else if (stage == 7) {
				File file7 = new File("src\\main\\java\\resources\\highscore7.txt");
				this.file = file7;
			} else if (stage == 8) {
				File file8 = new File("src\\main\\java\\resources\\highscore8.txt");
				this.file = file8;
			}

			if (file.createNewFile()) {
				System.out.println("HI SUCCESS");
			} else {
				System.out.println("FILE EXIST");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method allows the system to write and store the data into a file
	 * 
	 * @param data The highscore data
	 */
	public void writeFile(String data) {
		try {
			FileWriter Writer = new FileWriter(file);
			Writer.write(data);
			Writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method reads the value from a file
	 */

	public void readFile() {
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				this.data = reader.nextLine();
				separateString(this.data);

			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method separates the string into username and highscore
	 * 
	 * @param string The line of string written in file
	 */

	public void separateString(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isDigit(string.charAt(i))) {
				this.setHighscore(string.substring(0, i));
				this.setUsername(string.substring(i));
				break;
			}

		}

	}

	/**
	 * Getter to get the highscore
	 * 
	 * @return String highscore
	 */

	public String getHighscore() {
		return highscore;
	}

	/**
	 * Setter to set the highscore
	 * 
	 * @param highscore String the highscore
	 */

	public void setHighscore(String highscore) {
		this.highscore = highscore;
	}

	/**
	 * Getter to get the username of the player
	 * 
	 * @return Strin of the username of the player
	 */

	public String getUsername() {
		return username;
	}

	/**
	 * Setter to set the username of the player
	 * 
	 * @param username String of username of the player
	 */

	public void setUsername(String username) {
		this.username = username;
	}

}
