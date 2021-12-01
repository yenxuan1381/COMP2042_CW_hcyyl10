package main.java.view;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class HighScore {
	File file;
	HighScore(){
	
		try {
			File file = new File("C:\\Users\\Windows10\\eclipse-workspace\\COMP2042_CW_emily1381\\src\\main\\java\\resources\\highscore.txt");
			this.file = file;
			if(file.createNewFile()) {
				System.out.println("HI SUCCESS");
			}
			else {
				System.out.println("FILE EXIST");
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeFile(String data) {
		try {
			FileWriter Writer = new FileWriter("C:\\\\Users\\\\Windows10\\\\eclipse-workspace\\\\COMP2042_CW_emily1381\\\\src\\\\main\\\\java\\\\resources\\\\highscore.txt");
			Writer.write(data);
			Writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
