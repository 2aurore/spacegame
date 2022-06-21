package lank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Con_Lank {

	private String path = "C:\\java_study\\lank\\lank.txt";
	File f = new File(path);
	
	
	HashMap<String, Integer> user = new HashMap<>();

	public Con_Lank() {
		readfile();
		

		

	}
	void readfile() {
		//System.out.println(f.exists());
		
		if(f.exists()) {
			try {
				FileReader fd = new FileReader(f);
				FileInputStream fis = new FileInputStream(f);
				
				int tmp = 0;
				while ((tmp = fis.read()) != -1) {
					System.out.println((char)tmp);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new Con_Lank();

	}

}

class User {
	
	String id;
	int score;
	
	
	
	
}
